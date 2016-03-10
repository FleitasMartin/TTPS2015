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

@Service
public class MenuService {

	@Autowired
	private ComponenteDAO componenteDAO;
	@Autowired
	private CaracteristicaDAO caracteristicaDAO;
	@Autowired
	private MenuDAO menuDAO;
	
	public ModelAndView crear(){
		ModelAndView model = new ModelAndView();
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		ArrayList<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
		componentes = (ArrayList<Componente>) componenteDAO.getAll();
		caracteristicas = (ArrayList<Caracteristica>) caracteristicaDAO.getAll();
		model.setViewName("indexAdmin");
		model.addObject("componentes", componentes);
		model.addObject("caracteristicas", caracteristicas);
		model.addObject("contentPage","altaMenu");
		return model;
	}
	
	public ModelAndView crear(String nombre, ArrayList<Long> caracteristicas, ArrayList<Long> bebidas, 
			ArrayList<Long> entradas, ArrayList<Long> platos, ArrayList<Long> postres){
		
		Menu menu = new Menu();
		
		menu.setNombre(nombre);

		ArrayList<Caracteristica> caracteristicasA = new ArrayList<Caracteristica>();
		for (Long id : caracteristicas) {
			caracteristicasA.add(caracteristicaDAO.get(id));
		}
		menu.setCaracteristica(caracteristicasA);
		
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
		
		menu.setComponentes(componentes);
		
		menu.setVisible(true); //TODO POR DEFECTO O A ELEGIR EN EL FORM? O LO DESCARTAMOS??
		
		menuDAO.save(menu);
		
		return listar();
	}
	
	public ModelAndView editar(Long id){
		ModelAndView model = new ModelAndView();
		Menu menu = new Menu();
		menu = menuDAO.get(id);
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		ArrayList<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
		ArrayList<Componente> losComponentes = new ArrayList<Componente>();
		componentes = (ArrayList<Componente>) componenteDAO.getAll();
		ArrayList<Caracteristica> lasCaracteristicas = new ArrayList<Caracteristica>();
		caracteristicas = (ArrayList<Caracteristica>) caracteristicaDAO.getAll();
		for (int i = 0; i < componentes.size(); i++) {
			boolean existe = false;
			for (Componente componenteMenu : menu.getComponentes()) {
				if( componenteMenu.getId() == componentes.get(i).getId() ){
					existe = true;
				}
			}
			if (!existe){
				losComponentes.add(componentes.get(i));
			}
		}
		for (int i = 0; i < caracteristicas.size(); i++) {
			boolean existe = false;
			for (Caracteristica caracteristicasMenu : menu.getCaracteristica()) {
				if( caracteristicasMenu.getId() == caracteristicas.get(i).getId() ){
					existe = true;
				}
			}
			if (!existe){
				lasCaracteristicas.add(caracteristicas.get(i));
			}
		}
		
		model.setViewName("indexAdmin");
		model.addObject("menu", menu);
		model.addObject("componentes", losComponentes);
		model.addObject("caracteristicas", lasCaracteristicas);
		model.addObject("contentPage","editarMenu");
		return model;
	}
	
	public ModelAndView editar(Long id, String nombre, ArrayList<Long> caracteristicas, ArrayList<Long> bebidas, 
			ArrayList<Long> entradas, ArrayList<Long> platos, ArrayList<Long> postres){
		
		Menu menu = menuDAO.get(id);
		
		menu.setNombre(nombre);
		ArrayList<Caracteristica> caracteristicasA = new ArrayList<Caracteristica>();
		for (Long idC : caracteristicas) {
			caracteristicasA.add(caracteristicaDAO.get(idC));
		}
		menu.setCaracteristica(caracteristicasA);
		
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
		
		menu.setComponentes(componentes);
		
		menu.setVisible(true); //TODO ; POR DEFECTO O A ELEGIR EN EL FORM? O LO DESCARTAMOS??
		
		menuDAO.edit(menu);
		
		return listar();

	}
	
	public ModelAndView listar() {		
		ArrayList<Menu> menues = new ArrayList<Menu>();
		menues = (ArrayList<Menu>) menuDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage","adminMenues");
		return model;
	}
	
	public ModelAndView eliminar(Long id) {		
		menuDAO.delete(id);
		return listar();
	}
}
