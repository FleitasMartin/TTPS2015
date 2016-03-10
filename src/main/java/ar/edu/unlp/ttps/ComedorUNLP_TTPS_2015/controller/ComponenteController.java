package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.ComponenteService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.ErrorHelper;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;

@RestController(value="componenteController")
@RequestMapping(value="/componente")
public class ComponenteController {
	
	@Autowired
	private ComponenteService componenteService;
	
	
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public ModelAndView crear(){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return componenteService.crear();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");
	}
	
	@RequestMapping( value = "/crear" ,method = RequestMethod.POST)
	public ModelAndView crear(@RequestParam("nombre") String nombre,
			@RequestParam("tipo") String tipo){		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return componenteService.crear(nombre, tipo);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return componenteService.listar();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminar(@RequestParam("id") Long id) {	
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return componenteService.eliminar(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam("id") Long id) {
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return componenteService.editar(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("id") Long id, @RequestParam("nombre") String nombre) {		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return componenteService.editar(id, nombre);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
	
}
