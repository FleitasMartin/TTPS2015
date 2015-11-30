package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="diaMenu")
public class DiaMenu {
	@Id @GeneratedValue
	@Column(name="id")
	protected Long id;
	private String nombre;
	@OneToMany(mappedBy="diaMenu", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Menu> menues;

	
	public List<Menu> getMenues() {
		return menues;
	}
	@ManyToOne(optional = false)
	private Cartilla cartilla;
	
	public void setMenues(List<Menu> menues) {
		this.menues = menues;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected Boolean activo=true;
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
