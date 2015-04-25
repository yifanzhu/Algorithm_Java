import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Yifan Zhu
 *
 */
public class KMP {
	
	public int kmpSearch (ArrayList<String> string, ArrayList<String> word, ArrayList<Integer> table){
		
		int begin = 0;
		int position = 0;
		
		while ((begin + position) < string.size()) {
			
			if (word.get(position).equals(string.get(begin + position))) {
				
				if (position == (word.size() - 1)) {
					
					return begin;
					
				}
				
				position = position + 1;
				
			} else {
				
				if (table.get(position) > -1) {
					
					begin = begin + position - table.get(position);
					position = table.get(position);
					
				} else {
					
					position = 0;
					begin = begin + 1;
					
				}
			}
		}
		
		return string.size();
		
	}
	
	public int kmpTable (ArrayList<String> string, ArrayList<String> word){		
		ArrayList<Integer> table = new ArrayList<Integer>();
		table.add(0, -1);
		table.add(1, 0);		
		int position = 2;
		int currentpos = 0;		
		while (position < word.size()) {			
			if ((word.get(position-1)).equals(word.get(currentpos))) {				
				currentpos = currentpos + 1;
				table.add(position, currentpos);
				position = position + 1;				
			} else if (currentpos > 0) {				
				currentpos = table.get(currentpos);				
			} else {
				table.add(position, 0);
				position = position + 1;	
			}
		}
		
		KMP kmp = new KMP();
		int length = kmp.kmpSearch(string, word, table);
		return length;
	}
	
	 public void readFileByChars(String path, ArrayList<String> string) throws FileNotFoundException {
		
		 try {   
		          
		        FileInputStream is = new FileInputStream(path);   
		         
		        int n = 1;   
		        byte buffer[] = new byte[n];   
		        
		        while ((is.read(buffer, 0, n) != -1) && (n > 0)) {  
		        	
		        	String str = new String(buffer);
		        	string.add(str);
		             
		        }     
		         
		        is.close();   
		        } catch (IOException ioe) {   
		        System.out.println(ioe);   
		        } catch (Exception e) {   
		        System.out.println(e);   
		        }   
	 }
	
	public static void main(String[] args) throws FileNotFoundException{
		
		//for(int x = 100; x <= 1000000000;){
			
			ArrayList<String> string = new ArrayList<String>(); 
			ArrayList<String> word =new ArrayList<String>();
		
			
		/*	String strRandom[] = {"A", "B", "C", "D", "E"};
		
			Random randomnumber = new Random();
		
			for(int n = 0; n < x; n++){
				
				int position = randomnumber.nextInt(strRandom.length);
				String choiceChar = strRandom[position];
				string.add(choiceChar);
				
			}
		
			double N = Math.log10((double) x);
			int M = (int) Math.ceil(N);
		
			for(int m = 0; m < M; m++){
				
				int position = randomnumber.nextInt(strRandom.length);
				String choiceChar = strRandom[position];
				word.add(choiceChar);
				
			}
			System.out.println("string:");
			for (int i = 0; i < string.size(); i++) {
			
				System.out.print(string.get(i));
			
			}
			System.out.println(" ");
			
			System.out.println("the string length: " + x);
			System.out.println("the word length: " + M);
			
			System.out.println("word:");
			for (int i = 0; i < word.size(); i++) {
			
				System.out.print(word.get(i));
			
			}
			System.out.println(" ");
		*/
		
		
			KMP kmp = new KMP();
			kmp.readFileByChars("dataset/test.txt", string);
			
			System.out.println("string:");
			for (int i = 0; i < string.size(); i++) {
				
				System.out.print(string.get(i));
			
			}
			System.out.println();
			System.out.println("Please input a word:");
			
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			for (int m = 0; m < str.length(); m++){
				
				word.add(str.subSequence(m, m+1).toString());
				
			}
			
			System.out.println("word:");
			for (int j = 0; j < word.size(); j++) {
			
				System.out.print(word.get(j));
			
			}
			System.out.println();
			long start = System.currentTimeMillis();
			int length = kmp.kmpTable(string, word);
			long end = System.currentTimeMillis();
		
			System.out.println("The first position of the word is: " + (length + 1));
			System.out.println(end - start + " ms");
		
		//	x = x * 10;
		//}
	
	}		

}
