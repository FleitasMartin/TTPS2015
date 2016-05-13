package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.DiaMenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.MenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SemanaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.DiaMenu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Semana;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.ModelAndViewResolverCartilla;

/**
 * 
 * @author Martin
 *
 *         Servicio que implementa las funcionalidades de la cartilla. Es
 *         llamado por CartillaController para resolver las peticiones. Se
 *         comunica con MenuDAO, CartillaDAO, SemanaDAO, DiaMenuDAO para
 *         resolver dichas peticiones.
 * 
 */

@Service
public class CartillaService {

	@Autowired
	private MenuDAO menuDAO;

	@Autowired
	private CartillaDAO cartillaDAO;

	@Autowired
	private SemanaDAO semanaDAO;

	@Autowired
	private DiaMenuDAO diaMenuDAO;

	/**
	 * Este método pide todas las cartillas a cartillaDAO, las almacena en una
	 * estructura ArrayList y configura el ModelAndView para presentar la vista
	 * correspondiente al listado.
	 *
	 * @return ModelAndView
	 */
	public ModelAndView listar() {
		ArrayList<Cartilla> cartillas = new ArrayList<Cartilla>();
		cartillas = (ArrayList<Cartilla>) cartillaDAO.getAll();
		return ModelAndViewResolverCartilla.listarCartilla(cartillas);
	}

	/**
	 * Este método prepara los datos para la vista de detalle de una cartilla.
	 * Pide a cartillaDAO una cartilla particular (según el param id), almacena
	 * su primer semana para mostrar sus datos en el detalle y configura el
	 * ModelAndView para presentar la vista correspondiente al detalle.
	 * 
	 * @param id
	 *            | Un Long que es el identificador de la cartilla
	 * @return ModelAndView
	 */
	public ModelAndView detalle(Long id) {
		Cartilla cartilla = new Cartilla();
		cartilla = cartillaDAO.get(id);
		Semana semana = cartilla.getSemanas().get(0);
		return ModelAndViewResolverCartilla.detalleCartilla(id, semana);

	}

	/**
	 * Este método prepara la vista para la creación de una nueva cartilla. Pide
	 * a menuDAO todos los menues para presentarlos en la vista.
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView crear() {
		ArrayList<Menu> menues = new ArrayList<Menu>();
		menues = (ArrayList<Menu>) menuDAO.getAll();
		return ModelAndViewResolverCartilla.crearCartilla(menues);

	}

	/**
	 * Este pide a cartillaDAO la eliminación de una cartilla según un
	 * identificador recibido
	 * 
	 * @param id
	 *            | Un Long que es el identificador de la cartilla.
	 * @return ModelAndView
	 */
	public ModelAndView eliminar(Long id) {
		cartillaDAO.delete(id);
		return listar();
	}

	/**
	 * Este método prepara los datos para la vista de edición de una cartilla.
	 * Pide a menuDAO todos los menues, a cartillaDAO una cartilla particular
	 * (según el param id) y configura el ModelAndView para presentar la vista
	 * correspondiente al listado.
	 * 
	 * @param id
	 *            | Un Long que es el identificador de la cartilla a editar.
	 * @return ModelAndView
	 */
	public ModelAndView editar(Long id) {

		ArrayList<Menu> menues = (ArrayList<Menu>) menuDAO.getAll();
		Cartilla cartilla = cartillaDAO.get(id);
		Semana semana = cartilla.getSemanas().get(0);
		List<Menu> menuesLunes = semana.getDias().get(0).getMenues();
		List<Menu> menuesMartes = semana.getDias().get(1).getMenues();
		List<Menu> menuesMiercoles = semana.getDias().get(2).getMenues();
		List<Menu> menuesJueves = semana.getDias().get(3).getMenues();
		List<Menu> menuesViernes = semana.getDias().get(4).getMenues();

		ArrayList<MenuChecked> menuesChecked = this.seleccionarMenues(menues,
				menuesLunes, menuesMartes, menuesMiercoles, menuesJueves,
				menuesViernes);

		return ModelAndViewResolverCartilla.editarCartilla(cartilla,
				menuesChecked);

	}

	/**
	 * Este método recibe los parámetros involucrados en la realización de
	 * editar una cartilla, es el que efectiviza la edición de la misma. Pide a
	 * cartillaDAO una cartilla según su id y le re-setea todos los datos,
	 * posteriormente manda esa cartilla como argumento del mensaje edit para
	 * cartillaDAO.
	 * 
	 * @param id
	 *            | Un Long que es el identificador de la cartilla a editar.
	 * @param fechaDesde
	 *            | Un String que es la fecha inicial de la vigencia de la
	 *            cartilla.
	 * @param fechaHasta
	 *            | Un String que es la fecha final de la vigencia de la
	 *            cartilla.
	 * @param lunesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día lunes.
	 * @param martesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día martes.
	 * @param miercolesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día miercoles.
	 * @param juevesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día jueves.
	 * @param viernesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día viernes.
	 * @param precio
	 *            | Un Double que será el precio de cada menu contenido en la
	 *            cartilla.
	 * @return ModelAndView
	 * @throws ParseException
	 *             | En caso de error en el formato de fechaDesde o fechaHasta
	 */
	public ModelAndView editar(Long id, String fechaDesde, String fechaHasta,
			Long[] lunesMenues, Long[] martesMenues, Long[] miercolesMenues,
			Long[] juevesMenues, Long[] viernesMenues, Double precio)
			throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date fechaInicio = simpleDateFormat.parse(fechaDesde);
		Date fechaFin = simpleDateFormat.parse(fechaHasta);

		DateTime inicio = new DateTime(fechaInicio);
		DateTime fin = new DateTime(fechaFin);

		if (existeCartillaEditar(fechaInicio, id) || existeCartillaEditar(fechaFin, id)) {
			return editar(
					id,
					"Las fechas de inicio y/o fin para la cartilla ingresada se solapan con una existente.");
		} else {
			ArrayList<Long[]> diasMenues = new ArrayList<Long[]>();
			diasMenues.add(0, lunesMenues);
			diasMenues.add(1, martesMenues);
			diasMenues.add(2, miercolesMenues);
			diasMenues.add(3, juevesMenues);
			diasMenues.add(4, viernesMenues);

			Cartilla cartilla = cartillaDAO.get(id);

			ArrayList<Semana> semanas = this.armadorDiasSemanas(inicio, fin,
					diasMenues);

			cartilla.setFechaInicio(fechaInicio);
			cartilla.setFechaFin(fechaFin);
			cartilla.setSemanas(semanas);
			cartilla.setPrecio(precio);

			cartillaDAO.edit(cartilla);

			return listar();
		}

	}

	/**
	 * Este método se encarga de efectivizar la creación de una cartilla. Recibe
	 * todos los parámetros involucrados en dicha operación. Parsea los String
	 * fechaDesde y fechaHasta a objetos Date, luego este se utiliza para crear
	 * un DateTime que será manipulado con la librería JodaTime. Se arma una
	 * estructura ArrayList de semanas ayudado de un método privado.
	 * 
	 * @param fechaDesde
	 *            | Un String que es la fecha inicial de la vigencia de la
	 *            cartilla.
	 * @param fechaHasta
	 *            | Un String que es la fecha final de la vigencia de la
	 *            cartilla.
	 * @param lunesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día lunes.
	 * @param martesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día martes.
	 * @param miercolesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día miércoles.
	 * @param juevesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día jueves.
	 * @param viernesMenues
	 *            | Un Long[] que contiene los identificadores de los menues
	 *            para el día viernes.
	 * @param precio
	 *            | Un Double que será el precio de cada menu contenido en la
	 *            cartilla.
	 * @return ModelAndView
	 * @throws ParseException
	 *             | En caso de error en el formato de fechaDesde o fechaHasta
	 */
	public ModelAndView crear(String fechaDesde, String fechaHasta,
			Long[] lunesMenues, Long[] martesMenues, Long[] miercolesMenues,
			Long[] juevesMenues, Long[] viernesMenues, Double precio)
			throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date fechaInicio = simpleDateFormat.parse(fechaDesde);
		Date fechaFin = simpleDateFormat.parse(fechaHasta);

		DateTime inicio = new DateTime(fechaInicio);
		DateTime fin = new DateTime(fechaFin);

		if (existeCartilla(fechaInicio) || existeCartilla(fechaFin)) {
			return crear("Las fechas de inicio y/o fin para la cartilla ingresada se solapan con una existente.");
		} else {
			ArrayList<Long[]> diasMenues = construirDiasMenues(lunesMenues,
					martesMenues, miercolesMenues, juevesMenues, viernesMenues);

			ArrayList<Semana> semanas = armadorDiasSemanas(inicio, fin,
					diasMenues);
			Cartilla cartilla = new Cartilla(precio, fechaInicio, fechaFin,
					semanas);

			cartillaDAO.save(cartilla);

			return listar();
		}
	}

	/** Metodos privados que ayudan a resolver las peticiones. */

	private ModelAndView editar(Long id, String error) {

		ArrayList<Menu> menues = (ArrayList<Menu>) menuDAO.getAll();
		Cartilla cartilla = cartillaDAO.get(id);
		Semana semana = cartilla.getSemanas().get(0);
		List<Menu> menuesLunes = semana.getDias().get(0).getMenues();
		List<Menu> menuesMartes = semana.getDias().get(1).getMenues();
		List<Menu> menuesMiercoles = semana.getDias().get(2).getMenues();
		List<Menu> menuesJueves = semana.getDias().get(3).getMenues();
		List<Menu> menuesViernes = semana.getDias().get(4).getMenues();

		ArrayList<MenuChecked> menuesChecked = this.seleccionarMenues(menues,
				menuesLunes, menuesMartes, menuesMiercoles, menuesJueves,
				menuesViernes);

		return ModelAndViewResolverCartilla.editarCartilla(cartilla,
				menuesChecked, error);

	}

	private ModelAndView crear(String error) {
		ArrayList<Menu> menues = new ArrayList<Menu>();
		menues = (ArrayList<Menu>) menuDAO.getAll();
		return ModelAndViewResolverCartilla.crearCartilla(menues, error);

	}

	private ArrayList<Long[]> construirDiasMenues(Long[] lunesMenues,
			Long[] martesMenues, Long[] miercolesMenues, Long[] juevesMenues,
			Long[] viernesMenues) {
		ArrayList<Long[]> diasMenues = new ArrayList<Long[]>();
		diasMenues.add(0, lunesMenues);
		diasMenues.add(1, martesMenues);
		diasMenues.add(2, miercolesMenues);
		diasMenues.add(3, juevesMenues);
		diasMenues.add(4, viernesMenues);
		return diasMenues;
	}

	private boolean existeCartilla(Date fechaConsultada) {
		Object param = new java.sql.Date(fechaConsultada.getTime());
		return (cartillaDAO.getFirstCartilla(param) == null) ? false : true;
	}
	
	private boolean existeCartillaEditar(Date fechaConsultada, Long id) {
		Object param = new java.sql.Date(fechaConsultada.getTime());
		return (cartillaDAO.getCartillaExistente(param, id) == null) ? false : true;
	}

	private boolean existe(Menu menu, List<Menu> menues) {
		for (Menu menu2 : menues) {
			if (menu.getId() == menu2.getId()) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<MenuChecked> seleccionarMenues(List<Menu> menues,
			List<Menu> lunes, List<Menu> martes, List<Menu> miercoles,
			List<Menu> jueves, List<Menu> viernes) {

		ArrayList<MenuChecked> menuesChecked = new ArrayList<MenuChecked>();
		for (Menu menu : menues) {
			MenuChecked menuChecked = new MenuChecked(menu.getId(),
					menu.getNombre(), (existe(menu, lunes)) ? "checked" : " ",
					(existe(menu, martes)) ? "checked" : " ", (existe(menu,
							miercoles)) ? "checked" : " ",
					(existe(menu, jueves)) ? "checked" : " ", (existe(menu,
							viernes)) ? "checked" : " ");

			menuesChecked.add(menuChecked);
		}
		return menuesChecked;
	}

	private ArrayList<Semana> armadorDiasSemanas(DateTime diaActual,
			DateTime diaFin, ArrayList<Long[]> atributos) {
		ArrayList<Semana> semanas = new ArrayList<Semana>();
		while (diaActual.isBefore(diaFin.getMillis())) {
			ArrayList<DiaMenu> dias = new ArrayList<DiaMenu>();
			dias.add(this.armarYGuardarDia(atributos.get(0), "Lunes", diaActual
					.plusDays(0).toDate()));
			dias.add(this.armarYGuardarDia(atributos.get(1), "Martes",
					diaActual.plusDays(1).toDate()));
			dias.add(this.armarYGuardarDia(atributos.get(2), "Miercoles",
					diaActual.plusDays(2).toDate()));
			dias.add(this.armarYGuardarDia(atributos.get(3), "Jueves",
					diaActual.plusDays(3).toDate()));
			dias.add(this.armarYGuardarDia(atributos.get(4), "Viernes",
					diaActual.plusDays(4).toDate()));
			semanas.add(new Semana(diaActual.toDate(), dias));
			diaActual = diaActual.plusDays(7);
		}
		return semanas;
	}

	private DiaMenu armarYGuardarDia(Long[] menues, String nombre, Date fecha) {
		ArrayList<Menu> menuses = new ArrayList<Menu>();
		for (Long idMenu : menues) {
			menuses.add(menuDAO.get(idMenu));
		}
		DiaMenu diaMenu = new DiaMenu(nombre, fecha, menuses);
		diaMenuDAO.save(diaMenu);
		return diaMenu;
	}

	/**
	 * Clase utilizada para ayudar a mantener discriminados los menues
	 * seleccionados de los que no en la vista de edición de una cartilla.
	 */

	public class MenuChecked {

		private Long id;
		private String nombre;
		private String lunes;
		private String martes;
		private String miercoles;
		private String jueves;
		private String viernes;

		public MenuChecked() {
			super();
		}

		public MenuChecked(Long id, String nombre, String lunes, String martes,
				String miercoles, String jueves, String viernes) {
			super();
			setId(id);
			setNombre(nombre);
			setLunes(lunes);
			setMartes(martes);
			setMiercoles(miercoles);
			setJueves(jueves);
			setViernes(viernes);
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getLunes() {
			return lunes;
		}

		public void setLunes(String lunes) {
			this.lunes = lunes;
		}

		public String getMartes() {
			return martes;
		}

		public void setMartes(String martes) {
			this.martes = martes;
		}

		public String getMiercoles() {
			return miercoles;
		}

		public void setMiercoles(String miercoles) {
			this.miercoles = miercoles;
		}

		public String getJueves() {
			return jueves;
		}

		public void setJueves(String jueves) {
			this.jueves = jueves;
		}

		public String getViernes() {
			return viernes;
		}

		public void setViernes(String viernes) {
			this.viernes = viernes;
		}
	}
}
