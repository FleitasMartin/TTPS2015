package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.ResponsableService;

@RestController(value = "responsableController")
@RequestMapping(value = "/responsable")
public class ResponsableController {

	@Autowired
	ResponsableService responsableService;

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public ModelAndView crear() {
		return responsableService.crear();

	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crearResponsable(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("dni") String dni,
			@RequestParam("contrasena") String contrasena,
			@RequestParam("telefono") Integer telefono,
			@RequestParam("email") String email,
			@RequestParam("domicilio") String domicilio,
			@RequestParam("sedeId") Long sedeId) {

		return responsableService.crear(nombre, apellido, dni, contrasena,
				telefono, email, domicilio, sedeId);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		return responsableService.listar();
	}

	@RequestMapping(value = "/editarResponsable", method = RequestMethod.GET)
	public ModelAndView editarResponsable(@RequestParam("id") Long id) {
		return responsableService.editarResponsable(id);

	}

	@RequestMapping(value = "/editarResponsable", method = RequestMethod.POST)
	public ModelAndView editarResponsable(@RequestParam("id") Long id,
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("telefono") Integer telefono,
			@RequestParam("email") String email,
			@RequestParam("telefono") String domicilio,
			@RequestParam("sedeId") Long sede) {
		return responsableService.editarResponsable(id, nombre, apellido,
				telefono, email, domicilio, sede);

	}

	@RequestMapping(value = "/eliminarResponsable", method = RequestMethod.POST)
	public ModelAndView eliminarResponsable(@RequestParam("id") Long id) {

		return responsableService.eliminar(id);

	}
}
