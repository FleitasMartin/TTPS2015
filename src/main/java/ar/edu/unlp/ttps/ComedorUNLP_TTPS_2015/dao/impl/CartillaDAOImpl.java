package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;


public class CartillaDAOImpl extends GenericDAOImpl implements CartillaDAO{

	@Override
	public Cartilla save(Cartilla cartilla) {
		return (Cartilla) super.save(cartilla);
		
	}

	@Override
	public Cartilla edit(Cartilla cartilla) {
		return (Cartilla) super.edit(cartilla);
		
	}
	
	public List<Cartilla> getAll(){
		return super.getAll(Cartilla.class);
	}

	@Override
	public Cartilla get(Long id) throws EntityNotFoundException {
		return (Cartilla) super.getById(Cartilla.class, id);
	}

	@Override
	public List<Cartilla> get(String nombre)	throws EntityNotFoundException {
		return super.getByName(Cartilla.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		Cartilla cartilla = this.get(id);
		cartilla.setActivo(false);
		this.edit(cartilla);
	}

}