package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;


@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO{
	
	public UsuarioDAOImpl(){
		super(Usuario.class);
	}
		
	@Override
	public Usuario login(String dni, String contrasena){
		Query consulta=getEntityManager().createQuery("select e from "+Usuario.class.getSimpleName()+" e where e.dni = :dni and e.contrasena = :contrasena ").setParameter("dni", dni).setParameter("contrasena", contrasena);
		Usuario resultado = new Usuario();
		try{
			resultado = (Usuario)consulta.getSingleResult();
		}catch(Exception e){
			resultado = null;
		}
		return resultado;
	}
	
}
