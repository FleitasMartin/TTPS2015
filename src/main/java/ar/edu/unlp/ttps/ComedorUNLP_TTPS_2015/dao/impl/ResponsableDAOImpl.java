package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;

@Repository
public class ResponsableDAOImpl extends GenericDAOImpl<Responsable> implements
		ResponsableDAO {

	public ResponsableDAOImpl() {
		super(Responsable.class);
	}

	@Override
	public Responsable findByDNI(String dni) {
		try {
			Query consulta = getEntityManager().createQuery(
					"select p from " + Responsable.class.getSimpleName()
							+ " p where p.dni = :dni ")
					.setParameter("dni", dni);
			Responsable resultado = (Responsable) consulta.getSingleResult();
			return resultado;
		} catch (Exception e) {
			return null;
		}
	}

}