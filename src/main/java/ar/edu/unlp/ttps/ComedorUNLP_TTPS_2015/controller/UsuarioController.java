package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.UsuarioService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.ErrorHelper;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;


@RestController(value="usuarioController")
@RequestMapping(value="/user")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public ModelAndView perfil(@RequestParam("id") Long id) {		
		if ( SesionUtil.checkLogin() ){
			if (SesionUtil.checkTipo(1)){
				return usuarioService.perfil(id);
			}
			return ErrorHelper.generarErrorIndex("No posee los permisos necesarios.");
		}
		return ErrorHelper.generarErrorIndex("No hay sesión activa.");			
	}
}
