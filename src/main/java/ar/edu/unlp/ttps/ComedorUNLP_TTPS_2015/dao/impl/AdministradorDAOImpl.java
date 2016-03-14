package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;

@Repository
public class AdministradorDAOImpl extends GenericDAOImpl<Administrador> implements AdministradorDAO {

	public AdministradorDAOImpl(){
		super(Administrador.class);
	}
	
		
	@Override
	public Administrador login(String dni, String contrasena){
		Query consulta=getEntityManager().createQuery("select e from "+Administrador.class.getSimpleName()+" e where e.dni = :dni and e.contrasena = :contrasena ").setParameter("dni", dni).setParameter("contrasena", contrasena);
		Administrador resultado = new Administrador();
		try{
			resultado = (Administrador)consulta.getSingleResult();
		}catch(Exception e){
			resultado = null;
		}
		return resultado;
	}
	
}
