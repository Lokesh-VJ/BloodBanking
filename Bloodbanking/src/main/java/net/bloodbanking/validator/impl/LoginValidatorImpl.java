package net.bloodbanking.validator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.constants.ErrorConstants;
import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.RegistrationDTO.validateLoadRegistration;
import net.bloodbanking.dto.RegistrationDTO.validateProcessForgotPassword;
import net.bloodbanking.dto.RegistrationDTO.validateProcessSignup;
import net.bloodbanking.dto.RegistrationDTO.validateVerifySecurityQuestion;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.exception.ApplicationException;
import net.bloodbanking.exception.ApplicationMessage;
import net.bloodbanking.validator.BaseValidator;
import net.bloodbanking.validator.LoginValidator;

@Component("loginValidator")
public class LoginValidatorImpl extends BaseValidator<RegistrationDTO> implements LoginValidator {
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public void validateLoadRegistration(RegistrationDTO registrationDTO) throws ApplicationException {
		List<ApplicationMessage> messages = new ArrayList<ApplicationMessage>();
		validateDTOGroups(registrationDTO, false, validateLoadRegistration.class);
		
		if(null == loginDao.loadRegistration(registrationDTO)){
			messages.add(new ApplicationMessage(ErrorConstants.INVALID_USER));
		}
		
		throwExceptionOnValidation(messages);
	}
	
	@Override
	public void validatePreProcessLogin(RegistrationDTO registrationDTO) throws ApplicationException {
		List<ApplicationMessage> messages = new ArrayList<ApplicationMessage>();
		
		Registration registration = loginDao.loadRegistration(registrationDTO);
		if(null == registration){
			messages.add(new ApplicationMessage(ErrorConstants.INVALID_CREDENTIALS));
		}  
		
		throwExceptionOnValidation(messages);
	}
	
	@Override
	public void validateVerifySecurityQuestion(RegistrationDTO registrationDTO) throws ApplicationException {
		List<ApplicationMessage> messages = new ArrayList<ApplicationMessage>();
		validateDTOGroups(registrationDTO, false, validateVerifySecurityQuestion.class);
		
		Registration registration = loginDao.loadRegistration(registrationDTO);
		
		if(null == registration || registration.getSecurityQue() != registrationDTO.getSecurityQue()
				|| !registration.getAnswer().equals(registrationDTO.getAnswer())){
			messages.add(new ApplicationMessage(ErrorConstants.INVALID_SECURITY_DETAILS));
		}
		
		if(null != registration && registration.getStatusMst().getStatus().equals(AppConstants.DELETED)){
			messages.add(new ApplicationMessage(ErrorConstants.USER_DELETED));
		}
		
		throwExceptionOnValidation(messages);
	}
	
	@Override
	public void validateProcessForgotPassword(RegistrationDTO registrationDTO) throws ApplicationException {
		List<ApplicationMessage> messages = new ArrayList<ApplicationMessage>();
		validateDTOGroups(registrationDTO, false, validateProcessForgotPassword.class);
		
		if(!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())){
			messages.add(new ApplicationMessage(ErrorConstants.PASSWORD_MISMATCH));
		}
		
		Registration registration = loginDao.loadRegistration(registrationDTO);
		if(null == registration){
			messages.add(new ApplicationMessage(ErrorConstants.INVALID_USER));
		}
		
		if(null != registration && registration.getStatusMst().getStatus() == AppConstants.DELETED){
			messages.add(new ApplicationMessage(ErrorConstants.USER_DELETED));
		}
		
		throwExceptionOnValidation(messages);
	}
	
	@Override
	public void validateProcessSignup(RegistrationDTO registrationDTO) throws ApplicationException {
		List<ApplicationMessage> messages = new ArrayList<ApplicationMessage>();
		validateDTOGroups(registrationDTO, false, validateProcessSignup.class);
		
		if(!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())){
			messages.add(new ApplicationMessage(ErrorConstants.PASSWORD_MISMATCH));
		}
		
		Registration registration = loginDao.loadRegistration(registrationDTO);
		if(null != registration){
			messages.add(new ApplicationMessage(ErrorConstants.USER_ALREADY_REGISTERED));
		}
		
		throwExceptionOnValidation(messages);
	}
}