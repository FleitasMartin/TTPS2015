package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario findByDNI(String dni);
	
	public List<Usuario> getAllBySede(Sede sede);
}