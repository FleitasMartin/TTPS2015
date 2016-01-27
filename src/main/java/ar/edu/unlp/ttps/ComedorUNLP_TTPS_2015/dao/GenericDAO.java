package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

public interface GenericDAO<T> {

	public T save(T entity);
	
	public T edit(T entity);
	
	public 	List<T> getAll(Class<?> clas);
	
	public T getById(Class<?> clas, Long id);
	
	public List<T> getByName(Class<?> clas, String nombre);
	
	public void delete(Class<?> clas, Long id);
}
