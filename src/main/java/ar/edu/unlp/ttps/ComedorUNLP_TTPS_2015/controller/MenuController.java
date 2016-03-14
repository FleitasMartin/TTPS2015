package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.MenuService;

@RestController(value = "menuController")
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public ModelAndView crear() {
		return menuService.crear();

	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crear(@RequestParam("nombre") String nombre,
			@RequestParam("caracteristicas") ArrayList<Long> caracteristicas,
			@RequestParam("bebidas") ArrayList<Long> bebidas,
			@RequestParam("entradas") ArrayList<Long> entradas,
			@RequestParam("platos") ArrayList<Long> platos,
			@RequestParam("postres") ArrayList<Long> postres) {

		return menuService.crear(nombre, caracteristicas, bebidas, entradas,
				platos, postres);

	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam("id") Long id) {

		return menuService.editar(id);

	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("id") Long id,
			@RequestParam("nombre") String nombre,
			@RequestParam("caracteristicas") ArrayList<Long> caracteristicas,
			@RequestParam("bebidas") ArrayList<Long> bebidas,
			@RequestParam("entradas") ArrayList<Long> entradas,
			@RequestParam("platos") ArrayList<Long> platos,
			@RequestParam("postres") ArrayList<Long> postres) {

		return menuService.editar(id, nombre, caracteristicas, bebidas,
				entradas, platos, postres);

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		return menuService.listar();
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminarMenu(@RequestParam("id") Long id) {
		return menuService.eliminar(id);
	}
}
