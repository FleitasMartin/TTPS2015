package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Caracteristica;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;

public class ModelAndViewResolverMenu {

	private static ModelAndViewWrapperBase model = new ModelAndViewWrapperBaseAdmin();

	private static ModelAndViewWrapperBase getModel() {
		return model;
	}

	public static ModelAndView crear(List<Componente> componentes,
			List<Caracteristica> caracteristicas) {
		return getModel().addContentPage("altaMenu")
				.addObject("componentes", componentes)
				.addObject("caracteristicas", caracteristicas)
				.getModelAndView();
	}

	public static ModelAndView listar(List<Menu> menues) {
		return getModel().addContentPage("listarMenues")
				.addObject("menues", menues).getModelAndView();
	}

	public static ModelAndView editar(Menu menu, List<Componente> componentes,
			List<Caracteristica> caracteristicas) {

		return getModel().addContentPage("editarMenu").addObject("menu", menu)
				.addObject("componentes", componentes)
				.addObject("caracteristicas", caracteristicas)
				.getModelAndView();
	}
}
