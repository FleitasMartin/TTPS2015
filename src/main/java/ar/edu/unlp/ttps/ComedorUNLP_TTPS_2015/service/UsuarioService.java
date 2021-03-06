package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CaracteristicaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.UsuarioDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Caracteristica;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver.ModelAndViewResolverUsuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private CaracteristicaDAO caracteristicasDAO;

	public ModelAndView perfil(String dni) {
		Usuario usuario = usuarioDAO.findByDNI(dni);
		return ModelAndViewResolverUsuario.perfil(usuario);
	}

	public ModelAndView editarPreferencias(String dniUsuario) {
		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		ArrayList<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
		ArrayList<Caracteristica> lasCaracteristicas = new ArrayList<Caracteristica>();
		caracteristicas = (ArrayList<Caracteristica>) caracteristicasDAO
				.getAll();
		for (int i = 0; i < caracteristicas.size(); i++) {
			boolean existe = false;
			for (Caracteristica caracteristicasUsuario : usuario
					.getCaracteristica()) {
				if (caracteristicasUsuario.getId() == caracteristicas.get(i)
						.getId()) {
					existe = true;
				}
			}
			if (!existe) {
				lasCaracteristicas.add(caracteristicas.get(i));
			}
		}
		return ModelAndViewResolverUsuario.editarPreferencias(usuario,
				lasCaracteristicas);
	}

	public ModelAndView editar(ArrayList<Long> caracteristicas,
			String dniUsuario) {
		Usuario usuario = usuarioDAO.findByDNI(dniUsuario);
		ArrayList<Caracteristica> caracteristicasA = new ArrayList<Caracteristica>();
		for (Long idC : caracteristicas) {
			caracteristicasA.add(caracteristicasDAO.get(idC));
		}
		usuario.setCaracteristica(caracteristicasA);
		usuarioDAO.edit(usuario);
		return perfil(dniUsuario);
	}

	public ModelAndView modificarSaldo(Double saldo, String dni) {
		Usuario usuario = usuarioDAO.findByDNI(dni);
		usuario.setSaldo(usuario.getSaldo() + saldo);
		usuarioDAO.edit(usuario);
		return perfil(usuario.getDni());
		//return ModelAndViewResolverUsuario.saldo(usuario.getSaldo());
	}

}
