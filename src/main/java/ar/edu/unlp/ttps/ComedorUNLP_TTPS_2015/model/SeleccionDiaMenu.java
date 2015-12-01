package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="seleccionDiaMenu")
public class SeleccionDiaMenu {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	private String nombre;
	private boolean vianda;
	private Boolean activo=true;
	
	@ManyToOne(optional = false) 
	private Menu menu;
	@ManyToOne(optional = false) 
	private Sede sede;
	
	//@ManyToOne(optional = false)
	//private Compra compra;
	/*
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	*/
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
	/*
	public boolean isConsumido() {
		return consumido;
	}
	public void setConsumido(boolean consumido) {
		this.consumido = consumido;
	}*/
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
	
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
