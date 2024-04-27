package module_Java;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> ash = new HashSet<String>();
		
		ash.add("Apple");
		ash.add("Mango");
		ash.add("Water melon");
		ash.add("Chikku");
		ash.add("Kiwi");
		
		//To print all the values in HashSet
		System.out.println("All the values of HashSet: " + ash);
		
		//Adding duplicating value into HashSet
		ash.add("Mango");
		System.out.println("After adding duplicate value into HashSet: " + ash);
		
		//To check the HashSet is empty
		System.out.println("Is the HashSet empty: " + ash.isEmpty());
		
		//After removing an object from HashSet
		ash.remove("Chikku");
		System.out.println("After removing an element from HashSet: " + ash);
		
		//Getting all the values using iterator
		Iterator<String> it = ash.iterator();
		while(it.hasNext()) {
			
			System.out.println(it.next());
		}

	}

}
