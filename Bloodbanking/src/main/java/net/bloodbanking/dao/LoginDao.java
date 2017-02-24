package net.bloodbanking.dao;

import java.util.List;

import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.entity.SecurityQuestion;

public interface LoginDao extends BaseDao{
	public Registration loadRegistration(RegistrationDTO registrationDTO);
	public List<SecurityQuestion> listSecurityQuestions(SecurityQuestionDTO securityQuestionDTO);
}
