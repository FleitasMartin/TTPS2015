package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Table;


@Entity 
@Table(name="usuario")
public class Usuario extends Persona {

	private String facultad;
	private String tipo;
	private String email;
	private String pathFoto; //estará bien guardar el path de la imagen?
	private boolean vegetariano;
	private boolean celiaco;
	private boolean diabetico;
	private boolean hipertenso;
	private boolean intoLactosa;
	
	@OneToMany(mappedBy="usuario")//, cascade=CascadeType.ALL)
	private List<Compra> compras;
	
	@OneToMany(mappedBy="usuario")//, cascade=CascadeType.ALL)
	private List<Pago> pagos;
	
	@OneToMany(mappedBy="usuario")//, cascade=CascadeType.ALL)
	private List<Sugerencia> sugerencias;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPathFoto() {
		return pathFoto;
	}
	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}
	public boolean isVegetariano() {
		return vegetariano;
	}
	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
	public boolean isCeliaco() {
		return celiaco;
	}
	public void setCeliaco(boolean celiaco) {
		this.celiaco = celiaco;
	}
	public boolean isDiabetico() {
		return diabetico;
	}
	public void setDiabetico(boolean diabetico) {
		this.diabetico = diabetico;
	}
	public boolean isHipertenso() {
		return hipertenso;
	}
	public void setHipertenso(boolean hipertenso) {
		this.hipertenso = hipertenso;
	}
	public boolean isIntoLactosa() {
		return intoLactosa;
	}
	public void setIntoLactosa(boolean intoLactosa) {
		this.intoLactosa = intoLactosa;
	}
	protected Boolean activo=true;
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
