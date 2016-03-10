package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ComponenteDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;

@Service
public class ComponenteService {

	@Autowired
	private ComponenteDAO componenteDAO;
	
	public ModelAndView crear(String nombre, String tipo){		
		Componente componente = new Componente();
		componente.setTipo(tipo);
		componente.setNombre(nombre);
		componenteDAO.save(componente);		
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","altaComponente");
		return model;
	}
	
	public ModelAndView listar() {		
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		componentes = (ArrayList<Componente>) componenteDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("componentes", componentes);
		model.addObject("contentPage","adminComponentes");
		return model;
	}
	
	public ModelAndView eliminar(Long id) {		
		componenteDAO.delete(id);
		return listar();
	}
		
	public ModelAndView editar(Long id, String nombre) {		
		Componente componente = componenteDAO.get(id);
		componente.setNombre(nombre);
		componenteDAO.edit(componente);
		return listar();
	}
	
	public ModelAndView editar( Long id) {		
		Componente componente = componenteDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("componente", componente);
		model.addObject("contentPage","editarComponente");
		return model;
	}
	
	public ModelAndView crear(){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","altaComponente");
		return model;
	}
}
