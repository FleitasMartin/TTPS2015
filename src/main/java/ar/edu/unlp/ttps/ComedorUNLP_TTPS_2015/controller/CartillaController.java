package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.DiaMenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.MenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SemanaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.DiaMenu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Semana;

@Controller
public class CartillaController {

	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private CartillaDAO cartillaDAO;
	
	@Autowired
	private SemanaDAO semanaDAO;
	
	@Autowired
	private DiaMenuDAO diaMenuDAO;
	
	
	@RequestMapping( value = "/admin/cartillaSemanal" ,method = RequestMethod.GET)
	public ModelAndView listar(){
		ArrayList<Cartilla> cartillas = new ArrayList<Cartilla>();
		cartillas = (ArrayList<Cartilla>) cartillaDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("cartillas", cartillas);
		model.addObject("contentPage","cartillaSemanal");
		return model;
	}
	@RequestMapping( value = "/admin/editarCartilla" ,method = RequestMethod.GET)
	public ModelAndView editarCartilla(@RequestParam(value="id") Long id){
		ModelAndView model = new ModelAndView();
		ArrayList<Menu> menues = (ArrayList<Menu>) menuDAO.getAll();
		Cartilla cartilla = cartillaDAO.get(id);
		ArrayList<Menu> menuesLunes = (ArrayList<Menu>) cartilla.getSemanas().get(0).getDias().get(0).getMenues();
		ArrayList<Menu> menuesMartes = (ArrayList<Menu>) cartilla.getSemanas().get(0).getDias().get(1).getMenues();
		ArrayList<Menu> menuesMiercoles = (ArrayList<Menu>) cartilla.getSemanas().get(0).getDias().get(2).getMenues();
		ArrayList<Menu> menuesJueves = (ArrayList<Menu>) cartilla.getSemanas().get(0).getDias().get(3).getMenues();
		ArrayList<Menu> menuesViernes = (ArrayList<Menu>) cartilla.getSemanas().get(0).getDias().get(4).getMenues();
		
		ArrayList<MenuChecked> menuesChecked = this.seleccionarMenues(menues, menuesLunes, menuesMartes, menuesMiercoles, menuesJueves, menuesViernes);
		
		model.setViewName("indexAdmin");
		model.addObject("cartilla", cartilla);
		model.addObject("menues", menuesChecked);
		model.addObject("contentPage","editarCartilla");
		return model;
	}
	
	@RequestMapping( value = "/admin/altaCartilla" ,method = RequestMethod.GET)
	public ModelAndView altaCartilla(){
		ModelAndView model = new ModelAndView();
		ArrayList<Menu> menues = new ArrayList<Menu>();
		menues = (ArrayList<Menu>) menuDAO.getAll();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage","altaCartilla");
		return model;
	}
		
	@RequestMapping( value = "/admin/altaCartilla" ,method = RequestMethod.POST)
	public ModelAndView altaMenu(@RequestParam(value="desde") String fechaDesde,@RequestParam(value="hasta") String fechaHasta,
			@RequestParam(value="lunes") Long[] lunesMenues,@RequestParam(value="martes") Long[] martesMenues,
			@RequestParam(value="miercoles") Long[] miercolesMenues,@RequestParam(value="jueves") Long[] juevesMenues,
			@RequestParam(value="viernes") Long[] viernesMenues,@RequestParam(value="precio") Double precio )throws ParseException{
		
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
		
		Cartilla cartilla = new Cartilla();
		ArrayList<Semana> semanas = this.armadorDiasSemanas(inicio, fin, diasMenues);
		cartilla.setFechaInicio(inicioDate);
		cartilla.setFechaFin(finDate);
		cartilla.setSemanas(semanas);
		cartilla.setPrecio(precio);
		
		for (Semana semana : cartilla.getSemanas()) {
			System.out.println("Semana!: "+semana.getFechaDesde());
			System.out.println("SemanaID!: "+semana.getId());
		}		
		
		cartillaDAO.save(cartilla);
		
		ModelAndView model = new ModelAndView();
		ArrayList<Menu> menues = new ArrayList<Menu>();;
		menues = (ArrayList<Menu>) menuDAO.getAll();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage","altaCartilla");
		return model;
	}
	
	private ArrayList<Semana> armadorDiasSemanas(DateTime diaActual, DateTime diaFin, ArrayList<Long[]> atributos){
		ArrayList<Semana> semanas = new ArrayList<Semana>();
		while ( diaActual.isBefore(diaFin.getMillis()) ) {
			ArrayList<DiaMenu> dias = new ArrayList<DiaMenu>();
			dias.add(this.armarYGuardarDia(atributos.get(0), "Lunes", diaActual.plusDays(0).toDate()));
			dias.add(this.armarYGuardarDia(atributos.get(1), "Martes", diaActual.plusDays(1).toDate()));
			dias.add(this.armarYGuardarDia(atributos.get(2), "Miercoles", diaActual.plusDays(2).toDate()));
			dias.add(this.armarYGuardarDia(atributos.get(3), "Jueves", diaActual.plusDays(3).toDate()));
			dias.add(this.armarYGuardarDia(atributos.get(4), "Viernes", diaActual.plusDays(4).toDate()));
			semanas.add(this.armarYGuardarSemana(dias, diaActual.toDate()));
			diaActual = diaActual.plusDays(7);
		}
		return semanas;
	}
	
	private Semana armarYGuardarSemana(ArrayList<DiaMenu> dias, Date fechaInicio){
		Semana semana = new Semana();
		semana.setDias(dias);
		semana.setFechaDesde(fechaInicio);
		//semanaDAO.save(semana);
		return semana;
	}
	
	private DiaMenu armarYGuardarDia(Long[] menues, String nombre, Date fecha){
		DiaMenu diaMenu = new DiaMenu();
		diaMenu.setFecha(fecha);
		diaMenu.setNombre(nombre);
		ArrayList<Menu> menus = new ArrayList<Menu>();
		for (Long id : menues) {
			menus.add(menuDAO.get(id));
		}		
		diaMenu.setMenues(menus);
		diaMenuDAO.save(diaMenu);
		return diaMenu;
	}
	
	public ArrayList<MenuChecked> seleccionarMenues(ArrayList<Menu> menues, ArrayList<Menu> lunes, ArrayList<Menu> martes, ArrayList<Menu> miercoles,
			ArrayList<Menu> jueves, ArrayList<Menu> viernes){
		
		ArrayList<MenuChecked> menuesChecked = new ArrayList<MenuChecked>();
		for (Menu menu : menues) {
			MenuChecked menuChecked = new MenuChecked();
			menuChecked.setId(menu.getId());
			menuChecked.setNombre(menu.getNombre());
			if( lunes.contains(menu)){
				menuChecked.setLunes("checked");
			}else{
				menuChecked.setLunes(" ");
			}
			if( martes.contains(menu)){
				menuChecked.setMartes("checked");
			}else{
				menuChecked.setMartes(" ");
			}
			if( miercoles.contains(menu)){
				menuChecked.setMiercoles("checked");
			}else{
				menuChecked.setMiercoles(" ");
			}
			if( jueves.contains(menu)){
				menuChecked.setJueves("checked");
			}else{
				menuChecked.setJueves(" ");
			}
			if( viernes.contains(menu)){
				menuChecked.setViernes("checked");
			}else{
				menuChecked.setViernes(" ");
			}
			menuesChecked.add(menuChecked);
		}
		return menuesChecked;
	}
	
	public class MenuChecked{
		
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
