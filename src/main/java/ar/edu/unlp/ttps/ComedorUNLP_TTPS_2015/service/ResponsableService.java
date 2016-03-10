package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@Service
public class ResponsableService {

	@Autowired
	private SedeDAO sedeDAO;
	
	@Autowired
	private ResponsableDAO responsableDAO;
	
	public ModelAndView crear(){
		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes = (ArrayList<Sede>) sedeDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","altaResponsable");
		model.addObject("sedes", sedes);
		return model;
	}

	public ModelAndView crear(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("dni") int dni,
			@RequestParam("contrasena") String contrasena,
			@RequestParam("sedeId") Long sedeId){
		
		Responsable resp = new Responsable();
		resp.setDni(dni);
		resp.setContrasena(contrasena);
		resp.setApellido(apellido);
		resp.setNombre(nombre);
		Sede sede = sedeDAO.get(sedeId);
		resp.setSede(sede);
		responsableDAO.save(resp);
		return listar();
	}
	
	public ModelAndView listar() {		
		ArrayList<Responsable> resps = new ArrayList<Responsable>();
		resps = (ArrayList<Responsable>) responsableDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("resps", resps);
		model.addObject("contentPage","listarResponsables");
		return model;
	}
}
