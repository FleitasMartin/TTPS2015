package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.GenericDAO;

@Transactional
public class GenericDAOImpl<T> implements GenericDAO<T> {

	@PersistenceContext
	private EntityManager entityManager;

	
	public EntityManager getEntityManager() {
		return entityManager;
	}
		
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected T save(T entity) {
		this.getEntityManager().persist(entity);
		/*EntityManager em = EMF.getEMF().createEntityManager();
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
		}*/
		return entity;
	}

	protected T edit(T entity) {
		this.getEntityManager().merge(entity);
		/*EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		entity = em.merge(entity);
		etx.commit();
		em.close();*/
		return entity;
	}

	protected List<T> getAll(Class<?> clas){
		Query consulta= EMF.getEMF().createEntityManager().createQuery("select e from " +clas.getSimpleName()+" e");
				@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}
	
	protected T getById(Class<?> clas, Long id){
		Query consulta= EMF.getEMF().createEntityManager().createQuery("select e from " 
					+clas.getSimpleName()+" e where e.id = "+ id);
		@SuppressWarnings("unchecked")
		T resultado = (T)consulta.getSingleResult();
		return resultado;
	}

	protected List<T> getByName(Class<?> clas, String nombre){
		Query consulta= EMF.getEMF().createEntityManager().createQuery("select e from " 
					+clas.getSimpleName()+" e where e.nombre = :nombre");
		consulta.setParameter("nombre", nombre);
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}

}