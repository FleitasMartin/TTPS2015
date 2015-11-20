package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;


public interface ComponenteDAO {
	
	public void save(Componente componente);
		
	public void edit(Componente componente);
		
	public Componente get(Long idComponente) throws EntityNotFoundException;
		
	public Componente get(String componenteNombre) throws EntityNotFoundException;
		
	public List<Componente> listAll();
	

}
