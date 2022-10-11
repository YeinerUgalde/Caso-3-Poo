package Plantas;

import java.util.ArrayList;
import Readers.PlantaR2;

public class PlantaLoad {
	private PlantaR2 reader = new PlantaR2();
	private ArrayList<PlantaType> plantas;
	
	
	public PlantaLoad() {
		this.plantas = reader.cargarPlantas(); 
	}
	public PlantaType getPlantaType(int pPlantaID) {		
		return plantas.get(pPlantaID);		
	}
	public ArrayList<PlantaType> getPlantasType() {		
		return plantas;
	}
}
