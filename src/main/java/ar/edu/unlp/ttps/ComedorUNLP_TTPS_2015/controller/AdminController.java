package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.AdminService;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.ResponsableService;

@RestController(value = "adminController")
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private ResponsableService responsableService;

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public ModelAndView crear() {
		return adminService.crear();
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crear(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("dni") String dni,
			@RequestParam("contrasena") String contrasena,
			@RequestParam("telefono") Long telefono,
			@RequestParam("domicilio") String domicilio,
			@RequestParam("email") String email) {

		return adminService.crear(nombre, apellido, dni, contrasena, telefono,
				domicilio, email);

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {

		return adminService.listar();

	}

	@RequestMapping(value = "/editarAdmin", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam("id") Long id) {

		return adminService.editarAdmin(id);

	}

	@RequestMapping(value = "/editarAdmin", method = RequestMethod.POST)
	public ModelAndView editarAdmin(@RequestParam("id") Long id,
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("telefono") Long telefono,
			@RequestParam("email") String email,
			@RequestParam("telefono") String domicilio) {

		return adminService.editarAdmin(id, nombre, apellido, telefono, email,
				domicilio);

	}

	@RequestMapping(value = "/eliminarAdmin", method = RequestMethod.POST)
	public ModelAndView eliminarAdmin(@RequestParam("id") Long id) {

		return adminService.eliminar(id);

	}

}
