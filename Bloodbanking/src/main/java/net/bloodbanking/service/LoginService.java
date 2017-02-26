package net.bloodbanking.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.FeedbackDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.UserTypeMstDTO;
import net.bloodbanking.exception.NhanceApplicationException;

public interface LoginService {
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public RegistrationDTO loadRegistration(RegistrationDTO registrationDTO) throws NhanceApplicationException; 
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public RegistrationDTO processLogin(RegistrationDTO registrationDTO) throws NhanceApplicationException;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Boolean verifySecurityQuestion(RegistrationDTO registrationDTO) throws NhanceApplicationException;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<UserTypeMstDTO> listUserTypes(UserTypeMstDTO userTypeMstDTO);
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<SecurityQuestionDTO> listSecurityQuestions(SecurityQuestionDTO securityQuestionDTO);
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<BloodGroupMstDTO> listBloodGroups(BloodGroupMstDTO bloodGroupMstDTO);
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processForgotPassword(RegistrationDTO registrationDTO) throws NhanceApplicationException; 
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processSignup(RegistrationDTO registrationDTO) throws NhanceApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processEnquiry(EnquiryFormDTO enquiryFormDTO) throws NhanceApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void processFeedback(FeedbackDTO feedbackDTO) throws NhanceApplicationException;
}
