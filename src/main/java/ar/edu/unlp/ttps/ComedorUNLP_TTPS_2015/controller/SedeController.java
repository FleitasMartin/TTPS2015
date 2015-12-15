package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@Controller
public class SedeController {
	
	@Autowired
	private SedeDAO sedeDAO;
	
	@RequestMapping( value = "/admin/crearSede" ,method = RequestMethod.POST)
	public ModelAndView crearSede(@RequestParam("nombre") String nombre,
			@RequestParam("capacidad") int capacidad,
			@RequestParam("ubicacion") String ubicacion) {

		Sede sedeNueva = new Sede();
		sedeNueva.setNombre(nombre);
		sedeNueva.setCapacidad(capacidad);
		sedeNueva.setUbicacion(ubicacion);
		sedeDAO.save(sedeNueva);
		
		return new ModelAndView("index");
	}

	public SedeDAO getSedeDAO() {
		return sedeDAO;
	}

	public void setSedeDAO(SedeDAO sedeDAO) {
		this.sedeDAO = sedeDAO;
	}
}
