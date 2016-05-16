package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewWrapperBase {

	private ModelAndView modelAndView;

	public ModelAndViewWrapperBase(String indexView, String nombreUsuario) {
		super();
		setModelAndView(new ModelAndView());
		setIndexView(indexView);
		getModelAndView().addObject("nombreUsuario", nombreUsuario);
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
