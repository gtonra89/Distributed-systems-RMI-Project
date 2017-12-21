package ServerSide;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DictionaryService extends Remote {

	public String queryDictionary(String filename) throws RemoteException;

}
