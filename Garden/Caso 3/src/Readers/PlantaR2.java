package Readers;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.*;
import Constantes.Constantes;
import Plantas.Estado;
import Plantas.PlantaType;



public class PlantaR2 {
	private JSONObject jsonObject;
	private JSONArray plantas;
	
	public PlantaR2() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("../Caso 3/src/plantas.json"));
			this.jsonObject = (JSONObject) obj;	
		}catch(Exception e) {System.out.println("Archivo no encontrado");}
		this.plantas = (JSONArray)jsonObject.get("plantas");
		Constantes.setVelocidadDeCrecimienntoGeneral(Float.parseFloat((String) jsonObject.get("VelocidadDeCrecimiento")));
		Constantes.setVelocidadDelaSimulacion(Float.parseFloat((String)jsonObject.get("VelocidadDeLaSimulacion")));	
	
	}
//	Ya no se usan estas dos funciones, eran para trabajar los estados como un ArrayList.
//	public ArrayList<Serializable> getStateRules(JSONObject pRules) {
//		ArrayList<Serializable> rules = new ArrayList<Serializable>(), agua = new ArrayList<Serializable>();
//		ArrayList<Serializable> abono = new ArrayList<Serializable>(), sol  = new ArrayList<Serializable>();
//		agua.add("AguaRange");
//		agua.add( Integer.parseInt((String) pRules.get("MinNivelAgua")));
//		agua.add( Integer.parseInt((String) pRules.get("MaxNivelAgua")));
//		sol.add("SolRange");
//		sol.add( Integer.parseInt((String) pRules.get("MinNivelSol")));
//		sol.add( Integer.parseInt((String) pRules.get("MaxNivelSol")));
//		abono.add("AbonoRange");
//		abono.add( Integer.parseInt((String) pRules.get("MinNivelAbono")));
//		abono.add( Integer.parseInt((String) pRules.get("MaxNivelAbono")));
//		rules.add(agua);
//		rules.add(sol);
//		rules.add(abono);
//		return rules;
//	}
//	public ArrayList<ArrayList<Serializable>> getStates(JSONArray pStates) {
//		ArrayList<ArrayList<Serializable>> states = new ArrayList<ArrayList<Serializable>> ();
//		for (int j = 0; j < pStates.size(); j++) {
//			ArrayList<Serializable> stateData = new ArrayList<Serializable>(); 
//			JSONObject currentState = (JSONObject) pStates.get(j);
//			//stateData.add(currentState.get("EstadoID"));
//			stateData.add((String) currentState.get("EstadoName"));
//			stateData.add(Integer.parseInt((String) currentState.get("RangeTime")));
//			JSONObject rules = (JSONObject) currentState.get("rules");
//			if (rules != null) {
//				stateData.add(this.getStateRules(rules));
//			}				
//			stateData.add((String) currentState.get("Imagen"));
//			states.add(stateData); 
//		}
//		return states;
//	}
	
	public ArrayList<Estado> getStatesObject(JSONArray pStates) {
		ArrayList<Estado> allEstados = new ArrayList<Estado>();
		for (int j = 0; j < pStates.size(); j++) {
			JSONObject currentState = (JSONObject) pStates.get(j);
			Estado estado = new Estado();
			estado.setName((String) currentState.get("EstadoName"));
			estado.setRangoDeDias(Integer.parseInt((String) currentState.get("RangeTime")));			
			JSONObject rules = (JSONObject) currentState.get("rules");
			if (rules != null) {
				estado.setMinSol(Integer.parseInt((String) rules.get("MinNivelSol")));
				estado.setMaxSol(Integer.parseInt((String) rules.get("MaxNivelSol")));
				estado.setMinAgua(Integer.parseInt((String) rules.get("MinNivelAgua")));
				estado.setMaxAgua(Integer.parseInt((String) rules.get("MaxNivelAgua")));
				estado.setMinAbono(Integer.parseInt((String) rules.get("MinNivelAbono")));
				estado.setMaxAbono(Integer.parseInt((String) rules.get("MaxNivelAbono")));
			}
			JSONObject effects = (JSONObject) currentState.get("effects");
			if (effects != null) {
				estado.setBajarAguaEffect(Integer.parseInt((String) effects.get("bajarAguaEffect")));
				estado.setBajarAbonoEffect(Integer.parseInt((String) effects.get("bajarAbonoEffect")));
				estado.setBajarVidaEffect(Integer.parseInt((String) effects.get("bajarVidaEffect")));
				estado.setSubirVidaEffect(Integer.parseInt((String) effects.get("SubirVidaEffect")));
				estado.setAumentarAbonoEffect(Integer.parseInt((String) effects.get("AumentarAbono")));
				estado.setAumentarAguaEffect(Integer.parseInt((String) effects.get("AumentarAgua")));
			}
			estado.setImagen((String) currentState.get("Imagen")); 
			allEstados.add(estado);
		}
		return allEstados;
	}
	public ArrayList<PlantaType> cargarPlantas(){
		ArrayList<PlantaType> listPlantas = new ArrayList<PlantaType>();
		for(int i = 0; i < plantas.size();i++) {
			JSONObject planta = (JSONObject) plantas.get(i);
			PlantaType plantaType = new PlantaType();
			plantaType.setPlantaID(Integer.parseInt((String) planta.get("id")));
			plantaType.setNombre((String) planta.get("nombre"));
			plantaType.setVitalidad(Integer.parseInt((String) planta.get("Vitalidad")));
			plantaType.setFruto((String) planta.get("Fruto"));
			if (planta.get("Edad_maxima_en_dias") != null) {
				plantaType.setEdad_maxima(Integer.parseInt((String) planta.get("Edad_maxima_en_dias")));
			}			
			plantaType.setEstados((ArrayList<Estado>)this.getStatesObject((JSONArray) planta.get("States")));
			//plantaType.setStates((ArrayList<ArrayList<Serializable>>)this.getStates((JSONArray) planta.get("States"))); //Ya no se usa
	
			listPlantas.add(plantaType);	
		}
		return listPlantas;
	}
}



