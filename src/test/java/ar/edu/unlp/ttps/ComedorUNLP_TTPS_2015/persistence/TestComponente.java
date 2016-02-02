package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.persistence;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ComponenteDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resources/applicationContextTest.xml"})
public class TestComponente {

	@Autowired
	private ComponenteDAO componenteDAO;
	private Componente cPostre, cPlato, cEntrada, cBebida;
	
	@Before
	public void setUp(){
		cPostre = new Componente();
		cPostre.setNombre("Helado");
		cPostre.setTipo("Postre");
		cPlato = new Componente();
		cPlato.setNombre("Milanesa con pure");
		cPlato.setTipo("Plato");
		cEntrada = new Componente();
		cEntrada.setNombre("Fiambres varios");
		cEntrada.setTipo("Entrada");
		cBebida = new Componente();
		cBebida.setNombre("Agua");
		cBebida.setTipo("Bebida");
	}
	
	@Test
	public void testComponente(){
		componenteDAO.save(cPostre);
		componenteDAO.save(cPlato);
		componenteDAO.save(cEntrada);
		componenteDAO.save(cBebida);
		
		Assert.assertNotNull(cPostre.getId());
		Assert.assertNotNull(cPlato.getId());
		Assert.assertNotNull(cEntrada.getId());
		Assert.assertNotNull(cBebida.getId());
		
		ArrayList<Componente> componentes = (ArrayList<Componente>) componenteDAO.getAll();
		Assert.assertTrue(componentes.size()==4);
		
		Componente postreRecuperado = componenteDAO.get(cPostre.getId());
		Componente platoRecuperado = componenteDAO.get(cPlato.getId());
		Componente entradaRecuperado = componenteDAO.get(cEntrada.getId());
		Componente bebidaRecuperado = componenteDAO.get(cBebida.getId());
		
		Assert.assertTrue(postreRecuperado.getId().equals(cPostre.getId()));
		Assert.assertTrue(platoRecuperado.getId().equals(cPlato.getId()));
		Assert.assertTrue(entradaRecuperado.getId().equals(cEntrada.getId()));
		Assert.assertTrue(bebidaRecuperado.getId().equals(cBebida.getId()));
		
		Long idARecuperar = cPostre.getId();
		cPostre.setNombre("Gelatina");		
		componenteDAO.edit(cPostre);
		Componente cPostreRecuperado = componenteDAO.get(idARecuperar);
		Assert.assertEquals(cPostreRecuperado.getId(), cPostre.getId());
		
		componenteDAO.delete(cBebida.getId());
		Assert.assertNull(componenteDAO.get(cBebida.getId()));
		
	}

}
