package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SemanaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Semana;

@Repository
public class SemanaDAOImpl extends GenericDAOImpl<Semana> implements SemanaDAO {

	public SemanaDAOImpl(){
		super(Semana.class);
	}
}
