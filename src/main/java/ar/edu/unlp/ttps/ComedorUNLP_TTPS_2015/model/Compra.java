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
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class Compra {
	@Id @GeneratedValue
	@Column(name="id")
	private Double monto;
	@OneToMany
	private List<SeleccionDiaMenu> selecciones;
	private Date fechaEfectuada;
	
	@ManyToOne(optional = false)
	private Usuario usuario;
		
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
	public void setActivo(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
