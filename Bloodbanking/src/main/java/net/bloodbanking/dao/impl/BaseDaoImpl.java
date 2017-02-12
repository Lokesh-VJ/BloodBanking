package net.bloodbanking.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import net.bloodbanking.dao.BaseDao;

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
}
