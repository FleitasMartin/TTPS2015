package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;



import java.util.Date;

import org.joda.time.DateTime;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;

public interface CartillaDAO extends GenericDAO<Cartilla> {
	public Cartilla getFirstCartilla (Object fechaActual);

}