package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util;

import org.springframework.web.servlet.ModelAndView;

public class ErrorHelper {

	public static ModelAndView generarErrorIndex(String error){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("error", error);
		return model;
	}
}
