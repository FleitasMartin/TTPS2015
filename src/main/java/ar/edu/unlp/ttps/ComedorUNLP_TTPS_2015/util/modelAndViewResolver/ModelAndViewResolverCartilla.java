package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewResolverCartilla {

	public static ModelAndView listarCartilla(Object cartillas) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("listarCartillas")
				.addObject("cartillas", cartillas).getModelAndView();
	}

	public static ModelAndView detalleCartilla(Object id, Object semana) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("detalleCartilla").addObject("id", id)
				.addObject("semana", semana).getModelAndView();
	}

	public static ModelAndView crearCartilla(Object menues) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("altaCartilla").addObject("menues", menues)
				.getModelAndView();
	}

	public static ModelAndView crearCartilla(Object menues, String error) {
		return crearCartilla(menues).addObject("error", error);
	}

	public static ModelAndView editarCartilla(Object cartilla,
			Object menuesChecked) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("editarCartilla")
				.addObject("cartilla", cartilla)
				.addObject("menues", menuesChecked).getModelAndView();
	}

	public static ModelAndView editarCartilla(Object cartilla,
			Object menuesChecked, String error) {
		return editarCartilla(cartilla, menuesChecked)
				.addObject("error", error);
	}

}
