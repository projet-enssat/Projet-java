package client;
import java.util.Date;

public class Client {
	private String nom;
	private String prenom;
	private String adresse;
	private Date dateapprentissage;
	private Date datepermis;
	
	//Constructeur
	
	public Client() {
		this("inconnue","inconnue","inconnue",new Date(10/12/1900),new Date(10/12/1900));
	}
	
	public Client(String nom, String prenom, String adresse, Date date1, Date date2) {
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.dateapprentissage=date1;
		this.datepermis=date2;
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
	public Date getDateapprentissage() {
		return dateapprentissage;
	}
	public void setDateapprentissage(Date dateapprentissage) {
		this.dateapprentissage = dateapprentissage;
	}
	public Date getDatepermis() {
		return datepermis;
	}
	public void setDatepermis(Date datepermis) {
		this.datepermis = datepermis;
	}


	//toString hashcode et equals
	
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", dateapprentissage="
				+ dateapprentissage + ", datepermis=" + datepermis + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((dateapprentissage == null) ? 0 : dateapprentissage.hashCode());
		result = prime * result + ((datepermis == null) ? 0 : datepermis.hashCode());
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
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (dateapprentissage == null) {
			if (other.dateapprentissage != null)
				return false;
		} else if (!dateapprentissage.equals(other.dateapprentissage))
			return false;
		if (datepermis == null) {
			if (other.datepermis != null)
				return false;
		} else if (!datepermis.equals(other.datepermis))
			return false;
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
