package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SugerenciaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver.ModelAndViewResolverSugerencia;

@Service
public class SugerenciaService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private SedeDAO sedeDAO;
	@Autowired
	private SugerenciaDAO sugerenciaDAO;
	@Autowired
	private ResponsableDAO responsableDAO;

	public ModelAndView comentar(String dniUsuario) {
		ArrayList<Sede> sedes = (ArrayList<Sede>) sedeDAO.getAll();
		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		return ModelAndViewResolverSugerencia.comentar(usuario, sedes);
	}

	public ModelAndView comentar(String tipo, Long sedeId, String mensaje,
			String dniUsuario) {
		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		Sede sede = sedeDAO.get(sedeId);
		Sugerencia sugerencia = new Sugerencia(usuario, tipo, mensaje, sede);
		sugerenciaDAO.save(sugerencia);
		return comentar(dniUsuario);
	}

	public ModelAndView buzonVirtual() {
		ArrayList<Sugerencia> sugerencias = (ArrayList<Sugerencia>) sugerenciaDAO
				.getAll();
		return ModelAndViewResolverSugerencia.buzonVirtual(sugerencias);
	}

	public ModelAndView buzonVirtualDeSede(String dniResponsable) {
		Responsable responsable = responsableDAO.findByDNI(dniResponsable);
		ArrayList<Sugerencia> sugerencias = (ArrayList<Sugerencia>) sugerenciaDAO
				.getAllBySede(responsable.getSede().getId());
		return ModelAndViewResolverSugerencia.buzonVirtualDeSede(sugerencias);
	}

}
