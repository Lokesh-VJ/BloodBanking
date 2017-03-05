package net.bloodbanking.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.BloodDonationDTO;
import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.FeedbackDTO;
import net.bloodbanking.dto.LocationAddressDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.UserTypeMstDTO;
import net.bloodbanking.entity.BloodGroupMst;
import net.bloodbanking.entity.EnquiryForm;
import net.bloodbanking.entity.Feedback;
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
		if(null != registrationDTO.getUsertypeId()){
			criteria.add(Restrictions.eq("usertypeId", registrationDTO.getUsertypeId()));
		}
		criteria.add(Restrictions.ne("usertypeId", AppConstants.ADMIN_ID.longValue()));
		return viewList(registrationDTO, criteria);
	}

	@Override
	public List<Feedback> viewFeedback(FeedbackDTO feedbackDTO) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Feedback.class);
		return viewList(feedbackDTO, criteria);
	}

	@Override
	public List<EnquiryForm> viewEnquiry(EnquiryFormDTO enquiryFormDTO) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(EnquiryForm.class);
		return viewList(enquiryFormDTO, criteria);
	}

	@Override
	public List<BloodDonationDTO> viewBloodDonation(BloodDonationDTO bloodDonationDTO) {
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery("SELECT "
				+ " dbm.donor_id AS donorId, rla.name AS donorName, dbm.bloodbank_id AS bloodBankId, bbla.name AS bloodBankName, r.blood_group AS bloodGroupName,"
				+ " dbm.blood_units AS bloodUnits "
				+ " FROM donor_bloodbank_mapping dbm "
				+ " JOIN registration r ON r.registration_id = dbm.donor_id "
				+ " JOIN location_address rla ON rla.reference_id = r.registration_id AND rla.reference_type = 1 "
				+ " JOIN registration rbb ON rbb.registration_id = dbm.bloodbank_id "
				+ " JOIN location_address bbla ON bbla.reference_id = rbb.registration_id AND bbla.reference_type = 1")
			.addScalar("donorId", LongType.INSTANCE)
			.addScalar("donorName", StringType.INSTANCE)
			.addScalar("bloodBankId", LongType.INSTANCE)
			.addScalar("bloodBankName", StringType.INSTANCE)
			.addScalar("bloodGroupName", StringType.INSTANCE)
			.addScalar("bloodUnits", IntegerType.INSTANCE)
			.setResultTransformer( Transformers.aliasToBean(BloodDonationDTO.class));
		return viewList(bloodDonationDTO, query);
	}
}
