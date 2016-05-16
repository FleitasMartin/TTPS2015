package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;

public class ModelAndViewResolverComponente {

	private static ModelAndViewWrapperBase model = new ModelAndViewWrapperBaseAdmin();

	private static ModelAndViewWrapperBase getModel() {
		return model;
	}

	public static ModelAndView crear() {
		return getModel().addContentPage("altaComponente").getModelAndView();
	}

	public static ModelAndView listar(List<Componente> componentes) {
		return getModel().addContentPage("listarComponentes")
				.addObject("componentes", componentes).getModelAndView();
	}

	public static ModelAndView editar(Componente componente) {
		return getModel().addContentPage("editarComponente")
				.addObject("componente", componente).getModelAndView();
	}
}
