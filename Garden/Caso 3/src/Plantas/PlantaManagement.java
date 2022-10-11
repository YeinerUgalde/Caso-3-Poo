package Plantas;

import java.util.ArrayList;
import java.util.logging.Logger;

import Controller.ControllerFrame;
import Tiempo.TimeMain;
import Utils.*;

public class PlantaManagement implements IObserver{
	private ArrayList<Planta> ListaDePlantasExistentes = new ArrayList<Planta>();
	private PlantaLoad plantasData = new PlantaLoad();
	private TimeMain tiempo = new TimeMain(this);
	private int plantasExistentes = 0;
	private int sol;
	private int rain;
	public PlantaManagement() {
		
	}
	public Boolean enabledPlant() {
		for (Planta planta : ListaDePlantasExistentes) {
			if(planta.getActual_stateID()!=0) {
				return true;
			}
		}
		return false;
	}
	public void checkPlants() {
		for (int i = 0; i< this.ListaDePlantasExistentes.size(); i++) {
			Planta planta = this.ListaDePlantasExistentes.get(i);
			planta.setEdad_dias(planta.getEdad_dias()+1);
			int stateID = planta.getActual_stateID();
			if (stateID == 0) {continue;}
			
			Estado estado = planta.getEstadosINDEX(stateID);
			
			if ( sol <= estado.getMinSol() || sol >= estado.getMaxSol()) {
				planta.setAgua(planta.getAgua()-estado.getBajarAguaEffect());
				planta.setAbono(planta.getAbono()-estado.getBajarAbonoEffect());
				System.out.println(" SE BAJO EL AGUA POR SOL " +planta.getAgua() + " " + planta.getNombre());
			}
			if ( rain > 0) {
				planta.setAgua(planta.getAgua()+rain);
				System.out.println("SE AGREGO AGUA POR RAIN " +planta.getAgua() + " " + planta.getNombre());
			}
			
			if ( planta.getAbono() < estado.getMinAbono() || planta.getAbono() >= estado.getMaxAbono()) {
				planta.bajarVida(estado.getBajarVidaEffect());
				System.out.println(" SE BAJO LA VIDA POR FALTA DE ABONO: " +planta.getVitalidad() + " " + planta.getNombre()+ " " +planta.getAbono() + " Min: "+ estado.getMinAbono());
			}
			if ( planta.getAgua() < estado.getMinAgua() || planta.getAgua() >= estado.getMaxAgua()) {
				planta.bajarVida(estado.getBajarVidaEffect());
				System.out.println(" SE BAJO LA VIDA POR FALTA DE AGUA: " +planta.getVitalidad() + " " + planta.getNombre() + " " + planta.getAgua()+ " Min: "+estado.getMinAgua());
			}
			if (planta.getEdad_dias() > estado.getRangoDeDias()) {
				int estadoID = planta.getActual_stateID()+1;
				if (estadoID < planta.getEstados().size()) {
					planta.setActual_stateID(estadoID);
					planta.setAbono(0);
					tiempo.report(i);
				}
				
			}
			
			if (planta.getVitalidad() <= 0) {
				planta.setActual_stateID(0);
				tiempo.report(i);
				plantasExistentes-=1;
				System.out.println("Muerta\n\n");
			}
			if (planta.getEdad_dias() >= planta.getEdad_maxima()) {
				planta.setActual_stateID(0);
				plantasExistentes-=1;
				tiempo.report(i);
			}
			//System.out.println();
		}
		if (!enabledPlant()) {
			tiempo.pause();
		}
		
	}
	
	public void reportPlantsAbono(int pINDEX) {
		int aumentoAbono = this.ListaDePlantasExistentes.get(pINDEX).getEstados().get(this.ListaDePlantasExistentes.get(pINDEX).getActual_stateID()).getAumentarAbonoEffect();
		int aumentoVida = this.ListaDePlantasExistentes.get(pINDEX).getEstados().get(this.ListaDePlantasExistentes.get(pINDEX).getActual_stateID()).getAumentarAbonoEffect();
		this.ListaDePlantasExistentes.get(pINDEX).aumentarAbono(aumentoAbono);
		/*Estado estado = this.ListaDePlantasExistentes.get(pINDEX).getEstados().get(this.ListaDePlantasExistentes.get(pINDEX).getActual_stateID());
		if ( this.ListaDePlantasExistentes.get(pINDEX).getAbono() >= estado.getMinAbono() && this.ListaDePlantasExistentes.get(pINDEX).getAbono() <= estado.getMaxAbono()) {
			this.ListaDePlantasExistentes.get(pINDEX).setVitalidad(this.ListaDePlantasExistentes.get(pINDEX).getVitalidad()+aumentoVida);
		}*/
		System.out.println("Se aumento el abono "+ ListaDePlantasExistentes.get(pINDEX).getNombre()+ " mas: "+ aumentoAbono);
	}
	
	public void reportPlantsAgua(int pINDEX) {
		int aumento = this.ListaDePlantasExistentes.get(pINDEX).getEstados().get(this.ListaDePlantasExistentes.get(pINDEX).getActual_stateID()).getAumentarAguaEffect();
		this.ListaDePlantasExistentes.get(pINDEX).aumentarAgua(aumento);
		System.out.println("Se aumento el agua "+ ListaDePlantasExistentes.get(pINDEX).getNombre()+ " mas: "+ aumento) ;
	}
	
	public boolean addPlant(int pINDEX) {
		if ((this.plantasExistentes!=0)) {
			int pos = ListaDePlantasExistentes.size()-1;
			int edadMax = ListaDePlantasExistentes.get(pos).getEdad_maxima();			
			if (ListaDePlantasExistentes.get(pos).getEdad_dias() < (edadMax/3) && edadMax !=0 ) {
				System.out.println("La panta aun no ha crecido lo suficiente: " +
				ListaDePlantasExistentes.get(pos).getEdad_dias()  +" de "+ edadMax/3);
				return false;
			}else if (ListaDePlantasExistentes.get(pos).getActual_stateID() < ListaDePlantasExistentes.get(pos).getEstados().size()/3){
				System.out.println("La panta aun no ha crecido lo suficiente: (No tiene edad maxima) " +
						ListaDePlantasExistentes.get(pos).getActual_stateID()  +" de "+ ListaDePlantasExistentes.get(pos).getEstados().size()/3);
				return false;
			}
			
		}
		
		this.ListaDePlantasExistentes.add(new Planta(plantasData.getPlantaType(pINDEX)));
		this.plantasExistentes+=1;
		System.out.println(this.ListaDePlantasExistentes.get(ListaDePlantasExistentes.size()-1).getNombre()  + " cantPlantas: "+ this.plantasExistentes);
		this.tiempo.renaudar();
		if (!tiempo.getEnable()) {
			this.tiempo.iniciar();
			
		}
		return true;
		
	}
	public void deletPlant(int pIndex) {
	
		this.ListaDePlantasExistentes.remove(pIndex);
	}
	
	public void pause() {
		this.tiempo.pause();
	}
	
	public void start(ControllerFrame pController) {
		this.tiempo.iniciar();
		this.tiempo.setController(pController);
	}
	
	public int getSol() {
		return sol;
	}
	public void setSol(int sol) {
		this.sol = sol;
	}
	public int getRain() {
		return rain;
	}
	public void setRain(int rain) {
		this.rain = rain;
	}
	
	public ArrayList<String> getPlantasName(){
		ArrayList<String> plantasName = new ArrayList<String>();
		for (PlantaType planta : plantasData.getPlantasType()) {
			plantasName.add((String)planta.getNombre());
		}
		return plantasName;		
	}
	public String getImageInState(int pPlantaIndex, int pEstadoIndex) {
		String imagen = plantasData.getPlantasType().get(pPlantaIndex).getEstados().get(pEstadoIndex).getImagen();
		return imagen;
	}
	
	public String getImageInStateExistente(int pPlantaIndex) {
		String imagen = ListaDePlantasExistentes.get(pPlantaIndex).getEstados().get(ListaDePlantasExistentes.get(pPlantaIndex).getActual_stateID()).getImagen();
		return imagen;
	}
	
	public void setController(ControllerFrame pController) {
		this.tiempo.setController(pController);
	}
	
	public ArrayList<Integer> getPlantasLife(){
		ArrayList<Integer> vida = new ArrayList<Integer>();
		for (Planta planta: ListaDePlantasExistentes) {
			vida.add(planta.getVitalidad());
		}
		return vida;
	}
	
	public int getPlantasExistentes() {
		return ListaDePlantasExistentes.size();
	}
	
	
	@Override // No implementado
	public void update(Observable pObservable, Object args) {
		/*
		SimulatorReport simReport = (SimulatorReport)arg;
		if (simReport.action.compareTo(UPDATE_DAYS)==0) {
			evaluate(simReport.days);
		}
		if (simReport.action.compareTo(UPDATE_WEATHER)==0) {
			updateTemperature(simReport.days, simReport.temperature);
			updateWater(simReport.days, simReport.rain);
		}*/		
	}	
	
}
	
	
