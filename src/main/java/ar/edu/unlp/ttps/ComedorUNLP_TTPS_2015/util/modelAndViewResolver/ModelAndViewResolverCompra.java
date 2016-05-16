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
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("compras", compras);
		model.addObject("contentPage", "listarCompras");
		return model;
	}

	public static ModelAndView listarCompras(List<Compra> compras, String tipo,
			String mensaje) {
		return listarCompras(compras).addObject(tipo, mensaje);
	}

	public static ModelAndView crearCompra(Usuario usuario, Sede sede,
			Cartilla cartilla, Semana semana, Integer cantidad) {
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("contentPage", "compraDeTickets");
		model.addObject("usuario", usuario);
		model.addObject("sede", sede);
		model.addObject("cartilla", cartilla);
		model.addObject("semana", semana);
		model.addObject("cantidad", cantidad);
		return model;
	}

	public static ModelAndView editarCompra() {
		return null;
	}

	public static ModelAndView pagarCompra(List<Compra> compras) {
		ModelAndView model = new ModelAndView();
		model.setViewName("indexUsuario");
		model.addObject("compras", compras);
		model.addObject("contentPage", "listarCompras");
		return model;
	}
	
	public static ModelAndView pagarCompraExitoError(List<Compra> compras, String tipo, String mensaje) {
		return pagarCompra(compras).addObject(tipo, mensaje);
	}

}
