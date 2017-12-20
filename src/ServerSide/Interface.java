package ServerSide;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Interface extends Remote{
	
	public void queryDictionary(String filename) throws RemoteException;
	
}
