package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CartillaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.DiaMenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.MenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SemanaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service.CartillaService;

@RestController(value = "cartillaController")
@RequestMapping(value = "/cartilla")
public class CartillaController {

	@Autowired
	private MenuDAO menuDAO;

	@Autowired
	private CartillaDAO cartillaDAO;

	@Autowired
	private SemanaDAO semanaDAO;

	@Autowired
	private DiaMenuDAO diaMenuDAO;

	@Autowired
	private CartillaService cartillaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {

		return cartillaService.listar();

	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam(value = "id") Long id) {

		return cartillaService.editar(id);
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam(value = "idCartilla") Long id,
			@RequestParam(value = "desde") String fechaDesde,
			@RequestParam(value = "hasta") String fechaHasta,
			@RequestParam(value = "lunes") Long[] lunesMenues,
			@RequestParam(value = "martes") Long[] martesMenues,
			@RequestParam(value = "miercoles") Long[] miercolesMenues,
			@RequestParam(value = "jueves") Long[] juevesMenues,
			@RequestParam(value = "viernes") Long[] viernesMenues,
			@RequestParam(value = "precio") Double precio)
			throws ParseException {

		return cartillaService.editar(id, fechaDesde, fechaHasta, lunesMenues,
				martesMenues, miercolesMenues, juevesMenues, viernesMenues,
				precio);

	}

	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public ModelAndView detalle(@RequestParam("id") Long id) {

		return cartillaService.detalle(id);

	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public ModelAndView crear() {

		return cartillaService.crear();

	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crear(@RequestParam(value = "desde") String fechaDesde,
			@RequestParam(value = "hasta") String fechaHasta,
			@RequestParam(value = "lunes") Long[] lunesMenues,
			@RequestParam(value = "martes") Long[] martesMenues,
			@RequestParam(value = "miercoles") Long[] miercolesMenues,
			@RequestParam(value = "jueves") Long[] juevesMenues,
			@RequestParam(value = "viernes") Long[] viernesMenues,
			@RequestParam(value = "precio") Double precio)
			throws ParseException {

		return cartillaService.crear(fechaDesde, fechaHasta, lunesMenues,
				martesMenues, miercolesMenues, juevesMenues, viernesMenues,
				precio);
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminar(@RequestParam("id") Long id) {

		return cartillaService.eliminar(id);

	}

}
