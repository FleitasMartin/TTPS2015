package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.SeleccionDiaMenu;



public interface SeleccionDiaMenuDAO {

	public SeleccionDiaMenu save(SeleccionDiaMenu seleccionDiaMenu);
	
	public SeleccionDiaMenu edit(SeleccionDiaMenu seleccionDiaMenu);
		
	public SeleccionDiaMenu get(Long id) throws EntityNotFoundException;
		
	public SeleccionDiaMenu get(String nombre) throws EntityNotFoundException;
		
	public List<SeleccionDiaMenu> getAll();

	void delete(Long id);
	
}