package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ComponenteDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;

@Repository
public class ComponenteDAOImpl extends GenericDAOImpl<Componente> implements ComponenteDAO {

	@Override
	public Componente save(Componente componente) {
		return super.save(componente);
		
	}

	@Override
	public Componente edit(Componente componente) {
		return super.edit(componente);
		
	}
	
	public List<Componente> getAll(){
		return super.getAll(Componente.class);
	}

	@Override
	public Componente get(Long idComponente) throws EntityNotFoundException {
		return super.getById(Componente.class, idComponente);
	}

	@Override
	public List<Componente> get(String componenteNombre)	throws EntityNotFoundException {
		return super.getByName(Componente.class, componenteNombre);
	}
	
	@Override
	public void delete(Long id){
		Componente componente = this.get(id);
		componente.setActivo(false);
		this.edit(componente);
	}

}
