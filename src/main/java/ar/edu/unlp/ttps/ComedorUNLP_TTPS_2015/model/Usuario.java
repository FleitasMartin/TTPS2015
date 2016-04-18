package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Persona {

	private String facultad;
	private String tipo;
	private String pathFoto;
	private Double saldo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_caracteristicas", joinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "idCaracteristicas", referencedColumnName = "id"))
	private List<Caracteristica> caracteristica;

	@OneToMany(mappedBy = "usuario")
	private List<Compra> compras;

	@OneToMany(mappedBy = "usuario")
	private List<Pago> pagos;

	@OneToMany(mappedBy = "usuario")
	private List<Sugerencia> sugerencias;

	@ManyToOne(optional = false)
	private Sede sede;

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Collection<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<Sugerencia> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(List<Sugerencia> sugerencias) {
		this.sugerencias = sugerencias;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

	public List<Caracteristica> getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(List<Caracteristica> caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
