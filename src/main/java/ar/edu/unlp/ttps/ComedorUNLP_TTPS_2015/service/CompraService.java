package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public ModelAndView listar(String dniUsuario) {

		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		List<Compra> compras = compraDAO.getAllByUsuario(usuario.getId());
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("compras", compras);
		model.addObject("contentPage", "listarCompras");
		return model;
	}

	public ModelAndView crear(Long lunesMenuId, Long martesMenuId,
			Long miercolesMenuId, Long juevesMenuId, Long viernesMenuId,
			String fechaLunes, String fechaMartes, String fechaMiercoles,
			String fechaJueves, String fechaViernes,
			Boolean seleccionViandaLunes, Boolean seleccionViandaMartes,
			Boolean seleccionViandaMiercoles, Boolean seleccionViandaJueves,
			Boolean seleccionViandaViernes, Double precio, Long sedeID,
			Integer cantidadSemanas, String dniUsuario) throws ParseException {

		Usuario usuarioComprador = usuarioDAO.findByDNI(dniUsuario);

		Sede sede = new Sede();
		sede = sedeDAO.get(sedeID);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date lunes = simpleDateFormat.parse(fechaLunes);
		Date martes = simpleDateFormat.parse(fechaMartes);
		Date miercoles = simpleDateFormat.parse(fechaMiercoles);
		Date jueves = simpleDateFormat.parse(fechaJueves);
		Date viernes = simpleDateFormat.parse(fechaViernes);

		Double montoTotal = 0.0;

		Compra compraNueva = new Compra();
		compraNueva.setUsuario(usuarioComprador);
		ArrayList<SeleccionDiaMenu> seleccionesDeDiaMenu = new ArrayList<SeleccionDiaMenu>();
		for (int i = 0; i < cantidadSemanas; i++) {
			if (lunesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(lunesMenuId,/* fechaLunes */
						lunes, sede, seleccionViandaLunes, precio));
				montoTotal += precio;

			}

			if (martesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(martesMenuId,
						martes, sede, seleccionViandaMartes, precio));
				montoTotal += precio;
			}

			if (miercolesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(miercolesMenuId,
						miercoles, sede, seleccionViandaMiercoles, precio));
				montoTotal += precio;
			}

			if (juevesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(juevesMenuId,
						jueves, sede, seleccionViandaJueves, precio));
				montoTotal += precio;
			}

			if (viernesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(viernesMenuId,
						viernes, sede, seleccionViandaViernes, precio));
				montoTotal += precio;
			}
			java.util.Date fechaActual = new Date();
			compraNueva.setFechaEfectuada(fechaActual);
			compraNueva.setMonto(montoTotal);
			compraNueva.setSelecciones(seleccionesDeDiaMenu);

		}
		compraDAO.save(compraNueva);
		return listar(dniUsuario);
	}

	private SeleccionDiaMenu agregarSeleccion(Long menuId, Date fecha,
			Sede sede, Boolean seleccionVianda, Double precio) {
		SeleccionDiaMenu seleccionDiaMenu = new SeleccionDiaMenu();
		Menu menu = new Menu();
		menu = menuDAO.get(menuId);
		seleccionDiaMenu.setFecha(fecha);
		seleccionDiaMenu.setMenu(menu);
		seleccionDiaMenu.setNombre(menu.getNombre());
		seleccionDiaMenu.setSede(sede);
		seleccionDiaMenu.setVianda(seleccionVianda);
		seleccionDiaMenu.setPrecio(precio);
		return seleccionDiaMenu;

	}
}
