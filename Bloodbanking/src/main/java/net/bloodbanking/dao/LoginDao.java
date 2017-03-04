package net.bloodbanking.dao;

import java.util.List;

import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.LocationAddressDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.UserTypeMstDTO;
import net.bloodbanking.entity.BloodGroupMst;
import net.bloodbanking.entity.LocationAddress;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.entity.SecurityQuestion;
import net.bloodbanking.entity.UserTypeMapping;
import net.bloodbanking.entity.UserTypeMst;

public interface LoginDao extends BaseDao{
	public Registration loadRegistration(RegistrationDTO registrationDTO);
	public List<UserTypeMst> listUserTypes(UserTypeMstDTO userTypeMstDTO);
	public List<SecurityQuestion> listSecurityQuestions(SecurityQuestionDTO securityQuestionDTO);
	public List<BloodGroupMst> listBloodGroups(BloodGroupMstDTO bloodGroupMstDTO);
	public UserTypeMst loadUserType(UserTypeMstDTO userTypeMstDTO);
	public List<UserTypeMapping> listUserTypeMappings(UserTypeMstDTO userTypeMstDTO);
	public BloodGroupMst loadBloodGroup(BloodGroupMstDTO bloodGroupMstDTO);
	public LocationAddress loadLocationAddress(LocationAddressDTO locationAddressDTO);
	public List<Registration> viewUser(RegistrationDTO registrationDTO);
}
