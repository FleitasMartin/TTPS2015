package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="cartilla")
public class Cartilla {
	@Id @GeneratedValue
	@Column(name="id")
	protected Long id;
	private Double precio;
	private Date fechaInicio;
	private Date fechaFin;
	
	@OneToMany(mappedBy="cartilla", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<DiaMenu> diasMenues;
	
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
	public List<DiaMenu> getDiasMenues() {
		return diasMenues;
	}
	public void setDiasMenues(List<DiaMenu> diasMenues) {
		this.diasMenues = diasMenues;
	}
	protected Boolean activo=true;
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
