package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SeleccionDiaMenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.SeleccionDiaMenu;

@Repository
public class SeleccionDiaMenuDAOImpl extends GenericDAOImpl implements SeleccionDiaMenuDAO {
	@Override
	public SeleccionDiaMenu save(SeleccionDiaMenu seleccionDiaMenu) {
		return (SeleccionDiaMenu) super.save(seleccionDiaMenu);
		
	}

	@Override
	public SeleccionDiaMenu edit(SeleccionDiaMenu seleccionDiaMenu) {
		return (SeleccionDiaMenu) super.edit(seleccionDiaMenu);
		
	}
	
	public List<SeleccionDiaMenu> getAll(){
		return super.getAll(SeleccionDiaMenu.class);
	}

	@Override
	public SeleccionDiaMenu get(Long id) throws EntityNotFoundException {
		return (SeleccionDiaMenu) super.getById(SeleccionDiaMenu.class, id);
	}

	@Override
	public SeleccionDiaMenu get(String nombre)	throws EntityNotFoundException {
		return (SeleccionDiaMenu) super.getByName(SeleccionDiaMenu.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		SeleccionDiaMenu seleccionDiaMenu = this.get(id);
		seleccionDiaMenu.setActivo(false);
		this.edit(seleccionDiaMenu);
	}


}