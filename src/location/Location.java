package location;
import java.util.Calendar;

import client.Client;
import vehicule.Vehicule;

public class Location
{
	private Client client;
	private Vehicule vehicule;
	private Calendar debut, fin;
	private boolean reduction;
	private boolean rendu;
	
	public Location(Client client, Vehicule vehicule, Calendar debut, Calendar fin, boolean reduction)
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

	public Calendar getDebut()
	{
		return debut;
	}

	public void setDebut(Calendar debut)
	{
		this.debut = debut;
	}

	public Calendar getFin()
	{
		return fin;
	}

	public void setFin(Calendar fin)
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
