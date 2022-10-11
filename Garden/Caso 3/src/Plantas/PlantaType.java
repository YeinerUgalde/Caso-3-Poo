package Plantas;

import java.util.ArrayList;

public class PlantaType {
	private int plantaID;
	private int vitalidad;
	private int edad_maxima = 0;
	private String nombre;
	private String fruto;
	private ArrayList<?> states; // Ya no se utiliza, era para trabajar los estados como un arrayList
	private ArrayList<Estado> estados;

	public PlantaType() {
		this.states = new ArrayList<Estado>();
	}
	
	public int getPlantaID() {
		return plantaID;
	}

	public void setPlantaID(int plantaID) {
		this.plantaID = plantaID;
	}

	public int getVitalidad() {
		return vitalidad;
	}

	public void setVitalidad(int vitalidad) {
		this.vitalidad = vitalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<?> getStates() {
		return states;
	}

	public void setStates(ArrayList<?> states) {
		this.states = states;
	}

	public String getFruto() {
		return fruto;
	}

	public void setFruto(String fruto) {
		this.fruto = fruto;
	}

	public ArrayList<Estado> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<Estado> estados) {
		this.estados = estados;
	}

	public int getEdad_maxima() {
		return edad_maxima;
	}

	public void setEdad_maxima(int edad_maxima) {
		this.edad_maxima = edad_maxima;
	}

	
	
	
	
	

}
