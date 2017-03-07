package net.bloodbanking.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.bloodbanking.dto.BloodBankStockDTO;
import net.bloodbanking.dto.BloodDonationDTO;
import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.BloodRequestDTO;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.FeedbackDTO;
import net.bloodbanking.dto.ListDTO;
import net.bloodbanking.dto.LocationAddressDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.UserTypeMappingDTO;
import net.bloodbanking.dto.UserTypeMstDTO;
import net.bloodbanking.exception.ApplicationException;

public interface LoginService {
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public RegistrationDTO loadRegistration(RegistrationDTO registrationDTO) throws ApplicationException; 
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public RegistrationDTO preProcessLogin(RegistrationDTO registrationDTO) throws ApplicationException;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Boolean verifySecurityQuestion(RegistrationDTO registrationDTO) throws ApplicationException;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<UserTypeMstDTO> listUserTypes(UserTypeMstDTO userTypeMstDTO);
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<SecurityQuestionDTO> listSecurityQuestions(SecurityQuestionDTO securityQuestionDTO);
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<BloodGroupMstDTO> listBloodGroups(BloodGroupMstDTO bloodGroupMstDTO);
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processForgotPassword(RegistrationDTO registrationDTO) throws ApplicationException; 
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processSignup(RegistrationDTO registrationDTO) throws ApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processEnquiry(EnquiryFormDTO enquiryFormDTO) throws ApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processFeedback(FeedbackDTO feedbackDTO) throws ApplicationException;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public UserTypeMstDTO loadUserType(UserTypeMstDTO userTypeMstDTO);

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<UserTypeMappingDTO> loadPrivileges(UserTypeMstDTO userTypeMstDTO);

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public BloodGroupMstDTO loadBloodGroup(BloodGroupMstDTO bloodGroupMstDTO) throws ApplicationException;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public LocationAddressDTO loadLocationAddress(LocationAddressDTO locationAddressDTO) throws ApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processEditProfile(RegistrationDTO registrationDTO) throws ApplicationException;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processChangePassword(RegistrationDTO registrationDTO) throws ApplicationException;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ListDTO<RegistrationDTO> viewUser(RegistrationDTO registrationDTO) throws ApplicationException;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void activateUser(RegistrationDTO registrationDTO) throws ApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void deactivateUser(RegistrationDTO registrationDTO) throws ApplicationException;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ListDTO<FeedbackDTO> viewFeedback(FeedbackDTO feedbackDTO) throws ApplicationException;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ListDTO<EnquiryFormDTO> viewEnquiry(EnquiryFormDTO enquiryFormDTO) throws ApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processBloodDonation(BloodDonationDTO bloodDonationDTO) throws ApplicationException;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ListDTO<BloodDonationDTO> viewBloodDonation(BloodDonationDTO bloodDonationDTO) throws ApplicationException;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processBloodRequest(BloodRequestDTO bloodRequestDTO) throws ApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void supplyBloodRequest(BloodRequestDTO bloodRequestDTO) throws ApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void rejectBloodRequest(BloodRequestDTO bloodRequestDTO) throws ApplicationException;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ListDTO<BloodRequestDTO> viewBloodRequest(BloodRequestDTO bloodRequestDTO) throws ApplicationException;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ListDTO<RegistrationDTO> viewDonor(RegistrationDTO registrationDTO) throws ApplicationException;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ListDTO<RegistrationDTO> viewPatient(RegistrationDTO registrationDTO) throws ApplicationException;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ListDTO<BloodBankStockDTO> viewBloodBankStock(RegistrationDTO registrationDTO) throws ApplicationException;
}
