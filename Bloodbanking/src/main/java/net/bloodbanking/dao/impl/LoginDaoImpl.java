package net.bloodbanking.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.entity.SecurityQuestion;

/**
 * The Class LoginDaoImpl.
 */
@Repository("loginDao")
@SuppressWarnings("unchecked")
public class LoginDaoImpl extends BaseDaoImpl implements LoginDao {

	@Override
	public Registration loadRegistration(RegistrationDTO registrationDTO){
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Registration.class);
		if(StringUtils.isNotEmpty(registrationDTO.getUserName())){
			criteria.add(Restrictions.eq("userName", registrationDTO.getUserName()));
		}
		List<Registration> list = criteria.list();
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}
	
	@Override
	public List<SecurityQuestion> listSecurityQuestions(SecurityQuestionDTO securityQuestionDTO){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT sq.security_question_id as securityQuestionId, sq.security_question as securityQuestion FROM security_question sq WHERE 1 = 1 ");

		if(null != securityQuestionDTO.getSecurityQuestionId()){
			sql.append(" AND sq.security_question_id=:securityQuestionId ");
		}

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql.toString())
				.addScalar("securityQuestionId", IntegerType.INSTANCE)
				.addScalar("securityQuestion", StringType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(SecurityQuestion.class));
		if(null != securityQuestionDTO.getSecurityQuestionId()){
			query.setParameter("securityQuestionId", securityQuestionDTO.getSecurityQuestionId());
		}
		
		List<SecurityQuestion> list = (List<SecurityQuestion>) query.list();
		return CollectionUtils.isEmpty(list) ? null : list;
	}

}
