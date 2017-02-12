package net.bloodbanking.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.bloodbanking.dao.LocationDao;
import net.bloodbanking.dto.StateMstDTO;
import net.bloodbanking.entity.StateMst;

/**
 * The Class LoginDaoImpl.
 */
@Repository("locationDao")
public class LocationDaoImpl extends BaseDaoImpl implements LocationDao {
	
	@Override
	public StateMst loadStateById(StateMstDTO stateMstDTO) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(StateMst.class, "stateMst");
		if(null != stateMstDTO.getStateId()){
			criteria.add(Restrictions.eq("stateMst.stateId", stateMstDTO.getStateId()));
		}
		
		// List<StateMst> list = (List<StateMst>) getHibernateTemplate().findByCriteria(criteria);
		
		getHibernateTemplate().findByCriteria(criteria);
		List<StateMst> list = null;
		return CollectionUtils.isNotEmpty(list) ? list.get(0): null;
	}
	
}
