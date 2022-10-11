package Tiempo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import Utils.Observable;

import Controller.ControllerFrame;
import Plantas.PlantaManagement;
public class TimeMain extends Observable implements Runnable {
	private LocalTime startedTime;//_____
	private int dayPass;
	private int años = 0;
	private boolean enable,pause = false;
	private Thread hilo = null;
	private float MultiplicadorDeVelocidad = Constantes.Constantes.VelocidadDelaSimulacion;
	private PlantaManagement plantasManagement;
	private ControllerFrame controller;
	private Clima clima = new Clima();
	
	public TimeMain() {
		
	}
	
	public TimeMain(PlantaManagement pPlantasCheck) {
		this.plantasManagement = pPlantasCheck;
		
	}
	@Override
	public void run() {
		
		Period dias;
		LocalDate currentDay;
		this.startedTime = LocalTime.now();//_____
		int temporal = 0;
		try{
            while( enable ) {
            	if (pause) {
            		temporal = ((int) (ChronoUnit.MILLIS.between(startedTime, LocalTime.now()) / (1000/this.MultiplicadorDeVelocidad)))+1;
            		temporal -= dayPass;
            		continue;
            	}
            	dayPass = ((int) (ChronoUnit.MILLIS.between(startedTime, LocalTime.now()) / (1000/this.MultiplicadorDeVelocidad)))+1;
            	dayPass-=temporal;
            	dias = Period.ofDays(dayPass);
            	currentDay = LocalDate.now();
            	currentDay = currentDay.plus(dias);
            	años = currentDay.getYear();
            	años -= LocalDate.now().getYear();

            	clima.reloadClima(currentDay.getMonthValue());
           
            	
            	plantasManagement.setSol(clima.getSol());
            	plantasManagement.setRain(clima.getRain());
            	plantasManagement.checkPlants();
            	
            	
            	String estacion = clima.getCurrentSeason();
            	String mes = currentDay.getMonth().toString();
            	
            	controller.setData(currentDay.getDayOfMonth(),mes,currentDay.getYear(),estacion, dayPass,años);
            	
            	
            	Thread.sleep((long)(1000/this.MultiplicadorDeVelocidad));
            	
            	
            }
        }catch(Exception e){System.out.println(e.getMessage());}
		
    }
	
	
	public void iniciar() {
		this.enable = true;
		this.pause = false;
		this.hilo = new Thread( this );	
		
		hilo.start();
		
	}
	public void detener() {
		this.enable = false;
	}
	
	
	public int getAños() {
		return this.años;
	}
	
	public boolean getEnable() {
		return this.enable;
	}
	
	public void setController(ControllerFrame pController) {
		this.controller = pController;
	}
	
	public void pause() {
		this.pause = true;
	}
	
	public void renaudar() {
		this.pause = false;
	}
	
	public void report(int pINDEX) {
		controller.reportImageFrame(pINDEX);
	}
	
}
