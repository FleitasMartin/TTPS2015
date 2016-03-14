package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.CompraService;

@RestController(value = "compraController")
@RequestMapping(value = "/compra")
public class CompraController {

	@Autowired
	CompraService compraService;

	@RequestMapping(value = "/compraDeTickets", method = RequestMethod.GET)
	public ModelAndView compraDeTickets() throws ParseException {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return compraService.compraDeTickets(dniUsuario);
	}
}
