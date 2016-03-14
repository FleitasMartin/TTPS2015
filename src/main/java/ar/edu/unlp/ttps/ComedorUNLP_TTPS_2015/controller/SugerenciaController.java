package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.SugerenciaService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.ErrorHelper;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;


@RestController(value="sugerenciaController")
@RequestMapping(value="/sugerencia")
public class SugerenciaController {
	@Autowired 
	SugerenciaService sugerenciaService; 
	
	@RequestMapping(value = "/comentar", method = RequestMethod.GET)
	public ModelAndView comentar() {		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(3)){
				return sugerenciaService.comentar();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
	
	@RequestMapping( value = "/comentar" ,method = RequestMethod.POST)
	public ModelAndView comentar(@RequestParam("tipoSugerencia") String tipoSugerencia,
			@RequestParam("sedeId") Long sedeId,
			@RequestParam("message") String message){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(3)){
				return sugerenciaService.comentar(tipoSugerencia, sedeId, message);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
	
	@RequestMapping(value = "/buzonVirtual", method = RequestMethod.GET)
	public ModelAndView buzonVirtual() {		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return sugerenciaService.buzonVirtual();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
	
	@RequestMapping(value = "/buzonVirtualDeSede", method = RequestMethod.GET)
	public ModelAndView buzonVirtualDeSede() {		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(2)){
				return sugerenciaService.buzonVirtualDeSede();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}

}
