package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

public interface CompraDAO {
	public Compra save(Compra compra);
	
	public Compra edit(Compra compra);
		
	public Compra get(Long id) throws EntityNotFoundException;
		
	public Compra get(String nombre) throws EntityNotFoundException;
		
	public List<Compra> getAll();

	void delete(Long id);
	
}