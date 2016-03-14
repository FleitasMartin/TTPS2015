package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
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
	
	public ModelAndView listarResponsables() {
		
		ArrayList<Responsable> responsables = new ArrayList<Responsable>();
		responsables = (ArrayList<Responsable>) responsableDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("responsables", responsables);
		model.addObject("contentPage","listarResponsables");
		return model;
	}

	public ModelAndView crear(String nombre, String apellido, String dni, String contrasena, 
			Integer telefono, String email, String domicilio, Long sedeId){
		
		Responsable resp = new Responsable();
		resp.setDni(dni);
		resp.setContrasena(contrasena);
		resp.setApellido(apellido);
		resp.setNombre(nombre);
		resp.setDomicilio(domicilio);
		resp.setEmail(email);
		resp.setTelefono(telefono);
		Sede sede = sedeDAO.get(sedeId);
		resp.setSede(sede);
		responsableDAO.save(resp);
		return listar();
	}
	
	public ModelAndView editarResponsable(Long id){
		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes = (ArrayList<Sede>) sedeDAO.getAll();
		Responsable responsable = responsableDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("responsable", responsable);
		model.addObject("sedes", sedes);
		model.addObject("contentPage","editarResponsable");
		return model;
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
	
	public ModelAndView editarResponsable(Long id, String nombre, String apellido,Integer telefono, String email,  String domicilio, Long sede) {
		Responsable responsable = responsableDAO.get(id);
		responsable.setApellido(apellido);
		responsable.setNombre(nombre);
		responsable.setEmail(email);
		responsable.setTelefono(telefono);
		responsable.setDomicilio(domicilio);
		responsableDAO.edit(responsable);
		return listarResponsables();
	}
	
	public ModelAndView eliminar(Long id){
		responsableDAO.delete(id);
		return listarResponsables();
	}
}
