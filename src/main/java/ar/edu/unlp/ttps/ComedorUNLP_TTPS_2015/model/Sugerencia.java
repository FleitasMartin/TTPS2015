package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

public class Sugerencia {

	private String tipo;
	private String mensaje;
	private Sede sede = null; // así pongo que es opcional?
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
}
