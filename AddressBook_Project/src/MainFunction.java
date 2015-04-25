import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author Yifan Zhu
 *
 */
public class MainFunction {
	
	public static String letter;
	public static Scanner input;
	public static String partial;
	public static String choice = "Y";
	public static long start;
	public static long end;
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("Welcome to AddressBook,");
		
		/*
		 * Initialize AddressBook
		 */
		start = System.currentTimeMillis();
		AddressBook csv = new AddressBook();
		csv.initialize(new File("dataset/HugeAddressBook.csv")); 
		end = System.currentTimeMillis();
		System.out.println("initialized");
		System.out.println(end - start + " ms");
		
		while(choice.equals("Y")){
			
			System.out.println("What would you like to search on?(F,L,P,C)");
			input = new Scanner(System.in);
			
			/*
			 * choose F:FirstName, L:LastName, P:PhoneNumber, C:CityName
			 * as search fields
			 */
			if (input.hasNextLine()){
				letter = input.nextLine();
			}
			switch(letter){
				case "F":
				case "f":
					System.out.println("Enter the partial First Name");
					input = new Scanner(System.in);
					partial = input.nextLine();
					System.out.println("Results:");
					start = System.currentTimeMillis();
					csv.searchF(partial);
					end = System.currentTimeMillis();
					System.out.println(end - start + " ms");
				break;
				
				case "L":
				case "l":
					System.out.println("Enter the partial Last Name");
					input = new Scanner(System.in);
					partial = input.nextLine();
					System.out.println("Results:");
					start = System.currentTimeMillis();
					csv.searchL(partial);
					end = System.currentTimeMillis();
					System.out.println(end - start + " ms");
				break;
				
				case "P":
				case "p":
					System.out.println("Enter the partial Phone Number");
					input = new Scanner(System.in);
					partial = input.nextLine();
					System.out.println("Results:");
					start = System.currentTimeMillis();
					csv.searchP(partial);
					end = System.currentTimeMillis();
					System.out.println(end - start + " ms");
				break;
				
				case "C":
				case "c":
					System.out.println("Enter the partial City Name");
					input = new Scanner(System.in);
					partial = input.nextLine();
					System.out.println("Results:");
					start = System.currentTimeMillis();
					csv.searchC(partial);
					end = System.currentTimeMillis();
					System.out.println(end - start + " ms");
				break;
			}
			
			System.out.println("Another Search?(Y,N)");
			input = new Scanner(System.in);
			choice = input.nextLine();
		}
	}
}
