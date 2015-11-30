package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.persistence;

import java.util.ArrayList;

import org.junit.Test;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.ComponenteDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import junit.framework.Assert;
import junit.framework.TestCase;


public class TestComponente extends TestCase {

	private ComponenteDAOImpl componenteDAO = new ComponenteDAOImpl();
	private Componente cPostre, cPlato, cEntrada, cBebida;
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
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
		Componente cBebidaEliminada = componenteDAO.get(cBebida.getId());
		Assert.assertFalse(cBebidaEliminada.getActivo());
	}

}
