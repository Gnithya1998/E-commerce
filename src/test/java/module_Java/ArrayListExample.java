package module_Java;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> arr = new ArrayList<String>();
		
		//To add values into the ArrayList
		arr.add("Briyani");
		arr.add("Tandoori");
		arr.add("Ice cream");
		arr.add("Milkshake");
		System.out.println("Initial values in the ArrayList: " + arr);
		
		//Adding duplicate value into the List
		arr.add("Briyani");
		System.out.println("Values after adding duplicate value: " + arr);
		
		//To add data in the middle of ArrayList
		arr.add(1, "Mango");
		System.out.println("Values after inserting value into index 1 : " + arr);
		
		//To retrieve the data from ArrayList
		System.out.println("Value at 0th index: " + arr.get(0)); 
		System.out.println("Value at 3rd index: " + arr.get(3)); 
		
		//To get index of certain object
		System.out.println("Index value of Ice cream: " + arr.indexOf("Ice cream"));
		
		//To check whether an ArrayList is empty
		System.out.println("Is ArrayList empty: " + arr.isEmpty());
		
		//To Get the size of the ArrayList
		System.out.println("ArrayList size: " + arr.size());
		
		//To remove the ArrayList Value
		arr.remove(0);
		System.out.println("ArrayList after removing value by index: " + arr);
		arr.remove("Mango");
		System.out.println("ArrayList after removing value by object: " + arr);

	}

}
;