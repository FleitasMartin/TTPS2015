package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	private String nombre;
	private boolean visible;
	private Date fechaAlta;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Componente> componentes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_caracteristicas", joinColumns = @JoinColumn(name = "idMenu", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "idCaracteristicas", referencedColumnName = "id"))
	private List<Caracteristica> caracteristica;

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public List<Caracteristica> getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(List<Caracteristica> caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
