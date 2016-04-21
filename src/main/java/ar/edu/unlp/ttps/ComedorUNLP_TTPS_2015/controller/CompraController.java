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
			@RequestParam(value = "Lunes") Long lunesMenuId,
			@RequestParam(value = "Martes") Long martesMenuId,
			@RequestParam(value = "Miercoles") Long miercolesMenuId,
			@RequestParam(value = "Jueves") Long juevesMenuId,
			@RequestParam(value = "Viernes") Long viernesMenuId,
			@RequestParam(value = "fechaLunes") String fechaLunes,
			@RequestParam(value = "fechaMartes") String fechaMartes,
			@RequestParam(value = "fechaMiercoles") String fechaMiercoles,
			@RequestParam(value = "fechaJueves") String fechaJueves,
			@RequestParam(value = "fechaViernes") String fechaViernes,
			@RequestParam(value = "seleccionViandaLunes") Boolean seleccionViandaLunes,
			@RequestParam(value = "seleccionViandaMartes") Boolean seleccionViandaMartes,
			@RequestParam(value = "seleccionViandaMiercoles") Boolean seleccionViandaMiercoles,
			@RequestParam(value = "seleccionViandaJueves") Boolean seleccionViandaJueves,
			@RequestParam(value = "seleccionViandaViernes") Boolean seleccionViandaViernes,
			@RequestParam(value = "precio") Double precio,
			@RequestParam(value = "sede") Long sede,
			@RequestParam(value = "cantidadSemanas") Integer cantidadSemanas)
			throws ParseException {

		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String dniUsuario = (String) user.getUsername();
		
		return compraService.crear(lunesMenuId, martesMenuId, miercolesMenuId,
				juevesMenuId, viernesMenuId, fechaLunes, fechaMartes,
				fechaMiercoles, fechaJueves, fechaViernes,
				seleccionViandaLunes, seleccionViandaMartes,
				seleccionViandaMiercoles, seleccionViandaJueves,
				seleccionViandaViernes, precio, sede, cantidadSemanas, dniUsuario);
		
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

}
