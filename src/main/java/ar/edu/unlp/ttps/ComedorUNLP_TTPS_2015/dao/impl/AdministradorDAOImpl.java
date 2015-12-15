package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;

@Repository
public class AdministradorDAOImpl extends GenericDAOImpl implements AdministradorDAO {

	@Override
	public Administrador save(Administrador administrador) {
		return  (Administrador) super.save(administrador);
		
	}

	@Override
	public Administrador edit(Administrador administrador) {
		return (Administrador) super.edit(administrador);
		
	}
	
	public List<Administrador> getAll(){
		return super.getAll(Administrador.class);
	}

	@Override
	public Administrador get(Long id) throws EntityNotFoundException {
		return (Administrador) super.getById(Administrador.class, id);
	}

	@Override
	public Administrador get(String nombre)	throws EntityNotFoundException {
		return (Administrador) super.getByName(Administrador.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		Administrador componente = this.get(id);
		componente.setActivo(false);
		this.edit(componente);
	}


}
