package location;

import java.io.Serializable;
import java.util.ArrayList;

import client.Client;

/** Intermédiaire pour sérialiser et enregistrer des clients.
 * @author Dejan Paris
 */
public class ListeLocations extends ArrayList<Location> implements Serializable
{
	private static final long serialVersionUID = 1L;
}
