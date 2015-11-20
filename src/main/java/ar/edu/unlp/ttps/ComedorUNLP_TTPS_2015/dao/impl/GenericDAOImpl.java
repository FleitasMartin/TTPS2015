package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;


import java.util.List;

import org.hibernate.SessionFactory;

public class GenericDAOImpl {
	
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected void save(Object entity){
		getSessionFactory().getCurrentSession().save(entity);
	}
	
	protected Object get(Class<?> clas, Long idEntity){
		return getSessionFactory().getCurrentSession().get(clas, idEntity);
	}
	
	protected void edit(Object entity){
		getSessionFactory().getCurrentSession().update(entity);
	}
	
	protected List<?> list(Class<?> entityClass){
		return getSessionFactory().getCurrentSession().createCriteria(entityClass).list();
	}
	
}