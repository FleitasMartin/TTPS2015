package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;



public interface SugerenciaDAO {
	public Sugerencia save(Sugerencia sugerencia);
	
	public Sugerencia edit(Sugerencia sugerencia);
		
	public Sugerencia get(Long id) throws EntityNotFoundException;
		
	public Sugerencia get(String nombre) throws EntityNotFoundException;
		
	public List<Sugerencia> getAll();

	void delete(Long id);
	

}
