package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.SugerenciaService;

@RestController(value = "sugerenciaController")
@RequestMapping(value = "/sugerencia")
public class SugerenciaController {
	@Autowired
	SugerenciaService sugerenciaService;

	@RequestMapping(value = "/comentar", method = RequestMethod.GET)
	public ModelAndView comentar() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return sugerenciaService.comentar(dniUsuario);

	}

	@RequestMapping(value = "/comentar", method = RequestMethod.POST)
	public ModelAndView comentar(
			@RequestParam("tipoSugerencia") String tipoSugerencia,
			@RequestParam("sedeId") Long sedeId,
			@RequestParam("message") String message) {

		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return sugerenciaService.comentar(tipoSugerencia, sedeId, message,
				dniUsuario);

	}

	@RequestMapping(value = "/buzonVirtual", method = RequestMethod.GET)
	public ModelAndView buzonVirtual() {
		return sugerenciaService.buzonVirtual();

	}

	@RequestMapping(value = "/buzonVirtualDeSede", method = RequestMethod.GET)
	public ModelAndView buzonVirtualDeSede() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniResponsable = (String) user.getUsername();
		return sugerenciaService.buzonVirtualDeSede(dniResponsable);
	}

}
