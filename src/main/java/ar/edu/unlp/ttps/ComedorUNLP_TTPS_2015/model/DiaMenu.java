package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "diaMenu")
public class DiaMenu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Long id;
	private String nombre;
	//@OneToMany(mappedBy = "diaMenu", cascade = { CascadeType.PERSIST,
	//		CascadeType.REMOVE })
	@ManyToMany
	private List<Menu> menues;
	private Boolean activo = true;
	//@ManyToOne(optional = false)
	//private Cartilla cartilla;

	public List<Menu> getMenues() {
		return menues;
	}

	public void setMenues(List<Menu> menues) {
		this.menues = menues;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
/*
	public Cartilla getCartilla() {
		return cartilla;
	}

	public void setCartilla(Cartilla cartilla) {
		this.cartilla = cartilla;
	}
	*/
}
