package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@Service
public class AdminService {

	@Autowired
	private AdministradorDAO administradorDAO;
	
	public ModelAndView crear(){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","altaAdmin");
		return model;
	}

	public ModelAndView crear(String nombre, String apellido, int dni, String contrasena, Integer telefono,  String domicilio, String email ){
		
		Administrador admin = new Administrador();
		admin.setDni(dni);
		admin.setContrasena(contrasena);
		admin.setApellido(apellido);
		admin.setNombre(nombre);
		admin.setEmail(email);
		admin.setTelefono(telefono);
		admin.setDomicilio(domicilio);
		administradorDAO.save(admin);
		return listar();
	}
	
	public ModelAndView listar() {
		
		ArrayList<Administrador> admins = new ArrayList<Administrador>();
		admins = (ArrayList<Administrador>) administradorDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("admins", admins);
		model.addObject("contentPage","listarAdmins");
		return model;
	}
	
	
	public ModelAndView editarAdmin(Long id){
		Administrador administrador = administradorDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("admin", administrador);
		model.addObject("contentPage","editarAdmin");
		return model;
	}
	
	public ModelAndView editarAdmin(Long id, String nombre, String apellido,Integer telefono, String email,  String domicilio) {
		Administrador admin = administradorDAO.get(id);
		admin.setApellido(apellido);
		admin.setNombre(nombre);
		admin.setEmail(email);
		admin.setTelefono(telefono);
		admin.setDomicilio(domicilio);
		administradorDAO.edit(admin);
		return listar();
	}
	
	public ModelAndView eliminar(Long id){
		administradorDAO.delete(id);
		return listar();
	}
}
