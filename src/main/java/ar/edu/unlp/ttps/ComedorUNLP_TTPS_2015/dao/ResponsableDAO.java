package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;



public interface ResponsableDAO extends GenericDAO<Responsable>{
	
	public Responsable login(int dni, String contrasena);
	
}