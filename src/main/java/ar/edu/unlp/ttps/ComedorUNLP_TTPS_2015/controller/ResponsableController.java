package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.ResponsableService;

@RestController(value="responsableController")
@RequestMapping(value="/responsable")
public class ResponsableController {
	
	@Autowired
	ResponsableService responsableService;

	@RequestMapping( value = "/crear" ,method = RequestMethod.GET)
	public ModelAndView crear(){
		return responsableService.crear();
	}

	@RequestMapping( value = "/crear" ,method = RequestMethod.POST)
	public ModelAndView crearResponsable(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("dni") int dni,
			@RequestParam("contrasena") String contrasena,
			@RequestParam("sedeId") Long sedeId){
		
		return responsableService.crear(nombre, apellido, dni, contrasena, sedeId);
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {		
		return responsableService.listar();
	}
}
