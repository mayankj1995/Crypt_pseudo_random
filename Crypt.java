//Author: Mayank Jain
//Description: This program encrypts a txt file using pseudo random numbers created by the class Randomize
//------------It moves each character by the numbers generated by the Randomize class using a secret key provided by the user
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class Crypt {
	
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		
		String myFileName = "input.txt";
		
		String outputFileName = "output.txt";
		
		
		
		try{
			FileReader myFile = new FileReader(myFileName);
			Scanner scanMyFile = new Scanner(myFile);
			PrintWriter output = new PrintWriter(new FileWriter(outputFileName));
			//reading file and setting 'sentence' = the text in file
			String sentence = "";
			while(scanMyFile.hasNextLine())
				sentence += scanMyFile.next() + " ";
		
			//Creating an array of characters below
			String alpha="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+{}:<>?[];,./ ";
			int alpha_len = alpha.length();
			String[] alphaArray = alpha.split("");
			
			//Creating an array of character that we want to encrypt
			String[] arrayToCrypt = sentence.split("");
			String[] encryptedArray = new String[arrayToCrypt.length];
			
			System.out.println("-------------");
			System.out.println("Welcome to Secure Vault. This program will encrypt your text using pseudo random numbers");
			System.out.print("Enter your key to encrypt the text (<9 digit): ");
			long code = stdin.nextInt();			
			
			//Creating a randomizer to shift each character by random units
			Randomize k = new Randomize(code,6);
			
			System.out.println("Performing Encryption");
			
			for(int i=0;i<arrayToCrypt.length-1;i++){
				for(int j=0;j<alphaArray.length;j++){
					
					 if(arrayToCrypt[i].equals(alphaArray[j])){
						code = k.getIt(); //fetches the next random number
						encryptedArray[i] = alphaArray[(int) Math.floorMod(j+code, alpha_len)]; //moves the character by that random number
						output.print(encryptedArray[i]); //prints the character in the new file
						break; //goes to next character since done
					}
					
				}
				
			}
			System.out.println("Encryption successful.");
		stdin.close();
		scanMyFile.close();
		output.close();
		}
		catch(Exception ex){
			System.out.println("exception: "+ex.getMessage()+"caught");
		}	
	
	}
}