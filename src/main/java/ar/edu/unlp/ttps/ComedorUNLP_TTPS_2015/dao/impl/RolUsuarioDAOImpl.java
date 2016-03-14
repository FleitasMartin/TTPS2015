package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.RolUsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.RolUsuario;

@Repository
public class RolUsuarioDAOImpl extends GenericDAOImpl<RolUsuario> implements
		RolUsuarioDAO {

	public RolUsuarioDAOImpl() {
		super(RolUsuario.class);
	}

	@Override
	public RolUsuario getRol(String rol) {
		Query consulta = getEntityManager().createQuery(
				"select e from " + getPersistentClass().getSimpleName()
						+ " e where e.rol = :rol ").setParameter("rol", rol);
		RolUsuario resultado = new RolUsuario();
		try {
			resultado = (RolUsuario) consulta.getSingleResult();
		} catch (Exception e) {
			resultado = null;
		}
		return resultado;
	}

}
