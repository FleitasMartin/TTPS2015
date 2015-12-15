package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

public interface SedeDAO extends GenericDAO<Sede>{
	public Sede save(Sede sede);
	
	public Sede edit(Sede sede);
		
	public Sede get(Long id) throws EntityNotFoundException;
		
	public Sede get(String nombre) throws EntityNotFoundException;
		
	public List<Sede> getAll();

	void delete(Long id);
	
}