package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.criterion.Restrictions;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ComponenteDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;


public class ComponenteDAOImpl extends GenericDAOImpl implements ComponenteDAO {

	@Override
	public void save(Componente componente) {
		super.save(componente);
		
	}

	@Override
	public void edit(Componente componente) {
		super.edit(componente);
		
	}

	@Override
	public Componente get(Long idComponente) throws EntityNotFoundException {
		Componente componente = (Componente)super.get(Componente.class, idComponente);  
		if (componente == null) {
			throw new EntityNotFoundException("Componente con id " + idComponente + " no existe");
		}
		return componente;
	}

	@Override
	public Componente get(String componenteNombre)
			throws EntityNotFoundException {
		Componente componente = (Componente)getSessionFactory().getCurrentSession().createCriteria(Componente.class).add(Restrictions.eq("nombre", componenteNombre)).uniqueResult();  
		if (componente == null) {
			throw new EntityNotFoundException("Componente " + componenteNombre + " no existe");
		}
		return componente;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Componente> listAll() {
		return (List<Componente>)super.list(Componente.class);
	}

}
