package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;


public interface AdministradorDAO {
	public Administrador save(Administrador menu);
	
	public Administrador edit(Administrador menu);
		
	public Administrador get(Long id) throws EntityNotFoundException;
		
	public Administrador get(String menuNombre) throws EntityNotFoundException;
		
	public List<Administrador> getAll();

	void delete(Long id);
	
	public Administrador login(int dni, String contrasena);
}

