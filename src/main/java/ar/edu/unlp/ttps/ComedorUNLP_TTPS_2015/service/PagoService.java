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
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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

	public ModelAndView listadoSemanal(String fechaInicio, String dni)
			throws ParseException {

		Sede sede = responsableDAO.findByDNI(dni).getSede();

		Map<String, Date> inicioFinSemanaCompra = calcularInicioFinSemanaCompra(fechaInicio);

		Date inicio = inicioFinSemanaCompra.get("inicio");
		Date fin = inicioFinSemanaCompra.get("fin");

		List<Long> idsCompras = compraDAO.getIdsPagadosByFecha(inicio, fin);
		List<Pago> pagos = (idsCompras.size() > 0) ? pagoDAO.getAllBySedeId(
				sede, idsCompras) : new ArrayList<Pago>();

		/** Se agrupan todas las selecciones en una misma coleccion */
		List<SeleccionDiaMenu> selecciones = agruparSelecciones(pagos);

		Map<String, Date> lunesViernes = calcularInicioFinReal(fechaInicio);
		Date lunes = lunesViernes.get("inicio");
		Date viernes = lunesViernes.get("fin");

		/**
		 * Filtra selecciones que no estan en el rango real de la semana
		 * [lunes-viernes ingresado por el responsable]
		 */
		ArrayList<SeleccionDiaMenu> seleccionesFiltradas = filtrarSelecciones(
				lunes, viernes, selecciones);

		/**
		 * Generar la matriz de selecciones para presentarlo en la vista
		 */
		Map<String, Map<String, Integer>> diasMenuesCantidades = calcularCantidades(seleccionesFiltradas);

		return ModelAndViewResolverPago.listadoSemanal(diasMenuesCantidades);
	}

	private Map<String, Date> calcularInicioFinSemanaCompra(String fechaInicio)
			throws ParseException {
		Map<String, Date> inicioFin = new HashMap<String, Date>();
		/**
		 * La vuelta que se hace con la fecha es la siguiente: 1. Se toma la
		 * fechaInicio y se le resta una semana, de esa semana se obtiene el
		 * viernes, que es el límite superior de fecha de pago de menues para la
		 * semana que se consulta; 2. Se le restan dos semanas y se obtiene el
		 * sabado de la que queda, que es el límite inferior de fecha de pago de
		 * menues para la semana que se consulta; 3. Se arma un HashMap con las
		 * keys "inicio" y "fin" para referenciar a las fechas de 2. y 1.
		 */
		DateTime dateTime = definirInicio(fechaInicio);
		dateTime = dateTime.minusWeeks(1);
		inicioFin.put("fin", dateTime.withDayOfWeek(DateTimeConstants.FRIDAY)
				.toDate());
		dateTime = dateTime.minusWeeks(2);
		inicioFin.put("inicio",
				dateTime.withDayOfWeek(DateTimeConstants.SATURDAY).toDate());
		return inicioFin;
	}

	private Map<String, Date> calcularInicioFinReal(String fechaInicio)
			throws ParseException {
		Map<String, Date> inicioFin = new HashMap<String, Date>();
		DateTime dateTime = definirInicio(fechaInicio);
		inicioFin.put("inicio", dateTime
				.withDayOfWeek(DateTimeConstants.MONDAY).toDate());
		inicioFin.put("fin", dateTime.withDayOfWeek(DateTimeConstants.FRIDAY)
				.toDate());
		return inicioFin;
	}

	private DateTime definirInicio(String fechaInicio) throws ParseException {
		Date date;
		DateTime dateTime;
		if (fechaInicio == null) {
			dateTime = new DateTime();
			MutableDateTime mutable = dateTime.toMutableDateTime();
			mutable.setTime(0, 0, 0, 0);
			dateTime = mutable.toDateTime();
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"MM/dd/yyyy");
			date = simpleDateFormat.parse(fechaInicio);
			dateTime = new DateTime(date);
		}
		return dateTime;
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

	private ArrayList<SeleccionDiaMenu> agruparSelecciones(List<Pago> pagos) {
		ArrayList<SeleccionDiaMenu> selecciones = new ArrayList<SeleccionDiaMenu>();
		for (Pago pago : pagos) {
			selecciones.addAll(pago.getCompra().getSelecciones());
		}
		return selecciones;
	}

	private ArrayList<SeleccionDiaMenu> filtrarSelecciones(Date lunes,
			Date viernes, List<SeleccionDiaMenu> selecciones) {
		ArrayList<SeleccionDiaMenu> seleccionesFiltradas = new ArrayList<SeleccionDiaMenu>();
		for (SeleccionDiaMenu seleccion : selecciones) {
			if (seleccion.getFecha().compareTo(lunes) >= 0
					&& seleccion.getFecha().compareTo(viernes) <= 0) {
				seleccionesFiltradas.add(seleccion);
			}
		}
		return seleccionesFiltradas;
	}

	private Map<String, Map<String, Integer>> calcularCantidades(
			List<SeleccionDiaMenu> seleccionesFiltradas) {
		Map<String, Map<String, Integer>> diasMenuesCantidades = iniciarMapSemana();
		if (seleccionesFiltradas != null && seleccionesFiltradas.size() > 0) {
			for (SeleccionDiaMenu seleccion : seleccionesFiltradas) {
				String seleccionS = seleccion.getFecha().toString();
				int indicePunto = seleccionS.indexOf(".");
				DateTimeFormatter formatter = DateTimeFormat
						.forPattern("yyyy-MM-dd HH:mm:ss");
				DateTime dateTimeFormateado = formatter
						.parseDateTime(seleccionS.substring(0, indicePunto));
				switch (dateTimeFormateado.getDayOfWeek()) { // nro del día en
																// la semana
																// (1..5)
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

}
