package net.bloodbanking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import net.bloodbanking.controller.BaseController;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.exception.ApplicationException;
import net.bloodbanking.service.LoginService;

@Component("authProvider")
public class AuthProvider extends BaseController implements UserDetailsService {

	@Autowired
	private LoginService loginService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		RegistrationDTO registrationDTO = new RegistrationDTO();
		registrationDTO.setUserName(userName);
		try {
			registrationDTO = loginService.preProcessLogin(registrationDTO);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return registrationDTO;
	}

}
