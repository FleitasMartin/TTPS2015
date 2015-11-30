package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.DiaMenu;


public interface DiaMenuDAO {

	
	public DiaMenu save(DiaMenu diaMenu);
		
	public DiaMenu edit(DiaMenu diaMenu);
		
	public DiaMenu get(Long id) throws EntityNotFoundException;
		
	public List<DiaMenu> get(String nombre) throws EntityNotFoundException;
		
	public List<DiaMenu> getAll();
	
	public void delete(Long id);
	

}