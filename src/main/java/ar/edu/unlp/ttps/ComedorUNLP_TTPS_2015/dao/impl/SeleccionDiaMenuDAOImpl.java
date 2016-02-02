package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SeleccionDiaMenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.SeleccionDiaMenu;

@Repository
public class SeleccionDiaMenuDAOImpl extends GenericDAOImpl<SeleccionDiaMenu> implements SeleccionDiaMenuDAO {
	
	public SeleccionDiaMenuDAOImpl(){
		super(SeleccionDiaMenu.class);
	}
	

}