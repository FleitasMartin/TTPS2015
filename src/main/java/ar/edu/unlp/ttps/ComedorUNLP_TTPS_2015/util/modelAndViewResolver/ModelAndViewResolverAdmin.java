package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;

public class ModelAndViewResolverAdmin {

	private static ModelAndViewWrapperBase model = new ModelAndViewWrapperBaseAdmin();

	private static ModelAndViewWrapperBase getModel() {
		return model;
	}

	public static ModelAndView crear() {
		return getModel().addContentPage("altaAdmin").getModelAndView();
	}

	public static ModelAndView listar(List<Administrador> admins) {
		return getModel().addContentPage("listarAdmins")
				.addObject("admins", admins).getModelAndView();
	}

	public static ModelAndView editar(Administrador administrador) {
		return getModel().addContentPage("editarAdmin")
				.addObject("admin", administrador).getModelAndView();
	}

}
