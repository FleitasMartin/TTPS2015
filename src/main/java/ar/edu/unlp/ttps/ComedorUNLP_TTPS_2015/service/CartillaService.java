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

/**
 * 
 * @author Martin
 *
 * Servicio que implementa las funcionalidades de la cartilla.
 * Es llamado por CartillaController para resolver las peticiones.
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
	
	
	/** Metodos publicos encargados de resolver las peticiones del controller y retornar objetos ModelAndView. */
	
	public ModelAndView listar() {
		ArrayList<Cartilla> cartillas = new ArrayList<Cartilla>();
		cartillas = (ArrayList<Cartilla>) cartillaDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("cartillas", cartillas);
		model.addObject("contentPage", "listarCartillas");
		return model;
	}
	
	public ModelAndView editar(Long id) {
		
		ModelAndView model = new ModelAndView();
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

		model.setViewName("indexAdmin");
		model.addObject("cartilla", cartilla);
		model.addObject("menues", menuesChecked);
		model.addObject("contentPage", "editarCartilla");
		return model;
	}
	
	public ModelAndView editar(Long id, String fechaDesde,String fechaHasta, Long[] lunesMenues, Long[] martesMenues, 
			Long[] miercolesMenues,	Long[] juevesMenues, Long[] viernesMenues, Double precio) throws ParseException {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date inicioDate = simpleDateFormat.parse(fechaDesde);
		Date finDate = simpleDateFormat.parse(fechaHasta);

		DateTime inicio = new DateTime(inicioDate);
		DateTime fin = new DateTime(finDate);

		ArrayList<Long[]> diasMenues = new ArrayList<Long[]>();
		diasMenues.add(0, lunesMenues);
		diasMenues.add(1, martesMenues);
		diasMenues.add(2, miercolesMenues);
		diasMenues.add(3, juevesMenues);
		diasMenues.add(4, viernesMenues);

		Cartilla cartilla = cartillaDAO.get(id);
		
		ArrayList<Semana> semanas = this.armadorDiasSemanas(inicio, fin,
				diasMenues);
		
		cartilla.setFechaInicio(inicioDate);
		cartilla.setFechaFin(finDate);
		cartilla.setSemanas(semanas);
		cartilla.setPrecio(precio);

		cartillaDAO.edit(cartilla);

		ModelAndView model = new ModelAndView();
		ArrayList<Menu> menues = new ArrayList<Menu>();
		menues = (ArrayList<Menu>) menuDAO.getAll();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage", "altaCartilla");
		return model;
		
	}
	
	public ModelAndView detalle(Long id) {
		ModelAndView model = new ModelAndView();
		Cartilla cartilla = new Cartilla();
		cartilla = cartillaDAO.get(id);
		Semana semana = cartilla.getSemanas().get(0);
		model.setViewName("indexAdmin");
		model.addObject("id", id);
		model.addObject("semana", semana);
		model.addObject("contentPage", "detalleCartilla");
		return model;

	}
	
	public ModelAndView crear() {
		ModelAndView model = new ModelAndView();
		ArrayList<Menu> menues = new ArrayList<Menu>();
		menues = (ArrayList<Menu>) menuDAO.getAll();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage", "altaCartilla");
		return model;
	}
	
	public ModelAndView crear( String fechaDesde, String fechaHasta, Long[] lunesMenues, Long[] martesMenues, 
			Long[] miercolesMenues, Long[] juevesMenues, Long[] viernesMenues, Double precio) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date fechaInicio = simpleDateFormat.parse(fechaDesde);
		Date fechaFin = simpleDateFormat.parse(fechaHasta);

		DateTime inicio = new DateTime(fechaInicio);
		DateTime fin = new DateTime(fechaFin);

		ArrayList<Long[]> diasMenues = new ArrayList<Long[]>();
		diasMenues.add(0, lunesMenues);
		diasMenues.add(1, martesMenues);
		diasMenues.add(2, miercolesMenues);
		diasMenues.add(3, juevesMenues);
		diasMenues.add(4, viernesMenues);

		ArrayList<Semana> semanas = this.armadorDiasSemanas(inicio, fin,
				diasMenues);
		Cartilla cartilla = new Cartilla(precio, fechaInicio, fechaFin, semanas);

		cartillaDAO.save(cartilla);

		return listar();
	}
	
	public ModelAndView eliminar(Long id) {
		cartillaDAO.delete(id);
		return listar();
	}
	
	/**	Metodos privados que ayudan a resolver determinadas peticiones.	 */
	
	private boolean existe(Menu menu, List<Menu> menues){
		for (Menu menu2 : menues) {
			if (menu.getId() == menu2.getId()) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<MenuChecked> seleccionarMenues(List<Menu> menues,
			List<Menu> lunes, List<Menu> martes,
			List<Menu> miercoles, List<Menu> jueves,
			List<Menu> viernes) {

		ArrayList<MenuChecked> menuesChecked = new ArrayList<MenuChecked>();
		for (Menu menu : menues) {
			MenuChecked menuChecked = new MenuChecked();
			menuChecked.setId(menu.getId());
			menuChecked.setNombre(menu.getNombre());
			
			if (this.existe(menu, lunes)) {
				menuChecked.setLunes("checked");
			} else {
				menuChecked.setLunes(" ");
			}
			if (this.existe(menu, martes)) {
				menuChecked.setMartes("checked");
			} else {
				menuChecked.setMartes(" ");
			}
			if (this.existe(menu, miercoles)) {
				menuChecked.setMiercoles("checked");
			} else {
				menuChecked.setMiercoles(" ");
			}
			if (this.existe(menu, jueves)) {
				menuChecked.setJueves("checked");
			} else {
				menuChecked.setJueves(" ");
			}
			if (this.existe(menu, viernes)) {
				menuChecked.setViernes("checked");
			} else {
				menuChecked.setViernes(" ");
			}
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
			semanas.add( new Semana(diaActual.toDate(), dias));
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
	
	/** Clase utilizada para ayudar a mantener discriminados los menues seleccionados de los que no
	 	en la vista de edición de una cartilla.	*/

	public class MenuChecked {

		private Long id;
		private String nombre;
		private String lunes;
		private String martes;
		private String miercoles;
		private String jueves;
		private String viernes;

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
