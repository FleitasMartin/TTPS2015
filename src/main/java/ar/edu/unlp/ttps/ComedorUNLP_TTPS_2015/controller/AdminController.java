package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.AdminService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.ResponsableService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.ErrorHelper;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;

@RestController(value="adminController")
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;	
	@Autowired
	private ResponsableService responsableService;
		
	@RequestMapping( value = "/crear" ,method = RequestMethod.GET)
	public ModelAndView crear(){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return adminService.crear();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");	
	}

	@RequestMapping( value = "/crear" ,method = RequestMethod.POST)
	public ModelAndView crear(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("dni") int dni,
			@RequestParam("contrasena") String contrasena,
			@RequestParam("telefono") Integer telefono,
			@RequestParam("domicilio") String domicilio,
			@RequestParam("email") String email){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return adminService.crear(nombre, apellido, dni, contrasena, telefono, domicilio, email);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return adminService.listar();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");	
	}
	@RequestMapping(value = "/listarResponsables", method = RequestMethod.GET)
	public ModelAndView listarResponsables() {
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return responsableService.listarResponsables();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");	
	}
	
	@RequestMapping(value="/editarAdmin", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam("id") Long id){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return adminService.editarAdmin(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value="/editarResponsable", method = RequestMethod.GET)
	public ModelAndView editarResponsable(@RequestParam("id") Long id){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return responsableService.editarResponsable(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value="/editarAdmin", method = RequestMethod.POST)
	public ModelAndView editarAdmin(@RequestParam("id") Long id,
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("telefono")Integer telefono,
			@RequestParam("email")String email,
			@RequestParam("telefono")String domicilio
			){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return adminService.editarAdmin(id, nombre, apellido, telefono,email,domicilio );
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value="/editarResponsable", method = RequestMethod.POST)
	public ModelAndView editarResponsable(@RequestParam("id") Long id,
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("telefono")Integer telefono,
			@RequestParam("email")String email,
			@RequestParam("telefono")String domicilio,
			@RequestParam("sedeId")Long sede
			){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return responsableService.editarResponsable(id, nombre, apellido, telefono,email,domicilio, sede );
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping(value="/eliminarAdmin", method = RequestMethod.POST)
	public ModelAndView eliminarAdmin(@RequestParam("id") Long id){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return adminService.eliminar(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	@RequestMapping(value="/eliminarResponsable", method = RequestMethod.POST)
	public ModelAndView eliminarResponsable(@RequestParam("id") Long id){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return responsableService.eliminar(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	
}
