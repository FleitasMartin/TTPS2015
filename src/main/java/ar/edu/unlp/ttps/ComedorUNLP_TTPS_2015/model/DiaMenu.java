package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class DiaMenu {
	@Id @GeneratedValue
	private String nombre;
	private List<Menu> menues;

	@OneToMany(mappedBy="diaMenu", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
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

	public void setActivo(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
