package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;

public interface CartillaDAO {

	
	public Cartilla save(Cartilla cartilla);
		
	public Cartilla edit(Cartilla cartilla);
		
	public Cartilla get(Long id) throws EntityNotFoundException;
		
	public List<Cartilla> get(String nombre) throws EntityNotFoundException;
		
	public List<Cartilla> getAll();
	
	public void delete(Long id);
	

}