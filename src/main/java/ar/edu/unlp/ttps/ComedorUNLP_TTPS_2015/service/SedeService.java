package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.SedeDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Sede;

@Service
public class SedeService {
	

	@Autowired
	private SedeDAO sedeDAO;
	
	public ModelAndView listar() {
		
		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes = (ArrayList<Sede>) sedeDAO.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("sedes", sedes);
		model.addObject("contentPage","adminSedes");
		return model;
	}

	public ModelAndView crear(String nombre, int capacidad, String ubicacion) {

		Sede sedeNueva = new Sede();
		sedeNueva.setNombre(nombre);
		sedeNueva.setCapacidad(capacidad);
		sedeNueva.setUbicacion(ubicacion);
		sedeDAO.save(sedeNueva);
		return listar();
	}
	
	public ModelAndView crear(){
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("contentPage","altaSede");
		return model;
	}
	
	public ModelAndView editar(Long id, String nombre, int capacidad, String ubicacion) {
		Sede sede = sedeDAO.get(id);
		sede.setNombre(nombre);
		sede.setCapacidad(capacidad);
		sede.setUbicacion(ubicacion);
		sedeDAO.edit(sede);
		return listar();
	}
	
	public ModelAndView editar(Long id){
		Sede sede = sedeDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("indexAdmin");
		model.addObject("sede", sede);
		model.addObject("contentPage","editarSede");
		return model;
	}
	
	public ModelAndView eliminar(Long id){
		sedeDAO.delete(id);
		return listar();
	}
}
