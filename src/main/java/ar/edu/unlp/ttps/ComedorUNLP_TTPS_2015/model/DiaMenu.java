package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.List;

public class DiaMenu {

	private String nombre;
	private List<Menu> menues;

	public List<Menu> getMenues() {
		return menues;
	}

	public void setMenues(List<Menu> menues) {
		this.menues = menues;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
