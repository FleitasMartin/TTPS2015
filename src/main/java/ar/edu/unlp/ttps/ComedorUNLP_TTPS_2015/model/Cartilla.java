package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;
import java.util.List;

public class Cartilla {

	private Double precio;
	private Date fechaInicio;
	private Date fechaFin;
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
}
