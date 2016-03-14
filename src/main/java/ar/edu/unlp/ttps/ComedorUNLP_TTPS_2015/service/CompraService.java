package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.text.ParseException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CompraDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.MenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SeleccionDiaMenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SemanaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.SeleccionDiaMenu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Semana;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

@Service
public class CompraService {
	@Autowired
	SedeDAO sedeDAO;

	@Autowired
	UsuarioDAO usuarioDAO;

	@Autowired
	CartillaDAO cartillaDAO;

	@Autowired
	SemanaDAO semanaDAO;
	
	@Autowired
	MenuDAO menuDAO;
	
	@Autowired
	CompraDAO compraDAO;
	
	@Autowired
	SeleccionDiaMenuDAO seleccionDiaMenuDAO;
	public ModelAndView compraDeTickets(String dniUsuario)
			throws ParseException {

		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		java.util.Date date = new Date();
		Object param = new java.sql.Date(date.getTime());

		Cartilla cartilla = new Cartilla();
		cartilla = cartillaDAO.getFirstCartilla(param);
		if (cartilla != null) {

			Semana semana = new Semana();
			semana = semanaDAO.get(cartilla.getSemanas().get(0).getId());
			Integer cantidad = cartilla.getSemanas().size();

			Usuario usuario = usuarioDAO.findByDNI(dniUsuario);

			Sede sede = new Sede();
			sede = sedeDAO.get(usuario.getSede().getId());

			model.addObject("usuario", usuario);
			model.addObject("sede", sede);
			model.addObject("cartilla", cartilla);
			model.addObject("semana", semana);
			model.addObject("cantidad", cantidad);
		}
		model.addObject("contentPage", "compraDeTickets");
		return model;
	}
	
	public ModelAndView crear( Long lunesMenu, Long martesMenu, 
			Long miercolesMenu, Long juevesMenu, Long viernesMenu,Date  fechaLunes, Date fechaMartes,Date fechaMiercoles,Date fechaJueves, Date fechaViernes,
			Boolean seleccionViandaLunes,Boolean seleccionViandaMartes,Boolean seleccionViandaMiercoles, Boolean seleccionViandaJueves, Boolean seleccionViandaViernes,
			Double precio, Long sedeID , Integer cantidadSemanas )
	{

		Sede sede = new Sede();
		sede = sedeDAO.get(sedeID);
		

		Compra compra = new Compra ();
		for(int i=0; i<cantidadSemanas ; i++){
		if (lunesMenu != null)
		{
			compra.getSelecciones().add(this.agregarSeleccion(lunesMenu,fechaLunes, 
					sede, seleccionViandaLunes, precio));
			
		}

		
		if (martesMenu != null)
		{
			compra.getSelecciones().add(this.agregarSeleccion(martesMenu,fechaMartes, 
					sede, seleccionViandaMartes, precio));
		}

		
		if (miercolesMenu != null)
		{
			compra.getSelecciones().add(this.agregarSeleccion(miercolesMenu,fechaMiercoles, 
					sede, seleccionViandaMiercoles, precio));
		}
		
		if (juevesMenu != null)
		{
			compra.getSelecciones().add(this.agregarSeleccion(juevesMenu,fechaJueves, 
					sede, seleccionViandaJueves, precio));
		}
		
		if (viernesMenu != null)
		{
			compra.getSelecciones().add(this.agregarSeleccion(viernesMenu,fechaViernes, 
											sede, seleccionViandaViernes, precio));
		}
		}
		compraDAO.save(compra);
		ModelAndView model = new ModelAndView();
		model.addObject("contentPage","compraDeTickets");
		return model;
	}
	
	private SeleccionDiaMenu agregarSeleccion(Long menuId,Date fecha, 
			Sede sede, Boolean seleccionVianda,Double  precio)
	{
		SeleccionDiaMenu seleccionDiaMenu = new SeleccionDiaMenu();
		Menu menu = new Menu();
		menu= menuDAO.get(menuId);
		seleccionDiaMenu.setFecha(fecha);
		seleccionDiaMenu.setMenu(menu);
		seleccionDiaMenu.setNombre(menu.getNombre());
		seleccionDiaMenu.setSede(sede);
		seleccionDiaMenu.setVianda(seleccionVianda);
		seleccionDiaMenu.setPrecio(precio);
		seleccionDiaMenuDAO.save(seleccionDiaMenu);
		return seleccionDiaMenu;
		
	}
}
