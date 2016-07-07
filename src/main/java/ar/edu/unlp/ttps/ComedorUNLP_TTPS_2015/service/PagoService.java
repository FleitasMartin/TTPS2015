package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.MutableDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CompraDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.PagoDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ResponsableDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Pago;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.SeleccionDiaMenu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver.ModelAndViewResolverPago;

@Service
public class PagoService {

	@Autowired
	ResponsableDAO responsableDAO;
	@Autowired
	PagoDAO pagoDAO;
	@Autowired
	CompraDAO compraDAO;

	public ModelAndView listadoSemanal(String fechaConsultada, String dni)
			throws ParseException {

		Sede sede = responsableDAO.findByDNI(dni).getSede();

		Map<String, Date> inicioFinSemanaCompra = calcularInicioFinSemanaCompra(fechaConsultada);

		Date inicio = inicioFinSemanaCompra.get("inicio");
		Date fin = inicioFinSemanaCompra.get("fin");

		List<Pago> pagos = pagoDAO.getAllByFechaYSede(sede, inicio, fin);
		
		/** Agrupar las selecciones en una misma coleccion */
		List<SeleccionDiaMenu> selecciones = agruparSelecciones(pagos);

		/** Generar la matriz de selecciones para presentarlo en la vista */
		Map<String, Map<String, Integer>> diasMenuesCantidades = calcularCantidades(selecciones);

		return ModelAndViewResolverPago.listadoSemanal(diasMenuesCantidades, inicio);
	}
	
	private Map<String, Date> calcularInicioFinSemanaCompra(String fechaConsultada)
			throws ParseException {
		
		/** Convertimos el parámetro String en un DateTime para usar la lib Joda-Time */
		DateTime dateTime = definirInicioComoDateTime(fechaConsultada);

		Map<String, Date> inicioFin = new HashMap<String, Date>();
		inicioFin.put("inicio",	dateTime.withDayOfWeek(DateTimeConstants.MONDAY).toDate());
		inicioFin.put("fin", dateTime.withDayOfWeek(DateTimeConstants.FRIDAY).toDate());
		return inicioFin;
	}

	private DateTime definirInicioComoDateTime(String fechaConsultada) throws ParseException {
		Date date;
		DateTime dateTime;
		if (fechaConsultada == null) {
			dateTime = new DateTime();
			MutableDateTime mutable = dateTime.toMutableDateTime();
			mutable.setTime(0, 0, 0, 0);
			dateTime = mutable.toDateTime();
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"MM/dd/yyyy");
			date = simpleDateFormat.parse(fechaConsultada);
			dateTime = new DateTime(date);
		}
		return dateTime;
	}
	
	private ArrayList<SeleccionDiaMenu> agruparSelecciones(List<Pago> pagos) {
		ArrayList<SeleccionDiaMenu> selecciones = new ArrayList<SeleccionDiaMenu>();
		for (Pago pago : pagos) {
			selecciones.addAll(pago.getCompra().getSelecciones());
		}
		return selecciones;
	}
	
	private Map<String, Map<String, Integer>> calcularCantidades(
			List<SeleccionDiaMenu> selecciones) {
		Map<String, Map<String, Integer>> diasMenuesCantidades = iniciarMapSemana();
		if (selecciones != null && selecciones.size() > 0) {
			for (SeleccionDiaMenu seleccion : selecciones) {
				switch (new DateTime(seleccion.getFecha()).getDayOfWeek()) { 
				case 1:
					incrementarMenuCantidad(seleccion.getMenu().getNombre(),
							diasMenuesCantidades.get("Lunes"));
					break;
				case 2:
					incrementarMenuCantidad(seleccion.getMenu().getNombre(),
							diasMenuesCantidades.get("Martes"));
					break;
				case 3:
					incrementarMenuCantidad(seleccion.getMenu().getNombre(),
							diasMenuesCantidades.get("Miercoles"));
					break;
				case 4:
					incrementarMenuCantidad(seleccion.getMenu().getNombre(),
							diasMenuesCantidades.get("Jueves"));
					break;
				case 5:
					incrementarMenuCantidad(seleccion.getMenu().getNombre(),
							diasMenuesCantidades.get("Viernes"));
					break;
				default:
					break;
				}
			}
		}
		return diasMenuesCantidades;
	}
	
	private Map<String, Map<String, Integer>> iniciarMapSemana() {
		Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
		map.put("Lunes", new HashMap<String, Integer>());
		map.put("Martes", new HashMap<String, Integer>());
		map.put("Miercoles", new HashMap<String, Integer>());
		map.put("Jueves", new HashMap<String, Integer>());
		map.put("Viernes", new HashMap<String, Integer>());
		return map;
	}
	
	private void incrementarMenuCantidad(String nombreMenu,
			Map<String, Integer> menuesCantidades) {
		menuesCantidades.put(nombreMenu,
				(menuesCantidades.get(nombreMenu) == null) ? 1
						: menuesCantidades.get(nombreMenu) + 1);
	}
	
}
