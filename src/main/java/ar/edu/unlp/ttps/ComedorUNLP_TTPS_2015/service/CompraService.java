package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;





import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SemanaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Semana;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;

@Service
public class CompraService {
	@Autowired 
	SedeDAO sedeDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	CartillaDAO cartillaDAO;
	
	@Autowired
	SemanaDAO semanaDAO;
	

	public ModelAndView compraDeTickets() throws ParseException{
		Long id = (Long)SesionUtil.getSesion().getAttribute("idUsuario");
		Usuario usuario = usuarioDAO.get(id);
		
		Sede sede = new Sede();
		sede = sedeDAO.get(usuario.getSede().getId());
		
		java.util.Date date = new Date();
		Object param = new java.sql.Date(date.getTime());
		
		Cartilla cartilla = new Cartilla();
		cartilla = cartillaDAO.getFirstCartilla(param);
		Semana semana = new Semana();
		semana = semanaDAO.get(cartilla.getSemanas().get(0).getId());
		Integer cantidad = cartilla.getSemanas().size();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("usuario", usuario);
		model.addObject("sede", sede);
		model.addObject("cartilla", cartilla);
		model.addObject("semana", semana);
		model.addObject("cantidad", cantidad);
		model.addObject("contentPage","compraDeTickets");
		return model;
	}
}
