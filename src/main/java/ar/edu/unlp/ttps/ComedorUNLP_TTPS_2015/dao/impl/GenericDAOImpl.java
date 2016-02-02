package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.GenericDAO;

@Transactional
public class GenericDAOImpl<T> implements GenericDAO<T> {

	@PersistenceContext
	private EntityManager entityManager;

	protected Class<T> persistentClass;
	
	public GenericDAOImpl(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}
	
	public GenericDAOImpl(){
		
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
	public List<T> getAll(){
		Query consulta= getEntityManager().createQuery("select e from " +getPersistentClass().getSimpleName()+" e");
				@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}
	
	@Override
	public T get(Long id){
		Query consulta= getEntityManager().createQuery("select e from " 
					+getPersistentClass().getSimpleName()+" e where e.id = "+ id);
		@SuppressWarnings("unchecked")
		T resultado = (T)consulta.getSingleResult();
		return resultado;
	}

	@Override
	public List<T> get(String nombre){
		Query consulta= getEntityManager().createQuery("select e from " 
					+getPersistentClass().getSimpleName()+" e where e.nombre = :nombre");
		consulta.setParameter("nombre", nombre);
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}
	
	@Override
	public void delete(Long id){
		getEntityManager().remove(getEntityManager().find(getPersistentClass(), id));
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
		
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}