package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;

@Controller
public class LoginController {

	@Autowired
	AdministradorDAO adminDAO;

	@Autowired
	ResponsableDAO responsableDAO;

	@Autowired
	UsuarioDAO usuarioDAO;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView errorPermiso() {
		ModelAndView model = new ModelAndView();
		model.addObject("error", "No posee los permisos necesarios.");
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginDone() {
		ModelAndView model = new ModelAndView();

		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		SimpleGrantedAuthority permisoSimple = (SimpleGrantedAuthority) user
				.getAuthorities().toArray()[0];

		switch (permisoSimple.toString()) {
		case "ROLE_ADMIN":
			model.setViewName("indexAdmin");
			break;
		case "ROLE_RESPONSABLE":
			model.setViewName("indexResponsable");
			break;
		case "ROLE_USUARIO":
			model.setViewName("indexUsuario");
			break;
		default:
			break;
		}
		return model;
	}

	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	private ModelAndView salir(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("mensaje", "Sesión cerrada correctamente.");
		return model;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	private ModelAndView error() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("error", "Error en DNI o contraseña ingresada.");
		return model;
	}

}
