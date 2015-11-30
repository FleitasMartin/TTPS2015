package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SeleccionDiaMenu {
	@Id @GeneratedValue
	@Column(name="id")
	private String nombre;
	private boolean vianda;
	private boolean consumido;
	@OneToOne(optional = false) 
	private Menu menu;
	@OneToOne(optional = false) 
	private Sede sede;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isVianda() {
		return vianda;
	}
	public void setVianda(boolean vianda) {
		this.vianda = vianda;
	}
	public boolean isConsumido() {
		return consumido;
	}
	public void setConsumido(boolean consumido) {
		this.consumido = consumido;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	public void setActivo(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
