package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sugerencia;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

public class ModelAndViewResolverSugerencia {

	public static ModelAndView comentar(Usuario usuario, List<Sede> sedes) {
		return new ModelAndViewWrapperBaseUsuario().addContentPage("comentar")
				.addObject("sedes", sedes).addObject("usuario", usuario)
				.getModelAndView();
	}

	public static ModelAndView buzonVirtual(List<Sugerencia> sugerencias) {
		return new ModelAndViewWrapperBaseAdmin()
				.addContentPage("buzonVirtual")
				.addObject("sugerencias", sugerencias).getModelAndView();
	}

	public static ModelAndView buzonVirtualDeSede(List<Sugerencia> sugerencias) {
		return new ModelAndViewWrapperBaseResponsable()
				.addContentPage("buzonVirtualDeSede")
				.addObject("sugerencias", sugerencias).getModelAndView();
	}

}
