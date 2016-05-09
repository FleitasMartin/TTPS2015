package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sugerencia")
public class Sugerencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;

	@ManyToOne(optional = false)
	private Usuario usuario;

	private String tipo;
	private String mensaje;

	@OneToOne(optional = true)
	private Sede sede;

	public Sugerencia() {
		super();
	}

	public Sugerencia(Usuario usuario, String tipo, String mensaje, Sede sede) {
		super();
		setUsuario(usuario);
		setTipo(tipo);
		setMensaje(mensaje);
		setSede(sede);
	}

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

}
