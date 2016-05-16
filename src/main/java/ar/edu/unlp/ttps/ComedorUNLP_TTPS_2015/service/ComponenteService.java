package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ComponenteDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver.ModelAndViewResolverComponente;

@Service
public class ComponenteService {

	@Autowired
	private ComponenteDAO componenteDAO;

	public ModelAndView crear(String nombre, String tipo) {
		Componente componente = new Componente(nombre, tipo);
		componenteDAO.save(componente);
		return listar();
	}

	public ModelAndView listar() {
		ArrayList<Componente> componentes = (ArrayList<Componente>) componenteDAO
				.getAll();
		return ModelAndViewResolverComponente.listar(componentes);
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

	public ModelAndView editar(Long id) {
		Componente componente = componenteDAO.get(id);
		return ModelAndViewResolverComponente.editar(componente);
	}

	public ModelAndView crear() {
		return ModelAndViewResolverComponente.crear();
	}
}
