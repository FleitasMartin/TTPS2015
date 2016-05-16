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
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver.ModelAndViewResolverSede;

@Service
public class SedeService {

	@Autowired
	private SedeDAO sedeDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private ResponsableDAO responsableDAO;

	public ModelAndView listarAdmin() {
		ArrayList<Sede> sedes = (ArrayList<Sede>) sedeDAO.getAll();
		return ModelAndViewResolverSede.listarAdmin(sedes);
	}

	public ModelAndView listar() {
		ArrayList<Sede> sedes = (ArrayList<Sede>) sedeDAO.getAll();
		return ModelAndViewResolverSede.listarUsuario(sedes);
	}

	public ModelAndView usuariosHabilitados(String dni) {
		Responsable responsable = responsableDAO.findByDNI(dni);
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioDAO
				.getAllBySede(responsable.getSede());
		return ModelAndViewResolverSede.listarResponsable(usuarios);
	}

	public ModelAndView crear(String nombre, int capacidad, String ubicacion,
			String latitud, String longitud) {
		Sede sedeNueva = new Sede(nombre, capacidad, ubicacion, latitud,
				longitud);
		sedeDAO.save(sedeNueva);
		return listarAdmin();
	}

	public ModelAndView crear() {
		return ModelAndViewResolverSede.crear();
	}

	public ModelAndView editar(Long id, String nombre, int capacidad,
			String ubicacion, String latitud, String longitud) {
		Sede sede = sedeDAO.get(id);
		sede.editar(nombre, capacidad, ubicacion, latitud, longitud);
		sedeDAO.edit(sede);
		return listarAdmin();
	}

	public ModelAndView editar(Long id) {
		Sede sede = sedeDAO.get(id);
		return ModelAndViewResolverSede.editar(sede);
	}

	public ModelAndView eliminar(Long id) {
		sedeDAO.delete(id);
		return listarAdmin();
	}
}
