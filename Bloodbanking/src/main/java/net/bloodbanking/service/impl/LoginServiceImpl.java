package net.bloodbanking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.StatusMstDTO;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.entity.SecurityQuestion;
import net.bloodbanking.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public RegistrationDTO loadRegistration(RegistrationDTO registrationDTO){
		Registration registration = loginDao.loadRegistration(registrationDTO);
		if(null != registration){
			registrationDTO.setRegistrationId(registration.getRegistrationId());
			StatusMstDTO statusMstDTO = new StatusMstDTO();
			statusMstDTO.setStatus(registration.getStatusMst().getStatus());
			statusMstDTO.setDescription(registration.getStatusMst().getDescription());
			registrationDTO.setStatusMstDTO(statusMstDTO);
			registrationDTO.setBloodGroup(registration.getBloodGroup());
			registrationDTO.setBirthDate(registration.getBirthDate());
			registrationDTO.setGender(registration.getGender());
			registrationDTO.setUserName(registration.getUserName());
			registrationDTO.setPassword(registration.getPassword());
			registrationDTO.setUsertypeId(registration.getUsertypeId());
			registrationDTO.setSecurityQue(registration.getSecurityQue());
			registrationDTO.setAnswer(registration.getAnswer());
		}
		return registrationDTO;
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
}
