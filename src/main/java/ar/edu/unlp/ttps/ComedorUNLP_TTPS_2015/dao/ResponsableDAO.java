package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;



public interface ResponsableDAO {
	public Responsable save(Responsable responsable);
	
	public Responsable edit(Responsable responsable);
		
	public Responsable get(Long id) throws EntityNotFoundException;
		
	public Responsable get(String nombre) throws EntityNotFoundException;
		
	public List<Responsable> getAll();

	void delete(Long id);
	
	public Responsable login(int dni, String contrasena);
	
}