package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;

@Service
public class CompraService {

	public ModelAndView compraDeTickets(){
//		ArrayList<Sede> sedes = new ArrayList<Sede>();
//		sedes = (ArrayList<Sede>) sedeDAO.getAll();
//		Long id = (Long)SesionUtil.getSesion().getAttribute("idUsuario");
//		Usuario usuario = usuarioDAO.get(id);
		ModelAndView model = new ModelAndView();
//		model.setViewName("indexUsuario");
//		model.addObject("usuario", usuario);
//		model.addObject("sedes", sedes);
//		model.addObject("contentPage","compraDeTickets");
		return model;
	}
}
