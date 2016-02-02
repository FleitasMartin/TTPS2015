package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;


import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;


public interface UsuarioDAO extends GenericDAO<Usuario>{
	
	
	public Usuario login(int dni, String contrasena);
	
}