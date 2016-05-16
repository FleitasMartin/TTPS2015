package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;

public class ModelAndViewResolverAdmin {

	public static ModelAndView crear() {
		return new ModelAndViewWrapperBaseAdmin().addContentPage("altaAdmin")
				.getModelAndView();
	}

	public static ModelAndView listar(List<Administrador> admins) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("listarAdmins").addObject("admins", admins)
				.getModelAndView();
	}

	public static ModelAndView editar(Administrador administrador) {
		return new ModelAndViewWrapperBaseAdmin().addContentPage("editarAdmin")
				.addObject("admin", administrador).getModelAndView();
	}

}
