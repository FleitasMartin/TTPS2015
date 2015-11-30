package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {
	@Id @GeneratedValue
	@Column(name="id")
	protected Long id;
	protected Integer dni;

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.dni = dni;
	}
}
