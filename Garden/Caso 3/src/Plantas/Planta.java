package Plantas;

import java.util.ArrayList;

public class Planta extends PlantaType{
	
	private int actual_stateID = 1;
	private int abono = 0;
	private int agua = 0;
	private int edad_dias = 0;

	public Planta(PlantaType pPlant) {
	
		this.setVitalidad(pPlant.getVitalidad());
		this.setNombre(pPlant.getNombre());
		this.setPlantaID(pPlant.getPlantaID());
		//this.setStates(pPlant.getStates()); Esto es para trabajar los estados como un array y no como una clase "Estado"
		this.setEstados(pPlant.getEstados());
		this.setFruto(pPlant.getFruto());
		this.setEdad_maxima(pPlant.getEdad_maxima());;
	
	}
	public void bajarVida(int pVida) {
		this.setVitalidad(this.getVitalidad()-pVida);
	}
	
	public int getAbono() {
		return abono;
	}

	public void setAbono(int abono) {
		if (abono>=0) {
			this.abono = abono;
		}		
	}
	public void aumentarAbono(int abono) {
		this.abono += abono;
	}


	public int getEdad_dias() {
		return edad_dias;
	}

	public void setEdad_dias(int edad_dias) {
		this.edad_dias = edad_dias;
	}

	public int getActual_stateID() {
		return actual_stateID;
	}

	public void setActual_stateID(int actual_state) {
		this.actual_stateID = actual_state;
	}
	
	/*
	public ArrayList<?> getStateINDEX(int pID) {
		return (ArrayList<?>) this.getStates().get(pID);
	}*/
	
	public Estado getEstadosINDEX(int pID) {
		return this.getEstados().get(pID);
	}
	
	public int getAgua() {
		return agua;
	}
	public void setAgua(int agua) {
		if (agua>=0) {
			this.agua = agua;
		}
	}
	
	public void aumentarAgua(int abono) {
		this.agua += abono;
	}
	
	
}
