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

	@Override
	public T save(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}
	
	@Override
	public T edit(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}

	@Override
	public List<T> getAll(Class<?> clas){
		Query consulta= getEntityManager().createQuery("select e from " +clas.getSimpleName()+" e");
				@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}
	
	@Override
	public T getById(Class<?> clas, Long id){
		Query consulta= getEntityManager().createQuery("select e from " 
					+clas.getSimpleName()+" e where e.id = "+ id);
		@SuppressWarnings("unchecked")
		T resultado = (T)consulta.getSingleResult();
		return resultado;
	}

	@Override
	public List<T> getByName(Class<?> clas, String nombre){
		Query consulta= getEntityManager().createQuery("select e from " 
					+clas.getSimpleName()+" e where e.nombre = :nombre");
		consulta.setParameter("nombre", nombre);
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}
	
	@Override
	public void delete(Class<?> clas, Long id){
		getEntityManager().remove(getEntityManager().find(clas, id));
	}	

}