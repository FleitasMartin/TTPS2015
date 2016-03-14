package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Persona;

public interface PersonaDAO extends GenericDAO<Persona>{

	public Persona findByDNI(String dni);
}
