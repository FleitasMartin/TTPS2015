package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;

public class Pago {
	
	private Date fechaPago;
	private Compra compra;
	private Sede sede;
	
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	

}
