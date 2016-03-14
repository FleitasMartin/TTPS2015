package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;

@Repository
public class ResponsableDAOImpl extends GenericDAOImpl<Responsable> implements ResponsableDAO {

	public ResponsableDAOImpl(){
		super(Responsable.class);
	}
	
	@Override
	public Responsable login(String dni, String contrasena){
		Query consulta=getEntityManager().createQuery("select e from "+Responsable.class.getSimpleName()+" e where e.dni = :dni and e.contrasena = :contrasena ").setParameter("dni", dni).setParameter("contrasena", contrasena);
		Responsable resultado = new Responsable();
		try{
			resultado = (Responsable)consulta.getSingleResult();
		}catch(Exception e){
			resultado = null;
		}
		return resultado;
	}
	


}