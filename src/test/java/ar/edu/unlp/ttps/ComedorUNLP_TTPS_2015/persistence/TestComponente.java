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
	public void testSaveComponente(){
		componenteDAO.save(cPostre);
		componenteDAO.save(cPlato);
		componenteDAO.save(cEntrada);
		componenteDAO.save(cBebida);
	}
	
	@Test
	public void testGetAllComponente(){
		ArrayList<Componente> componentes = (ArrayList<Componente>) componenteDAO.getAll();
		Assert.assertTrue(componentes.size()==4);
	}
	
	@Test
	public void testGetComponente(){
		Componente postreRecuperado = componenteDAO.get(cPostre.getId());
		Componente platoRecuperado = componenteDAO.get(cPlato.getId());
		Componente entradaRecuperado = componenteDAO.get(cEntrada.getId());
		Componente bebidaRecuperado = componenteDAO.get(cBebida.getId());
		Assert.assertTrue(postreRecuperado.getNombre().equals(cPostre.getNombre()));
		Assert.assertTrue(platoRecuperado.getNombre().equals(cPlato.getNombre()));
		Assert.assertTrue(entradaRecuperado.getNombre().equals(cEntrada.getNombre()));
		Assert.assertTrue(bebidaRecuperado.getNombre().equals(cBebida.getNombre()));
	}
	
	@Test
	public void testEditComponente(){
		cPostre.setNombre("Gelatina");
		componenteDAO.edit(cPostre);
	}
	
	@Test
	public void testDeleteComponente(){
		componenteDAO.delete(cBebida.getId());
		componenteDAO.get(cBebida.getId());
		Assert.assertFalse(cBebida.getActivo());		
	}
	
}
