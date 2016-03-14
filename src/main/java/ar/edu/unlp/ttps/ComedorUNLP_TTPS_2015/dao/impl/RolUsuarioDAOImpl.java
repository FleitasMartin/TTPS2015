package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.RolUsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.RolUsuario;

@Repository
public class RolUsuarioDAOImpl extends GenericDAOImpl<RolUsuario> implements RolUsuarioDAO {

	public RolUsuarioDAOImpl(){
		super(RolUsuario.class);
	}
	

}
