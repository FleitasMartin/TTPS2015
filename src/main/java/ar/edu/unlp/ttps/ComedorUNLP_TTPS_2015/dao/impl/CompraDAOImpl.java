package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CompraDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

@Repository
public class CompraDAOImpl extends GenericDAOImpl<Compra> implements CompraDAO {
	
	public CompraDAOImpl(){
		super(Compra.class);
	}
	
	public List<Compra> getAllByUsuario(Long idUsuario){
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

}
