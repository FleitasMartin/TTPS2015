package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;

public interface MenuDAO {

	public Menu save(Menu menu);
	
	public Menu edit(Menu menu);
		
	public Menu get(Long idMenu) throws EntityNotFoundException;
		
	public Menu get(String menuNombre) throws EntityNotFoundException;
		
	public List<Menu> listAll();
	
}
