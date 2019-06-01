package vehicule;

public abstract class VehiculeTerrestre extends Vehicule {
	private static final long serialVersionUID = 1L;
	private Float km;
	private int puissance;
	
	public VehiculeTerrestre(){
		this("inconnue","inconnue",new Float(0),"inconnue","inconnue",0,new Float(0),0);
	}
	
	public VehiculeTerrestre(String modele, String etat, Float prixjour, String marque, String immatriculation,
			int vitesse, Float km, int puissance) {
		super(modele, etat, prixjour, marque, immatriculation,vitesse);
		this.km = km;
		this.puissance = puissance;
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
	
	
	
}
