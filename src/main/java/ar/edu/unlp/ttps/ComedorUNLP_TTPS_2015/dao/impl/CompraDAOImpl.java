package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CompraDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;

@Repository
public class CompraDAOImpl extends GenericDAOImpl<Compra> implements CompraDAO {

	public CompraDAOImpl() {
		super(Compra.class);
	}

	public List<Compra> getAllByUsuario(Long idUsuario) {
		try {
			Query consulta = getEntityManager().createQuery(
					"select c from " + getPersistentClass().getSimpleName()
							+ " c where c.usuario.id = :idUsuario ")
					.setParameter("idUsuario", idUsuario);
			@SuppressWarnings("unchecked")
			List<Compra> compras = (List<Compra>) consulta.getResultList();
			return compras;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Long> getIdsPagadosByFecha(Object inicio, Object fin) {
		try {
			Query consulta = getEntityManager()
					.createQuery(
							"select c.id from "
									+ getPersistentClass().getSimpleName()
									+ " c where pagado = true and c.fechaEfectuada >= :inicio and c.fechaEfectuada <= :fin")
					.setParameter("inicio", inicio).setParameter("fin", fin);
			@SuppressWarnings("unchecked")
			List<Long> idsCompras = (List<Long>) consulta.getResultList();
			return idsCompras;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
