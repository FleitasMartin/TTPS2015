package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;



public class ResponsableDAOImpl extends GenericDAOImpl implements ResponsableDAO {

	@Override
	public Responsable save(Responsable responsable) {
		return (Responsable) super.save(responsable);
		
	}

	@Override
	public Responsable edit(Responsable responsable) {
		return (Responsable) super.edit(responsable);
		
	}
	
	public List<Responsable> getAll(){
		return super.getAll(Responsable.class);
	}

	@Override
	public Responsable get(Long id) throws EntityNotFoundException {
		return (Responsable) super.getById(Responsable.class, id);
	}

	@Override
	public Responsable get(String nombre)	throws EntityNotFoundException {
		return (Responsable) super.getByName(Responsable.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		Responsable responsable = this.get(id);
		responsable.setActivo(false);
		this.edit(responsable);
	}


}