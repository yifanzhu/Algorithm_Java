import java.util.HashMap;
import java.util.Iterator;
import java.io.*;

/**
 * @author Yifan Zhu
 */
public class AddressBook {
	HashMap<String, String> hashF = new HashMap<String, String>();
	HashMap<String, String> hashL = new HashMap<String, String>();
	HashMap<String, String> hashP = new HashMap<String, String>();
	HashMap<String, String> hashC = new HashMap<String, String>();
	
	public int count = 0;

	public void initialize(File filename) throws Exception{
		
		FileReader file = new FileReader(filename);
		BufferedReader text = new BufferedReader(file);
		String line = text.readLine();
		line = text.readLine();
		/*
		 * Insert the index as key and the whole information as value into each of HashMap
		 */
		while (line != null) {
			String[] items = line.split(",");
			hashF.put(items[0], line);
			hashL.put(items[1], line);
			hashP.put(items[2], line);
			hashC.put(items[3], line);
			line = text.readLine();
		}
		text.close();
	}	
	
	/**
	 * search the matched results in HashMap
	 * @param hash
	 * @param input
	 */
	public void search(HashMap<String, String> hash, String input) {
		Iterator<String> ite = hash.keySet().iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			if (key.startsWith(input)) {
				System.out.println(hash.get(key));
				count++;
			}
		}
	}
	
	/**
	 * search FirstName HashMap
	 * @param input
	 */
	public void searchF(String input) {
		search(hashF, input);
		count();
	}
	
	/**
	 * search LastName HashMap
	 * @param input
	 */
	public void searchL(String input) {
		search(hashL, input);
		count();
	}
	
	/**
	 * search PhoneNumber HashMap
	 * @param input
	 */
	public void searchP(String input) {
		search(hashP, input);
		count();
	}
	
	/**
	 * search CityName HashMap
	 * @param input
	 */
	public void searchC(String input) {
		search(hashC, input);
		count();
	}
	
	/**
	 * count the total number of information matches
	 */
	public void count() {
		if (count == 0){
			System.out.println("No results were founded");
		}
		else if (count == 1) {
			System.out.println("(" + count + " total match)");
		}
		else
			System.out.println("(" + count + " total matches)");
		count = 0;
	}
	
}
