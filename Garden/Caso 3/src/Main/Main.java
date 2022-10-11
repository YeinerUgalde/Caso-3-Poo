package Main;

import Plantas.PlantaManagement;
import PlantasGui.MainFrame;
import Controller.ControllerFrame;

public class Main {

	public static void main(String[] args) {
			
		
		//                       INIT                            //
		new MainFrame(new ControllerFrame(new PlantaManagement()));
		//                       INIT                            //
		
	}

}
