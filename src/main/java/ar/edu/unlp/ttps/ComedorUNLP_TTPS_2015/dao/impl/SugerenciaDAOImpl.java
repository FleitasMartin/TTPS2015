package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SugerenciaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;

@Repository
public class SugerenciaDAOImpl extends GenericDAOImpl implements SugerenciaDAO {
	@Override
	public Sugerencia save(Sugerencia sugerencia) {
		return (Sugerencia) super.save(sugerencia);
		
	}

	@Override
	public Sugerencia edit(Sugerencia sugerencia) {
		return (Sugerencia) super.edit(sugerencia);
		
	}
	
	public List<Sugerencia> getAll(){
		return super.getAll(Sugerencia.class);
	}

	@Override
	public Sugerencia get(Long id) throws EntityNotFoundException {
		return (Sugerencia) super.getById(Sugerencia.class, id);
	}

	@Override
	public Sugerencia get(String nombre)	throws EntityNotFoundException {
		return (Sugerencia) super.getByName(Sugerencia.class, nombre);
	}
	
	@Override
	public void delete(Long id){
		Sugerencia sugerencia = this.get(id);
		sugerencia.setActivo(false);
		this.edit(sugerencia);
	}


}