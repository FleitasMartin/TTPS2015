package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.MenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;

@Controller
public class CartillaController {

	@Autowired
	private MenuDAO menuDAO;
	@Autowired
	private CartillaDAO cartillaDAO;
	
	@RequestMapping( value = "/admin/altaCartilla" ,method = RequestMethod.GET)
	public ModelAndView altaMenu(){
		ModelAndView model = new ModelAndView();
		ArrayList<Menu> menues = new ArrayList<Menu>();;
		menues = (ArrayList<Menu>) menuDAO.getAll();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage","altaCartilla");
		return model;
	}
	
	@RequestMapping( value = "/admin/altaCartilla" ,method = RequestMethod.POST)
	public ModelAndView altaMenu(@RequestParam(value="lunes") Long[] lunes,
			@RequestParam(value="martes") Long[] martes,
			@RequestParam(value="miercoles") Long[] miercoles,
			@RequestParam(value="jueves") Long[] jueves,
			@RequestParam(value="viernes") Long[] viernes){
		
		for (int i = 0; i < viernes.length; i++) {
			System.out.println(viernes[i]);
		}
		
		
		ModelAndView model = new ModelAndView();
		ArrayList<Menu> menues = new ArrayList<Menu>();;
		menues = (ArrayList<Menu>) menuDAO.getAll();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage","altaCartilla");
		return model;
	}
	
}
