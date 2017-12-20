package ServerSide;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class DictionaryServiceImplentation extends UnicastRemoteObject implements Interface {
	private static final long serialVersionUID = 1L;
	HashMapDictionary HDMap; HashMap<String, ArrayList<String>> dictHashMap;
	
	public DictionaryServiceImplentation() throws Exception, RemoteException{
		super();
		HDMap = new HashMapDictionary(); HDMap.ReadCsv();
		dictHashMap = HDMap.returnDictionary();
	}
	@Override
	public void queryDictionary(String input) throws RemoteException {
		if(dictHashMap.containsKey(input.toUpperCase())){			
			System.out.println(input.toUpperCase()+" --> "+dictHashMap.get(input.toUpperCase()).toString());			
		}	
		else{
			System.out.println(input.toUpperCase()+" --> This word is undefined in this dictionary!");
		}
	}
}
