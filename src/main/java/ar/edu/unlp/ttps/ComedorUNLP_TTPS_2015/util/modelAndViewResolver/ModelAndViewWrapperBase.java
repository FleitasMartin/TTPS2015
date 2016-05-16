package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.DetalleUsuarioService.CustomUserDetails;

public class ModelAndViewWrapperBase {

	protected ModelAndView modelAndView;

	protected ModelAndViewWrapperBase(String indexView) {
		super();
		setModelAndView(new ModelAndView());
		setIndexView(indexView);
		getModelAndView()
				.addObject(
						"nombreUsuario",
						((CustomUserDetails) SecurityContextHolder.getContext()
								.getAuthentication().getPrincipal())
								.getNombreUsuario());
	}
	
	protected ModelAndViewWrapperBase(){
		super();
	}

	public ModelAndViewWrapperBase addObject(String attributeName,
			Object attributeValue) {
		getModelAndView().addObject(attributeName, attributeValue);
		return this;
	}

	public ModelAndViewWrapperBase addContentPage(String contentPage) {
		getModelAndView().addObject("contentPage", contentPage);
		return this;
	}

	public void setIndexView(String indexView) {
		getModelAndView().setViewName(indexView);
	}

	public ModelAndView getModelAndView() {
		return modelAndView;
	}

	public void setModelAndView(ModelAndView modelAndView) {
		this.modelAndView = modelAndView;
	}

}
