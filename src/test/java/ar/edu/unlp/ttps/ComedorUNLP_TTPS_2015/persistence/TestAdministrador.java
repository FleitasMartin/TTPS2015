package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.persistence;


import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.AdministradorDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import junit.framework.Assert;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resources/applicationContextTest.xml"})
public class TestAdministrador extends TestCase {

	@Autowired
	private AdministradorDAOImpl administradorDAO;//= new AdministradorDAOImpl();
	
	
	private Administrador admin1,admin2;
	
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		admin1 = new Administrador();
		admin1.setDni(1234);
		admin2 = new Administrador();
		admin2.setDni(456);
		
	}
	@Test
	public void testAdministrador(){
		administradorDAO.save(admin1);
		administradorDAO.save(admin2);
		Administrador admin1Recuperado = administradorDAO.get(admin1.getId());
		Administrador admin2Recuperado = administradorDAO.get(admin2.getId());

		Assert.assertTrue(admin1Recuperado.getDni().equals(admin1.getDni()));
		Assert.assertTrue(admin2Recuperado.getDni().equals(admin2.getDni()));
		
		admin1.setDni(789);
		administradorDAO.edit(admin1);
		
		administradorDAO.delete(admin1.getId());
		Administrador adminEliminado = administradorDAO.get(admin1.getId());
		Assert.assertFalse(adminEliminado.getActivo());
	}
	@Test
	public void testGetAllAdministradores(){
		ArrayList<Administrador> administrador = (ArrayList<Administrador>) administradorDAO.getAll();
		Assert.assertTrue(administrador.size()==2);
	}
	public AdministradorDAOImpl getAdministradorDAO() {
		return administradorDAO;
	}
	public void setAdministradorDAO(AdministradorDAOImpl administradorDAO) {
		this.administradorDAO = administradorDAO;
	}


}
