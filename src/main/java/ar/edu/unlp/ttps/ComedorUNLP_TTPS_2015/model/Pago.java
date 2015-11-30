package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Pago {
	@Id @GeneratedValue
	@Column(name="id")
	private Date fechaPago;
    @OneToOne(optional = false)   
	private Compra compra;
    @OneToOne(optional = false) 
	private Sede sede;
	
	@ManyToOne(optional = false)
	private Usuario usuario;
	
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
	public void setActivo(boolean b) {
		// TODO Auto-generated method stub
		
	}
	

}
