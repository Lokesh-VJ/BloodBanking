package net.bloodbanking.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.constants.ErrorConstants;
import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.BloodDonationDTO;
import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.BloodRequestDTO;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.FeedbackDTO;
import net.bloodbanking.dto.ListDTO;
import net.bloodbanking.dto.LocationAddressDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.StatusMstDTO;
import net.bloodbanking.dto.UserTypeMappingDTO;
import net.bloodbanking.dto.UserTypeMstDTO;
import net.bloodbanking.entity.BloodGroupMst;
import net.bloodbanking.entity.DonorBloodbankMapping;
import net.bloodbanking.entity.EnquiryForm;
import net.bloodbanking.entity.Feedback;
import net.bloodbanking.entity.LocationAddress;
import net.bloodbanking.entity.PatientBloodbankMapping;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.entity.SecurityQuestion;
import net.bloodbanking.entity.StatusMst;
import net.bloodbanking.entity.UserTypeMapping;
import net.bloodbanking.entity.UserTypeMst;
import net.bloodbanking.enums.ReferenceTypeEnum;
import net.bloodbanking.exception.ApplicationException;
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
	public RegistrationDTO loadRegistration(RegistrationDTO registrationDTO) throws ApplicationException{
		loginValidator.validateLoadRegistration(registrationDTO);
		Registration registration = loginDao.loadRegistration(registrationDTO);
		registrationDTO.setRegistrationId(registration.getRegistrationId());
		registrationDTO.setBloodGroup(registration.getBloodGroup());
		registrationDTO.setBirthDate(DateUtil.convertDateToDateStr(registration.getBirthDate(), DateUtil.DATE_FORMAT_dd_MM_yyyy_SEP_HIPHEN));
		registrationDTO.setGender(registration.getGender());
		registrationDTO.setUserName(registration.getUserName());
		registrationDTO.setPassword(registration.getPassword());
		registrationDTO.setUsertypeId(registration.getUsertypeId());
		registrationDTO.setSecurityQue(registration.getSecurityQue());
		registrationDTO.setAnswer(registration.getAnswer());
		
		StatusMstDTO statusMstDTO = new StatusMstDTO();
		statusMstDTO.setStatus(registration.getStatusMst().getStatus());
		statusMstDTO.setDescription(registration.getStatusMst().getDescription());
		registrationDTO.setStatusMstDTO(statusMstDTO);
		
		LocationAddressDTO locationAddressDTO = new LocationAddressDTO();
		locationAddressDTO.setReferenceId(registrationDTO.getRegistrationId().toString());
		locationAddressDTO.setReferenceType(ReferenceTypeEnum.USER.getCode());
		registrationDTO.setLocationAddressDTO(this.loadLocationAddress(locationAddressDTO));
		
		UserTypeMstDTO userTypeMstDTO = new UserTypeMstDTO();
		userTypeMstDTO.setUsertypeId(registrationDTO.getUsertypeId().intValue());
		userTypeMstDTO = this.loadUserType(userTypeMstDTO);
		registrationDTO.setUsertypeName(userTypeMstDTO.getUsertypeName());
		
		BloodGroupMstDTO bloodGroupMstDTO = new BloodGroupMstDTO();
		bloodGroupMstDTO.setBloodGroupId(registrationDTO.getBloodGroup());
		bloodGroupMstDTO = this.loadBloodGroup(bloodGroupMstDTO);
		registrationDTO.setBloodGroupName(bloodGroupMstDTO.getBloodGroupName());
		return registrationDTO;
	}
	
	@Override
	public RegistrationDTO preProcessLogin(RegistrationDTO registrationDTO) throws ApplicationException{
		// loginValidator.validatePreProcessLogin(registrationDTO);	// TODO, Enable validation later...
		if(null == loginDao.loadRegistration(registrationDTO)){
			return registrationDTO;
		}
		return this.loadRegistration(registrationDTO);
	}
	
	@Override
	public Boolean verifySecurityQuestion(RegistrationDTO registrationDTO) throws ApplicationException{
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
	public void processForgotPassword(RegistrationDTO registrationDTO) throws ApplicationException{
		loginValidator.validateProcessForgotPassword(registrationDTO);
		Registration registration = loginDao.loadRegistration(registrationDTO);
		registration.setPassword(registrationDTO.getPassword());
		loginDao.update(registration);
	}
	
	@Override
	public void processSignup(RegistrationDTO registrationDTO) throws ApplicationException{
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
	public void processEnquiry(EnquiryFormDTO enquiryFormDTO) throws ApplicationException{
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
	public void processFeedback(FeedbackDTO feedbackDTO) throws ApplicationException{
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
	
	@Override
	public UserTypeMstDTO loadUserType(UserTypeMstDTO userTypeMstDTO) {
		// TODO, place validation for userTypeId here...
		UserTypeMst userTypeMst = loginDao.loadUserType(userTypeMstDTO);
		userTypeMstDTO.setUsertypeName(userTypeMst.getUsertypeName());
		return userTypeMstDTO;
	}
	
	@Override
	public BloodGroupMstDTO loadBloodGroup(BloodGroupMstDTO bloodGroupMstDTO) {
		// TODO, place validation...
		BloodGroupMst bloodGroupMst = loginDao.loadBloodGroup(bloodGroupMstDTO);
		bloodGroupMstDTO.setBloodGroupName(bloodGroupMst.getBloodGroupName());
		return bloodGroupMstDTO;
	}
	
	@Override
	public LocationAddressDTO loadLocationAddress(LocationAddressDTO locationAddressDTO) {
		// TODO, place validation...
		LocationAddress locationAddress = loginDao.loadLocationAddress(locationAddressDTO);
		locationAddressDTO.setLocationAddressId(locationAddress.getLocationAddressId());
		locationAddressDTO.setName(locationAddress.getName());
		locationAddressDTO.setMobileNumber(locationAddress.getMobileNumber());
		locationAddressDTO.setEmailId(locationAddress.getEmailId());
		locationAddressDTO.setAddress(locationAddress.getAddress());
		locationAddressDTO.setState(locationAddress.getState());
		locationAddressDTO.setCity(locationAddress.getCity());
		locationAddressDTO.setPincode(locationAddress.getPincode());
		return locationAddressDTO;
	}
	
	@Override
	public List<UserTypeMappingDTO> loadPrivileges(UserTypeMstDTO userTypeMstDTO){
		List<UserTypeMapping> list = loginDao.listUserTypeMappings(userTypeMstDTO);
		List<UserTypeMappingDTO> dtoList = null;
		if(CollectionUtils.isNotEmpty(list)){
			dtoList = new ArrayList<UserTypeMappingDTO>();
			UserTypeMappingDTO dto = null;
			for(UserTypeMapping entity: list){
				dto = new UserTypeMappingDTO();
				dto.setLeftMenuName(entity.getUserLeftMenu().getLeftMenuName());
				dto.setLeftMenuDescription(entity.getUserLeftMenu().getLeftMenuDescription());
				dto.setSubMenuName(entity.getUserSubMenu().getSubMenuName());
				dtoList.add(dto);
			}
		}
		return dtoList;
	}
	
	@Override
	public void processEditProfile(RegistrationDTO registrationDTO) throws ApplicationException{
		// TODO, place validation here...
		Registration registration = loginDao.loadRegistration(registrationDTO);
		if(null == registration){
			throw new ApplicationException(ErrorConstants.INVALID_USER);
		}
		LocationAddressDTO locationAddressDTO = new LocationAddressDTO();
		locationAddressDTO.setReferenceId(registration.getRegistrationId().toString());
		locationAddressDTO.setReferenceType(ReferenceTypeEnum.USER.getCode());
		LocationAddress locationAddress = loginDao.loadLocationAddress(locationAddressDTO);
		if(null == locationAddress){
			throw new ApplicationException(ErrorConstants.USER_ADDRESS_NOT_AVAILABLE);
		}
		locationAddress.setName(registrationDTO.getLocationAddressDTO().getName());
		locationAddress.setMobileNumber(registrationDTO.getLocationAddressDTO().getMobileNumber());
		locationAddress.setEmailId(registrationDTO.getLocationAddressDTO().getEmailId());
		locationAddress.setAddress(registrationDTO.getLocationAddressDTO().getAddress());
		locationAddress.setState(registrationDTO.getLocationAddressDTO().getState());
		locationAddress.setCity(registrationDTO.getLocationAddressDTO().getCity());
		locationAddress.setPincode(registrationDTO.getLocationAddressDTO().getPincode());
		loginDao.update(locationAddress);
	}

	@Override
	public void processChangePassword(RegistrationDTO registrationDTO) throws ApplicationException {
		// TODO, place validation here...
		Registration registration = loginDao.loadRegistration(registrationDTO);
		if(null == registration){
			throw new ApplicationException(ErrorConstants.INVALID_USER);
		}
		if(!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())){
			throw new ApplicationException(ErrorConstants.PASSWORD_MISMATCH);
		}
		// TODO, enable security question & answer update...
		registration.setPassword(registrationDTO.getPassword());
		loginDao.update(registration);
	}

	@Override
	public ListDTO<RegistrationDTO> viewUser(RegistrationDTO registrationDTO) throws ApplicationException {
		List<Registration> list = loginDao.viewUser(registrationDTO);
		ListDTO<RegistrationDTO> listDTO = new ListDTO<RegistrationDTO>();
		List<RegistrationDTO> registrationDTOs = new ArrayList<RegistrationDTO>();
		RegistrationDTO dto = null;
		if(list != null){
			for(Registration registration: list){
				dto = new RegistrationDTO();
				dto.setUserName(registration.getUserName());
				registrationDTOs.add(this.loadRegistration(dto));
			}
		}
		listDTO.setList(registrationDTOs);
		listDTO.setTotalSize(registrationDTO.getTotalSize());
		return listDTO;
	}

	@Override
	public void activateUser(RegistrationDTO registrationDTO) throws ApplicationException {
		// TODO, place validation here...
		Registration registration = loginDao.loadRegistration(registrationDTO);
		if(null == registration){
			throw new ApplicationException(ErrorConstants.INVALID_USER);
		}
		StatusMst statusMst = new StatusMst();
		statusMst.setStatus(AppConstants.ACTIVE);
		registration.setStatusMst(statusMst);
		loginDao.update(registration);
	}

	@Override
	public void deactivateUser(RegistrationDTO registrationDTO) throws ApplicationException {
		// TODO, place validation here...
		Registration registration = loginDao.loadRegistration(registrationDTO);
		if(null == registration){
			throw new ApplicationException(ErrorConstants.INVALID_USER);
		}
		StatusMst statusMst = new StatusMst();
		statusMst.setStatus(AppConstants.INACTIVE);
		registration.setStatusMst(statusMst);
		loginDao.update(registration);
	}

	@Override
	public ListDTO<FeedbackDTO> viewFeedback(FeedbackDTO feedbackDTO) throws ApplicationException {
		List<Feedback> list = loginDao.viewFeedback(feedbackDTO);
		ListDTO<FeedbackDTO> listDTO = new ListDTO<FeedbackDTO>();
		List<FeedbackDTO> feedbackDTOs = new ArrayList<FeedbackDTO>();
		FeedbackDTO dto = null;
		if(list != null){
			for(Feedback feedback: list){
				dto = new FeedbackDTO();
				dto.setFeedback(feedback.getFeedback());
				LocationAddressDTO locationAddressDTO = new LocationAddressDTO();
				locationAddressDTO.setReferenceId(String.valueOf(feedback.getFid()));
				locationAddressDTO.setReferenceType(ReferenceTypeEnum.FEEDBACK.getCode());
				dto.setLocationAddressDTO(this.loadLocationAddress(locationAddressDTO));
				feedbackDTOs.add(dto);
			}
		}
		listDTO.setList(feedbackDTOs);
		listDTO.setTotalSize(feedbackDTO.getTotalSize());
		return listDTO;
	}

	@Override
	public ListDTO<EnquiryFormDTO> viewEnquiry(EnquiryFormDTO enquiryFormDTO) throws ApplicationException {
		List<EnquiryForm> list = loginDao.viewEnquiry(enquiryFormDTO);
		ListDTO<EnquiryFormDTO> listDTO = new ListDTO<EnquiryFormDTO>();
		List<EnquiryFormDTO> enquiryFormDTOs = new ArrayList<EnquiryFormDTO>();
		EnquiryFormDTO dto = null;
		if(list != null){
			for(EnquiryForm enquiryForm: list){
				dto = new EnquiryFormDTO();
				dto.setMessage(enquiryForm.getMessage());
				LocationAddressDTO locationAddressDTO = new LocationAddressDTO();
				locationAddressDTO.setReferenceId(String.valueOf(enquiryForm.getInqId()));
				locationAddressDTO.setReferenceType(ReferenceTypeEnum.ENQUIRY.getCode());
				dto.setLocationAddressDTO(this.loadLocationAddress(locationAddressDTO));
				enquiryFormDTOs.add(dto);
			}
		}
		listDTO.setList(enquiryFormDTOs);
		listDTO.setTotalSize(enquiryFormDTO.getTotalSize());
		return listDTO;
	}
	
	@Override
	public void processBloodDonation(BloodDonationDTO bloodDonationDTO) throws ApplicationException{
		// TODO, place validation here...
		RegistrationDTO registrationDTO = new RegistrationDTO();
		registrationDTO.setUserName(bloodDonationDTO.getDonorUserName());
		Registration registration = loginDao.loadRegistration(registrationDTO);
		DonorBloodbankMapping donorBloodbankMapping = new DonorBloodbankMapping();
		donorBloodbankMapping.setDonorId(registration.getRegistrationId());
		donorBloodbankMapping.setBloodbankId(bloodDonationDTO.getBloodBankId());
		donorBloodbankMapping.setBloodUnits(bloodDonationDTO.getBloodUnits());
		donorBloodbankMapping.setCreatedDate(new Date());
		loginDao.save(donorBloodbankMapping);
	}

	@Override
	public ListDTO<BloodDonationDTO> viewBloodDonation(BloodDonationDTO bloodDonationDTO) throws ApplicationException {
		ListDTO<BloodDonationDTO> listDTO = new ListDTO<BloodDonationDTO>();
		listDTO.setList(loginDao.viewBloodDonation(bloodDonationDTO));
		listDTO.setTotalSize(bloodDonationDTO.getTotalSize());
		return listDTO;
	}

	@Override
	public ListDTO<BloodDonationDTO> viewBloodAvailability(BloodDonationDTO bloodDonationDTO) throws ApplicationException {
		ListDTO<BloodDonationDTO> listDTO = new ListDTO<BloodDonationDTO>();
		listDTO.setList(loginDao.viewBloodAvailability(bloodDonationDTO));
		listDTO.setTotalSize(bloodDonationDTO.getTotalSize());
		return listDTO;
	}

	@Override
	public void processBloodRequest(BloodRequestDTO bloodRequestDTO) throws ApplicationException {
		// TODO, place validation here...
		RegistrationDTO registrationDTO = new RegistrationDTO();
		registrationDTO.setUserName(bloodRequestDTO.getPatientUserName());
		Registration registration = loginDao.loadRegistration(registrationDTO);
		PatientBloodbankMapping patientBloodbankMapping = new PatientBloodbankMapping();
		patientBloodbankMapping.setPatientId(registration.getRegistrationId());
		patientBloodbankMapping.setBloodbankId(bloodRequestDTO.getBloodBankId());
		patientBloodbankMapping.setBloodUnits(bloodRequestDTO.getBloodUnits());
		patientBloodbankMapping.setStatus(AppConstants.ACTIVE);
		patientBloodbankMapping.setCreatedDate(new Date());
		loginDao.save(patientBloodbankMapping);
	}

	@Override
	public void supplyBloodRequest(BloodRequestDTO bloodRequestDTO) throws ApplicationException {
		// TODO, place validation here...
		PatientBloodbankMapping patientBloodbankMapping = loginDao.loadPatientBloodMapping(bloodRequestDTO);
		if(null == patientBloodbankMapping){
			throw new ApplicationException(ErrorConstants.INVALID_BLOOD_REQUEST);
		}
		patientBloodbankMapping.setStatus(AppConstants.SUPPLIED);
		loginDao.update(patientBloodbankMapping);
	}

	@Override
	public void rejectBloodRequest(BloodRequestDTO bloodRequestDTO) throws ApplicationException {
		// TODO, place validation here...
		PatientBloodbankMapping patientBloodbankMapping = loginDao.loadPatientBloodMapping(bloodRequestDTO);
		if(null == patientBloodbankMapping){
			throw new ApplicationException(ErrorConstants.INVALID_BLOOD_REQUEST);
		}
		patientBloodbankMapping.setStatus(AppConstants.REJECTED);
		loginDao.update(patientBloodbankMapping);
	}

	@Override
	public ListDTO<BloodRequestDTO> viewBloodRequest(BloodRequestDTO bloodRequestDTO) throws ApplicationException {
		ListDTO<BloodRequestDTO> listDTO = new ListDTO<BloodRequestDTO>();
		listDTO.setList(loginDao.viewBloodRequest(bloodRequestDTO));
		listDTO.setTotalSize(bloodRequestDTO.getTotalSize());
		return listDTO;
	}
}
