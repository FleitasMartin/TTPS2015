package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.SedeService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.ErrorHelper;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;

@RestController(value="sedeController")
@RequestMapping(value="/sede")
public class SedeController {
	
	@Autowired
	private SedeService sedeService;
	
	@RequestMapping( value = "/crear" ,method = RequestMethod.POST)
	public ModelAndView crear(@RequestParam("nombre") String nombre,
			@RequestParam("capacidad") int capacidad,
			@RequestParam("ubicacion") String ubicacion) {
		return sedeService.crear(nombre, capacidad, ubicacion);
		/*if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return sedeService.crear(nombre, capacidad, ubicacion);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");*/		
	}
	
	@RequestMapping( value = "/crear" ,method = RequestMethod.GET)
	public ModelAndView crear(){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return sedeService.crear();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (auth != null) ? (User)auth.getPrincipal() :  null;
		
		System.out.println("---------------------------------------------------------");
		System.out.println("METODO LISTAR SEDE");
		System.out.println(user.getUsername());
		System.out.println(user.getAuthorities().toArray()[0]);
		return sedeService.listar();
		/*if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return sedeService.listar();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");	*/	
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminar(@RequestParam("id") Long id){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return sedeService.eliminar(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value="/editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam("id") Long id){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return sedeService.editar(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value="/editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("id") Long id,
			@RequestParam("nombre") String nombre,
			@RequestParam("capacidad") int capacidad,
			@RequestParam("ubicacion") String ubicacion){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return sedeService.editar(id, nombre, capacidad, ubicacion);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}

}
