package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.ComponenteService;

@RestController(value = "componenteController")
@RequestMapping(value = "/componente")
public class ComponenteController {

	@Autowired
	private ComponenteService componenteService;

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public ModelAndView crear() {
		return componenteService.crear();

	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crear(@RequestParam("nombre") String nombre,
			@RequestParam("tipo") String tipo) {

		return componenteService.crear(nombre, tipo);

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {

		return componenteService.listar();

	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminar(@RequestParam("id") Long id) {

		return componenteService.eliminar(id);

	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam("id") Long id) {

		return componenteService.editar(id);

	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("id") Long id,
			@RequestParam("nombre") String nombre) {

		return componenteService.editar(id, nombre);

	}

}
