package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "responsable")
public class Responsable extends Persona {

	@ManyToOne(optional = false)
	private Sede sede;

	public Responsable() {
		super();
	}

	public Responsable(String dni, String contrasena, String apellido,
			String nombre, String domicilio, String email, Long telefono,
			Sede sede, RolUsuario rol) {
		super();
		setDni(dni);
		setContrasena(contrasena);
		setApellido(apellido);
		setNombre(nombre);
		setDomicilio(domicilio);
		setEmail(email);
		setTelefono(telefono);
		setSede(sede);
		setRol(rol);
	}

	public void editar(String apellido, String nombre, String email,
			Long telefono, String domicilio, Sede sede) {
		setApellido(apellido);
		setNombre(nombre);
		setEmail(email);
		setTelefono(telefono);
		setDomicilio(domicilio);
		setSede(sede);
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

}
