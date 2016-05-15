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

@Service
public class ResponsableService {

	@Autowired
	private SedeDAO sedeDAO;

	@Autowired
	private ResponsableDAO responsableDAO;

	@Autowired
	private RolUsuarioDAO rolUsuarioDAO;

	public ModelAndView crear() {
		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes = (ArrayList<Sede>) sedeDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage", "altaResponsable");
		model.addObject("sedes", sedes);
		return model;
	}

	public ModelAndView listar() {

		ArrayList<Responsable> responsables = new ArrayList<Responsable>();
		responsables = (ArrayList<Responsable>) responsableDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("responsables", responsables);
		model.addObject("contentPage", "listarResponsables");
		return model;
	}

	public ModelAndView crear(String nombre, String apellido, String dni,
			String contrasena, Long telefono, String email,
			String domicilio, Long sedeId) {

		Sede sede = sedeDAO.get(sedeId);
		Responsable resp = new Responsable(dni, contrasena, apellido, nombre,
				domicilio, email, telefono, sede,
				rolUsuarioDAO.getRol("ROLE_RESPONSABLE"));
		responsableDAO.save(resp);
		return listar();
	}

	public ModelAndView editarResponsable(Long id) {
		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes = (ArrayList<Sede>) sedeDAO.getAll();
		Responsable responsable = responsableDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("responsable", responsable);
		model.addObject("sedes", sedes);
		model.addObject("contentPage", "editarResponsable");
		return model;
	}

	public ModelAndView editarResponsable(Long id, String nombre,
			String apellido, Long telefono, String email, String domicilio,
			Long sede) {
		Responsable responsable = responsableDAO.get(id);
		responsable.setApellido(apellido);
		responsable.setNombre(nombre);
		responsable.setEmail(email);
		responsable.setTelefono(telefono);
		responsable.setDomicilio(domicilio);
		responsableDAO.edit(responsable);
		return listar();
	}

	public ModelAndView eliminar(Long id) {
		responsableDAO.delete(id);
		return listar();
	}
}
