package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;



import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;

@Repository
public class CartillaDAOImpl extends GenericDAOImpl<Cartilla> implements CartillaDAO{

	public CartillaDAOImpl(){
		super(Cartilla.class);
	}
	
	public Cartilla getFirstCartilla (Object fechaActual){
		Query consulta = getEntityManager().createQuery(
				"select e from " + getPersistentClass().getSimpleName() +  " e where e.fechaInicio > " + fechaActual + " ORDER BY fechaInicio DESC");
		@SuppressWarnings("unchecked")
		Cartilla resultado = (Cartilla) consulta.getSingleResult();
		return resultado;
	}

}