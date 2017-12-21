package ServerSide;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class DictionaryServiceImplentation extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	private String result ="";
	HashMapDictionary HDMap; HashMap<String, ArrayList<String>> dictHashMap;
	
	public DictionaryServiceImplentation() throws Exception, RemoteException{
		super();
		HDMap = new HashMapDictionary(); HDMap.ReadCsv();
		dictHashMap = HDMap.returnDictionary();
	}
	@Override
	public String queryDictionary(String input) throws RemoteException {
		if(dictHashMap.containsKey(input.toUpperCase())){			
			System.out.println(dictHashMap.get(input.toUpperCase()).toString());
			result = dictHashMap.get(input.toUpperCase()).toString();
		}	
		else{
			
			result = "This Word is Not in dictionary!";
		}
		return result;
	}
}
