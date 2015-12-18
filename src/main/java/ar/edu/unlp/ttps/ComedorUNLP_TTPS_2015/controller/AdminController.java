package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@Controller
public class AdminController {
	
	@Autowired
	private SedeDAO sedeDAO;
	
	@Autowired
	private AdministradorDAO administradorDAO;
	
	@Autowired
	private ResponsableDAO responsableDAO;
	
	@RequestMapping( value = "/admin/altaSede" ,method = RequestMethod.POST)
	public ModelAndView crearSede(@RequestParam("nombre") String nombre,
			@RequestParam("capacidad") int capacidad,
			@RequestParam("ubicacion") String ubicacion) {

		Sede sedeNueva = new Sede();
		sedeNueva.setNombre(nombre);
		sedeNueva.setCapacidad(capacidad);
		sedeNueva.setUbicacion(ubicacion);
		sedeDAO.save(sedeNueva);
		ModelAndView model = new ModelAndView();
		model = listarSedes();
		return model;
	}
	
	@RequestMapping( value = "/admin/altaSede" ,method = RequestMethod.GET)
	public ModelAndView crearSede(){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","altaSede");
		return model;
	}
	
	@RequestMapping(value = "/admin/listarSedes", method = RequestMethod.GET)
	public ModelAndView listarSedes() {
		
		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes = (ArrayList<Sede>) sedeDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("sedes", sedes);
		model.addObject("contentPage","adminSedes");
		return model;
	}
	
	@RequestMapping(value="/admin/eliminarSede", method = RequestMethod.POST)
	public ModelAndView eliminarSede(@RequestParam("id") Long id){
		sedeDAO.delete(id);
		ModelAndView model = new ModelAndView();
		model = listarSedes();
		return model;
	}
	
	@RequestMapping( value = "/admin/altaAdmin" ,method = RequestMethod.GET)
	public ModelAndView crearAdmin(){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","altaAdmin");
		return model;
	}

	@RequestMapping( value = "/admin/altaAdmin" ,method = RequestMethod.POST)
	public ModelAndView crearAdmin(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("dni") int dni,
			@RequestParam("contrasena") String contrasena){
		
		Administrador admin = new Administrador();
		admin.setDni(dni);
		admin.setContrasena(contrasena);
		admin.setApellido(apellido);
		admin.setNombre(nombre);
		administradorDAO.save(admin);
		ModelAndView model = new ModelAndView();
		model = listarAdmins();
		return model;
	}
	
	@RequestMapping(value = "/admin/listarAdmins", method = RequestMethod.GET)
	public ModelAndView listarAdmins() {
		
		ArrayList<Administrador> admins = new ArrayList<Administrador>();
		admins = (ArrayList<Administrador>) administradorDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("admins", admins);
		model.addObject("contentPage","listarAdmins");
		return model;
	}
	
	@RequestMapping( value = "/admin/altaResponsable" ,method = RequestMethod.GET)
	public ModelAndView crearResponsable(){
		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes = (ArrayList<Sede>) sedeDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","altaResponsable");
		model.addObject("sedes", sedes);
		return model;
	}

	@RequestMapping( value = "/admin/altaResponsable" ,method = RequestMethod.POST)
	public ModelAndView crearResponsable(@RequestParam("nombre") String nombre,
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
		ModelAndView model = new ModelAndView();
		model = listarResponsables();
		return model;
	}
	
	@RequestMapping(value = "/admin/listarResponsables", method = RequestMethod.GET)
	public ModelAndView listarResponsables() {
		
		ArrayList<Responsable> resps = new ArrayList<Responsable>();
		resps = (ArrayList<Responsable>) responsableDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("resps", resps);
		model.addObject("contentPage","listarResponsables");
		return model;
	}
	
	public SedeDAO getSedeDAO() {
		return sedeDAO;
	}

	public void setSedeDAO(SedeDAO sedeDAO) {
		this.sedeDAO = sedeDAO;
	}

	public AdministradorDAO getAdministradorDAO() {
		return administradorDAO;
	}

	public void setAdministradorDAO(AdministradorDAO administradorDAO) {
		this.administradorDAO = administradorDAO;
	}

	public ResponsableDAO getResponsableDAO() {
		return responsableDAO;
	}

	public void setResponsableDAO(ResponsableDAO responsableDAO) {
		this.responsableDAO = responsableDAO;
	}
}
