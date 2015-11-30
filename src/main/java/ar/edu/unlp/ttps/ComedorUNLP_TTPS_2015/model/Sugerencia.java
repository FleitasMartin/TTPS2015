package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Sugerencia implements Serializable{
	@Id @GeneratedValue
	
	
	@ManyToOne
	@JoinColumn(name="id")
	private Usuario usuario;
	
	private String tipo;
	private String mensaje;
	@OneToOne(optional = false) 
	private Sede sede = null; // así pongo que es opcional?
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
}
