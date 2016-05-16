package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.AdministradorDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.RolUsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver.ModelAndViewResolverAdmin;

@Service
public class AdminService {

	@Autowired
	private AdministradorDAO administradorDAO;
	@Autowired
	private RolUsuarioDAO rolUsuarioDAO;

	public ModelAndView crear() {
		return ModelAndViewResolverAdmin.crear();
	}

	public ModelAndView crear(String nombre, String apellido, String dni,
			String contrasena, Long telefono, String domicilio, String email) {

		Administrador admin = new Administrador(nombre, apellido, dni,
				contrasena, telefono, domicilio, email);
		admin.setRol(rolUsuarioDAO.getRol("ROLE_ADMIN"));
		administradorDAO.save(admin);
		return listar();
	}

	public ModelAndView listar() {
		ArrayList<Administrador> admins = (ArrayList<Administrador>) administradorDAO
				.getAll();
		return ModelAndViewResolverAdmin.listar(admins);
	}

	public ModelAndView editarAdmin(Long id) {
		Administrador administrador = administradorDAO.get(id);
		return ModelAndViewResolverAdmin.editar(administrador);
	}

	public ModelAndView editarAdmin(Long id, String nombre, String apellido,
			Long telefono, String email, String domicilio) {
		Administrador admin = administradorDAO.get(id);
		admin.editarDatos(apellido, nombre, email, telefono, domicilio);
		administradorDAO.edit(admin);
		return listar();
	}

	public ModelAndView eliminar(Long id) {
		administradorDAO.delete(id);
		return listar();
	}
}
