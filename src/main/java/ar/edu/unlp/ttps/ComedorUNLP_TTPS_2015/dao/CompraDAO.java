package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.List;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;

public interface CompraDAO extends GenericDAO<Compra> {

	public List<Compra> getAllByUsuario(Long idUsuario);
}