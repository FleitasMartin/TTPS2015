package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.CartillaDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.ComponenteDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.CompraDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.MenuDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.PagoDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.SedeDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.UsuarioDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.DiaMenu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Pago;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.SeleccionDiaMenu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestCompleto extends TestCase {

	private CartillaDAOImpl cartillaDAO = new CartillaDAOImpl();
	private SedeDAOImpl sedeDAO = new SedeDAOImpl();
	private Cartilla cartilla = new Cartilla();
	private Sede sede = new Sede();
		
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		Componente bebida = new Componente(), 
				entrada1 = new Componente(), 
				entrada2 = new Componente(), 
				plato1 = new Componente(), 
				plato2 = new Componente(), 
				postre1 = new Componente(), 
				postre2 = new Componente();
		bebida.setNombre("Agua");
		bebida.setTipo("Bebida");
		entrada1.setNombre("Entrada1");
		entrada1.setTipo("Entrada");
		entrada2.setNombre("Entrada2");
		entrada2.setTipo("Entrada");
		plato1.setNombre("Plato1");
		plato1.setTipo("Plato");
		plato2.setNombre("Plato2");
		plato2.setTipo("Plato");
		postre1.setNombre("Postre1");
		postre1.setTipo("Postre");
		postre2.setNombre("Postre2");
		postre2.setTipo("Postre");
		
		ComponenteDAOImpl componenteDAO = new ComponenteDAOImpl();
		componenteDAO.save(postre2);
		componenteDAO.save(postre1);
		componenteDAO.save(plato1);
		componenteDAO.save(plato2);
		componenteDAO.save(entrada1);
		componenteDAO.save(entrada2);
		componenteDAO.save(bebida);
		
		Menu menu1 = new Menu(), 
			menu2 = new Menu(), 
			menu3 = new Menu(), 
			menu4 = new Menu(), 
			menu5 = new Menu();
		
		menu1.setNombre("MENU1");
		menu1.setCeliaco(true);
		menu1.setDiabetico(false);
		menu1.setHipertenso(true);
		menu1.setIntoLactosa(false);
		menu1.setVegetariano(true);
		menu1.setFechaAlta(new Date());
		
		menu2.setNombre("MENU2");
		menu2.setCeliaco(true);
		menu2.setDiabetico(false);
		menu2.setHipertenso(true);
		menu2.setIntoLactosa(false);
		menu2.setVegetariano(true);
		menu2.setFechaAlta(new Date());
		
		menu3.setNombre("MENU3");
		menu3.setCeliaco(true);
		menu3.setDiabetico(false);
		menu3.setHipertenso(true);
		menu3.setIntoLactosa(false);
		menu3.setVegetariano(true);
		menu3.setFechaAlta(new Date());
		
		menu4.setNombre("MENU4");
		menu4.setCeliaco(true);
		menu4.setDiabetico(false);
		menu4.setHipertenso(true);
		menu4.setIntoLactosa(false);
		menu4.setVegetariano(true);
		menu4.setFechaAlta(new Date());
		
		menu5.setNombre("MENU5");
		menu5.setCeliaco(true);
		menu5.setDiabetico(false);
		menu5.setHipertenso(true);
		menu5.setIntoLactosa(false);
		menu5.setVegetariano(true);
		menu5.setFechaAlta(new Date());
		
		ArrayList<Componente> lista1 = new ArrayList<Componente>(),
							lista2 = new ArrayList<Componente>(),
							lista3 = new ArrayList<Componente>(),
							lista4 = new ArrayList<Componente>(),
							lista5 = new ArrayList<Componente>(); 
		lista1.add(bebida);
		lista1.add(entrada1);
		lista1.add(plato1);
		lista1.add(postre1);
		menu1.setComponentes( lista1 );
		
		lista2.add(bebida);
		lista2.add(entrada2);
		lista2.add(plato2);
		lista2.add(postre1);
		menu2.setComponentes( lista2 );
		
		lista3.add(bebida);
		lista3.add(entrada1);
		lista3.add(plato1);
		lista3.add(postre2);
		menu3.setComponentes( lista3 );
		
		lista4.add(bebida);
		lista4.add(entrada2);
		lista4.add(plato2);
		lista4.add(postre2);
		menu4.setComponentes( lista4 );
		
		lista5.add(bebida);
		lista5.add(entrada1);
		lista5.add(plato2);
		lista5.add(postre1);
		menu5.setComponentes( lista5 );
		
		MenuDAOImpl menuDAO = new MenuDAOImpl();
		menuDAO.save(menu1);
		menuDAO.save(menu2);
		menuDAO.save(menu3);
		menuDAO.save(menu4);
		menuDAO.save(menu5);
		
		DiaMenu diaLunes = new DiaMenu(),
				diaMartes = new DiaMenu(),
				diaMiercoles = new DiaMenu(),
				diaJueves = new DiaMenu(),
				diaViernes = new DiaMenu();
		
		diaLunes.setNombre("Lunes");
		diaMartes.setNombre("Martes");
		diaMiercoles.setNombre("Miercoles");
		diaJueves.setNombre("Jueves");
		diaViernes.setNombre("Viernes");
		
		ArrayList<Menu> arregloDiaMenu1 = new ArrayList<Menu>(),
				arregloDiaMenu2 = new ArrayList<Menu>(),
				arregloDiaMenu3 = new ArrayList<Menu>(),
				arregloDiaMenu4 = new ArrayList<Menu>(),
				arregloDiaMenu5 = new ArrayList<Menu>();  
		arregloDiaMenu1.add(menu1);
		arregloDiaMenu2.add(menu2);
		arregloDiaMenu3.add(menu3);
		arregloDiaMenu4.add(menu4);
		arregloDiaMenu5.add(menu5);
		
		diaLunes.setMenues(arregloDiaMenu1);
		diaMartes.setMenues(arregloDiaMenu2);
		diaMiercoles.setMenues(arregloDiaMenu3);
		diaJueves.setMenues(arregloDiaMenu4);
		diaViernes.setMenues(arregloDiaMenu5);
		
		ArrayList<DiaMenu> diasMenues = new ArrayList<DiaMenu>();
		diasMenues.add(diaLunes);
		diasMenues.add(diaMartes);
		diasMenues.add(diaMiercoles);
		diasMenues.add(diaJueves);
		diasMenues.add(diaViernes);
		cartilla.setDiasMenues(diasMenues);
		cartilla.setPrecio(7.5);
		Date fechaInicio = new Date();
		fechaInicio.setYear(2015);;
		fechaInicio.setMonth(12);
		fechaInicio.setDate(7);
		Date fechaFin = new Date();
		fechaFin.setYear(2015);;
		fechaFin.setMonth(12);
		fechaFin.setDate(11);
		cartilla.setFechaInicio(fechaInicio);
		cartilla.setFechaFin(fechaFin);		
		cartillaDAO.save(cartilla);		
		
		sede.setNombre("Bosque");
		sede.setUbicacion("115 y 50");
		sede.setCapacidad(1500);
		sedeDAO.save(sede);
		Assert.assertNotNull(sede.getId());
	}
	
	@Test
	public void testCartilla(){
				
		Assert.assertNotNull(cartilla.getId());
		
		Cartilla cartillaRecuperada = cartillaDAO.get(cartilla.getId());
		Assert.assertEquals(cartilla.getId(), cartillaRecuperada.getId());
		
		cartilla.setPrecio(99.9);
		cartillaDAO.edit(cartilla);
		Cartilla cartillaRecuperada2 = cartillaDAO.get(cartilla.getId());
		Assert.assertEquals(cartillaRecuperada2.getPrecio(), 99.9);
		
		cartillaDAO.delete(cartilla.getId());
		Cartilla cartillaRecuperada3 = cartillaDAO.get(cartilla.getId());
		Assert.assertFalse(cartillaRecuperada3.getActivo());
		
		
	}
	
	@Test
	public void testPagoUsuario(){
		
		Usuario usuario = new Usuario();
		usuario.setApellido("Perez");
		usuario.setNombre("Juan");
		usuario.setFacultad("Informatica");
		usuario.setTipo("Alumno");
		usuario.setEmail("juan@perez.com");
		usuario.setCeliaco(false);
		usuario.setVegetariano(false);
		usuario.setDiabetico(false);
		usuario.setHipertenso(false);
		usuario.setIntoLactosa(false);
		usuario.setDni(12345678);
		
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		usuarioDAO.save(usuario);
		
		SeleccionDiaMenu seleccionLunes = new SeleccionDiaMenu(),
						seleccionMartes = new SeleccionDiaMenu();
		
		seleccionLunes.setNombre("Lunes");
		seleccionLunes.setVianda(true);
		seleccionLunes.setMenu(cartilla.getDiasMenues().get(0).getMenues().get(0));
		System.out.println(cartilla.getDiasMenues().get(0).getMenues().get(0).getNombre());
		
		seleccionMartes.setNombre("Martes");
		seleccionMartes.setVianda(true);
		seleccionMartes.setMenu(cartilla.getDiasMenues().get(1).getMenues().get(0));	
		
		seleccionLunes.setSede(sede);
		seleccionMartes.setSede(sede);
				
		ArrayList<SeleccionDiaMenu> selecciones = new ArrayList<SeleccionDiaMenu>();
		selecciones.add(seleccionLunes);
		selecciones.add(seleccionMartes);
		
		Compra compra = new Compra();
		compra.setSelecciones(selecciones);
		compra.setMonto(cartilla.getPrecio() * selecciones.size());
		compra.setFechaEfectuada(new Date(2015,12,1));
		compra.setUsuario(usuario);
		
		ArrayList<Compra> compras = new ArrayList<Compra>();
		compras.add(compra);
		usuario.setCompras(compras);		
		
		CompraDAOImpl compraDAO = new CompraDAOImpl();
		compraDAO.save(compra);
				
		Pago pago = new Pago();
		pago.setCompra(compra);
		pago.setSede(sede);
		pago.setFechaPago(new Date());
		pago.setUsuario(usuario);
		
		ArrayList<Pago> pagos= new ArrayList<Pago>();
		pagos.add(pago);
		usuario.setPagos( pagos );		
		
		PagoDAOImpl pagoDAO = new PagoDAOImpl();
		pagoDAO.save(pago);
		Assert.assertNotNull(usuario.getId());
		Assert.assertNotNull(compra.getId());
		Assert.assertNotNull(pago.getId());
		Assert.assertNotNull(seleccionLunes.getId());
		
	}
	
}
