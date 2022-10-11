package Plantas;

public class Estado {
	private String name;
	private String imagen;
	private int estatoID;
	private int rangoDeDias;
	private int maxSol,maxAgua,maxAbono;
	private int minSol,minAgua,minAbono;;
	private int bajarAguaEffect,bajarVidaEffect,bajarAbonoEffect = 0;	
	private int AumentarAguaEffect,subirVidaEffect,AumentarAbonoEffect = 0;	
	
	public Estado(){	
	}
	public int getMaxAgua() {
		return maxAgua;
	}
	public void setMaxAgua(int maxAgua) {
		this.maxAgua = maxAgua;
	}
	public int getMaxAbono() {
		return maxAbono;
	}
	public void setMaxAbono(int maxAbono) {
		this.maxAbono = maxAbono;
	}
	public int getMinAgua() {
		return minAgua;
	}
	public void setMinAgua(int minAgua) {
		this.minAgua = minAgua;
	}
	public int getMinAbono() {
		return minAbono;
	}
	public void setMinAbono(int minAbono) {
		this.minAbono = minAbono;
	}
	public int getEstatoID() {
		return estatoID;
	}
	public void setEstatoID(int estatoID) {
		this.estatoID = estatoID;
	}
	public int getRangoDeDias() {
		return rangoDeDias;
	}
	public void setRangoDeDias(int rangoDeDias) {
		this.rangoDeDias = rangoDeDias;
	}
	public int getMaxSol() {
		return maxSol;
	}
	public void setMaxSol(int maxSol) {
		this.maxSol = maxSol;
	}
	public int getMinSol() {
		return minSol;
	}
	public void setMinSol(int minSol) {
		this.minSol = minSol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getBajarAguaEffect() {
		return bajarAguaEffect;
	}
	public void setBajarAguaEffect(int regarEffect) {
		this.bajarAguaEffect = regarEffect;
	}
	public int getBajarVidaEffect() {
		return bajarVidaEffect;
	}
	public void setBajarVidaEffect(int bajarVidaEffect) {
		this.bajarVidaEffect = bajarVidaEffect;
	}
	public int getBajarAbonoEffect() {
		return bajarAbonoEffect;
	}
	public void setBajarAbonoEffect(int abonarEffect) {
		this.bajarAbonoEffect = abonarEffect;
	}
	public int getSubirVidaEffect() {
		return subirVidaEffect;
	}
	public void setSubirVidaEffect(int subirVidaEffect) {
		this.subirVidaEffect = subirVidaEffect;
	}
	public int getAumentarAbonoEffect() {
		return AumentarAbonoEffect;
	}
	public void setAumentarAbonoEffect(int aumentarAbonoEffect) {
		AumentarAbonoEffect = aumentarAbonoEffect;
	}
	public int getAumentarAguaEffect() {
		return AumentarAguaEffect;
	}
	public void setAumentarAguaEffect(int aumentarAguaEffect) {
		AumentarAguaEffect = aumentarAguaEffect;
	}
	
	
	
}
