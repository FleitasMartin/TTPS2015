package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

public class ModelAndViewResolverSede {

	public static ModelAndView listarAdmin(List<Sede> sedes) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("listarSedesAdmin").addObject("sedes", sedes)
				.getModelAndView();
	}

	public static ModelAndView listarUsuario(List<Sede> sedes) {
		return new ModelAndViewWrapperBaseUsuario()
				.addContentPage("listarSedes").addObject("sedes", sedes)
				.getModelAndView();
	}

	public static ModelAndView listarResponsable(List<Usuario> usuarios) {
		return new ModelAndViewWrapperBaseResponsable()
				.addContentPage("listarUsuariosHabilitados")
				.addObject("usuarios", usuarios).getModelAndView();
	}

	public static ModelAndView crear() {
		return new ModelAndViewWrapperBaseAdmin().addContentPage("altaSede")
				.getModelAndView();
	}

	public static ModelAndView editar(Sede sede) {
		return new ModelAndViewWrapperBaseAdmin().addContentPage("editarSede")
				.addObject("sede", sede).getModelAndView();
	}

}
