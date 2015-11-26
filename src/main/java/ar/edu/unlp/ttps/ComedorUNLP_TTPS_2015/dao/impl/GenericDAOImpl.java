package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	protected T persistentClass; //Esto está sacado del ejemplo de la catedra
								// No lo entiendo y posiblemente sea eliminado.


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

	protected List<T> getAll(Class<?> clas){
		Query consulta= EMF.getEMF().createEntityManager().createQuery("select e from " +clas.getSimpleName()+" e");
				@SuppressWarnings("unchecked")
				List<T> resultado = (List<T>)consulta.getResultList();
				return resultado;
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

	public T getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(T persistentClass) {
		this.persistentClass = persistentClass;
	}

}