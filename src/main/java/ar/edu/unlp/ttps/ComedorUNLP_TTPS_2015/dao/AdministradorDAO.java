package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;


import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;


public interface AdministradorDAO extends GenericDAO<Administrador> {	

	public Administrador login(int dni, String contrasena);
}

