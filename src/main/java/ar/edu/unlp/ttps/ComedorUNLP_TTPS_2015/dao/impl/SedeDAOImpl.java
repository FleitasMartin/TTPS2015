package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@Repository
public class SedeDAOImpl extends GenericDAOImpl<Sede> implements SedeDAO{
	
	public SedeDAOImpl(){
		super(Sede.class);
	}
	

}