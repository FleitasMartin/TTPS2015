package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Caracteristica;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

public class ModelAndViewResolverUsuario {

	public static ModelAndView perfil(Usuario usuario) {
		return new ModelAndViewWrapperBaseUsuario()
				.addContentPage("userPerfil").addObject("usuario", usuario)
				.getModelAndView();
	}

	public static ModelAndView editarPreferencias(Usuario usuario,
			List<Caracteristica> caracteristicas) {
		return new ModelAndViewWrapperBaseUsuario()
				.addContentPage("editarPreferencias")
				.addObject("usuario", usuario)
				.addObject("caracteristicas", caracteristicas)
				.getModelAndView();
	}

	public static ModelAndView saldo(Double saldo) {
		return new ModelAndViewWrapperBaseUsuario().addContentPage("saldo")
				.addObject("saldo", saldo).getModelAndView();
	}

}
