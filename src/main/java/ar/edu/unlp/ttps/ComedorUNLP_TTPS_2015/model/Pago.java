package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name="pago")
public class Pago {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private Date fechaPago;
    @ManyToOne(optional = false)//, cascade=CascadeType.ALL)   
	private Compra compra;
    @ManyToOne(optional = false) 
	private Sede sede;
    private Boolean activo=true;
	
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
	
	public Boolean getActivo() {
		return activo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	

}
