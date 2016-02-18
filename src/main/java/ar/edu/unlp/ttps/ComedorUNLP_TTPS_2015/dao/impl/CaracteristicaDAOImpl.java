package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Caracteristica;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CaracteristicaDAO;
import org.springframework.stereotype.Repository;

@Repository
public class CaracteristicaDAOImpl extends GenericDAOImpl<Caracteristica> implements CaracteristicaDAO{

	public CaracteristicaDAOImpl(){
		super(Caracteristica.class);
	}
}
