package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("")
	public ModelAndView getAllUsuarios() {
		return new ModelAndView("index");
	}

}
