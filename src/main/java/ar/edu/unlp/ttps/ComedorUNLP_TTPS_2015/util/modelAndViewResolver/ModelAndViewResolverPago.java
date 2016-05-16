package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewResolverPago {

	public static ModelAndView listadoSemanal(
			Map<String, Map<String, Integer>> diasMenuesCantidades) {
		return new ModelAndViewWrapperBaseResponsable()
				.addContentPage("listarPagosSemanal")
				.addObject("map", diasMenuesCantidades).getModelAndView();
	}

}
