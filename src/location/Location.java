package location;
import java.util.Calendar;

import client.Client;
import vehicule.Vehicule;

public class Location
{
	private Client client;
	private Vehicule vehicule;
	private String debut, fin;
	private boolean reduction;
	private boolean rendu;
	
	public Location(Client client, Vehicule vehicule, String debut, String fin, boolean reduction)
	{
		super();
		this.client = client;
		this.vehicule = vehicule;
		this.debut = debut;
		this.fin = fin;
		this.reduction = reduction;
		this.rendu = false;
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}

	public Vehicule getVehicule()
	{
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule)
	{
		this.vehicule = vehicule;
	}

	public String getDebut()
	{
		return debut;
	}

	public void setDebut(String debut)
	{
		this.debut = debut;
	}

	public String getFin()
	{
		return fin;
	}

	public void setFin(String fin)
	{
		this.fin = fin;
	}

	public boolean isReduction()
	{
		return reduction;
	}

	public void setReduction(boolean reduction)
	{
		this.reduction = reduction;
	}

	public boolean isRendu()
	{
		return rendu;
	}

	public void setRendu(boolean rendu)
	{
		this.rendu = rendu;
	}
	
}
