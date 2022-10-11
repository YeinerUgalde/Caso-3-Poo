package Tiempo;

import java.util.ArrayList;
import Readers.EstacionR;

public class Estacion {
	private int maxSol;
	private int minSol;
	private int maxRain;
	private int minRain;
	private int numEstaciones;
	private String currentSeason;
	private ArrayList<EstacionType> estaciones;
	
	public Estacion() {
		EstacionR reader = new EstacionR();
		this.estaciones = reader.cargarEstaciones();
		this.numEstaciones = estaciones.size();
	
	}
	
	
	public void currentSeason(int pINDEX) {
		EstacionType estacion = this.estaciones.get(pINDEX);
		this.minSol = estacion.getMinSol();
		this.maxSol = estacion.getMaxSol();
		this.minRain = estacion.getMinRain();
		this.maxRain = estacion.getMaxRain();
		this.currentSeason = estacion.getEstacion();
	}
	
	public int getMaxSol() {
		return maxSol;
	}

	public int getMinSol() {
		return minSol;
	}

	public int getMaxRain() {
		return maxRain;
	}

	public int getMinRain() {
		return minRain;
	}


	public int size() {
		return numEstaciones;
	}


	public String getCurrentSeason() {
		return currentSeason;
	}
	
	
	
}
