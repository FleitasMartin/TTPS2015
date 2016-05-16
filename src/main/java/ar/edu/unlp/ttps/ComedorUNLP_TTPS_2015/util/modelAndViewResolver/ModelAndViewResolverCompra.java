package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Cartilla;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Compra;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Semana;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

public class ModelAndViewResolverCompra {

	public static ModelAndView listarCompras(List<Compra> compras) {
		return new ModelAndViewWrapperBaseUsuario()
				.addContentPage("listarCompras").addObject("compras", compras)
				.getModelAndView();
	}

	public static ModelAndView listarCompras(List<Compra> compras, String tipo,
			String mensaje) {
		return listarCompras(compras).addObject(tipo, mensaje);
	}

	public static ModelAndView crearCompra(Usuario usuario, Sede sede,
			Cartilla cartilla, Semana semana, Integer cantidad) {
		return new ModelAndViewWrapperBaseUsuario()
				.addContentPage("compraDeTickets")
				.addObject("usuario", usuario).addObject("sede", sede)
				.addObject("cartilla", cartilla).addObject("semana", semana)
				.addObject("cantidad", cantidad).getModelAndView();
	}

	public static ModelAndView pagarCompra(List<Compra> compras) {
		return new ModelAndViewWrapperBaseUsuario()
				.addContentPage("listarCompras").addObject("compras", compras)
				.getModelAndView();
	}

	public static ModelAndView pagarCompraExitoError(List<Compra> compras,
			String tipo, String mensaje) {
		return pagarCompra(compras).addObject(tipo, mensaje);
	}

}
