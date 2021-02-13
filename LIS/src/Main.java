import java.util.Random;

public class Main {
	public static void main(String [] args) {
		//these three lines below are an array of type 'int', 
		//object of the 'LIS' class, and a random 'int' object. Respectively
		int[] arrRnd = new int[100];
		LIS obj = new LIS();
		Random rnd = new Random();
		//'for loop' to populate the array
		for(int i = 0; i < arrRnd.length; i++) {
			arrRnd[i] = rnd.nextInt(20);
			//TEST: making sure the array populates
			System.out.println("value: " + i + " " + arrRnd[i]);
		}//end of 'for loop'
		//call to the method 'Lis()' in the 'LIS' class
		obj.Lis(arrRnd);
	}
}
