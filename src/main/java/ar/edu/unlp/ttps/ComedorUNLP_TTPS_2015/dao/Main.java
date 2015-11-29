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
		
		
		Componente entrada = new Componente();
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
		componenteDAO.save(bebida);
		componenteDAO.save(entrada);
		componenteDAO.save(plato);
		componenteDAO.save(postre);
		ArrayList<Componente> listaComponentes = (ArrayList<Componente>) componenteDAO.getAll();
		System.out.println("Tamaño de la coleccion de componentes: "+listaComponentes.size());
		Componente componenteRecuperadoI = (Componente) componenteDAO.get(postre.getId());
		System.out.println("Id del componente recuperado de la base de datos: "+componenteRecuperadoI.getId());
		ArrayList<Componente> componenteRecuperadoN = (ArrayList<Componente>) componenteDAO.get(postre.getNombre());
		for (int i=0; i<componenteRecuperadoN.size();i++) {
			System.out.println("Nombre del componente recuperado de la base de datos: "+componenteRecuperadoN.get(i).getNombre());
		}
		componenteDAO.delete(postre.getId());
		/*Menu menu = new Menu();
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
