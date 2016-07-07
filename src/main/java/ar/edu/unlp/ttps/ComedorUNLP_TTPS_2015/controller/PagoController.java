package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.PagoService;

@RestController(value = "pagoController")
@RequestMapping(value = "/pago")
public class PagoController {
	
	@Autowired
	PagoService pagoService;
	
	@RequestMapping(value = "/listadoSemanal", method = RequestMethod.GET)
	public ModelAndView listadoSemanal(@RequestParam(name = "fechaInicio", required=false) String fechaInicio) throws ParseException {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dni = (String) user.getUsername();
		return pagoService.listadoSemanal(fechaInicio, dni);
	}

}
