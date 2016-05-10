package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;

@Repository
public class CartillaDAOImpl extends GenericDAOImpl<Cartilla> implements
		CartillaDAO {

	public CartillaDAOImpl() {
		super(Cartilla.class);
	}

	public Cartilla getFirstCartilla(Object fechaActual) {
		Query consulta = getEntityManager().createQuery(
				"select e from " + getPersistentClass().getSimpleName()
						+ " e where e.fechaInicio >   :fechaActual"
						+ " ORDER BY fechaInicio DESC")
						.setParameter("fechaActual", fechaActual);
		Cartilla resultado = new Cartilla();
		try {
			resultado = (Cartilla) consulta.getSingleResult();
		} catch (Exception e) {
			resultado = null;
		}
		return resultado;
	}

}