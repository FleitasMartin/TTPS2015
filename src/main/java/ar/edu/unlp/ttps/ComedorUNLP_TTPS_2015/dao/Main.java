package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao;

import java.util.ArrayList;
import java.util.Date;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.ComponenteDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.EMF;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl.MenuDAOImpl;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Componente;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Menu;

public class Main {

	public static void main(String[] args) {
		EMF.getEMF();
		System.out.print("Se obtuvo conexion");
		ComponenteDAOImpl componenteDAO = new ComponenteDAOImpl();
		ArrayList<Componente> listaComponentes = (ArrayList<Componente>) componenteDAO.getAll();
		System.out.println("Tamaño de la coleccion de componentes: "+listaComponentes.size());
		
	/*	Componente entrada = new Componente();
		entrada.setNombre("Fiambres");
		entrada.setTipo("Entrada");
		Componente plato = new Componente();
		plato.setNombre("Milanesa con pure");
		plato.setTipo("Plato");
		Componente postre = new Componente();
		postre.setNombre("Helado");
		postre.setTipo("Postre");
		Componente bebida = new Componente();
		bebida.setNombre("agua");
		bebida.setTipo("Bebida");
		ComponenteDAOImpl componenteDAO = new ComponenteDAOImpl();
		componenteDAO.save(bebida);
		componenteDAO.save(entrada);
		componenteDAO.save(plato);
		componenteDAO.save(postre);
		Menu menu = new Menu();
		menu.setNombre("menu1");
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		componentes.add(entrada);
		componentes.add(plato);
		componentes.add(postre);
		componentes.add(bebida);
		menu.setComponentes(componentes);
		menu.setCeliaco(false);
		menu.setDiabetico(false);
		menu.setHipertenso(false);
		menu.setIntoLactosa(false);
		menu.setVegetariano(false);
		menu.setVisible(true);
		Date dia = new Date();
		menu.setFechaAlta(dia);
		MenuDAOImpl menuDAO = new MenuDAOImpl();
		menuDAO.save(menu);
		System.out.println(menu.getIdMenu()+" "+menu.getNombre());
		menu.setNombre("menuEditado");
		menuDAO.edit(menu);
		System.out.println(menu.getIdMenu()+" "+menu.getNombre());*/
	}

}
