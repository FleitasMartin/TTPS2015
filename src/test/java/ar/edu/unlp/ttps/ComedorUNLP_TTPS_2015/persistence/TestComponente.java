package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.persistence;

import org.junit.Test;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.ComponenteDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
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
	}
	
	@Test
	public void testGuardarComponente(){
		componenteDAO.save(cPostre);
	}
}
