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
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SugerenciaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.ResponsableDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.SedeDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.SugerenciaDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resources/applicationContextTest.xml"})
public class TestSugerencia{
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private SedeDAO sedeDAO = new SedeDAOImpl();
	@Autowired
	private SugerenciaDAO sugerenciaDAO = new SugerenciaDAOImpl();
	@Autowired
	private ResponsableDAO responsableDAO = new ResponsableDAOImpl();
	private Usuario usuario;
	private Sede sede1, sede2;
	private Sugerencia sugerencia1, sugerencia2;
	private Responsable responsable1, responsable2 ;
	
	@Before
	public void setUp(){
		
		sede1 = new Sede();
		sede1.setNombre("Bosque");
		sede1.setUbicacion("115 y 50");
		sede1.setCapacidad(1500);
		
		responsable1 = new Responsable();
		responsable1.setDni(34818052);
		responsable1.setSede(sede1);
		
		ArrayList<Responsable> responsables1 = new ArrayList<Responsable>();
		responsables1.add(responsable1);
		sede1.setResponsables(responsables1);
		
		sedeDAO.save(sede1);
		Assert.assertNotNull(sede1.getId());
		
		responsableDAO.save(responsable1);
		Assert.assertNotNull(responsable1.getId());
		
		sede2 = new Sede();
		sede2.setNombre("Bosque");
		sede2.setUbicacion("115 y 50");
		sede2.setCapacidad(1500);
		
		responsable2 = new Responsable();
		responsable2.setDni(38298166);
		responsable2.setSede(sede2);
		
		ArrayList<Responsable> responsables2 = new ArrayList<Responsable>();
		responsables2.add(responsable2);
		sede2.setResponsables(responsables2);
		
		sedeDAO.save(sede2);
		Assert.assertNotNull(sede2.getId());
		
		responsableDAO.save(responsable2);
		Assert.assertNotNull(responsable2.getId());
				
		Usuario usuario = new Usuario();
		usuario.setApellido("Lopez");
		usuario.setNombre("Luis");
		usuario.setFacultad("Abogado");
		usuario.setTipo("No Docente");
		usuario.setEmail("luis@lopez.com");
//		usuario.setCeliaco(false);
//		usuario.setVegetariano(false);
//		usuario.setDiabetico(false);
//		usuario.setHipertenso(false);
//		usuario.setIntoLactosa(false);
		usuario.setDni(17486225);
		
		sugerencia1 = new Sugerencia();
		sugerencia1.setTipo("comentario");
		sugerencia1.setSede(sede1);
		sugerencia1.setMensaje("el lugar esta re lendo");
		sugerencia1.setUsuario(usuario);
		
		sugerencia2 = new Sugerencia();
		sugerencia2.setTipo("comida");
		sugerencia2.setSede(sede2);
		sugerencia2.setMensaje("hagan menues mas variados");
		sugerencia2.setUsuario(usuario);
		
		ArrayList<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		sugerencias.add(sugerencia1);
		sugerencias.add(sugerencia2);
		usuario.setSugerencias(sugerencias);
		
		usuarioDAO.save(usuario);
		Assert.assertNotNull(usuario.getId());
		
	}
	
	@Test
	public void testResponsable(){
		
		sugerenciaDAO.save(sugerencia1);
		sugerenciaDAO.save(sugerencia2);
		Assert.assertNotNull(sugerencia1.getId());
		Assert.assertNotNull(sugerencia2.getId());
		
		ArrayList<Sugerencia> sugerencias = (ArrayList<Sugerencia>) sugerenciaDAO.getAll();
		Assert.assertTrue(sugerencias.size()==2);
		
		Long idARecuperar = sugerencia1.getId();
		sugerencia1.setMensaje("mejoren los postres");;		
		sugerenciaDAO.edit(sugerencia1);
		Sugerencia sugerenciaRecuperada1 = sugerenciaDAO.get(idARecuperar);
		Assert.assertEquals(sugerenciaRecuperada1.getId(), sugerencia1.getId());
		
		sugerenciaDAO.delete(sugerencia2.getId());
		Assert.assertNull(sugerenciaDAO.get(sugerencia2.getId()));
		
	}


}
