package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SugerenciaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.SesionUtil;

@Service
public class SugerenciaService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private SedeDAO sedeDAO;
	@Autowired
	private SugerenciaDAO sugerenciaDAO;
	@Autowired
	private ResponsableDAO responsableDAO;
	
	public ModelAndView comentar(){
		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes = (ArrayList<Sede>) sedeDAO.getAll();
		Long id = (Long)SesionUtil.getSesion().getAttribute("idUsuario");
		Usuario usuario = usuarioDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("usuario", usuario);
		model.addObject("sedes", sedes);
		model.addObject("contentPage","comentar");
		return model;
	}
	
	public ModelAndView comentar(String tipoSugerencia, Long sedeId, String message ){
		Long id = (Long)SesionUtil.getSesion().getAttribute("idUsuario");
		Usuario usuario = usuarioDAO.get(id);
		Sugerencia sugerencia = new Sugerencia();
		Sede sede = sedeDAO.get(sedeId);
		sugerencia.setSede(sede);
		sugerencia.setTipo(tipoSugerencia);
		sugerencia.setMensaje(message);
		sugerencia.setUsuario(usuario);
		
		sugerenciaDAO.save(sugerencia);
		return comentar();
	}
	
	public ModelAndView buzonVirtual() {
		
		ArrayList<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		sugerencias = (ArrayList<Sugerencia>) sugerenciaDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("sugerencias", sugerencias);
		model.addObject("contentPage","buzonVirtual");
		return model;
	}
	
	public ModelAndView buzonVirtualDeSede() {
		
		ArrayList<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		Long id = (Long)SesionUtil.getSesion().getAttribute("idUsuario");
		Responsable responsable = responsableDAO.get(id);
		sugerencias = (ArrayList<Sugerencia>) sugerenciaDAO.getAllBySede(responsable.getSede().getId());
		ModelAndView model = new ModelAndView();
		model.setViewName("indexResponsable");
		model.addObject("sugerencias", sugerencias);
		model.addObject("contentPage","buzonVirtualDeSede");
		return model;
	}

}
