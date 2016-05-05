package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.SedeService;

@RestController(value = "sedeController")
@RequestMapping(value = "/sede")
public class SedeController {

	@Autowired
	private SedeService sedeService;

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crear(@RequestParam("nombre") String nombre,
			@RequestParam("capacidad") int capacidad,
			@RequestParam("ubicacion") String ubicacion) {
		return sedeService.crear(nombre, capacidad, ubicacion);

	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public ModelAndView crear() {
		return sedeService.crear();
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		return sedeService.listar();
	}

	@RequestMapping(value = "/usuariosHabilitados", method = RequestMethod.GET)
	public ModelAndView usuariosHabilitados() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dni = (String) user.getUsername();
		return sedeService.usuariosHabilitados(dni);

	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminar(@RequestParam("id") Long id) {

		return sedeService.eliminar(id);

	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam("id") Long id) {
		return sedeService.editar(id);
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("id") Long id,
			@RequestParam("nombre") String nombre,
			@RequestParam("capacidad") int capacidad,
			@RequestParam("ubicacion") String ubicacion) {

		return sedeService.editar(id, nombre, capacidad, ubicacion);
	}

}
