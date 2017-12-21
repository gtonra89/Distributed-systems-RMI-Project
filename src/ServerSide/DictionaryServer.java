package ServerSide;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryServer {

	public static void main(String args[]) throws Exception {
		DictionaryService DSI = new DictionaryServiceImplentation();

		// Start up registry on port 1099(Default port)
		LocateRegistry.createRegistry(1099);

		// bind dictionary service with a name.
		Naming.rebind("dictionaryService", DSI);

		System.out.println("server online!");
		// check if querying server ...it worked wohoo
		DSI.queryDictionary("dog");
	}
}
