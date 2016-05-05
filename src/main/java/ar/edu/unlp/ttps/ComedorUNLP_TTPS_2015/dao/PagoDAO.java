package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Pago;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

public interface PagoDAO extends GenericDAO<Pago> {

	public List<Pago> getAllBySedeId(Sede sede, List<Long> ids);
}