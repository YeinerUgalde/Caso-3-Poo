package Readers;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import Tiempo.EstacionType;

public class EstacionR {
	private JSONObject jsonObject;
	private JSONArray estaciones;
	public EstacionR() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("../Caso 3/src/estaciones.json"));
			this.jsonObject = (JSONObject) obj;	
			estaciones = (JSONArray) jsonObject.get("estaciones");
		}catch(Exception e) {System.out.println("Archivo no encontrado");}
	}
	
	public ArrayList<EstacionType> cargarEstaciones(){
		ArrayList<EstacionType> listEstaciones = new ArrayList<EstacionType>();
		for (int i = 0; i < estaciones.size(); i++) {
			EstacionType estacionType = new EstacionType();
			JSONObject estacion = (JSONObject) estaciones.get(i);
			estacionType.setEstacion((String)estacion.get("nombre"));
			estacionType.setMinSol(Integer.parseInt((String) estacion.get("SolMin")));
			estacionType.setMaxSol(Integer.parseInt((String) estacion.get("SolMax")));
			estacionType.setMinRain(Integer.parseInt((String) estacion.get("MinRain")));
			estacionType.setMaxRain(Integer.parseInt((String) estacion.get("MaxRain")));
			
			listEstaciones.add(estacionType);
		}
		return listEstaciones;
	}
	
}
