package net.bloodbanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.LoginDTO;
import net.bloodbanking.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public LoginDTO loadUserByUsername(LoginDTO loginDTO) {
		return loginDTO;
	}
}
