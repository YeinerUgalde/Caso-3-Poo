package PlantasGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class OtraFormadehacerElFrame extends JFrame { 

	private static final long serialVersionUID = 1L;
	private JPanel panelPlantas,panelPlantasPosibles,temporal;
	private JButton boton_de_planta;
	private int last_ButtonX,last_ButtonY = 0;
	private ArrayList<JPanel> plantasCustom = new ArrayList<JPanel>();
	//private Controller controller;

	public OtraFormadehacerElFrame(String pTitle) {
		this.setTitle(pTitle);
		//controller = pController; // frame ve al controller
		//controller.setWindow(this); // controller ve al frame

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, 1080, 780);
		this.setLocationRelativeTo(null);
		this.setLayout(null); 
		this.setBackground(Color.white);
		this.initComponents();
		this.setVisible(true);		
	}
	public void actulizarVida(ArrayList<Integer> pVida) {
		for (int i = 0; i < pVida.size(); i++) {
			JPanel panel = plantasCustom.get(i);
			JLabel vida = (JLabel)panel.getComponent(3); // Tiene que tener cuidado con el orden, index 3 = JLabel Vida;
			vida.setText(pVida.get(i)+"");
		}
	}
	
	public JButton addRegarButton() {
		JButton button = new JButton("Regar");
		button.setBounds(10,130,100,30);
		button.setBackground(Color.pink);		
		return button;
	}
	public JButton addAbonarButton() {
		JButton button = new JButton("Abonar");
		button.setBounds(110,130,100,30);
		button.setBackground(Color.pink);		
		return button;
	}
	public JButton addActionRegar(JButton pButton, int pPos) {
		
		pButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				System.out.println("Regar: "+ pPos);
				//controller.reportPlanta(pPos);
			}
			
		});
		
		return pButton;
	}
	public JButton addActionAbonar(JButton pButton, int pPos) {
		//Tiene que poner la posicion exacta de la lista de plantas existentes no la de las de tipos de plantas.
		
		pButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				System.out.println("Abonar: "+ pPos);
				//controller.reportPlanta(pPos);
			}
			
		});
		
		return pButton;
	}
	public JButton addAction(JButton pButton, int pINDEX) { //SE LE PASA LA PLANTA A CREAR EN EL TYPE PLANTA
		pButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				
				//controller.addPlanta(pINDEX);
				
				if (temporal == null) {
					temporal = new JPanel();
					temporal.setBounds(10,10,0,160);
					temporal.setLayout(null);
				}
				int x = (int)temporal.getBounds().getMaxX()+10;
				int y = temporal.getY();
				System.out.println(x+100 + "  " + panelPlantas.getBounds().getMaxX());
				if (x+100 > panelPlantas.getBounds().getMaxX()) {
					y+=180;
					x=20;
				}
				JPanel panel = new JPanel();				
				panel.setBounds(x,y,250,160);
				temporal.setBounds(panel.getBounds()); //Aquí actualizamos a temporal.
				
				JLabel vida = new JLabel("0"); //Tiene que tener un metodo para cambiarlo, set tiene que inicilizar, bounds etc
				vida.setBounds(10,10,100,20);
				vida.setForeground(Color.BLACK);
				JButton regar = addRegarButton();
				JButton abonar = addAbonarButton();
				//int LasPos = controller.getLasPosInGarden();
				int LasPos = pINDEX;
				regar = addActionRegar(regar,LasPos);
				abonar = addActionAbonar(abonar,LasPos);
				JLabel imagen = new JLabel();
				imagen.setBounds(10, 15, 320, 140);
				//imagen.add(new ImageIcon) // COn la ruta y escalarlo
				/*
				panel.add(imagen); 
				*/
				panel.add(regar);
				panel.add(abonar);
				panel.add(vida);
				panel.repaint();
				
				plantasCustom.add(panel);
				//System.out.println(panel.getComponent(0));
				
				panelPlantas.add(panel);
				panelPlantas.repaint();	
				
			}
			
		});
		return pButton;
	}
	public JButton createButtonPlanta(String pNombre) {
		if (this.boton_de_planta == null) {
			this.boton_de_planta = new JButton();
			this.boton_de_planta.setBounds(30,20,150,30);
		}
		int y = (int)boton_de_planta.getBounds().getMaxY()+20;
		/*
		if (y > this.getBounds().getMaxY()) {
			this.panelPlantasPosibles.setPreferredSize(new Dimension(300,(int)(this.getBounds().getMaxY()+600)));
			//Actualizar el y, actulizar el bound etc
		}
		*/
		JButton button = new JButton(pNombre);
		button.setBounds(30,y,150,30);
		boton_de_planta.setBounds(button.getBounds());
		button.setBackground(Color.pink);
		return button;
	}
	
	public void cargarBotonesDePlantas() {
		//ArrayList<String> plantasName = controller.getPlantasName(); //[0,1,2,3,4]
		ArrayList<String> plantasName = new ArrayList<String>();
		plantasName.add("Cilantro");
		plantasName.add("planta 1");
		plantasName.add("planta 2");
		plantasName.add("planta 3");
		for (int i = 0; i<plantasName.size();i++) {
			String nombre = plantasName.get(i);
			JButton button = createButtonPlanta(nombre);
			button = addAction(button,i);
			this.panelPlantasPosibles.add(button);
			this.panelPlantasPosibles.repaint();
		}	
		
	}
	public void initPanelPlantas() {
		this.panelPlantas = new JPanel();
		this.panelPlantas.setBounds(0,0,(int)this.getBounds().getMaxX()-501,(int)this.getBounds().getMaxY());
		this.panelPlantas.setBackground(Color.green);
		this.panelPlantas.setLayout(null);
		this.add(panelPlantas);
	}
	
	public void initPanelPlantasPosibles() {
		this.panelPlantasPosibles = new JPanel();
		this.panelPlantasPosibles.setBounds((int)this.getBounds().getMaxX()-500, 0, 300,(int)this.getBounds().getMaxY());
		this.panelPlantasPosibles.setBackground(Color.MAGENTA);
		this.panelPlantasPosibles.setLayout(null);
		this.add(panelPlantasPosibles);
	}
	
	private void initComponents() {
		
		initPanelPlantas();
		initPanelPlantasPosibles();
		cargarBotonesDePlantas();
		
		
	}
	
	/*
	//Metodos en el controller y manager
	public ArrayList<String> getPlantasVida() {
		//Recoge y agarra los nombre;
		return null;
	}
	
	public int getLasPosInGarden() {
		int lasPos = garden.size()-1;
		return null
	}
	*/
	
}
