package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.MenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;

@Repository
public class MenuDAOImpl extends GenericDAOImpl<Menu> implements MenuDAO {

	public MenuDAOImpl(){
		super(Menu.class);
	}
	
}
