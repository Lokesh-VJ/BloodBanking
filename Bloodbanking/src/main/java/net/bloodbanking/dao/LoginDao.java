package net.bloodbanking.dao;

import net.bloodbanking.dto.LoginDTO;

public interface LoginDao extends BaseDao{

	LoginDTO loadUserByUsername(LoginDTO loginDTO);

}
