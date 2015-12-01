package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.persistence;

import java.util.ArrayList;

import org.junit.Test;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.ResponsableDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.SedeDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestResponsable extends TestCase {
	private ResponsableDAOImpl responsableDAO = new ResponsableDAOImpl();
	private Responsable responsable1, responsable2 ;
	private Sede sede1, sede2;
	private SedeDAOImpl sedeDAO = new SedeDAOImpl();
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		
		sede1 = new Sede();
		sede1.setNombre("Bosque");
		sede1.setUbicacion("115 y 50");
		sede1.setCapacidad(1500);
		sedeDAO.save(sede1);
		Assert.assertNotNull(sede1.getId());
		
		sede2 = new Sede();
		sede2.setNombre("Bosque");
		sede2.setUbicacion("115 y 50");
		sede2.setCapacidad(1500);
		sedeDAO.save(sede2);
		Assert.assertNotNull(sede2.getId());
		
		
		responsable1 = new Responsable();
		responsable1.setDni(34818052);
		responsable1.setSede(sede1);
	
		responsable2 = new Responsable();
		responsable2.setDni(38298166);
		responsable2.setSede(sede2);
		
	}
	
	@Test
	public void testResponsable(){
		responsableDAO.save(responsable1);
		responsableDAO.save(responsable2);
	
		Assert.assertNotNull(responsable1.getId());
		Assert.assertNotNull(responsable2.getId());
		
		ArrayList<Responsable> responsables = (ArrayList<Responsable>) responsableDAO.getAll();
		Assert.assertTrue(responsables.size()==2);
		
		Responsable responsableRecuperado1 = responsableDAO.get(responsable1.getId());
		Assert.assertTrue(responsableRecuperado1.getId().equals(responsable1.getId()));
		
		Long idARecuperar = responsable1.getId();
		responsable1.setDni(36321248);		
		responsableDAO.edit(responsable1);
		Responsable responsableRecuperado2 = responsableDAO.get(idARecuperar);
		Assert.assertEquals(responsableRecuperado2.getId(), responsable1.getId());
		
		responsableDAO.delete(responsable2.getId());
		Responsable responsableEliminado = responsableDAO.get(responsable2.getId());
		Assert.assertFalse(responsableEliminado.getActivo());

	}

}


		
	
		

