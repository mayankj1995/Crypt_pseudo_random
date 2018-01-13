//Author Mayank Jain
//Description: This class is used to create a list of pseudo random numbers

public class Randomize {
	private long key; //The larger the better (must be less than 9 digits)
	private int difficulty;// must be an integer less than 9
	
	//Helping variables
	private String num;
	String rev;
	
	
	
	//Initialize 
	public Randomize(long key, int difficulty){
		this.key = key;
		this.difficulty = difficulty;

	}
	
	//This function converts long to string, reverses it, converts back to long
	public long reverse(long x){
		rev = Long.toString(x);
		rev  = new StringBuilder(rev).reverse().toString();
		x = Long.parseLong(rev);
		return x;
	}
	//This function conducts a bunch of different operations on the key and returns a new key
	
	public long getIt(){		
		key = key*key; //first it squares the key
		key = reverse(key); //Secondly It reverses the key
		num = Long.toString(key); //Converts it to string
		
		int k = difficulty;
		if(num.length()<k)
			k = num.length(); 
		//Then it gets the middle part of the string based on the difficulty
		num = num.substring((int)Math.floor((num.length()-k)/2), (int)Math.floor(((num.length()+k)/2)));
		key = Long.parseLong(num); //Converts it back to long
		if(key %10 == 0 ){ //If the last digit is zero then it adds 1 to maintain the difficulty(so on reversing the digit doesnt get smaller)
			key += 1;
		}
		

		return key;
	}

	public static void main(String[] args ){
		
		long key1 = 123467;
		int diff1 = 6;
		int num =5000;
		System.out.println("The key is " + key1 + " and the difficulty is " + diff1);
		Randomize k = new Randomize(key1,diff1);
		System.out.println("Creating "+ num + " pseudo random numbers");
		for(int i=0;i< num ;i++){
			key1 = k.getIt();
			System.out.println(key1);
		}

	}
	
}
