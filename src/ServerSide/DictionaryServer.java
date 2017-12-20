package ServerSide;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryServer {

	public static void main(String args[]) throws Exception {
		DictionaryServiceImplentation DSI = new DictionaryServiceImplentation();

		// Start up registry on port 1099(Default port)
		LocateRegistry.createRegistry(1099);

		// bind dictionary service with a name.
		Naming.rebind("dictionaryServiceImplemtation",DSI);

		System.out.println("Dictionary server ready!");
		//check if querying server ...it worked wohoo
		//DSI.queryDictionary("food");
	}
}
