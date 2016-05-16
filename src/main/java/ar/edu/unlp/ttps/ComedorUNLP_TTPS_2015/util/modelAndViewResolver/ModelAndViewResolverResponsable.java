package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

public class ModelAndViewResolverResponsable {

	public static ModelAndView crear(List<Sede> sedes) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("altaResponsable").addObject("sedes", sedes)
				.getModelAndView();
	}

	public static ModelAndView listar(List<Responsable> responsables) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("listarResponsables")
				.addObject("responsables", responsables).getModelAndView();
	}

	public static ModelAndView editar(Responsable responsable, List<Sede> sedes) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("editarResponsable").addObject("sedes", sedes)
				.addObject("responsable", responsable).getModelAndView();
	}

}
