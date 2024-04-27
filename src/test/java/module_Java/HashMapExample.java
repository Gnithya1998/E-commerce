package module_Java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(2, "Minimalist");
		hm.put(4, "Loreal");
		hm.put(6, "Vaseline");
		hm.put(8, "AcneSquard");
		hm.put(10, "Lakme");
		hm.put(11, "BodyWise");
		
		//To get certain key value
		System.out.println("Getting the key value: " + hm.get(6));
		
		//To remove a key value
		hm.remove(11);
		System.out.println("After removing the key value: " + hm.get(11));
		
		Set<Entry<Integer, String>> set = hm.entrySet();
		Iterator<Entry<Integer, String>> it = set.iterator();
		
		while(it.hasNext()) {
			
			Map.Entry<Integer, String> mapEntry = (Map.Entry<Integer, String>) it.next();
			System.out.print("Key number " + mapEntry.getKey());
			System.out.print(" value is: " + mapEntry.getValue());
			System.out.println();
		}

	}

}
