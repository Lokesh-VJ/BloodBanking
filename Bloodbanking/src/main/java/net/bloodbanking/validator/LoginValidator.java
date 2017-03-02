package net.bloodbanking.validator;

import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.exception.ApplicationException;

public interface LoginValidator extends Validator<RegistrationDTO> {

	void validateLoadRegistration(RegistrationDTO registrationDTO) throws ApplicationException;
	
	void validatePreProcessLogin(RegistrationDTO registrationDTO) throws ApplicationException;
	
	void validateVerifySecurityQuestion(RegistrationDTO registrationDTO) throws ApplicationException;
	
	void validateProcessForgotPassword(RegistrationDTO registrationDTO) throws ApplicationException;
	
	void validateProcessSignup(RegistrationDTO registrationDTO) throws ApplicationException;
	
}
