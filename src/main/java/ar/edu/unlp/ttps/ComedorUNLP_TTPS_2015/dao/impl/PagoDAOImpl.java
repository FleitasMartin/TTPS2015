package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.PagoDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Pago;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.SeleccionDiaMenu;

@Repository
public class PagoDAOImpl extends GenericDAOImpl<Pago> implements PagoDAO {

	public PagoDAOImpl() {
		super(Pago.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pago> getAllByFechaYSede(Sede sede, Object inicio, Object fin){
		try {
			Query consulta = getEntityManager()
					.createQuery(
							"select p from "
									+ Pago.class.getSimpleName()
									+ " p where p.sede = :sede and exists ( "
									+ "	from "+SeleccionDiaMenu.class.getSimpleName()
									+ " s where s in elements(p.compra.selecciones) "
											+ "and s.fecha >= :inicio and s.fecha <= :fin"
											+ ") ")
					.setParameter("sede", sede).setParameter("inicio", inicio).setParameter("fin", fin);
			List<Pago> pagos = (List<Pago>) consulta.getResultList();
			return pagos;
		} catch (Exception e) {
			return null;
		}
	}

}