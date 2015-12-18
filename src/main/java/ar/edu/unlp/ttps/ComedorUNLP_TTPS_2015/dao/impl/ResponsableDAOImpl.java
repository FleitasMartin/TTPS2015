package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;

@Repository
public class ResponsableDAOImpl extends GenericDAOImpl implements ResponsableDAO {

	@Override
	public Responsable save(Responsable responsable) {
		return (Responsable) super.save(responsable);
		
	}

	@Override
	public Responsable edit(Responsable responsable) {
		return (Responsable) super.edit(responsable);
		
	}
	
	public List<Responsable> getAll(){
		return super.getAll(Responsable.class);
	}

	@Override
	public Responsable get(Long id) throws EntityNotFoundException {
		return (Responsable) super.getById(Responsable.class, id);
	}

	@Override
	public Responsable get(String nombre)	throws EntityNotFoundException {
		return (Responsable) super.getByName(Responsable.class, nombre);
	}
	
	@Override
	public Responsable login(int dni, String contrasena){
		Query consulta=getEntityManager().createQuery("select e from "+Responsable.class.getSimpleName()+" e where e.dni = :dni and e.contrasena = :contrasena ").setParameter("dni", dni).setParameter("contrasena", contrasena);
		Responsable resultado = new Responsable();
		try{
			resultado = (Responsable)consulta.getSingleResult();
		}catch(Exception e){
			resultado = null;
		}
		return resultado;
	}
	
	@Override
	public void delete(Long id){
		Responsable responsable = this.get(id);
		responsable.setActivo(false);
		this.edit(responsable);
	}


}