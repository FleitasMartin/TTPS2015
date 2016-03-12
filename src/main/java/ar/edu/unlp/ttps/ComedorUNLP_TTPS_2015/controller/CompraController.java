package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView compraDeTickets() {		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(3)){
				return compraService.compraDeTickets();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
}
