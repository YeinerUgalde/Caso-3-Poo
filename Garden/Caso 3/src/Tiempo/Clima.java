package Tiempo;

import java.util.ArrayList;
import java.util.Random;

public class Clima {

	private int sol;
	private int rain;
	private int numEstaciones;
	private float rango_mes_por_Estaciones;
	private String currentSeason;
	private Estacion estacion;
	private ArrayList<Integer> rangos = new ArrayList<Integer>();
	
	
	public Clima() {
		this.estacion = new Estacion();
		this.numEstaciones = estacion.size();
		this.rango_mes_por_Estaciones = 12/this.numEstaciones; //365 /4 = 91
		this.createRanges();
	}
	
	public void createRanges() {
		this.rangos.add(0);
		for (int i = 1; i < this.numEstaciones; i++) {
			this.rangos.add((int) (this.rango_mes_por_Estaciones*i));
		}
		this.rangos.add(12);
		//System.out.println(rangos);
	}
	
	public void reloadClima(int pMes) {
		
		for (int j = 0; j < rangos.size(); j++) {
			if (pMes >= rangos.get(j) && pMes <= rangos.get(j+1)) {				
				estacion.currentSeason(j);
				this.currentSeason = estacion.getCurrentSeason();
				//System.out.println(pMes +" : "+ rangos.get(j) +" : "+ rangos.get(j+1) );
				break;
			}
		}
		
		Random rand = new Random();
		
		int maxS = estacion.getMaxSol();
		int minS = estacion.getMinSol();
		this.sol = (rand.nextInt(maxS-minS)+minS)-1;
		
		
		
		int maxR = estacion.getMaxRain();
		int minR = estacion.getMinRain();
		this.rain = (rand.nextInt(maxR-minR)+minR);

	}

	public int getSol() {
		return this.sol;
	}
	
	public int getRain() {
		return this.rain;
	}

	public String getCurrentSeason() {
		return currentSeason;
	}
}
