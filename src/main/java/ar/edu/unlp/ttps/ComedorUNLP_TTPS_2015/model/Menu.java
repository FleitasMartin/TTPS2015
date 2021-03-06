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

import org.joda.time.DateTime;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	private String nombre;
	private Boolean visible;
	private Date fechaAlta;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Componente> componentes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_caracteristicas", joinColumns = @JoinColumn(name = "idMenu", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "idCaracteristicas", referencedColumnName = "id"))
	private List<Caracteristica> caracteristicas;

	public Menu() {
		super();
	}

	public Menu(String nombre, List<Componente> componentes,
			List<Caracteristica> caracteristicas, Boolean visible) {
		super();
		setNombre(nombre);
		setComponentes(componentes);
		setCaracteristica(caracteristicas);
		setVisible(visible);
		setFechaAlta(new DateTime().toDate());
	}

	public void editar(String nombre, List<Caracteristica> caracteristicas,
			List<Componente> componentes, Boolean visible) {
		setNombre(nombre);
		setCaracteristica(caracteristicas);
		setComponentes(componentes);
		setVisible(true);
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public List<Caracteristica> getCaracteristica() {
		return caracteristicas;
	}

	public void setCaracteristica(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
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

	public void setVisible(Boolean visible) {
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
