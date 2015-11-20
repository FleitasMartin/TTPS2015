package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.List;

public class Usuario extends Persona {

	private String apellido;
	private String nombre;
	private String facultad;
	private String tipo;
	private String email;
	private String pathFoto; //estará bien guardar el path de la imagen?
	private boolean vegetariano;
	private boolean celiaco;
	private boolean diabetico;
	private boolean hipertenso;
	private boolean intoLactosa;
	
	private List<Compra> compras;
	private List<Pago> pagos;
	private List<Sugerencia> sugerencias;
	
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	public List<Pago> getPagos() {
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
}
