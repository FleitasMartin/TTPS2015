package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.persistence;


import java.util.ArrayList;

import org.junit.Test;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.AdministradorDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import junit.framework.Assert;
import junit.framework.TestCase;


public class TestAdministrador extends TestCase {

	private AdministradorDAOImpl administradorDAO = new AdministradorDAOImpl();
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
	public void testSaveComponente(){
		administradorDAO.save(admin1);
		administradorDAO.save(admin2);
		Administrador admin1Recuperado = administradorDAO.get(admin1.getId());
		Administrador admin2Recuperado = administradorDAO.get(admin2.getId());

		Assert.assertTrue(admin1Recuperado.getDni().equals(admin1.getDni()));
		Assert.assertTrue(admin2Recuperado.getDni().equals(admin2.getDni()));
		
		admin1.setDni(789);
		administradorDAO.edit(admin1);
	}
	@Test
	public void testGetAllAdministradores(){
		ArrayList<Administrador> administrador = (ArrayList<Administrador>) administradorDAO.getAll();
		Assert.assertTrue(administrador.size()==2);
	}

	/*
	@Test
	public void testDeleteComponente(){
		componenteDAO.delete(cBebida.getId());
		componenteDAO.get(cBebida.getId());
		Assert.assertFalse(cBebida.getActivo());		
	}
	*/

}
