package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CompraDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;

@Repository
public class CompraDAOImpl extends GenericDAOImpl implements CompraDAO {
	@Override
	public Compra save(Compra compra) {
		return (Compra) super.save(compra);
		
	}

	@Override
	public Compra edit(Compra compra) {
		return (Compra) super.edit(compra);
		
	}
	
	public List<Compra> getAll(){
		return super.getAll(Compra.class);
	}

	@Override
	public Compra get(Long id) throws EntityNotFoundException {
		return (Compra) super.getById(Compra.class, id);
	}

	@Override
	public Compra get(String nombre)	throws EntityNotFoundException {
		return (Compra) super.getByName(Compra.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		Compra compra = this.get(id);
		compra.setActivo(false);
		this.edit(compra);
	}


}
