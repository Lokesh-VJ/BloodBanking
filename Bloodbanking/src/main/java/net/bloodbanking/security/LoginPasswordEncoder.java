package net.bloodbanking.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("passwordEncoder")
public class LoginPasswordEncoder implements PasswordEncoder , SaltSource {

	@Override
	public String encodePassword(String arg0, Object arg1) throws DataAccessException {
		return null;
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) throws DataAccessException {
		if(StringUtils.isNotEmpty(encPass) && encPass.equals(rawPass)){
			return true;
		}
		return false;
	}

	@Override
	public Object getSalt(UserDetails userdetails) {
		return "";
	}

}
