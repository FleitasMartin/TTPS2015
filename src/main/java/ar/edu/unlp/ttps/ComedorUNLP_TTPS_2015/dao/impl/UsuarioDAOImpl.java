package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;


@Repository
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
	public Usuario login(int dni, String contrasena){
		Query consulta=getEntityManager().createQuery("select e from "+Usuario.class.getSimpleName()+" e where e.dni = :dni and e.contrasena = :contrasena ").setParameter("dni", dni).setParameter("contrasena", contrasena);
		Usuario resultado = new Usuario();
		try{
			resultado = (Usuario)consulta.getSingleResult();
		}catch(Exception e){
			resultado = null;
		}
		return resultado;
	}
	
	@Override
	public void delete(Long id){
		Usuario usuario = this.get(id);
		usuario.setActivo(false);
		this.edit(usuario);
	}


}
