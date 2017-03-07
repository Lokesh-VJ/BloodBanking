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
import net.bloodbanking.dto.BloodBankStockDTO;
import net.bloodbanking.dto.BloodDonationDTO;
import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.BloodRequestDTO;
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
import net.bloodbanking.entity.PatientBloodbankMapping;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.entity.SecurityQuestion;
import net.bloodbanking.entity.UserTypeMapping;
import net.bloodbanking.entity.UserTypeMst;
import net.bloodbanking.enums.ReferenceTypeEnum;

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
		if(CollectionUtils.isNotEmpty(registrationDTO.getRegistrationIdList())){
			criteria.add(Restrictions.in("registrationId", registrationDTO.getRegistrationIdList()));
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
		String donorFilter = "";
		if(null != bloodDonationDTO.getDonorId()){
			donorFilter = " and dbm.donor_id="+bloodDonationDTO.getDonorId()+" ";
		}
		String bloodbankFilter = "";
		if(null != bloodDonationDTO.getBloodBankId()){
			bloodbankFilter = " and dbm.bloodbank_id="+bloodDonationDTO.getBloodBankId()+" ";
		}
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery("SELECT "
				+ " dbm.donor_bloodbank_mapping_id AS donorBloodbankMappingId, dbm.donor_id AS donorId, rla.name AS donorName, dbm.bloodbank_id AS bloodBankId, bbla.name AS bloodBankName, bgm.blood_group_name AS bloodGroupName,"
				+ " dbm.blood_units AS bloodUnits, CONCAT(bbla.address, ' ', bbla.city, ' ', bbla.state, ' ', bbla.pincode) as bloodBankAddress, "
				+ " CONCAT(rla.address, ' ', rla.city, ' ', rla.state, ' ', rla.pincode) as donorAddress "
				+ " FROM donor_bloodbank_mapping dbm "
				+ " JOIN registration r ON r.registration_id = dbm.donor_id "+donorFilter+" "
				+ " JOIN location_address rla ON rla.reference_id = r.registration_id AND rla.reference_type =:referenceTypeUser "
				+ " JOIN blood_group_mst bgm ON bgm.blood_group_id=r.blood_group "
				+ " JOIN registration rbb ON rbb.registration_id = dbm.bloodbank_id "+bloodbankFilter+" "
				+ " JOIN location_address bbla ON bbla.reference_id = rbb.registration_id AND bbla.reference_type =:referenceTypeUser")
			.addScalar("donorBloodbankMappingId", LongType.INSTANCE)
			.addScalar("donorId", LongType.INSTANCE)
			.addScalar("donorName", StringType.INSTANCE)
			.addScalar("bloodBankId", LongType.INSTANCE)
			.addScalar("bloodBankName", StringType.INSTANCE)
			.addScalar("bloodGroupName", StringType.INSTANCE)
			.addScalar("bloodUnits", IntegerType.INSTANCE)
			.addScalar("bloodBankAddress", StringType.INSTANCE)
			.addScalar("donorAddress", StringType.INSTANCE)
			.setParameter("referenceTypeUser", ReferenceTypeEnum.USER.getCode())
			.setResultTransformer( Transformers.aliasToBean(BloodDonationDTO.class));
		return viewList(bloodDonationDTO, query);
	}

	@Override
	public List<BloodRequestDTO> viewBloodRequest(BloodRequestDTO bloodRequestDTO) {
		String patientFilter = "";
		if(null != bloodRequestDTO.getPatientId()){
			patientFilter = " and pbm.patient_id="+bloodRequestDTO.getPatientId()+" ";
		}
		String bloodbankFilter = "";
		if(null != bloodRequestDTO.getBloodBankId()){
			bloodbankFilter = " and pbm.bloodbank_id="+bloodRequestDTO.getBloodBankId()+" ";
		}
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery("SELECT "
				+ " pbm.patient_bloodbank_mapping_id AS patientBloodbankMappingId, pbm.patient_id AS patientId, rla.name AS patientName, "
				+ " pbm.bloodbank_id AS bloodBankId, bbla.name AS bloodBankName, bgm.blood_group_name AS bloodGroupName,"
				+ " pbm.blood_units AS bloodUnits, CONCAT(bbla.address, ' ', bbla.city, ' ', bbla.state, ' ', bbla.pincode) as bloodBankAddress,"
				+ " CONCAT(rla.address, ' ', rla.city, ' ', rla.state, ' ', rla.pincode) as patientAddress,"
				+ " pbm.status AS status, sm.description AS statusStr "
				+ " FROM patient_bloodbank_mapping pbm "
				+ " JOIN registration r ON r.registration_id = pbm.patient_id "+patientFilter+" "
				+ " JOIN location_address rla ON rla.reference_id = r.registration_id AND rla.reference_type =:referenceTypeUser "
				+ " JOIN blood_group_mst bgm ON bgm.blood_group_id=r.blood_group "
				+ " JOIN status_mst sm ON sm.status=pbm.status "
				+ " JOIN registration rbb ON rbb.registration_id = pbm.bloodbank_id "+bloodbankFilter+" "
				+ " JOIN location_address bbla ON bbla.reference_id = rbb.registration_id AND bbla.reference_type =:referenceTypeUser")
			.addScalar("patientBloodbankMappingId", LongType.INSTANCE)
			.addScalar("patientId", LongType.INSTANCE)
			.addScalar("patientName", StringType.INSTANCE)
			.addScalar("bloodBankId", LongType.INSTANCE)
			.addScalar("bloodBankName", StringType.INSTANCE)
			.addScalar("bloodGroupName", StringType.INSTANCE)
			.addScalar("bloodUnits", IntegerType.INSTANCE)
			.addScalar("bloodBankAddress", StringType.INSTANCE)
			.addScalar("patientAddress", StringType.INSTANCE)
			.addScalar("status", IntegerType.INSTANCE)
			.addScalar("statusStr", StringType.INSTANCE)
			.setParameter("referenceTypeUser", ReferenceTypeEnum.USER.getCode())
			.setResultTransformer( Transformers.aliasToBean(BloodRequestDTO.class));
		return viewList(bloodRequestDTO, query);
	}

	@Override
	public PatientBloodbankMapping loadPatientBloodMapping(BloodRequestDTO bloodRequestDTO) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(PatientBloodbankMapping.class);
		criteria.add(Restrictions.eq("patientBloodbankMappingId", bloodRequestDTO.getPatientBloodbankMappingId()));
		List<PatientBloodbankMapping> list = criteria.list();
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null ;
	}

	@Override
	public List<BloodDonationDTO> viewDonor(RegistrationDTO registrationDTO) {
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery("SELECT "
				+ " dbm.donor_id AS donorId "
				+ " FROM donor_bloodbank_mapping dbm "
				+ " JOIN registration rbb ON rbb.registration_id = dbm.bloodbank_id AND rbb.user_name =:userName "
				+ " GROUP BY dbm.donor_id")
			.addScalar("donorId", LongType.INSTANCE)
			.setParameter("userName", registrationDTO.getUserName())
			.setResultTransformer( Transformers.aliasToBean(BloodDonationDTO.class));
		return viewList(registrationDTO, query);
	}

	@Override
	public List<BloodRequestDTO> viewPatient(RegistrationDTO registrationDTO) {
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery("SELECT "
				+ " pbm.patient_id AS patientId "
				+ " FROM patient_bloodbank_mapping pbm "
				+ " JOIN registration rbb ON rbb.registration_id = pbm.bloodbank_id AND rbb.user_name =:userName "
				+ " GROUP BY pbm.patient_id")
			.addScalar("patientId", LongType.INSTANCE)
			.setParameter("userName", registrationDTO.getUserName())
			.setResultTransformer( Transformers.aliasToBean(BloodRequestDTO.class));
		return viewList(registrationDTO, query);
	}

	@Override
	public List<BloodBankStockDTO> viewBloodBankStock(RegistrationDTO registrationDTO) {
		String bloodGroupFilter = "";
		if(null != registrationDTO.getBloodGroup()){
			bloodGroupFilter = " AND r.blood_group="+registrationDTO.getBloodGroup()+" ";
		}
		String donorBloodBankFilter = "";
		if(null != registrationDTO.getRegistrationId()){
			donorBloodBankFilter = " AND dbm.bloodbank_id="+registrationDTO.getRegistrationId()+" ";
		}
		String patientBloodBankFilter = "";
		if(null != registrationDTO.getRegistrationId()){
			patientBloodBankFilter = " AND pbm.bloodbank_id="+registrationDTO.getRegistrationId()+" ";
		}
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(
			"SELECT labb.name AS bloodBankName, bgm.blood_group_name AS bloodGroupName, t1.bloodUnits AS donotedBloodUnits, IFNULL(t2.bloodUnits, 0) AS suppliedBloodUnits, "
			+ " IFNULL(t3.bloodUnits, 0) AS rejectedBloodUnits, IFNULL(t4.bloodUnits, 0) AS pendingBloodUnits, (IFNULL(t1.bloodUnits, 0)-IFNULL(t2.bloodUnits, 0)) AS totalAvailableBloodUnits "
			+ " FROM (SELECT dbm.bloodbank_id AS bloodBankId, r.blood_group AS bloodGroup, SUM(dbm.blood_units) AS bloodUnits "
			+ "	FROM `donor_bloodbank_mapping` dbm "
			+ " JOIN registration r ON r.registration_id=dbm.donor_id "+donorBloodBankFilter+" "+bloodGroupFilter+" "
			+ " GROUP BY dbm.bloodbank_id, r.blood_group) t1 "
			+ " LEFT JOIN (SELECT pbm.bloodbank_id AS bloodBankId, r.blood_group AS bloodGroup, SUM(pbm.blood_units) AS bloodUnits, pbm.status AS `status` "
			+ " FROM `patient_bloodbank_mapping` pbm "
			+ " JOIN registration r ON r.registration_id=pbm.patient_id AND pbm.status =:suppliedStatus "+patientBloodBankFilter+" "+bloodGroupFilter+" "
			+ " GROUP BY pbm.bloodbank_id, r.blood_group) t2 ON t2.bloodBankId = t1.bloodBankId AND t2.bloodGroup = t1.bloodGroup "
			+ " LEFT JOIN (SELECT pbm.bloodbank_id AS bloodBankId, r.blood_group AS bloodGroup, SUM(pbm.blood_units) AS bloodUnits, pbm.status AS `status` "
			+ " FROM `patient_bloodbank_mapping` pbm "
			+ " JOIN registration r ON r.registration_id=pbm.patient_id AND pbm.status =:rejectedStatus "+patientBloodBankFilter+" "+bloodGroupFilter+" "
			+ " GROUP BY pbm.bloodbank_id, r.blood_group) t3 ON t3.bloodBankId = t1.bloodBankId AND t3.bloodGroup = t1.bloodGroup "
			+ " LEFT JOIN (SELECT pbm.bloodbank_id AS bloodBankId, r.blood_group AS bloodGroup, SUM(pbm.blood_units) AS bloodUnits, pbm.status AS `status` "
			+ " FROM `patient_bloodbank_mapping` pbm "
			+ " JOIN registration r ON r.registration_id=pbm.patient_id AND pbm.status =:pendingStatus "+patientBloodBankFilter+" "+bloodGroupFilter+" "
			+ " GROUP BY pbm.bloodbank_id, r.blood_group) t4 ON t4.bloodBankId = t1.bloodBankId AND t4.bloodGroup = t1.bloodGroup "
			+ " JOIN blood_group_mst bgm ON bgm.blood_group_id=t1.bloodGroup "
			+ " JOIN location_address labb ON labb.reference_id = t1.bloodBankId AND labb.reference_type =:referenceTypeUser ")
			.addScalar("bloodBankName", StringType.INSTANCE)
			.addScalar("bloodGroupName", StringType.INSTANCE)
			.addScalar("donotedBloodUnits", LongType.INSTANCE)
			.addScalar("suppliedBloodUnits", LongType.INSTANCE)
			.addScalar("rejectedBloodUnits", LongType.INSTANCE)
			.addScalar("pendingBloodUnits", LongType.INSTANCE)
			.addScalar("totalAvailableBloodUnits", LongType.INSTANCE)
			.setParameter("suppliedStatus", AppConstants.SUPPLIED)
			.setParameter("rejectedStatus", AppConstants.REJECTED)
			.setParameter("pendingStatus", AppConstants.ACTIVE)
			.setParameter("referenceTypeUser", ReferenceTypeEnum.USER.getCode())
			.setResultTransformer( Transformers.aliasToBean(BloodBankStockDTO.class));
		return viewList(registrationDTO, query);
	}
}
