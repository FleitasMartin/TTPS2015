package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "semana")
public class Semana {
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)//@GeneratedValue(strategy=GenerationType.AUTO)//
	@Column(name = "id")
	private Long id;	
	
	private Date fechaDesde;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<DiaMenu> dias;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public List<DiaMenu> getDias() {
		return dias;
	}
	public void setDias(List<DiaMenu> dias) {
		this.dias = dias;
	}
}
