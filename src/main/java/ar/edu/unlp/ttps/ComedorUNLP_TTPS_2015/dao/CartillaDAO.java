package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;

public interface CartillaDAO extends GenericDAO<Cartilla> {
	public Cartilla getFirstCartilla(Object fechaActual);
	public Cartilla getCartillaExistente(Object fechaActual, Long id);
}