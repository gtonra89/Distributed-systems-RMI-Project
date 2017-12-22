package ie.gmit.sw.DictionaryLookupSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DictionaryService extends Remote {

	public String queryDictionary(String filename) throws RemoteException, Exception;

}
