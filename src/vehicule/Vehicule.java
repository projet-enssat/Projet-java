package vehicule;

public abstract class Vehicule {
	private String modele;
	private String etat;
	private Float prixJour;
	private String marque;
	private String immatriculation;
	
	public Vehicule() {
		this("inconnue","inconnue",new Float(0),"inconnue","inconnue",0);
	}
	
	public Vehicule(String modele, String etat, Float prixJour, String marque, String immatriculation, int vitesse) {
		super();
		this.modele = modele;
		this.etat = etat;
		this.prixJour = prixJour;
		this.marque = marque;
		this.immatriculation = immatriculation;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((immatriculation == null) ? 0 : immatriculation.hashCode());
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		result = prime * result + ((modele == null) ? 0 : modele.hashCode());
		result = prime * result + ((prixJour == null) ? 0 : prixJour.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicule other = (Vehicule) obj;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (immatriculation == null) {
			if (other.immatriculation != null)
				return false;
		} else if (!immatriculation.equals(other.immatriculation))
			return false;
		if (marque == null) {
			if (other.marque != null)
				return false;
		} else if (!marque.equals(other.marque))
			return false;
		if (modele == null) {
			if (other.modele != null)
				return false;
		} else if (!modele.equals(other.modele))
			return false;
		if (prixJour == null) {
			if (other.prixJour != null)
				return false;
		} else if (!prixJour.equals(other.prixJour))
			return false;
		return true;
	}

	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Float getPrixjour() {
		return prixJour;
	}
	public void setPrixjour(Float prixJour) {
		this.prixJour = prixJour;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
}
