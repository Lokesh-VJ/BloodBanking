package net.bloodbanking.dao;

import java.util.List;

import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.UserTypeMstDTO;
import net.bloodbanking.entity.BloodGroupMst;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.entity.SecurityQuestion;
import net.bloodbanking.entity.UserTypeMst;

public interface LoginDao extends BaseDao{
	public Registration loadRegistration(RegistrationDTO registrationDTO);
	public List<UserTypeMst> listUserTypes(UserTypeMstDTO userTypeMstDTO);
	public List<SecurityQuestion> listSecurityQuestions(SecurityQuestionDTO securityQuestionDTO);
	public List<BloodGroupMst> listBloodGroups(BloodGroupMstDTO bloodGroupMstDTO);
}
