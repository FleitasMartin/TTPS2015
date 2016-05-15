package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private Date fechaDeSemanaComprada;
	private Integer cantidadDeSemanas;
	private Double monto;
	private Date fechaEfectuada;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SeleccionDiaMenu> selecciones;
	private Boolean pagado;

	@ManyToOne(optional = false)
	private Usuario usuario;

	public Compra() {
		super();
	}

	public Compra(Usuario usuarioComprador, Date fechaDeSemanaComprada, Integer cantidadDeSemanas, Double montoTotal, List<SeleccionDiaMenu> selecciones) {
		super();
		setUsuario(usuarioComprador);
		setFechaDeSemanaComprada(fechaDeSemanaComprada);
		setCantidadDeSemanas(cantidadDeSemanas);
		setMonto(montoTotal);
		setSelecciones(selecciones);
		setFechaEfectuada(new Date());
		setPagado(false);		
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public List<SeleccionDiaMenu> getSelecciones() {
		return selecciones;
	}

	public void setSelecciones(List<SeleccionDiaMenu> selecciones) {
		this.selecciones = selecciones;
	}

	public Date getFechaEfectuada() {
		return fechaEfectuada;
	}

	public void setFechaEfectuada(Date fechaEfectuada) {
		this.fechaEfectuada = fechaEfectuada;
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

	public Date getFechaDeSemanaComprada() {
		return fechaDeSemanaComprada;
	}

	public void setFechaDeSemanaComprada(Date fechaDeSemanaComprada) {
		this.fechaDeSemanaComprada = fechaDeSemanaComprada;
	}

	public Integer getCantidadDeSemanas() {
		return cantidadDeSemanas;
	}

	public void setCantidadDeSemanas(Integer cantidadDeSemanas) {
		this.cantidadDeSemanas = cantidadDeSemanas;
	}
}
