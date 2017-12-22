package ie.gmit.sw.DictionaryLookupSystem;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryServer {

	public static void main(String args[]) throws Exception {
		DictionaryService ds = new DictionaryServiceImp();

		// Start up registry on port 1099(Default port)
		LocateRegistry.createRegistry(1099);

		// bind dictionary service with a name.
		Naming.rebind("DS", ds);

		System.out.println("server online!");
		// simple check if querying server ...it worked wohoo
		// ds.queryDictionary("dog");
	}
}
