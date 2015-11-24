package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="componente")
public class Componente {

	@Id @GeneratedValue
	@Column(name="idComponente")
	protected Long idComponente;
	
	protected String nombre;

	protected String tipo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(Long idComponente) {
		this.idComponente = idComponente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
