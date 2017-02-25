package net.bloodbanking.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.StatusMstDTO;
import net.bloodbanking.entity.EnquiryForm;
import net.bloodbanking.entity.LocationAddress;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.entity.SecurityQuestion;
import net.bloodbanking.entity.StatusMst;
import net.bloodbanking.enums.ReferenceTypeEnum;
import net.bloodbanking.exception.NhanceApplicationException;
import net.bloodbanking.service.LoginService;
import net.bloodbanking.validator.EnquiryValidator;
import net.bloodbanking.validator.LoginValidator;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private LoginValidator loginValidator;
	
	@Autowired
	private EnquiryValidator enquiryValidator;
	
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
		registrationDTO.setBirthDate(registration.getBirthDate());
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
	public List<SecurityQuestionDTO> listSecurityQuestions(SecurityQuestionDTO securityQuestionDTO) {
		List<SecurityQuestion> list = loginDao.listSecurityQuestions(securityQuestionDTO);
		List<SecurityQuestionDTO> dtoList = null;
		if(!CollectionUtils.isEmpty(list)){
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
		registration.setBirthDate(registrationDTO.getBirthDate());
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
}
