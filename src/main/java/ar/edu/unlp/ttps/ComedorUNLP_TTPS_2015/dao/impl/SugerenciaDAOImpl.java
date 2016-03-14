package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SugerenciaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;

@Repository
public class SugerenciaDAOImpl extends GenericDAOImpl<Sugerencia> implements SugerenciaDAO {
	
	public SugerenciaDAOImpl(){
		super(Sugerencia.class);
	}
	
	public List<Sugerencia> getAllBySede(Long idSede) {
		Query consulta = getEntityManager().createQuery(
				"select e from " + getPersistentClass().getSimpleName() +  " e where e.sede.id = " + idSede);
		@SuppressWarnings("unchecked")
		List<Sugerencia> resultado = (List<Sugerencia>) consulta.getResultList();
		return resultado;
	}
	

}