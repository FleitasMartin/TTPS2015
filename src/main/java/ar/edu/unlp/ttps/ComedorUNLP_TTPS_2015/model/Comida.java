package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model;

import java.util.ArrayList;

public class Comida extends Componente {

	ArrayList<String> ingredientes = new ArrayList<String>();

	
	public void ddIngrediente(String ingrediente){
		this.ingredientes.add(ingrediente);
	}
		
	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
}
