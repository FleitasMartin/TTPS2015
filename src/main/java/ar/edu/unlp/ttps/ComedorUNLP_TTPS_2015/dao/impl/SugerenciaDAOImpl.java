package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SugerenciaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;

@Repository
public class SugerenciaDAOImpl extends GenericDAOImpl<Sugerencia> implements SugerenciaDAO {
	
	public SugerenciaDAOImpl(){
		super(Sugerencia.class);
	}
	
}