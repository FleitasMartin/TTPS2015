package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;

@Controller
public class LoginController {

	@Autowired
	AdministradorDAO adminDAO;

	@Autowired
	ResponsableDAO responsableDAO;

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginUnico(@RequestParam("dni") int dni,
			@RequestParam("contrasena") String contrasena){
		
		ModelAndView model = new ModelAndView();
		if ( !SesionUtil.checkLogin() ){
			Usuario usuario = usuarioDAO.login(dni, contrasena);
			if( usuario != null){
				model.setViewName("indexUsuario");
				SesionUtil.crearSesion(usuario);
				model.addObject("nombreUsuario", SesionUtil.getSesion().getAttribute("nombre"));
				
			}else{
				Administrador admin = adminDAO.login(dni, contrasena);
				if (admin != null){
					model.setViewName("indexAdmin");
					SesionUtil.crearSesion(admin);
					model.addObject("nombreUsuario", SesionUtil.getSesion().getAttribute("nombre"));
				}else{
					Responsable responsable = responsableDAO.login(dni, contrasena);
					if (responsable != null){
						model.setViewName("indexResponsable");
						SesionUtil.crearSesion(responsable);
						model.addObject("nombreUsuario", SesionUtil.getSesion().getAttribute("nombre"));
					}else{
						model.setViewName("index");
						model.addObject("error", "Contraseña erronea o no existe usuario con DNI "+dni);
						SesionUtil.destruirSesion();
					}				
				}
			}		
		}else{
			model.setViewName("index");
			model.addObject("error", "Ya existe una sesión activa para esta máquina.");
			SesionUtil.destruirSesion();
		}
		
		return model;
	}
	
	@RequestMapping(value= "/salir",method = RequestMethod.GET)
	private ModelAndView salir(){
		SesionUtil.destruirSesion();
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("mensaje", "Sesión cerrada.");
		return model;
	}
	
}
