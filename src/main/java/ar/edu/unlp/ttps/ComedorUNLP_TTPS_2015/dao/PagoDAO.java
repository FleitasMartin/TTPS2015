package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Pago;



public interface PagoDAO {

	public Pago save(Pago pago);
	
	public Pago edit(Pago pago);
		
	public Pago get(Long id) throws EntityNotFoundException;
		
	public Pago get(String nombre) throws EntityNotFoundException;
		
	public List<Pago> getAll();

	void delete(Long id);
	
}