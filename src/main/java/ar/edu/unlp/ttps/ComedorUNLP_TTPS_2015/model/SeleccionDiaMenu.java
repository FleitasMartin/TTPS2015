package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seleccionDiaMenu")
public class SeleccionDiaMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String nombre;
	private boolean vianda;

	private Double precio;
	
	@ManyToOne(optional = false) 

	private Menu menu;
	@ManyToOne(optional = false)
	private Sede sede;

	private Date fecha;
	
	public SeleccionDiaMenu(){
		super();
	}
	public SeleccionDiaMenu(Date fecha, Menu menu, Sede sede, Boolean seleccionVianda, Double precio){
		super();
		setFecha(fecha);
		setMenu(menu);
		setNombre(menu.getNombre());
		setSede(sede);
		setVianda(seleccionVianda);
		setPrecio(precio);
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
