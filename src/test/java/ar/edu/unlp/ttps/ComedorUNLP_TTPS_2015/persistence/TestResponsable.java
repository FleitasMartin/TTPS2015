package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.persistence;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resources/applicationContextTest.xml"})
public class TestResponsable {
	
	@Autowired
	private ResponsableDAO responsableDAO;
	@Autowired
	private SedeDAO sedeDAO;
	private Responsable responsable1, responsable2 ;
	private Sede sede1, sede2;
	
	
	@Before
	public void setUp(){
		
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
		responsable1.setDni("34818052");
		responsable1.setSede(sede1);
	
		responsable2 = new Responsable();
		responsable2.setDni("38298166");
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
		responsable1.setDni("36321248");		
		responsableDAO.edit(responsable1);
		Responsable responsableRecuperado2 = responsableDAO.get(idARecuperar);
		Assert.assertEquals(responsableRecuperado2.getId(), responsable1.getId());
		
		responsableDAO.delete(responsable2.getId());
		Assert.assertNull(responsableDAO.get(responsable2.getId()));

	}

}


		
	
		

