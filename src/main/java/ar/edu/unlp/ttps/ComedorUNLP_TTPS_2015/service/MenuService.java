package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CaracteristicaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ComponenteDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.MenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Caracteristica;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util.modelAndViewResolver.ModelAndViewResolverMenu;

@Service
public class MenuService {

	@Autowired
	private ComponenteDAO componenteDAO;
	@Autowired
	private CaracteristicaDAO caracteristicaDAO;
	@Autowired
	private MenuDAO menuDAO;

	public ModelAndView crear() {
		ArrayList<Componente> componentes = (ArrayList<Componente>) componenteDAO
				.getAll();
		ArrayList<Caracteristica> caracteristicas = (ArrayList<Caracteristica>) caracteristicaDAO
				.getAll();
		return ModelAndViewResolverMenu.crear(componentes, caracteristicas);
	}

	public ModelAndView crear(String nombre, ArrayList<Long> caracteristicas,
			ArrayList<Long> bebidas, ArrayList<Long> entradas,
			ArrayList<Long> platos, ArrayList<Long> postres) {

		ArrayList<Caracteristica> caracteristicasA = new ArrayList<Caracteristica>();
		for (Long id : caracteristicas) {
			caracteristicasA.add(caracteristicaDAO.get(id));
		}

		ArrayList<Componente> componentes = new ArrayList<Componente>();
		for (Long idComponente : bebidas) {
			componentes.add(componenteDAO.get(idComponente));
		}

		for (Long idComponente : entradas) {
			componentes.add(componenteDAO.get(idComponente));
		}

		for (Long idComponente : platos) {
			componentes.add(componenteDAO.get(idComponente));
		}

		for (Long idComponente : postres) {
			componentes.add(componenteDAO.get(idComponente));
		}

		Menu menu = new Menu(nombre, componentes, caracteristicasA, true);

		menuDAO.save(menu);

		return listar();
	}

	public ModelAndView editar(Long id) {
		Menu menu = menuDAO.get(id);
		ArrayList<Componente> componentes = (ArrayList<Componente>) componenteDAO
				.getAll();
		ArrayList<Caracteristica> caracteristicas = (ArrayList<Caracteristica>) caracteristicaDAO
				.getAll();
		ArrayList<Componente> losComponentes = new ArrayList<Componente>();
		ArrayList<Caracteristica> lasCaracteristicas = new ArrayList<Caracteristica>();

		for (int i = 0; i < componentes.size(); i++) {
			boolean existe = false;
			for (Componente componenteMenu : menu.getComponentes()) {
				if (componenteMenu.getId() == componentes.get(i).getId()) {
					existe = true;
				}
			}
			if (!existe) {
				losComponentes.add(componentes.get(i));
			}
		}
		for (int i = 0; i < caracteristicas.size(); i++) {
			boolean existe = false;
			for (Caracteristica caracteristicasMenu : menu.getCaracteristica()) {
				if (caracteristicasMenu.getId() == caracteristicas.get(i)
						.getId()) {
					existe = true;
				}
			}
			if (!existe) {
				lasCaracteristicas.add(caracteristicas.get(i));
			}
		}
		return ModelAndViewResolverMenu.editar(menu, losComponentes,
				lasCaracteristicas);
	}

	public ModelAndView editar(Long id, String nombre,
			ArrayList<Long> caracteristicas, ArrayList<Long> bebidas,
			ArrayList<Long> entradas, ArrayList<Long> platos,
			ArrayList<Long> postres) {

		Menu menu = menuDAO.get(id);

		ArrayList<Caracteristica> caracteristicasA = new ArrayList<Caracteristica>();
		for (Long idC : caracteristicas) {
			caracteristicasA.add(caracteristicaDAO.get(idC));
		}

		ArrayList<Componente> componentes = new ArrayList<Componente>();
		for (Long idComponente : bebidas) {
			componentes.add(componenteDAO.get(idComponente));
		}

		for (Long idComponente : entradas) {
			componentes.add(componenteDAO.get(idComponente));
		}

		for (Long idComponente : platos) {
			componentes.add(componenteDAO.get(idComponente));
		}

		for (Long idComponente : postres) {
			componentes.add(componenteDAO.get(idComponente));
		}

		menu.editar(nombre, caracteristicasA, componentes, true);
		menuDAO.edit(menu);
		return listar();

	}

	public ModelAndView listar() {
		ArrayList<Menu> menues = (ArrayList<Menu>) menuDAO.getAll();
		return ModelAndViewResolverMenu.listar(menues);
	}

	public ModelAndView eliminar(Long id) {
		menuDAO.delete(id);
		return listar();
	}
}
