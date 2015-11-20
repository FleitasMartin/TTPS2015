package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;
import java.util.List;

public class Compra {

	private Double monto;
	private List<SeleccionDiaMenu> selecciones;
	private Date fechaEfectuada;
		
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public List<SeleccionDiaMenu> getSelecciones() {
		return selecciones;
	}
	public void setSelecciones(List<SeleccionDiaMenu> selecciones) {
		this.selecciones = selecciones;
	}
	public Date getFechaEfectuada() {
		return fechaEfectuada;
	}
	public void setFechaEfectuada(Date fechaEfectuada) {
		this.fechaEfectuada = fechaEfectuada;
	}
}
