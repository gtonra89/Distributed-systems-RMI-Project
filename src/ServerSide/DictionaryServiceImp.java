package ServerSide;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.*;

public class DictionaryServiceImp extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	//private String result = "";
	HashMapDictionary Map;
	HashMap<String, ArrayList<String>> HashMap;

	public DictionaryServiceImp() throws Exception, RemoteException {
		super();
		Map = new HashMapDictionary();
		Map.ReadCsv();
		HashMap = Map.returnDictionary();
	}

	@Override
	public String queryDictionary(String input) throws RemoteException {
		if (HashMap.containsKey(input.toUpperCase())) {
			System.out.println(HashMap.get(input.toUpperCase()).toString());
			return HashMap.get(input.toUpperCase()).toString();
		} else {

			return "This Word is Not in dictionary!";
		}
	}
}
