package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.DiaMenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.DiaMenu;


@Repository
public class DiaMenuDAOImpl extends GenericDAOImpl<DiaMenu> implements DiaMenuDAO {

	public DiaMenuDAOImpl(){
		super(DiaMenu.class);
	}
	
}
