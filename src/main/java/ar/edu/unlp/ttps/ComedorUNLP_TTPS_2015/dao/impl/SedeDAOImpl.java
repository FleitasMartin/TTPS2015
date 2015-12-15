package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@Repository("sedeDAO")
public class SedeDAOImpl extends GenericDAOImpl<Sede> implements SedeDAO{
	@Override
	public Sede save(Sede sede) {
		return (Sede) super.save(sede);
		
	}

	@Override
	public Sede edit(Sede sede) {
		return (Sede) super.edit(sede);
		
	}
	
	public List<Sede> getAll(){
		return super.getAll(Sede.class);
	}

	@Override
	public Sede get(Long id) throws EntityNotFoundException {
		return (Sede) super.getById(Sede.class, id);
	}

	@Override
	public Sede get(String nombre)	throws EntityNotFoundException {
		return (Sede) super.getByName(Sede.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		Sede sede = this.get(id);
		sede.setActivo(false);
		this.edit(sede);
	}


}