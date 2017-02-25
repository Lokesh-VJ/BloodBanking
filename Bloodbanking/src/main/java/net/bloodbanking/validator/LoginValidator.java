package net.bloodbanking.validator;

import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.exception.NhanceApplicationException;

public interface LoginValidator extends Validator<RegistrationDTO> {

	void validateLoadRegistration(RegistrationDTO registrationDTO) throws NhanceApplicationException;
	
	void validateProcessLogin(RegistrationDTO registrationDTO) throws NhanceApplicationException;
	
	void validateVerifySecurityQuestion(RegistrationDTO registrationDTO) throws NhanceApplicationException;
	
	void validateProcessForgotPassword(RegistrationDTO registrationDTO) throws NhanceApplicationException;
	
	void validateProcessSignup(RegistrationDTO registrationDTO) throws NhanceApplicationException;
	
}
