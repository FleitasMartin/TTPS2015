package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.RolUsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver.ModelAndViewResolverResponsable;

@Service
public class ResponsableService {

	@Autowired
	private SedeDAO sedeDAO;

	@Autowired
	private ResponsableDAO responsableDAO;

	@Autowired
	private RolUsuarioDAO rolUsuarioDAO;

	public ModelAndView crear() {
		ArrayList<Sede> sedes = (ArrayList<Sede>) sedeDAO.getAll();
		return ModelAndViewResolverResponsable.crear(sedes);
	}

	public ModelAndView listar() {
		ArrayList<Responsable> responsables = (ArrayList<Responsable>) responsableDAO
				.getAll();
		return ModelAndViewResolverResponsable.listar(responsables);
	}

	public ModelAndView crear(String nombre, String apellido, String dni,
			String contrasena, Long telefono, String email, String domicilio,
			Long sedeId) {

		Sede sede = sedeDAO.get(sedeId);
		Responsable resp = new Responsable(dni, contrasena, apellido, nombre,
				domicilio, email, telefono, sede,
				rolUsuarioDAO.getRol("ROLE_RESPONSABLE"));
		responsableDAO.save(resp);
		return listar();
	}

	public ModelAndView editarResponsable(Long id) {
		ArrayList<Sede> sedes = (ArrayList<Sede>) sedeDAO.getAll();
		Responsable responsable = responsableDAO.get(id);
		return ModelAndViewResolverResponsable.editar(responsable, sedes);
	}

	public ModelAndView editarResponsable(Long id, String nombre,
			String apellido, Long telefono, String email, String domicilio,
			Long sedeId) {
		Responsable responsable = responsableDAO.get(id);
		Sede sede = sedeDAO.get(sedeId);
		responsable.editar(apellido, nombre, email, telefono, domicilio, sede);
		responsableDAO.edit(responsable);
		return listar();
	}

	public ModelAndView eliminar(Long id) {
		responsableDAO.delete(id);
		return listar();
	}
}
