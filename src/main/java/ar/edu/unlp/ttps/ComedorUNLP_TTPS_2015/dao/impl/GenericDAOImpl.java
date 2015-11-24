package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	protected T persistentClass;

	/*
	 * protected SessionFactory sessionFactory;
	 * 
	 * public SessionFactory getSessionFactory() { return sessionFactory; }
	 * 
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */

	protected T save(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			//throw e;
		} finally {
			em.close();
		}
		return entity;
		// getSessionFactory().getCurrentSession().save(entity);
	}

	protected T edit(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		entity = em.merge(entity);
		etx.commit();
		em.close();
		return entity;
	}

	/*
	 * protected Object get(Class<?> clas, Long idEntity){ return
	 * getSessionFactory().getCurrentSession().get(clas, idEntity); }
	 * 
	 * protected void edit(Object entity){
	 * getSessionFactory().getCurrentSession().update(entity); }
	 * 
	 * protected List<?> list(Class<?> entityClass){ return
	 * getSessionFactory().getCurrentSession
	 * ().createCriteria(entityClass).list(); }
	 */

}