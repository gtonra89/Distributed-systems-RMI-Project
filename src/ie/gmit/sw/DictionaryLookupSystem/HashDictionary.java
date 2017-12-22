package ie.gmit.sw.DictionaryLookupSystem;

import java.io.*;
import java.util.*;

public class HashDictionary {

	HashMap<String, ArrayList<String>> MyHashMap = new HashMap<String, ArrayList<String>>();

	public void ReadCsv() throws Exception {
		String line_Read_In = null, HashKey = null, Checker = null, Filename = "./DictionaryFile.csv";

		// Initialize the bufferedReader and parse the dictionary file
		BufferedReader MyReader = new BufferedReader(new FileReader(Filename));

		// check if line_Read_In is empty or not
		while ((line_Read_In = MyReader.readLine()) != null) {

			// split after second comma as per csv layout
			String[] keyString = line_Read_In.split(",", 2);

			if (line_Read_In.equals("")) {
				// skip it
				continue;
			}
			// Checker will look for quotation mark
			Checker = keyString[0].substring(0, 1);
			// keyString replaces quotation mark with nothing
			keyString[0] = keyString[0].replace("\"", "");

			if ("\"".equals(Checker)) {
				HashKey = keyString[0];
				addNewWord(HashKey.toUpperCase(), line_Read_In);
			} else {
				addNewWord(HashKey.toUpperCase(), line_Read_In);
			}
		} // fall out of while loop

		MyReader.close();// close bufferedRead
	}

	// add New Word to The Dictionary
	private void addNewWord(String HashKey, String newWord) {
		if (MyHashMap.get(HashKey) == null) {
			MyHashMap.put(HashKey, new ArrayList<String>());
		}
		MyHashMap.get(HashKey).add("\n" + newWord);
	}

	// Return the hashmap
	public HashMap<String, ArrayList<String>> returnDictionary() {
		return this.MyHashMap;
	}
}
