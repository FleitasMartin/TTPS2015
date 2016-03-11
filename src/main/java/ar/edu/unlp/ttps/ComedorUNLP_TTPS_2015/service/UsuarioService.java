package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public ModelAndView perfil(Long id){
		Usuario usuario = usuarioDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("usuario", usuario);
		model.addObject("contentPage","perfil");
		return model;
	}
}
