package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sede")
public class Sede {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String nombre;
	private String ubicacion;
	private String latitud;
	private String longitud;
	private Integer capacidad;

	@OneToMany(mappedBy = "sede")
	private List<Responsable> responsables;

	@OneToMany(mappedBy = "sede")
	private List<Usuario> usuarios;

	public Sede() {
		super();
	}

	public Sede(String nombre, int capacidad, String ubicacion, String latitud,
			String longitud) {
		super();
		setNombre(nombre);
		setCapacidad(capacidad);
		setUbicacion(ubicacion);
		setLatitud(latitud);
		setLongitud(longitud);
		setResponsables(new ArrayList<Responsable>());
		setUsuarios(new ArrayList<Usuario>());
	}

	public void editar(String nombre, Integer capacidad, String ubicacion,
			String latitud, String longitud) {
		setNombre(nombre);
		setCapacidad(capacidad);
		setUbicacion(ubicacion);
		setLatitud(latitud);
		setLongitud(longitud);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public List<Responsable> getResponsables() {
		return responsables;
	}

	public void setResponsables(List<Responsable> responsables) {
		this.responsables = responsables;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
