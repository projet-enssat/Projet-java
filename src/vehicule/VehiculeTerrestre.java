package vehicule;

public abstract class VehiculeTerrestre extends Vehicule {
	private Float km;
	private int puissance;
	private int vitesseMax;
	
	public VehiculeTerrestre(){
		this("inconnue","inconnue",new Float(0),"inconnue","inconnue",0,new Float(0),0,0);
	}
	
	public VehiculeTerrestre(String modele, String etat, Float prixjour, String marque, String immatriculation,
			int vitesse, Float km, int puissance, int vitesseMax) {
		super(modele, etat, prixjour, marque, immatriculation,vitesse);
		this.km = km;
		this.puissance = puissance;
		this.vitesseMax = vitesseMax;
	}
	
	public Float getKm() {
		return km;
	}
	public void setKm(Float km) {
		this.km = km;
	}
	public int getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	public int getVitesseMax() {
		return vitesseMax;
	}
	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	
	
	
}
