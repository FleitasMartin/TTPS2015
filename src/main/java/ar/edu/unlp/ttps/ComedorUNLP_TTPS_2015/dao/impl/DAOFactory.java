package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.*;

public class DAOFactory {

	public static ComponenteDAO getComponenteDAO(){
		return new ComponenteDAOImpl();
	}
}
