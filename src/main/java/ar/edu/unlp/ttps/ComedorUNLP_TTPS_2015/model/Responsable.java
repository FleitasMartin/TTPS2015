package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  
@Table(name="responsable")
public class Responsable extends Persona {
	
	@OneToOne(optional = false) 
	private Sede sede;

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	protected Boolean activo=true;
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
}
