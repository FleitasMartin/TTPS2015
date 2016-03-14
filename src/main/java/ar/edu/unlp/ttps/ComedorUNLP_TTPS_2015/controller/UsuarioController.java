package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Caracteristica;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.UsuarioService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.ErrorHelper;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;


@RestController(value="usuarioController")
@RequestMapping(value="/user")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public ModelAndView perfil() {		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(3)){
				return usuarioService.perfil();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
	
	@RequestMapping(value="/editarPreferencias", method = RequestMethod.GET)
	public ModelAndView editarPreferencias(){
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(3)){
				return usuarioService.editarPreferencias();
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");		
	}
	
	@RequestMapping( value = "/editarPreferencias" ,method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("caracteristicas") ArrayList<Long> caracteristicas){
		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(3)){
				return usuarioService.editar(caracteristicas);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");
	}
}
