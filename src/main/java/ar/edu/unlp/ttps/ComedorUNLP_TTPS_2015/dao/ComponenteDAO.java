package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;


public interface ComponenteDAO {
	
	public Componente save(Componente componente);
		
	public Componente edit(Componente componente);
		
	public Componente get(Long idComponente) throws EntityNotFoundException;
		
	public List<Componente> get(String componenteNombre) throws EntityNotFoundException;
		
	public List<Componente> getAll();
	
	public void delete(Long id);
	

}
