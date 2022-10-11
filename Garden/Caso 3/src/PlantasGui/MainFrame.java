package PlantasGui;

import Controller.ControllerFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import static java.awt.Font.PLAIN;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	

	private JPanel panel1,panel2,panel3;
	private int xPanel2Max,yPanel2Max,yPanel1Max = 0;
	private JLabel dias,sol,rain = null;
	private JButton plantaBttn,plantaEnListaBttn = null;
	private JScrollPane scrollPanel1,scrollPanel2;
	private ControllerFrame controller;
	private ArrayList<ArrayList<JComponent>> plantas = new ArrayList<ArrayList<JComponent>>();
	
	public MainFrame(ControllerFrame pController) {
		this.controller = pController;
		this.controller.setFrame(this);
		this.setTitle("Garden");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0,1212,675);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.initComponents();
		this.setVisible(true);
	}

	
	public void setFecha(int pDia, String pMes , int pAño, String pEstacion, int daysPass , int pAñosCant) {
		this.dias.setText("Dia "+ pDia + " de "+ pMes 
				+ " del " + pAño + " ( "+ pEstacion + " )" 
				+ " ( DiasT: "+ daysPass + " / AñosT: "
				+ pAñosCant + " )");
		this.panel3.repaint();
	}
	public void setRain(int pRain) {
		this.rain.setText(pRain+"");
		this.panel3.repaint();
	}
	public void setSol(int pSol) {
		this.sol.setText(pSol+"");
		this.panel3.repaint();
	}
	public void setPlantsLife(ArrayList<Integer> pVidas) {
		for (int i = 0; i<pVidas.size();i++) {
			int currentVida = pVidas.get(i);
			if (i >= plantas.size()) {break;}
			ArrayList planta =  (ArrayList) plantas.get(i);
			JLabel vida = (JLabel)planta.get(1);
			JLabel vidaNUM = (JLabel)planta.get(2);
			float menos = 0;
			//menos = (float) (vida.getBounds().getMaxX() / (currentVida)); //para ir bajando la barra de vida poco a poco // No sirve F
			vida.setBounds(vida.getX(),vida.getY(),(int) (210-menos),45);
			vidaNUM.setText(currentVida+"");
			vida.repaint();
			
			
			if (currentVida-2 <= 0) {
				
				JButton jbtt = (JButton) planta.get(4);
				JButton jbtt2 = (JButton) planta.get(3);
				JLabel muerte = new JLabel("Muerta");
				jbtt2.setVisible(false);
				jbtt.setText("Muerta");
				jbtt.setForeground(Color.white);
				jbtt.setBackground(Color.darkGray);
				
				jbtt.setBounds(jbtt.getX(),jbtt.getY(),210,30);
				jbtt.setVisible(true);				
				jbtt.repaint();
				vidaNUM.setText("0");
				vida.setVisible(false);
				
				
			}
		}
		

	
	}
	public JButton addPlantaButton(String pString) {
		
		if (this.plantaBttn==null) {
			this.plantaBttn = new JButton();
			this.plantaBttn.setBounds(-100,230,100,30);
		}
		int x = (int) this.plantaBttn.getBounds().getMaxX()+10 , y = (int) this.plantaBttn.getBounds().getY();	
		if (y+300 > this.yPanel2Max && x+50 > this.xPanel2Max) {
			y = 230;
			x+= 20;
			this.xPanel2Max+=900;
			this.panel2.setPreferredSize(new Dimension((this.xPanel2Max),500));
		}
		else if (x+100 > this.xPanel2Max) {
			x = xPanel2Max-900+10;
			y+= 180+90;//20
		}		
		this.plantaBttn = new JButton(pString);
		this.plantaBttn.setBounds(x,y,100,30);
		this.plantaBttn.setBackground(Color.ORANGE); 
		this.plantaBttn.setForeground(Color.BLACK);
		this.plantaBttn.setBorder(new LineBorder(Color.BLACK));
		this.plantaBttn.setFont(new Font("PLAIN",0, 18));
		
	
		this.panel2.repaint();
		this.panel1.repaint();
		this.panel3.repaint();
		JButton button = new JButton();
		button = this.plantaBttn;
		return button;
	}
	
	public JButton addPlantaEnLista(String pNombre) {
		
		if (this.plantaEnListaBttn == null) {
			this.plantaEnListaBttn = new JButton(pNombre);
			this.plantaEnListaBttn.setBounds(65,0,180,30);
		}
		int y = (int)this.plantaEnListaBttn.getBounds().getMaxY()+30;
		if (y+50 >= this.yPanel1Max) {
			y = this.yPanel1Max-30;
			this.yPanel1Max+=600;
			this.panel1.setPreferredSize(new Dimension(300,this.yPanel1Max));
		}

		this.plantaEnListaBttn = new JButton(pNombre);
		this.plantaEnListaBttn.setBounds(65, y,180,30);
		this.plantaEnListaBttn.setBackground(Color.YELLOW); 
		this.plantaEnListaBttn.setForeground(Color.BLACK);
		this.plantaEnListaBttn.setBorder(new LineBorder(Color.BLACK));
		this.plantaEnListaBttn.setFont(new Font("PLAIN",0, 18));
		JButton button = new JButton();
		button = this.plantaEnListaBttn;
		return button;
	}
	
	
	public JLabel createLabelIMAGE() {
		JLabel Label= new JLabel();
		Label.setBounds(plantaBttn.getX(),plantaBttn.getY()-170,210,160);			
		Label.setBorder(new LineBorder(Color.BLACK));
		Label.setLayout(null);				
		return Label;
	}
	public JLabel createLabelMARCOVIDA() {
		JLabel Label= new JLabel();
		Label.setBounds(plantaBttn.getX(),plantaBttn.getY()-210,210,45);					
		Label.setLayout(null);				
		return Label;
	}
	public JLabel createLabelVIDA() {
		JLabel Label= new JLabel();
		Label.setBounds(plantaBttn.getX()+12,plantaBttn.getY()-210,210,45);					
		Label.setLayout(null);				
		return Label;
	}
	public JLabel createLabelMARCO() {
		JLabel Label= new JLabel();
		Label.setBounds(plantaBttn.getX(),plantaBttn.getY()-210,210,243);					
		Label.setLayout(null);				
		return Label;
	}
	
	public JLabel setImage(JLabel pLabel, String ruta) {
		ImageIcon image = new ImageIcon(ruta);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(pLabel.getWidth(), pLabel.getHeight(), Image.SCALE_DEFAULT));		
		pLabel.setIcon(icon); 
		return pLabel;
	}
	
	public void reportImage(int pINDEX) {
		
		JLabel currentImage = (JLabel) plantas.get(pINDEX).get(0);
		setImage(currentImage,controller.getImageCurrent(pINDEX));
		
	}
	
	public JButton addActionAbonar(JButton pButton,int pINDEX) {
		pButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Abonar "+controller.getPlantasName().get(pINDEX)); //LA ACCION QUE HACE
				controller.abonarPlanta(pINDEX);

			}
		});
		return pButton;
		
	}
	public JButton addActionRegar(JButton pButton,int pINDEX) {
		pButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Regar "+controller.getPlantasName().get(pINDEX)); //LA ACCION QUE HACE
				controller.regarPlanta(pINDEX);

			}
		});
		return pButton;
		
	}
	
	public JButton addAction(JButton pButton, int pINDEX) {		
		pButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Boolean succes = controller.addPlanta(pINDEX);
				if (!succes) {
					return;
				}
				System.out.println("PlantaType: "+pINDEX);
				int posicion = controller.getPosUltimaPlanta();
				System.out.println("Posicion: "+ posicion);
				
				ArrayList plantaCustom = new ArrayList();
				
				JButton regarBttn = addPlantaButton("Regar"); //SE DEBE DE GENERAR PRIMERO PARA QUE LOS LABELS TOMEN SUS BOUNDS
				regarBttn = addActionRegar(regarBttn,posicion);
				
				//plantaCustom.addAll(labelPlantaSettings(pINDEX));
				//--------------------------------------------------------------------
				JLabel imagenLabel = createLabelIMAGE();
				JLabel marcoVida = createLabelMARCOVIDA();
				JLabel vida = createLabelVIDA();
				JLabel marco = createLabelMARCO();
				JLabel vidaNUM = createLabelVIDA();
				String imagen = controller.getImageDeafult(pINDEX,1);
				String imagenMarcoVida = "../Caso 3/src/Imagenes/VidaVacia.png";
				String imagenMarco= "../Caso 3/src/Imagenes/marco.jpg";
				String imagenVida= "../Caso 3/src/Imagenes/barraVida.png";
				imagenLabel = setImage(imagenLabel,imagen);				
				marcoVida = setImage(marcoVida,imagenMarcoVida);				
				marco = setImage(marco,imagenMarco);				
				vida = setImage(vida,imagenVida);
				vidaNUM.setBounds((int)vidaNUM.getX()+103,(int)vidaNUM.getY(),50,45);
				vidaNUM.setForeground(Color.white);
				//--------------------------------------------------------------------
				
				JButton abonarBttn = addPlantaButton("Abonar");
				abonarBttn = addActionAbonar(abonarBttn,posicion);
				
				
				plantaCustom.add(imagenLabel);
				plantaCustom.add(vida);
				plantaCustom.add(vidaNUM);
				plantaCustom.add(abonarBttn);
				plantaCustom.add(regarBttn);
				
				panel2.add(abonarBttn);
				panel2.add(regarBttn);
				panel2.add(imagenLabel);panel2.add(vidaNUM);panel2.add(vida);
				panel2.add(marcoVida);panel2.add(marco);
				plantas.add(plantaCustom);
	
				System.out.println("----------------------NUEVA PLANTA----------------------");
			}
		});
		return pButton;
		
		
	}
	public void cargarLista(ArrayList<String> plantas) {
		for (int i = 0; i<plantas.size();i++) {
			JButton button = addPlantaEnLista(plantas.get(i));
			button = addAction(button,i);
			panel1.add(button);
		}
	}
	
	public void panelListaPlantas(){
		panel1 = new JPanel();
		panel1.setBackground(Color.darkGray);
		panel1.setBounds(890,0,300,(int)this.getBounds().getMaxY());
		panel1.setPreferredSize(new Dimension(250,630));
		this.yPanel1Max = (int)panel1.getBounds().getMaxY();
		panel1.setLayout(null);
		scrollPanel1.setViewportView(panel1);
	}
	
	public void panelPlantas() {
		panel2= new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setBounds(0,0,900,635);
		panel2.setPreferredSize(new Dimension(850,600));
		this.xPanel2Max = (int)panel2.getBounds().getMaxX();
		this.yPanel2Max = (int)panel2.getBounds().getMaxY();
		panel2.setLayout(null);
		scrollPanel2.setViewportView(panel2);
	}
	public void panelDataLabels() {
		JLabel solIMAGE = new JLabel();
		solIMAGE.setBounds(10,5,50,35);
		setImage(solIMAGE,"../Caso 3/src/Imagenes/sol.png");
		this.sol = new JLabel("0");
		sol.setForeground(Color.white);
		sol.setFont(new Font("PLAIN",0, 18));
		sol.setBounds(75,5,50,35);
		JLabel rainIMAGE = new JLabel();
		rainIMAGE.setBounds(100,5,50,35);
		setImage(rainIMAGE,"../Caso 3/src/Imagenes/rain.png");
		this.rain = new JLabel("0");
		rain.setForeground(Color.white);
		rain.setFont(new Font("PLAIN",0, 18));
		rain.setBounds(165,5,50,35);
		JLabel reloj = new JLabel();
		reloj.setBounds(190,5,60,35);
		setImage(reloj,"../Caso 3/src/Imagenes/reloj.png");
		this.dias = new JLabel("Dia [] de [] del []");
		dias.setForeground(Color.white);
		dias.setFont(new Font("PLAIN",0, 18));
		dias.setBounds(250,5,590,35);
		
		panel3.add(solIMAGE);
		panel3.add(rainIMAGE);
		panel3.add(reloj);
	}
	
	public void panelData() {
		panel3= new JPanel();
		panel3.setBackground(Color.darkGray);
		panel3.setBounds(0,0,910, 50);
		panel3.setPreferredSize(new Dimension((int) this.getBounds().getMaxX(),50));
		panel3.setLayout(null);
		panelDataLabels();
		panel3.add(dias);
		panel3.add(sol);
		panel3.add(rain);
		panel3.repaint();
	}
	
	private void initComponents() {
		scrollPanel1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel1.setBounds(899,-5,300,(int)this.getBounds().getMaxY()-105);
		scrollPanel2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanel2.setBounds(0,50,899,(int)this.getBounds().getMaxY()-163);
		
		panelListaPlantas();
		panelPlantas();
		panelData();

		this.add(scrollPanel1);
		this.add(scrollPanel2);
		this.add(panel3);
	
		cargarLista(controller.getPlantasName());
		

		
		
		
		
		

		
		
	}
}
