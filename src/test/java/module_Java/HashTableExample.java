package module_Java;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

public class HashTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<Integer, String> hm = new Hashtable<>();
		hm.put(2, "Minimalist");
		hm.put(4, "Loreal");
		hm.put(6, "Vaseline");
		hm.put(8, "AcneSquard");
		hm.put(10, "Lakme");
		hm.put(11, "BodyWise");
		
		System.out.println(hm);
		
		Enumeration<String> e = hm.elements();
		 
		while(e.hasMoreElements()) {
			
			if(e.nextElement().equals("Loreal")) {
				
				hm.remove(4);
			}
		}
		
		System.out.println(hm);

	}

}
