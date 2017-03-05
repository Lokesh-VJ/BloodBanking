package net.bloodbanking.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.dao.BaseDao;
import net.bloodbanking.dto.BaseDTO;

@Repository
public class BaseDaoImpl implements BaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public final void setSessionFactory() {

		if (hibernateTemplate == null || sessionFactory != hibernateTemplate.getSessionFactory())
			hibernateTemplate = createHibernateTemplate(sessionFactory);
	}

	protected HibernateTemplate createHibernateTemplate(
			SessionFactory sessionFactory) {

		return new HibernateTemplate(sessionFactory);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public Serializable save(Object obj) {
		return getHibernateTemplate().save(obj);
	}
	
	@Override
	public void saveOrUpdate(Object obj) {
		 getHibernateTemplate().saveOrUpdate(obj);
	}

	public void update(Object obj) {
		getHibernateTemplate().update(obj);
	}

	public void delete(Object obj) {
		getHibernateTemplate().delete(obj);
	}

	public void saveList(@SuppressWarnings("rawtypes") List list) {
		for(Object object : list){
			getHibernateTemplate().save(object);
		}
	}

	public void flush() {
		getHibernateTemplate().flush() ;		
	}
	
	@SuppressWarnings("unchecked")
	protected <T> List<T> viewList(BaseDTO baseDTO, Object criteria) {
		List<T> resultList = null;
		if(criteria instanceof Criteria){
			resultList = ((Criteria) criteria).list();
		} else if(criteria instanceof Query){
			resultList = ((Query) criteria).list();
		}
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
