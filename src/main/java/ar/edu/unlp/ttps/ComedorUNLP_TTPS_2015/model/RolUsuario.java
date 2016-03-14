package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class RolUsuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rolUsuarioId;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	/*@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona", nullable = false)
	@OneToMany(fetch = FetchType.LAZY)
	private Persona persona;
	*/
	@OneToMany(mappedBy = "rol")
	private List<Persona> personas;
	
	@Column(name = "rol", nullable = false, length = 45)
	private String rol;
	
	
	public Integer getRolUsuarioId() {
		return rolUsuarioId;
	}
	public void setRolUsuarioId(Integer rolUsuarioId) {
		this.rolUsuarioId = rolUsuarioId;
	}
	
	public List<Persona> getPersona() {
		return personas;
	}
	public void setPersona(List<Persona> personas) {
		this.personas = personas;
	}
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
		
}
