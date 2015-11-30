package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.DiaMenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.DiaMenu;



public class DiaMenuDAOImpl extends GenericDAOImpl implements DiaMenuDAO {

	@Override
	public DiaMenu save(DiaMenu diaMenu) {
		return (DiaMenu) super.save(diaMenu);
		
	}

	@Override
	public DiaMenu edit(DiaMenu diaMenu) {
		return (DiaMenu) super.edit(diaMenu);
		
	}
	
	public List<DiaMenu> getAll(){
		return super.getAll(DiaMenu.class);
	}

	@Override
	public DiaMenu get(Long id) throws EntityNotFoundException {
		return (DiaMenu) super.getById(DiaMenu.class, id);
	}

	@Override
	public List<DiaMenu> get(String nombre)	throws EntityNotFoundException {
		return super.getByName(DiaMenu.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		DiaMenu diaMenu = this.get(id);
		diaMenu.setActivo(false);
		this.edit(diaMenu);
	}

}
