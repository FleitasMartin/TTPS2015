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
	
	@RequestMapping( value = "/admin/altaCartilla" ,method = RequestMethod.GET)
	public ModelAndView altaMenu(){
		ModelAndView model = new ModelAndView();
		ArrayList<Menu> menues = new ArrayList<Menu>();;
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
			@RequestParam(value="viernes") Long[] viernesMenues,@RequestParam(value="precio") Long precio )throws ParseException{
		
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
		
		ArrayList<DiaMenu> dias = this.armadorDias(inicio, fin, diasMenues);

		Semana semana = this.armarSemana(dias, inicioDate);
		
		semanaDAO.save(semana);
		
		ModelAndView model = new ModelAndView();
		ArrayList<Menu> menues = new ArrayList<Menu>();;
		menues = (ArrayList<Menu>) menuDAO.getAll();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage","altaCartilla");
		return model;
	}
	
	private ArrayList<DiaMenu> armadorDias(DateTime diaActual, DateTime diaFin, ArrayList<Long[]> atributos){
		ArrayList<DiaMenu> dias = new ArrayList<DiaMenu>();
		while ( diaActual.isBefore(diaFin.getMillis()) ) {
			dias.add(this.armaLunes(atributos.get(0), diaActual.plusDays(0).toDate()));
			dias.add(this.armaMartes(atributos.get(1), diaActual.plusDays(1).toDate()));
			dias.add(this.armaMiercoles(atributos.get(2), diaActual.plusDays(2).toDate()));
			dias.add(this.armaJueves(atributos.get(3), diaActual.plusDays(3).toDate()));
			dias.add(this.armaViernes(atributos.get(4), diaActual.plusDays(4).toDate()));
			diaActual = diaActual.plusDays(7);
		}
		return dias;
	}
	
	private Semana armarSemana(ArrayList<DiaMenu> dias, Date fechaInicio){
		Semana semana = new Semana();
		semana.setDias(dias);
		semana.setFechaDesde(fechaInicio);
		return semana;
	}
	
	private DiaMenu armaLunes(Long[] menues, Date fecha){
		return this.armarDia(menues, "Lunes", fecha);
	}
	private DiaMenu armaMartes(Long[] menues, Date fecha){
		return this.armarDia(menues, "Martes", fecha);
	}
	private DiaMenu armaMiercoles(Long[] menues, Date fecha){
		return this.armarDia(menues, "Miercoles", fecha);
	}
	private DiaMenu armaJueves(Long[] menues, Date fecha){
		return this.armarDia(menues, "Jueves", fecha);
	}
	private DiaMenu armaViernes(Long[] menues, Date fecha){
		return this.armarDia(menues, "Viernes", fecha);
	}
	private DiaMenu armarDia(Long[] menues, String nombre, Date fecha){
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
	
}
