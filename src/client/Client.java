package client;
import java.io.Serializable;

public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String adresse;
	private String dateApprentissage;
	private String datePermis;
	
	//Constructeur
	
	public Client() {
		this("inconnue","inconnue","inconnue","00/00/0000","00/00/0000");
	}
	
	public Client(String nom, String prenom, String adresse, String date1, String date2) {
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.dateApprentissage=date1;
		this.datePermis=date2;
	}
	
	//getters and setters
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDateApprentissage() {
		return dateApprentissage;
	}
	public void setDateApprentissage(String dateapprentissage) {
		this.dateApprentissage = dateapprentissage;
	}
	public String getDatePermis() {
		return datePermis;
	}
	public void setDatePermis(String datepermis) {
		this.datePermis = datepermis;
	}


	//toString hashcode et equals
	
	@Override
	public String toString() {
		return nom + "#" + prenom + "#" + adresse +"#" + dateApprentissage + "#" + datePermis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Client other = (Client) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
}
