package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compra {
	@Id @GeneratedValue
	@Column(name="id")
	private Double monto;
	@OneToMany
	private Collection<SeleccionDiaMenu> selecciones;
	private Date fechaEfectuada;
	
	@ManyToOne(optional = false)
	private Usuario usuario;
		
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Collection<SeleccionDiaMenu> getSelecciones() {
		return selecciones;
	}
	public void setSelecciones(Collection<SeleccionDiaMenu> selecciones) {
		this.selecciones = selecciones;
	}
	public Date getFechaEfectuada() {
		return fechaEfectuada;
	}
	public void setFechaEfectuada(Date fechaEfectuada) {
		this.fechaEfectuada = fechaEfectuada;
	}
}
