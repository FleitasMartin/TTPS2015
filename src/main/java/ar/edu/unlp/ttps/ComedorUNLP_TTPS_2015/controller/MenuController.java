package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.CaracteristicaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.ComponenteDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.MenuDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Caracteristica;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;

@Controller
public class MenuController {

	@Autowired
	private ComponenteDAO componenteDAO;
	@Autowired
	private CaracteristicaDAO caracteristicaDAO;
	@Autowired
	private MenuDAO menuDAO;
	
	@RequestMapping( value = "/admin/altaMenu" ,method = RequestMethod.GET)
	public ModelAndView altaMenu(){
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
	
	@RequestMapping( value = "/admin/altaMenu" ,method = RequestMethod.POST)
	public ModelAndView altaMenu(@RequestParam("nombre") String nombre,
			@RequestParam("caracteristicas") ArrayList<Long> caracteristicas,
			@RequestParam("bebidas") ArrayList<Long> bebidas, @RequestParam("entradas") ArrayList<Long> entradas,
			@RequestParam("platos") ArrayList<Long> platos, @RequestParam("postres") ArrayList<Long> postres){
		
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
		
		ModelAndView model = new ModelAndView();
		model = listar();
		return model;
	}
	
	@RequestMapping( value = "/admin/editarMenu" ,method = RequestMethod.GET)
	public ModelAndView editarMenu(@RequestParam("id") Long id){
		ModelAndView model = new ModelAndView();
		Menu menu = new Menu();
		menu = menuDAO.get(id);
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		ArrayList<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
		ArrayList<Componente> losComponentes = new ArrayList<Componente>();
		componentes = (ArrayList<Componente>) componenteDAO.getAll();
		ArrayList<Caracteristica> lasCaracteristicas = new ArrayList<Caracteristica>();
		caracteristicas = (ArrayList<Caracteristica>) caracteristicaDAO.getAll();
		//losComponentes = (ArrayList<Componente>) componenteDAO.getAll();
		//componentes.removeAll(menu.getComponentes());
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
	
	@RequestMapping( value = "/admin/editarMenu" ,method = RequestMethod.POST)
	public ModelAndView editarMenu(@RequestParam("id") Long id, @RequestParam("nombre") String nombre,
			@RequestParam("caracteristicas") ArrayList<Long> caracteristicas,
			@RequestParam("bebidas") ArrayList<Long> bebidas, @RequestParam("entradas") ArrayList<Long> entradas,
			@RequestParam("platos") ArrayList<Long> platos, @RequestParam("postres") ArrayList<Long> postres){
		
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
		
		ModelAndView model = new ModelAndView();
		model = listar();
		return model;
		
//		if( caracteristicas.contains(1)){
//			menu.setCeliaco(true);	
//		}else{
//			menu.setCeliaco(false);
//		}
//		if( caracteristicas.contains(2)){
//			menu.setDiabetico(true);	
//		}else{
//			menu.setDiabetico(false);
//		}
//		if( caracteristicas.contains(3)){
//			menu.setHipertenso(true);	
//		}else{
//			menu.setHipertenso(false);
//		}
//		if( caracteristicas.contains(4)){
//			menu.setIntoLactosa(true);	
//		}else{
//			menu.setIntoLactosa(false);
//		}
//		if( caracteristicas.contains(5)){
//			menu.setVegetariano(true);	
//		}else{
//			menu.setVegetariano(false);
//		}

	}
	
	@RequestMapping(value = "/admin/adminMenues", method = RequestMethod.GET)
	public ModelAndView listar() {		
		ArrayList<Menu> menues = new ArrayList<Menu>();
		menues = (ArrayList<Menu>) menuDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("menues", menues);
		model.addObject("contentPage","adminMenues");
		return model;
	}
	
	@RequestMapping(value = "/admin/eliminarMenu", method = RequestMethod.POST)
	public ModelAndView eliminarMenu(@RequestParam("id") Long id) {		
		menuDAO.delete(id);
		ModelAndView model = new ModelAndView();
		model = listar();
		return model;
	}
	
}
