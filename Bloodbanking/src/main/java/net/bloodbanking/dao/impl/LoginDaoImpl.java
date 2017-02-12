package net.bloodbanking.dao.impl;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.LoginDTO;

/**
 * The Class LoginDaoImpl.
 */
@Repository("loginDao")
public class LoginDaoImpl extends BaseDaoImpl implements LoginDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public LoginDTO loadUserByUsername(LoginDTO loginDTO) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(LoginDTO.class, "user");
		criteria.setFetchMode("role", FetchMode.JOIN);
		criteria.createAlias("user.userRole", "role");
		//criteria.add(Restrictions.or(Restrictions.eq("user.emailId", loginPrincipal), Restrictions.eq("user.mobileNumber", loginPrincipal)));
		//List<LoginDTO> loginUsers = (List<LoginDTO>) getHibernateTemplate().findByCriteria(criteria);
		//return CollectionUtils.isNotEmpty(loginUsers) ? loginUsers.get(0): null;
		
		return null;
	}
	
}
