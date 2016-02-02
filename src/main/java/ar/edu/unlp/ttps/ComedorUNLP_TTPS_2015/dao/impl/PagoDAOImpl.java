package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.PagoDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Pago;


@Repository
public class PagoDAOImpl extends GenericDAOImpl<Pago> implements PagoDAO{

	public PagoDAOImpl(){
		super(Pago.class);
	}
	

}