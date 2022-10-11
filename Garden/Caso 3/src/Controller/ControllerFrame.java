package Controller;
import PlantasGui.MainFrame;
import java.util.ArrayList;

import Plantas.PlantaManagement;
public class ControllerFrame {
	private MainFrame frame;
	private PlantaManagement management;
	
	public ControllerFrame() {
		
	}
	public ControllerFrame(PlantaManagement pManagement) {
		management = pManagement;
		this.management.setController(this);
	}
	
	
	public void setFrame(MainFrame pFrame) {
		this.frame = pFrame;
	}
	
	public MainFrame getFrameControlled() {
		return this.frame;
	}
	public void setManagement(PlantaManagement pManagement) {
		this.management = pManagement;
		this.management.setController(this);
	}
	public ArrayList<String>getPlantasName() {
		return this.management.getPlantasName();		
	}
	public String getImageDeafult(int pPlantaIndex, int pEstado) {
		String image = this.management.getImageInState(pPlantaIndex, pEstado);
		return image;
	}
	public String getImageCurrent(int pPlantaIndex) {
		String image = this.management.getImageInStateExistente(pPlantaIndex);
		return image;
	}
	
	public void reportImageFrame(int pINDEX) {
		frame.reportImage(pINDEX);
	}
	public void setFecha(int pDias,String pMes, int pAños, String pEstacion, int daysPass, int pAñosCant) {
		frame.setFecha(pDias,pMes,pAños,pEstacion,daysPass,pAñosCant);
	}
	public void setRain() {
		frame.setRain(management.getRain());
	}
	public void setSol() {
		frame.setSol(this.management.getSol());
	}
	public void setVida() {
		frame.setPlantsLife(management.getPlantasLife());
	}
	
	public void setData(int pDias, String pMes, int pAños, String pEstacion, int pDayPass, int pAñosCant) {
		setFecha(pDias,pMes,pAños,pEstacion,pDayPass,pAñosCant);
		setRain();
		setSol();
		setVida();
	}
	
	public boolean addPlanta(int pINDEX) {
		if (this.management.addPlant(pINDEX)) {
			return true;
		}
		return false;
		
	}
	
	public void abonarPlanta(int pINDEX) {
		management.reportPlantsAbono(pINDEX);
	}
	public void regarPlanta(int pINDEX) {
		management.reportPlantsAgua(pINDEX);
	}
	
	public int getPosUltimaPlanta() {
		int size = management.getPlantasExistentes()-1;
		return size;
	}
}
