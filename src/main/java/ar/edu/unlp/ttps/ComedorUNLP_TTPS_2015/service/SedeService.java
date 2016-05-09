package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

@Service
public class SedeService {

	@Autowired
	private SedeDAO sedeDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private ResponsableDAO responsableDAO;
	
	public ModelAndView listar() {

		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes = (ArrayList<Sede>) sedeDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("sedes", sedes);
		model.addObject("contentPage", "adminSedes");
		return model;
	}

	public ModelAndView usuariosHabilitados(String dni) {

		Responsable responsable = responsableDAO.findByDNI(dni);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = (ArrayList<Usuario>) usuarioDAO.getAllBySede(responsable.getSede());
		ModelAndView model = new ModelAndView();
		model.setViewName("indexResponsable");
		model.addObject("usuarios", usuarios);
		model.addObject("contentPage", "usersList");
		return model;
	}

	public ModelAndView crear(String nombre, int capacidad, String ubicacion, String latitud, String longitud) {

		Sede sedeNueva = new Sede(nombre, capacidad, ubicacion, latitud, longitud);
		sedeDAO.save(sedeNueva);
		return listar();
	}

	public ModelAndView crear() {
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage", "altaSede");
		return model;
	}

	public ModelAndView editar(Long id, String nombre, int capacidad,
			String ubicacion, String latitud, String longitud) {
		Sede sede = sedeDAO.get(id);
		sede.setNombre(nombre);
		sede.setCapacidad(capacidad);
		sede.setUbicacion(ubicacion);
		sede.setLatitud(latitud);
		sede.setLongitud(longitud);
		sedeDAO.edit(sede);
		return listar();
	}

	public ModelAndView editar(Long id) {
		Sede sede = sedeDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("sede", sede);
		model.addObject("contentPage", "editarSede");
		return model;
	}

	public ModelAndView eliminar(Long id) {
		sedeDAO.delete(id);
		return listar();
	}
}
