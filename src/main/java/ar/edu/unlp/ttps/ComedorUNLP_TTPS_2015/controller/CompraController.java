package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.CompraService;

@RestController(value = "compraController")
@RequestMapping(value = "/compra")
public class CompraController {

	@Autowired
	CompraService compraService;

	@RequestMapping(value = "/compraDeTickets", method = RequestMethod.GET)
	public ModelAndView compraDeTickets() throws ParseException {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return compraService.compraDeTickets(dniUsuario);
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crear(
			@RequestParam(value = "Lunes", required=false) Long lunesMenuId,
			@RequestParam(value = "Martes", required=false) Long martesMenuId,
			@RequestParam(value = "Miercoles", required=false) Long miercolesMenuId,
			@RequestParam(value = "Jueves", required=false) Long juevesMenuId,
			@RequestParam(value = "Viernes", required=false) Long viernesMenuId,
			@RequestParam(value = "fechaLunes", required=false) String fechaLunes,
			@RequestParam(value = "fechaMartes", required=false) String fechaMartes,
			@RequestParam(value = "fechaMiercoles", required=false) String fechaMiercoles,
			@RequestParam(value = "fechaJueves", required=false) String fechaJueves,
			@RequestParam(value = "fechaViernes", required=false) String fechaViernes,
			@RequestParam(value = "seleccionViandaLunes", required=false) Boolean seleccionViandaLunes,
			@RequestParam(value = "seleccionViandaMartes", required=false) Boolean seleccionViandaMartes,
			@RequestParam(value = "seleccionViandaMiercoles", required=false) Boolean seleccionViandaMiercoles,
			@RequestParam(value = "seleccionViandaJueves", required=false) Boolean seleccionViandaJueves,
			@RequestParam(value = "seleccionViandaViernes", required=false) Boolean seleccionViandaViernes,
			@RequestParam(value = "precio", required=false) Double precio,
			@RequestParam(value = "sede", required=false) Long sede,
			@RequestParam(value = "cantidadSemanas", required=false) Integer cantidadSemanas,
			@RequestParam(value = "fechaDesde") Date fechaDesde)
			throws ParseException {

		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		
		return compraService.crear(lunesMenuId, martesMenuId, miercolesMenuId,
				juevesMenuId, viernesMenuId, fechaLunes, fechaMartes,
				fechaMiercoles, fechaJueves, fechaViernes,
				seleccionViandaLunes, seleccionViandaMartes,
				seleccionViandaMiercoles, seleccionViandaJueves,
				seleccionViandaViernes, precio, sede, cantidadSemanas, dniUsuario, fechaDesde);
		
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar(){
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return compraService.listar(dniUsuario);
	}

	@RequestMapping(value = "/pagar", method = RequestMethod.POST)
	public ModelAndView pagar(@RequestParam(value = "id") Long id){
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return compraService.pagar(id, dniUsuario);
	}
	
	@RequestMapping(value = "/borrar", method = RequestMethod.POST)
	public ModelAndView borrar(@RequestParam("id") Long id) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		return compraService.borrar(id, dniUsuario);

	}

}
