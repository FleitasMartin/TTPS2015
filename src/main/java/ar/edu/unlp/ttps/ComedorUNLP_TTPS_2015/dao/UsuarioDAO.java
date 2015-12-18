package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;


public interface UsuarioDAO {
	public Usuario save(Usuario menu);
	
	public Usuario edit(Usuario menu);
		
	public Usuario get(Long id) throws EntityNotFoundException;
		
	public Usuario get(String nombre) throws EntityNotFoundException;
		
	public List<Usuario> getAll();

	void delete(Long id);
	
	public Usuario login(int dni, String contrasena);
	
}