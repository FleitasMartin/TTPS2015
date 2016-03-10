package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.MenuService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.ErrorHelper;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;

@RestController(value="menuController")
@RequestMapping(value="/menu")
public class MenuController {

	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping( value = "/crear" ,method = RequestMethod.GET)
	public ModelAndView crear(){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return menuService.crear();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping( value = "/crear" ,method = RequestMethod.POST)
	public ModelAndView crear(@RequestParam("nombre") String nombre,
			@RequestParam("caracteristicas") ArrayList<Long> caracteristicas,
			@RequestParam("bebidas") ArrayList<Long> bebidas, @RequestParam("entradas") ArrayList<Long> entradas,
			@RequestParam("platos") ArrayList<Long> platos, @RequestParam("postres") ArrayList<Long> postres){
		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return menuService.crear(nombre, caracteristicas, bebidas, entradas, platos, postres);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping( value = "/editar" ,method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam("id") Long id){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return menuService.editar(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping( value = "/editar" ,method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("id") Long id, @RequestParam("nombre") String nombre,
			@RequestParam("caracteristicas") ArrayList<Long> caracteristicas,
			@RequestParam("bebidas") ArrayList<Long> bebidas, @RequestParam("entradas") ArrayList<Long> entradas,
			@RequestParam("platos") ArrayList<Long> platos, @RequestParam("postres") ArrayList<Long> postres){
		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return menuService.editar(id, nombre, caracteristicas, bebidas, entradas, platos, postres);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {	
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return menuService.listar();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminarMenu(@RequestParam("id") Long id) {
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return menuService.eliminar(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
}
