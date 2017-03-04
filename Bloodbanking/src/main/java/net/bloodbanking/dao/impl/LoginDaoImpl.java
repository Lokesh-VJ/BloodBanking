package net.bloodbanking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.BaseDTO;
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
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null ;
	}
	
	@Override
	public List<UserTypeMst> listUserTypes(UserTypeMstDTO userTypeMstDTO){
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(UserTypeMst.class);
		if(null != userTypeMstDTO.getUsertypeId()){
			criteria.add(Restrictions.eq("usertypeId", userTypeMstDTO.getUsertypeId()));
		}
		// TODO, this condition to be added in creative way...
		criteria.add(Restrictions.ne("usertypeName", "Admin"));
		List<UserTypeMst> list = criteria.list();
		return CollectionUtils.isNotEmpty(list) ? list : null ;
	}
	
	@Override
	public List<SecurityQuestion> listSecurityQuestions(SecurityQuestionDTO securityQuestionDTO){
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(SecurityQuestion.class);
		if(null != securityQuestionDTO.getSecurityQuestionId()){
			criteria.add(Restrictions.eq("securityQuestionId", securityQuestionDTO.getSecurityQuestionId()));
		}
		List<SecurityQuestion> list = criteria.list();
		return CollectionUtils.isNotEmpty(list) ? list : null ;
	}

	@Override
	public List<BloodGroupMst> listBloodGroups(BloodGroupMstDTO bloodGroupMstDTO) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(BloodGroupMst.class);
		if(null != bloodGroupMstDTO.getBloodGroupId()){
			criteria.add(Restrictions.eq("bloodGroupId", bloodGroupMstDTO.getBloodGroupId()));
		}
		List<BloodGroupMst> list = criteria.list();
		return CollectionUtils.isNotEmpty(list) ? list : null ;
	}

	@Override
	public UserTypeMst loadUserType(UserTypeMstDTO userTypeMstDTO) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(UserTypeMst.class);
		if(null != userTypeMstDTO.getUsertypeId()){
			criteria.add(Restrictions.eq("usertypeId", userTypeMstDTO.getUsertypeId()));
		}
		List<UserTypeMst> list = criteria.list();
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null ;
	}

	@Override
	public List<UserTypeMapping> listUserTypeMappings(UserTypeMstDTO userTypeMstDTO){
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(UserTypeMapping.class);
		if(null != userTypeMstDTO.getUsertypeId()){
			criteria.add(Restrictions.eq("userTypeMst.usertypeId", userTypeMstDTO.getUsertypeId()));
		}
		List<UserTypeMapping> list = criteria.list();
		return CollectionUtils.isNotEmpty(list) ? list : null ;
	}

	@Override
	public BloodGroupMst loadBloodGroup(BloodGroupMstDTO bloodGroupMstDTO) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(BloodGroupMst.class);
		if(null != bloodGroupMstDTO.getBloodGroupId()){
			criteria.add(Restrictions.eq("bloodGroupId", bloodGroupMstDTO.getBloodGroupId()));
		}
		List<BloodGroupMst> list = criteria.list();
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null ;
	}

	@Override
	public LocationAddress loadLocationAddress(LocationAddressDTO locationAddressDTO) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(LocationAddress.class);
		if(null != locationAddressDTO.getReferenceId()){
			criteria.add(Restrictions.eq("referenceId", locationAddressDTO.getReferenceId()));
		}
		if(null != locationAddressDTO.getReferenceType()){
			criteria.add(Restrictions.eq("referenceType", locationAddressDTO.getReferenceType()));
		}
		List<LocationAddress> list = criteria.list();
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null ;
	}

	@Override
	public List<Registration> viewUser(RegistrationDTO registrationDTO) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Registration.class);
		return viewList(registrationDTO, criteria);
	}
	
	private <T> List<T> viewList(BaseDTO baseDTO, Criteria criteria) {
		List<T> resultList = criteria.list();
		List<T> returnResultList = new ArrayList<T>();
		baseDTO.setTotalSize(resultList.size());
		int loopStart = baseDTO.getQueryPageNumber() * AppConstants.RESULTSPERPAGE;
		int loopEnd = loopStart + AppConstants.RESULTSPERPAGE;
		if (loopEnd > resultList.size()) loopEnd = resultList.size();
		for (int i = loopStart; i < loopEnd; i++) {
			returnResultList.add(resultList	.get(i));
		}
		return CollectionUtils.isNotEmpty(returnResultList) ? returnResultList : null;
	}
}
