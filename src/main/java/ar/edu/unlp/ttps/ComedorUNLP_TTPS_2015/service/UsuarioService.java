package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CaracteristicaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Caracteristica;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private CaracteristicaDAO caracteristicasDAO;
	
	public ModelAndView perfil(String dni){
		Usuario usuario = usuarioDAO.findByDNI(dni);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("usuario", usuario);
		model.addObject("contentPage","userPerfil");
		return model;
	}
	
	
	public ModelAndView editarPreferencias(String dniUsuario){
		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		ArrayList<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
		ArrayList<Caracteristica> lasCaracteristicas = new ArrayList<Caracteristica>();
		caracteristicas = (ArrayList<Caracteristica>) caracteristicasDAO.getAll();
		for (int i = 0; i < caracteristicas.size(); i++) {
			boolean existe = false;
			for (Caracteristica caracteristicasUsuario : usuario.getCaracteristica()) {
				if( caracteristicasUsuario.getId() == caracteristicas.get(i).getId() ){
					existe = true;
				}
			}
			if (!existe){
				lasCaracteristicas.add(caracteristicas.get(i));
			}
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("usuario", usuario);
		model.addObject("caracteristicas", lasCaracteristicas);
		model.addObject("contentPage","editarPreferencias");
		return model;
	}
	
	public ModelAndView editar(ArrayList<Long> caracteristicas, String dniUsuario){		
		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		ArrayList<Caracteristica> caracteristicasA = new ArrayList<Caracteristica>();
		for (Long idC : caracteristicas) {
			caracteristicasA.add(caracteristicasDAO.get(idC));
		}
		usuario.setCaracteristica(caracteristicasA);
		usuarioDAO.edit(usuario);
		
		return perfil(dniUsuario);
	}

}
