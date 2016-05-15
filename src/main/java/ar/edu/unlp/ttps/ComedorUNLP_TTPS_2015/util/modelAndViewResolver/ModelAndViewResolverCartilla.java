package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewResolverCartilla {

	public static ModelAndView listarCartilla(Object cartillas){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("cartillas", cartillas);
		model.addObject("contentPage", "listarCartillas");
		return model;
	}
	
	public static ModelAndView detalleCartilla(Object id, Object semana){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("id", id);
		model.addObject("semana", semana);
		model.addObject("contentPage", "detalleCartilla");
		return model;
	}
	
	public static ModelAndView crearCartilla(Object menues){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage", "altaCartilla");
		return model;
	}
	
	public static ModelAndView crearCartilla(Object menues, String error){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("error", error);
		model.addObject("contentPage", "altaCartilla");
		return model;
	}
	
	public static ModelAndView editarCartilla(Object cartilla, Object menuesChecked){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("cartilla", cartilla);
		model.addObject("menues", menuesChecked);
		model.addObject("contentPage", "editarCartilla");
		return model;
	}
	
	public static ModelAndView editarCartilla(Object cartilla, Object menuesChecked, String error){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("cartilla", cartilla);
		model.addObject("menues", menuesChecked);
		model.addObject("error", error);
		model.addObject("contentPage", "editarCartilla");
		return model;
	}
	
}
