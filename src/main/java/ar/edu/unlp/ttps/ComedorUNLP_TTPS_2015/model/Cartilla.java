package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="cartilla")
public class Cartilla {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private Double precio;
	private Date fechaInicio;
	private Date fechaFin;
	
	@ManyToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	private List<Semana> semanas;
	
	public Cartilla(){
		super();
	}
	public Cartilla(Double precio, Date fechaInicio, Date fechaFin, List<Semana> semanas){
		super();
		setPrecio(precio);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setSemanas(semanas);
	}
	
	public void editar(Double precio, Date fechaInicio, Date fechaFin, List<Semana> semanas){
		setPrecio(precio);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setSemanas(semanas);
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Semana> getSemanas() {
		return semanas;
	}
	public void setSemanas(List<Semana> semanas) {
		this.semanas = semanas;
	}
}
