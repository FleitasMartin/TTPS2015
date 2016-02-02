package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;

@Repository
public class CartillaDAOImpl extends GenericDAOImpl<Cartilla> implements CartillaDAO{

	public CartillaDAOImpl(){
		super(Cartilla.class);
	}

}