package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements
		UsuarioDAO {

	public UsuarioDAOImpl() {
		super(Usuario.class);
	}

	@Override
	public Usuario findByDNI(String dni) {
		try {
			Query consulta = getEntityManager().createQuery(
					"select p from " + Usuario.class.getSimpleName()
							+ " p where p.dni = :dni ")
					.setParameter("dni", dni);
			Usuario usuario = (Usuario) consulta.getSingleResult();
			return usuario;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllBySede(Sede sede){
		try{
			Query consulta = getEntityManager().createQuery(
					"select p from " + Usuario.class.getSimpleName()
					+ " p where p.sede = :sede ")
			.setParameter("sede", sede);
			List<Usuario> usuario = (List<Usuario>) consulta.getResultList();
			return usuario;
		} catch (Exception e){
			return null;
		}
	}

}
