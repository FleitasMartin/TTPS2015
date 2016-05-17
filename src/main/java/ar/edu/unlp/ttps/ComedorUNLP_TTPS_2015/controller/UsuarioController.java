package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.UsuarioService;

@RestController(value = "usuarioController")
@RequestMapping(value = "/user")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public ModelAndView perfil() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return usuarioService.perfil(dniUsuario);
	}

	@RequestMapping(value = "/editarPreferencias", method = RequestMethod.GET)
	public ModelAndView editarPreferencias() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return usuarioService.editarPreferencias(dniUsuario);
	}

	@RequestMapping(value = "/editarPreferencias", method = RequestMethod.POST)
	public ModelAndView editar(
			@RequestParam("caracteristicas") ArrayList<Long> caracteristicas) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return usuarioService.editar(caracteristicas, dniUsuario);

	}
	
	@RequestMapping(value = "/saldo", method = RequestMethod.POST)
	public ModelAndView saldo(@RequestParam("saldo") Double saldo) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return usuarioService.modificarSaldo(saldo, dniUsuario);
	}
}
