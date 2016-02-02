package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;


import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ComponenteDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;

@Repository
public class ComponenteDAOImpl extends GenericDAOImpl<Componente> implements ComponenteDAO {

	public ComponenteDAOImpl(){
		super(Componente.class);
	}

}
