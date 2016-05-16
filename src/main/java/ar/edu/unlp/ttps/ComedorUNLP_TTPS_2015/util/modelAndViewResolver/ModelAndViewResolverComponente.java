package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;

public class ModelAndViewResolverComponente {

	public static ModelAndView crear() {
		return new ModelAndViewWrapperBaseAdmin().addContentPage(
				"altaComponente").getModelAndView();
	}

	public static ModelAndView listar(List<Componente> componentes) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("listarComponentes")
				.addObject("componentes", componentes).getModelAndView();
	}

	public static ModelAndView editar(Componente componente) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("editarComponente")
				.addObject("componente", componente).getModelAndView();
	}
}
