package net.bloodbanking.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.bloodbanking.dto.LoginDTO;

public interface LoginService {
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public LoginDTO loadUserByUsername(LoginDTO loginDTO);
	
}
