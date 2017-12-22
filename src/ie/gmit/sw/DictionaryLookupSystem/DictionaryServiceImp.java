package ie.gmit.sw.DictionaryLookupSystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.*;

public class DictionaryServiceImp extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	// private String result = "";
	HashDictionary Map;
	HashMap<String, ArrayList<String>> HashMap;
	String Result ="";

	public DictionaryServiceImp() throws Exception, RemoteException {
		super();
		Map = new HashDictionary();
		Map.ReadCsv();
		HashMap = Map.returnDictionary();
	}

	@Override
	public String queryDictionary(String input) throws RemoteException {
		if (HashMap.containsKey(input.toUpperCase())) {
			System.out.println(HashMap.get(input.toUpperCase()).toString());
			Thread thread = new Thread(new Runnable() {

			    @Override
			    public void run() {
			        for(int i=0; i<10; i++) {
			            System.out.println(i + " Querying ...");
			        }   
			    }
			    
			});
			thread.start();
			try {
				thread.sleep(2000);
				Result =  HashMap.get(input.toUpperCase()).toString();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Result;
		} else {

			return "This Word is Not in dictionary!";
		}
		
	}
}
