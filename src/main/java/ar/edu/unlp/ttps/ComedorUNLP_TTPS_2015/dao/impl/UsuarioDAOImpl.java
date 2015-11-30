package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;



public class UsuarioDAOImpl extends GenericDAOImpl implements UsuarioDAO{
	@Override
	public Usuario save(Usuario usuario) {
		return (Usuario) super.save(usuario);
		
	}

	@Override
	public Usuario edit(Usuario usuario) {
		return (Usuario) super.edit(usuario);
		
	}
	
	public List<Usuario> getAll(){
		return super.getAll(Usuario.class);
	}

	@Override
	public Usuario get(Long id) throws EntityNotFoundException {
		return (Usuario) super.getById(Usuario.class, id);
	}

	@Override
	public Usuario get(String nombre)	throws EntityNotFoundException {
		return (Usuario) super.getByName(Usuario.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		Usuario usuario = this.get(id);
		usuario.setActivo(false);
		this.edit(usuario);
	}


}
