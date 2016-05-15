package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador extends Persona {

	public Administrador(){
		
	}
	
	public Administrador(String nombre, String apellido, String dni,
			String contrasena, Long telefono, String domicilio, String email){
		super();
		setNombre(nombre);
		setApellido(apellido);
		setDni(dni);
		setContrasena(contrasena);
		setTelefono(telefono);
		setDomicilio(domicilio);
		setEmail(email);
	}
}
