package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;



public interface SugerenciaDAO extends GenericDAO<Sugerencia>{

	public List<Sugerencia> getAllBySede(Long idSede);
		
	
}
