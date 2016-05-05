package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.PagoDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Pago;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@Repository
public class PagoDAOImpl extends GenericDAOImpl<Pago> implements PagoDAO {

	public PagoDAOImpl() {
		super(Pago.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pago> getAllBySedeId(Sede sede, List<Long> ids) {
		try {
			Query consulta = getEntityManager()
					.createQuery(
							"select p from "
									+ Pago.class.getSimpleName()
									+ " p where p.sede=:sede and p.compra.id IN (:ids)")
					.setParameter("sede", sede).setParameter("ids", ids);
			List<Pago> pagos = (List<Pago>) consulta.getResultList();
			return pagos;
		} catch (Exception e) {
			return null;
		}
	}

}