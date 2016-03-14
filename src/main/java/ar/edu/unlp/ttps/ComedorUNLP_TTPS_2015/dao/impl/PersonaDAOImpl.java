package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.PersonaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Persona;

@Repository
public class PersonaDAOImpl extends GenericDAOImpl<Persona> implements PersonaDAO{

	public PersonaDAOImpl(){
		super(Persona.class);
	}
	
	public Persona findByDNI(String dni){
		try {
			Query consulta = getEntityManager().createQuery(
					"select p from " + Persona.class.getSimpleName()
							+ " p where p.dni = :dni ").setParameter("dni", dni);
			Persona resultado = (Persona) consulta.getSingleResult();
			return resultado;
		} catch (Exception e) {
			return null;
		}
	}
}
