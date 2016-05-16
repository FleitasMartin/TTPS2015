package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.DetalleUsuarioService.CustomUserDetails;

public class ModelAndViewResolverCartilla {

	private static ModelAndViewWrapperBase model = new ModelAndViewWrapperBase(
			"indexAdmin",
			((CustomUserDetails) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal()).getNombreUsuario());

	public static ModelAndView listarCartilla(Object cartillas) {
		return getModel().addContentPage("listarCartillas")
				.addObject("cartillas", cartillas).getModelAndView();
	}

	public static ModelAndView detalleCartilla(Object id, Object semana) {
		return getModel().addContentPage("detalleCartilla").addObject("id", id)
				.addObject("semana", semana).getModelAndView();
	}

	public static ModelAndView crearCartilla(Object menues) {
		return getModel().addContentPage("altaCartilla")
				.addObject("menues", menues).getModelAndView();
	}

	public static ModelAndView crearCartilla(Object menues, String error) {
		return getModel().addContentPage("altaCartilla")
				.addObject("menues", menues).addObject("error", error)
				.getModelAndView();
	}

	public static ModelAndView editarCartilla(Object cartilla,
			Object menuesChecked) {
		return getModel().addContentPage("editarCartilla")
				.addObject("cartilla", cartilla)
				.addObject("menues", menuesChecked).getModelAndView();
	}

	public static ModelAndView editarCartilla(Object cartilla,
			Object menuesChecked, String error) {
		return editarCartilla(cartilla, menuesChecked)
				.addObject("error", error);
	}

	private static ModelAndViewWrapperBase getModel() {
		return model;
	}

}
