package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.CompraService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.ErrorHelper;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;


@RestController(value="compraController")
@RequestMapping(value="/compra")
public class CompraController {

	@Autowired
	CompraService compraService;
	
	@RequestMapping(value = "/compraDeTickets", method = RequestMethod.GET)
	public ModelAndView compraDeTickets() throws ParseException {		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(3)){
				return compraService.compraDeTickets();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crear(
			@RequestParam(value = "lunes") Long lunesMenu,
			@RequestParam(value = "martes") Long martesMenu,
			@RequestParam(value = "miercoles") Long miercolesMenu,
			@RequestParam(value = "jueves") Long juevesMenu,
			@RequestParam(value = "viernes") Long viernesMenu,
			@RequestParam(value = "fechaLunes") Date fechaLunes,
			@RequestParam(value = "fechaMartes") Date fechaMartes,
			@RequestParam(value = "fechaMiercoles") Date fechaMiercoles,
			@RequestParam(value = "fechaJueves") Date fechaJueves,
			@RequestParam(value = "fechaViernes") Date fechaViernes,
			@RequestParam(value = "seleccionViandaLunes") Boolean seleccionViandaLunes,
			@RequestParam(value = "seleccionViandaMartes") Boolean seleccionViandaMartes,
			@RequestParam(value = "seleccionViandaMiercoles") Boolean seleccionViandaMiercoles,
			@RequestParam(value = "seleccionViandaJueves") Boolean seleccionViandaJueves,
			@RequestParam(value = "seleccionViandaViernes") Boolean seleccionViandaViernes,
			@RequestParam(value = "precio") Double precio,
			@RequestParam(value = "sede") Long sede,
			@RequestParam(value = "cantidadSemanas") Integer cantidadSemanas)
			throws ParseException {

		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(3)){
				return compraService.crear( lunesMenu, martesMenu, 
						miercolesMenu, juevesMenu, viernesMenu, fechaLunes, fechaMartes,fechaMiercoles,fechaJueves,fechaViernes,
						seleccionViandaLunes,seleccionViandaMartes,seleccionViandaMiercoles, seleccionViandaJueves, seleccionViandaViernes,
						precio,sede, cantidadSemanas );
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
}
