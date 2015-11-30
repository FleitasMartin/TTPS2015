package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.PagoDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Pago;



public class PagoDAOImpl extends GenericDAOImpl implements PagoDAO{

	@Override
	public Pago save(Pago pago) {
		return (Pago) super.save(pago);
		
	}

	@Override
	public Pago edit(Pago pago) {
		return (Pago) super.edit(pago);
		
	}
	
	public List<Pago> getAll(){
		return super.getAll(Pago.class);
	}

	@Override
	public Pago get(Long id) throws EntityNotFoundException {
		return (Pago) super.getById(Pago.class, id);
	}

	@Override
	public Pago get(String nombre)	throws EntityNotFoundException {
		return (Pago) super.getByName(Pago.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		Pago pago = this.get(id);
		pago.setActivo(false);
		this.edit(pago);
	}


}