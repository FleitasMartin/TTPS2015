package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ComponenteDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@Controller
public class ComponenteController {
	
	@Autowired
	private ComponenteDAO componenteDAO;

	@RequestMapping( value = "/admin/altaComponente" ,method = RequestMethod.GET)
	public ModelAndView crearAdmin(){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","altaComponente");
		return model;
	}

	@RequestMapping( value = "/admin/altaComponente" ,method = RequestMethod.POST)
	public ModelAndView crearComponente(@RequestParam("nombre") String nombre,
			@RequestParam("tipo") String tipo){
		
		Componente componente = new Componente();
		componente.setTipo(tipo);
		componente.setNombre(nombre);
		componenteDAO.save(componente);
		System.out.println(componente.getNombre());
		System.out.println(componente.getTipo());
		System.out.println(componente.getId());
		ModelAndView model = new ModelAndView();
		model = listar();
		return model;
	}
	
	@RequestMapping(value = "/admin/adminComponentes", method = RequestMethod.GET)
	public ModelAndView listar() {		
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		componentes = (ArrayList<Componente>) componenteDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("componentes", componentes);
		model.addObject("contentPage","adminComponentes");
		return model;
	}
	
	@RequestMapping(value = "/admin/eliminarComponente", method = RequestMethod.POST)
	public ModelAndView eliminarComponente(@RequestParam("id") Long id) {		
		componenteDAO.delete(id);
		ModelAndView model = new ModelAndView();
		model = listar();
		return model;
	}
	
	@RequestMapping(value = "/admin/editarComponente", method = RequestMethod.GET)
	public ModelAndView editarComponente(@RequestParam("id") Long id) {		
		Componente componente = componenteDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("componente", componente);
		model.addObject("contentPage","editarComponente");
		return model;
	}
	
	@RequestMapping(value = "/admin/editarComponente", method = RequestMethod.POST)
	public ModelAndView editarComponente(@RequestParam("id") Long id, @RequestParam("nombre") String nombre) {		
		Componente componente = componenteDAO.get(id);
		componente.setNombre(nombre);
		componenteDAO.edit(componente);
		ModelAndView model = new ModelAndView();
		model = listar();
		return model;
	}
	
}
