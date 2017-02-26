package net.bloodbanking.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.FeedbackDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.StatusMstDTO;
import net.bloodbanking.dto.UserTypeMstDTO;
import net.bloodbanking.entity.BloodGroupMst;
import net.bloodbanking.entity.EnquiryForm;
import net.bloodbanking.entity.Feedback;
import net.bloodbanking.entity.LocationAddress;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.entity.SecurityQuestion;
import net.bloodbanking.entity.StatusMst;
import net.bloodbanking.entity.UserTypeMst;
import net.bloodbanking.enums.ReferenceTypeEnum;
import net.bloodbanking.exception.NhanceApplicationException;
import net.bloodbanking.service.LoginService;
import net.bloodbanking.utils.DateUtil;
import net.bloodbanking.validator.EnquiryValidator;
import net.bloodbanking.validator.FeedbackValidator;
import net.bloodbanking.validator.LoginValidator;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private LoginValidator loginValidator;
	
	@Autowired
	private EnquiryValidator enquiryValidator;
	
	@Autowired
	private FeedbackValidator feedbackValidator;
	
	@Override
	public RegistrationDTO loadRegistration(RegistrationDTO registrationDTO) throws NhanceApplicationException{
		loginValidator.validateLoadRegistration(registrationDTO);
		Registration registration = loginDao.loadRegistration(registrationDTO);
		registrationDTO.setRegistrationId(registration.getRegistrationId());
		StatusMstDTO statusMstDTO = new StatusMstDTO();
		statusMstDTO.setStatus(registration.getStatusMst().getStatus());
		statusMstDTO.setDescription(registration.getStatusMst().getDescription());
		registrationDTO.setStatusMstDTO(statusMstDTO);
		registrationDTO.setBloodGroup(registration.getBloodGroup());
		registrationDTO.setBirthDate(DateUtil.convertDateToDateStr(registration.getBirthDate(), DateUtil.DATE_FORMAT_yyyy_MM_dd_SEP_HIPHEN));
		registrationDTO.setGender(registration.getGender());
		registrationDTO.setUserName(registration.getUserName());
		registrationDTO.setUsertypeId(registration.getUsertypeId());
		registrationDTO.setSecurityQue(registration.getSecurityQue());
		registrationDTO.setAnswer(registration.getAnswer());
		return registrationDTO;
	}
	
	@Override
	public RegistrationDTO processLogin(RegistrationDTO registrationDTO) throws NhanceApplicationException{
		loginValidator.validateProcessLogin(registrationDTO);
		return this.loadRegistration(registrationDTO);
	}
	
	@Override
	public Boolean verifySecurityQuestion(RegistrationDTO registrationDTO) throws NhanceApplicationException{
		loginValidator.validateVerifySecurityQuestion(registrationDTO);
		return true;
	}
	
	@Override
	public List<UserTypeMstDTO> listUserTypes(UserTypeMstDTO userTypeMstDTO) {
		List<UserTypeMst> list = loginDao.listUserTypes(userTypeMstDTO);
		List<UserTypeMstDTO> dtoList = null;
		if(CollectionUtils.isNotEmpty(list)){
			dtoList = new ArrayList<UserTypeMstDTO>();
			UserTypeMstDTO dto = null;
			for(UserTypeMst entity: list){
				dto = new UserTypeMstDTO();
				dto.setUsertypeId(entity.getUsertypeId());
				dto.setUsertypeName(entity.getUsertypeName());
				// TODO, entity.getUserTypeMappings()
				dtoList.add(dto);
			}
		}
		return dtoList;
	}
	
	@Override
	public List<SecurityQuestionDTO> listSecurityQuestions(SecurityQuestionDTO securityQuestionDTO) {
		List<SecurityQuestion> list = loginDao.listSecurityQuestions(securityQuestionDTO);
		List<SecurityQuestionDTO> dtoList = null;
		if(CollectionUtils.isNotEmpty(list)){
			dtoList = new ArrayList<SecurityQuestionDTO>();
			SecurityQuestionDTO dto = null;
			for(SecurityQuestion entity: list){
				dto = new SecurityQuestionDTO();
				dto.setSecurityQuestionId(entity.getSecurityQuestionId());
				dto.setSecurityQuestion(entity.getSecurityQuestion());
				dtoList.add(dto);
			}
		}
		return dtoList;
	}

	@Override
	public List<BloodGroupMstDTO> listBloodGroups(BloodGroupMstDTO bloodGroupMstDTO) {
		List<BloodGroupMst> list = loginDao.listBloodGroups(bloodGroupMstDTO);
		List<BloodGroupMstDTO> dtoList = null;
		if(CollectionUtils.isNotEmpty(list)){
			dtoList = new ArrayList<BloodGroupMstDTO>();
			BloodGroupMstDTO dto = null;
			for(BloodGroupMst entity: list){
				dto = new BloodGroupMstDTO();
				dto.setBloodGroupId(entity.getBloodGroupId());
				dto.setBloodGroupName(entity.getBloodGroupName());
				dtoList.add(dto);
			}
		}
		return dtoList;
	}
	
	@Override
	public void processForgotPassword(RegistrationDTO registrationDTO) throws NhanceApplicationException{
		loginValidator.validateProcessForgotPassword(registrationDTO);
		Registration registration = loginDao.loadRegistration(registrationDTO);
		registration.setPassword(registrationDTO.getPassword());
		loginDao.update(registration);
	}
	
	@Override
	public void processSignup(RegistrationDTO registrationDTO) throws NhanceApplicationException{
		loginValidator.validateProcessSignup(registrationDTO);
		Registration registration = new Registration();
		registration.setBloodGroup(registrationDTO.getBloodGroup());
		registration.setBirthDate(DateUtil.convertDateStrToDate(registrationDTO.getBirthDate(), DateUtil.DATE_FORMAT_dd_MM_yyyy_SEP_HIPHEN));
		registration.setGender(registrationDTO.getGender());
		registration.setUserName(registrationDTO.getUserName());
		registration.setPassword(registrationDTO.getPassword());
		registration.setUsertypeId(registrationDTO.getUsertypeId());
		registration.setSecurityQue(registrationDTO.getSecurityQue());
		registration.setAnswer(registrationDTO.getAnswer());
		StatusMst statusMst = new StatusMst();
		statusMst.setStatus(AppConstants.ACTIVE);
		registration.setStatusMst(statusMst);
		loginDao.save(registration);
		
		LocationAddress locationAddress = new LocationAddress();
		locationAddress.setReferenceId(String.valueOf(registration.getRegistrationId()));
		locationAddress.setReferenceType(ReferenceTypeEnum.USER.getCode());
		locationAddress.setName(registrationDTO.getLocationAddressDTO().getName());
		locationAddress.setMobileNumber(registrationDTO.getLocationAddressDTO().getMobileNumber());
		locationAddress.setEmailId(registrationDTO.getLocationAddressDTO().getEmailId());
		locationAddress.setAddress(registrationDTO.getLocationAddressDTO().getAddress());
		locationAddress.setState(registrationDTO.getLocationAddressDTO().getState());
		locationAddress.setCity(registrationDTO.getLocationAddressDTO().getCity());
		locationAddress.setPincode(registrationDTO.getLocationAddressDTO().getPincode());
		loginDao.save(locationAddress);
	}
	
	@Override
	public void processEnquiry(EnquiryFormDTO enquiryFormDTO) throws NhanceApplicationException{
		enquiryValidator.validateProcessEnquiry(enquiryFormDTO);
		EnquiryForm enquiryForm = new EnquiryForm();
		enquiryForm.setMessage(enquiryFormDTO.getMessage());
		StatusMst statusMst = new StatusMst();
		statusMst.setStatus(AppConstants.ACTIVE);
		enquiryForm.setStatusMst(statusMst);
		enquiryForm.setCreatedDate(new Date());
		loginDao.save(enquiryForm);
		
		LocationAddress locationAddress = new LocationAddress();
		locationAddress.setReferenceId(String.valueOf(enquiryForm.getInqId()));
		locationAddress.setReferenceType(ReferenceTypeEnum.ENQUIRY.getCode());
		locationAddress.setName(enquiryFormDTO.getLocationAddressDTO().getName());
		locationAddress.setMobileNumber(enquiryFormDTO.getLocationAddressDTO().getMobileNumber());
		locationAddress.setEmailId(enquiryFormDTO.getLocationAddressDTO().getEmailId());
		loginDao.save(locationAddress);
	}
	
	@Override
	public void processFeedback(FeedbackDTO feedbackDTO) throws NhanceApplicationException{
		feedbackValidator.validateProcessFeedback(feedbackDTO);
		
		Feedback feedback = new Feedback();
		feedback.setFeedback(feedbackDTO.getFeedback());
		loginDao.save(feedback);
		
		LocationAddress locationAddress = new LocationAddress();
		locationAddress.setReferenceId(String.valueOf(feedback.getFid()));
		locationAddress.setReferenceType(ReferenceTypeEnum.FEEDBACK.getCode());
		locationAddress.setName(feedbackDTO.getLocationAddressDTO().getName());
		locationAddress.setEmailId(feedbackDTO.getLocationAddressDTO().getEmailId());
		loginDao.save(locationAddress);
	}
}
