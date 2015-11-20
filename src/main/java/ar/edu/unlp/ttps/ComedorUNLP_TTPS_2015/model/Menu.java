package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;
import java.util.List;

public class Menu {
	private String nombre;
	private boolean vegetariano;
	private boolean celiaco;
	private boolean diabetico;
	private boolean hipertenso;
	private boolean intoLactosa;
	private boolean visible;
	private Date fechaAlta;
	private List<Componente> componentes;
	
	
	public List<Componente> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isVegetariano() {
		return vegetariano;
	}
	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
	public boolean isCeliaco() {
		return celiaco;
	}
	public void setCeliaco(boolean celiaco) {
		this.celiaco = celiaco;
	}
	public boolean isDiabetico() {
		return diabetico;
	}
	public void setDiabetico(boolean diabetico) {
		this.diabetico = diabetico;
	}
	public boolean isHipertenso() {
		return hipertenso;
	}
	public void setHipertenso(boolean hipertenso) {
		this.hipertenso = hipertenso;
	}
	public boolean isIntoLactosa() {
		return intoLactosa;
	}
	public void setIntoLactosa(boolean intoLactosa) {
		this.intoLactosa = intoLactosa;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
