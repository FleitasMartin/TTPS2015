package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CompraDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;

@Repository
public class CompraDAOImpl extends GenericDAOImpl<Compra> implements CompraDAO {
	
	public CompraDAOImpl(){
		super(Compra.class);
	}

}
