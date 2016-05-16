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
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.PagoDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SeleccionDiaMenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SemanaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Pago;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.SeleccionDiaMenu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Semana;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver.ModelAndViewResolverCompra;

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
	PagoDAO pagoDAO;

	@Autowired
	SeleccionDiaMenuDAO seleccionDiaMenuDAO;

	public ModelAndView listar(String dniUsuario) {

		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		List<Compra> compras = compraDAO.getAllByUsuario(usuario.getId());
		return ModelAndViewResolverCompra.listarCompras(compras);
	}

	public ModelAndView borrar(Long id, String dniUsuario) {
		compraDAO.delete(id);
		return listar(dniUsuario);
	}

	public ModelAndView compraDeTickets(String dniUsuario)
			throws ParseException {

		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		Sede sede = sedeDAO.get(usuario.getSede().getId());
		java.util.Date date = new Date();
		Object param = new java.sql.Date(date.getTime());

		Cartilla cartilla = cartillaDAO.getFirstCartilla(param);
		if (cartilla != null) {

			List<Semana> semanas = cartilla.getSemanas();
			Integer cantidadSemanas = semanas.size();
			Integer numeroDeSemana = 0;
			List<Compra> compras = usuario.getCompras();

			for (int i = 0; i < semanas.size(); i++) {
				for (Compra compra : compras) {
					if (compra.getFechaDeSemanaComprada().equals(
							semanas.get(i).getFechaDesde())) {
						cantidadSemanas -= compra.getCantidadDeSemanas();
						numeroDeSemana += compra.getCantidadDeSemanas();
						compras.remove(compra);
						break;
					}
				}
			}

			if (cantidadSemanas <= 0) {
				return ModelAndViewResolverCompra.listarCompras(
						compraDAO.getAllByUsuario(usuario.getId()), "error",
						"Ya compraste lo habilitado hasta el dia de hoy");
			} else {
				Semana semana = semanaDAO.get(cartilla.getSemanas()
						.get(numeroDeSemana).getId());
				return ModelAndViewResolverCompra.crearCompra(usuario, sede,
						cartilla, semana, cantidadSemanas);
			}

		}
		return ModelAndViewResolverCompra.listarCompras(
				compraDAO.getAllByUsuario(usuario.getId()), "error",
				"No existen cartillas vigentes!");
	}

	public ModelAndView crear(Long lunesMenuId, Long martesMenuId,
			Long miercolesMenuId, Long juevesMenuId, Long viernesMenuId,
			String fechaLunes, String fechaMartes, String fechaMiercoles,
			String fechaJueves, String fechaViernes,
			Boolean seleccionViandaLunes, Boolean seleccionViandaMartes,
			Boolean seleccionViandaMiercoles, Boolean seleccionViandaJueves,
			Boolean seleccionViandaViernes, Double precio, Long sedeID,
			Integer cantidadDeSemanas, String dniUsuario, Date fechaDesde)
			throws ParseException {

		Usuario usuarioComprador = usuarioDAO.findByDNI(dniUsuario);

		Sede sede = sedeDAO.get(sedeID);

		List<Date> dias = convertirDias(fechaLunes, fechaMartes,
				fechaMiercoles, fechaJueves, fechaViernes);

		/**
		 * List<Long> diasMenuIds = agruparDiaMenuIds(lunesMenuId, martesMenuId,
		 * miercolesMenuId, juevesMenuId, viernesMenuId);
		 * 
		 * List<Boolean> seleccionViandas = agruparSeleccionVianda(
		 * seleccionViandaLunes, seleccionViandaMartes,
		 * seleccionViandaMiercoles, seleccionViandaJueves,
		 * seleccionViandaViernes);
		 */

		Double montoTotal = 0.0;

		ArrayList<SeleccionDiaMenu> seleccionesDeDiaMenu = new ArrayList<SeleccionDiaMenu>();
		for (int i = 0; i < cantidadDeSemanas; i++) {

			/**
			 * for (int j = 0; j < 5; j++) { if (diasMenuIds.get(j) != null) {
			 * seleccionesDeDiaMenu.add(this.agregarSeleccion(lunesMenuId,
			 * dias.get(j), sede, seleccionViandas.get(j), precio)); montoTotal
			 * += precio; } } java.util.Date fechaActual = new Date();
			 * compraNueva.setFechaEfectuada(fechaActual);
			 * compraNueva.setMonto(montoTotal);
			 * compraNueva.setSelecciones(seleccionesDeDiaMenu);
			 */

			if (lunesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(lunesMenuId,
						dias.get(0), sede, seleccionViandaLunes, precio));
				montoTotal += precio;

			}

			if (martesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(martesMenuId,
						dias.get(1), sede, seleccionViandaMartes, precio));
				montoTotal += precio;
			}

			if (miercolesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(miercolesMenuId,
						dias.get(2), sede, seleccionViandaMiercoles, precio));
				montoTotal += precio;
			}

			if (juevesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(juevesMenuId,
						dias.get(3), sede, seleccionViandaJueves, precio));
				montoTotal += precio;
			}

			if (viernesMenuId != null) {
				seleccionesDeDiaMenu.add(this.agregarSeleccion(viernesMenuId,
						dias.get(4), sede, seleccionViandaViernes, precio));
				montoTotal += precio;
			}

		}

		Compra compraNueva = new Compra(usuarioComprador, fechaDesde,
				cantidadDeSemanas, montoTotal, seleccionesDeDiaMenu);
		compraDAO.save(compraNueva);
		return listar(dniUsuario);

		/**
		 * java.util.Date fechaActual = new Date();
		 * compraNueva.setFechaEfectuada(fechaActual);
		 * compraNueva.setMonto(montoTotal);
		 * compraNueva.setSelecciones(seleccionesDeDiaMenu);
		 * 
		 * }
		 * 
		 * compraDAO.save(compraNueva); return listar(dniUsuario);
		 */
	}

	public ModelAndView pagar(Long id, String dniUsuario) {
		// String mensaje;
		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		Compra compra = compraDAO.get(id);
		List<Compra> compras = compraDAO.getAllByUsuario(usuario.getId());
		if (usuario.getSaldo() >= compra.getMonto()) {
			usuario.setSaldo(usuario.getSaldo() - compra.getMonto());
			usuarioDAO.edit(usuario);
			compra.setPagado(true);
			compraDAO.edit(compra);
			java.util.Date fechaPago = new Date();
			Pago pago = new Pago(compra, fechaPago, usuario);
			pagoDAO.save(pago);
			// mensaje = "Su compra ha sido pagada correctamente!";
			return ModelAndViewResolverCompra.pagarCompraExitoError(compras,
					"mensaje", "Su compra ha sido pagada correctamente!");
		} else {
			// mensaje = "No tenes suficiente saldo!";
			return ModelAndViewResolverCompra.pagarCompraExitoError(compras,
					"error", "No tenes suficiente saldo!");
		}
		// return ModelAndViewResolverCompra.pagarCompra(compras, mensaje);
	}

	private SeleccionDiaMenu agregarSeleccion(Long menuId, Date fecha,
			Sede sede, Boolean seleccionVianda, Double precio) {
		Menu menu = new Menu();
		menu = menuDAO.get(menuId);
		return new SeleccionDiaMenu(fecha, menu, sede, seleccionVianda, precio);
	}

	private List<Date> convertirDias(String fechaLunes, String fechaMartes,
			String fechaMiercoles, String fechaJueves, String fechaViernes) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

		ArrayList<Date> diasConvertidos = new ArrayList<Date>();
		try {
			diasConvertidos.add(simpleDateFormat.parse(fechaLunes));
			diasConvertidos.add(simpleDateFormat.parse(fechaMartes));
			diasConvertidos.add(simpleDateFormat.parse(fechaMiercoles));
			diasConvertidos.add(simpleDateFormat.parse(fechaJueves));
			diasConvertidos.add(simpleDateFormat.parse(fechaViernes));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return diasConvertidos;
	}
	/**
	 * private List<Long> agruparDiaMenuIds(Long lunesMenuId, Long martesMenuId,
	 * Long miercolesMenuId, Long juevesMenuId, Long viernesMenuId) { List<Long>
	 * diasMenuIds = new ArrayList<Long>(); diasMenuIds.add(lunesMenuId);
	 * diasMenuIds.add(martesMenuId); diasMenuIds.add(miercolesMenuId);
	 * diasMenuIds.add(juevesMenuId); diasMenuIds.add(viernesMenuId); return
	 * diasMenuIds; }
	 * 
	 * private List<Boolean> agruparSeleccionVianda(Boolean
	 * seleccionViandaLunes, Boolean seleccionViandaMartes, Boolean
	 * seleccionViandaMiercoles, Boolean seleccionViandaJueves, Boolean
	 * seleccionViandaViernes) { List<Boolean> seleccionesVianda = new
	 * ArrayList<Boolean>(); seleccionesVianda.add(seleccionViandaLunes);
	 * seleccionesVianda.add(seleccionViandaMartes);
	 * seleccionesVianda.add(seleccionViandaMiercoles);
	 * seleccionesVianda.add(seleccionViandaJueves);
	 * seleccionesVianda.add(seleccionViandaViernes); return seleccionesVianda;
	 * }
	 */
}
