package client;

import java.io.Serializable;
import java.util.ArrayList;

/** Intermédiaire pour sérialiser et enregistrer des clients.
 * @author Dejan Paris
 */
public class ListeClients extends ArrayList<Client> implements Serializable
{
	private static final long serialVersionUID = 1L;
}
