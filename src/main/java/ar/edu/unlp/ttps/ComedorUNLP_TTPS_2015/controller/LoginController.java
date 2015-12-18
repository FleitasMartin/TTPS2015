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

@Controller
public class LoginController {

	@Autowired
	AdministradorDAO adminDAO;

	@Autowired
	ResponsableDAO responsableDAO;

	@Autowired
	UsuarioDAO usuarioDAO;

	@RequestMapping(value= "/login/admin",method = RequestMethod.POST)
	public ModelAndView loginAdmin(@RequestParam("dni") int dni,
			@RequestParam("contrasena") String contrasena) {
		
		Administrador admin = adminDAO.login(dni, contrasena);
		ModelAndView model = new ModelAndView();
		if(admin!=null){
			model.setViewName("indexAdmin");
		}else{
			model.setViewName("index");
		}		
		return model;
	}
	
	@RequestMapping(value= "/login/admin",method = RequestMethod.GET)
	public ModelAndView loginAdmin(){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","loginAdmin");
		return model;
	}
	
	@RequestMapping(value= "/login/responsable",method = RequestMethod.POST)
	public ModelAndView loginResponsable(@RequestParam("dni") int dni,
			@RequestParam("contrasena") String contrasena) {
		
		Responsable responsable = responsableDAO.login(dni, contrasena);
		ModelAndView model = new ModelAndView();
		if(responsable!=null){
			model.setViewName("indexResponsable");
		}else{
			model.setViewName("index");
		}		
		return model;
	}
	
	@RequestMapping(value= "/login/responsable",method = RequestMethod.GET)
	public ModelAndView loginResponsable(){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexResponsable");
		model.addObject("contentPage","loginResponsable");
		return model;
	}

	@RequestMapping(value= "/login/usuario",method = RequestMethod.POST)
	public ModelAndView loginUsuario(@RequestParam("dni") int dni,
			@RequestParam("contrasena") String contrasena) {
		
		Usuario usuario = usuarioDAO.login(dni, contrasena);
		ModelAndView model = new ModelAndView();
		if(usuario!=null){
			model.setViewName("indexUsuario");
		}else{
			model.setViewName("index");
		}		
		return model;
	}
	
	@RequestMapping(value= "/login/usuario",method = RequestMethod.GET)
	public ModelAndView loginUsuario(){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("contentPage","loginUsuario");
		return model;
	}
	
}
