package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.MenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;

public class MenuDAOImpl extends GenericDAOImpl<Menu> implements MenuDAO {

	@Override
	public Menu save(Menu menu) {
		return super.save(menu);
		
	}

	@Override
	public Menu edit(Menu menu) {
		return super.edit(menu);
		
	}

	@Override
	public Menu get(Long idMenu) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu get(String menuNombre)
			throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
