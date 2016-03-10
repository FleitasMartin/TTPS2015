package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;

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

	public ModelAndView crear(String nombre, String apellido, int dni, String contrasena){
		
		Administrador admin = new Administrador();
		admin.setDni(dni);
		admin.setContrasena(contrasena);
		admin.setApellido(apellido);
		admin.setNombre(nombre);
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
}
