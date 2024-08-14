package module_Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PlayGround {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the digits");
		String val = "bitty bought butter but butter";
		PlayGround pg = new PlayGround();
		HashMap<String, Integer> result = pg.reverseString(val);
		System.out.println(result);
	}
	
	public HashMap<String, Integer> reverseString(String val) {
		
		HashMap<String, Integer> map = new HashMap<>();
	//	List<String> arr = new ArrayList<>();
		String[] st = val.split("\\s+");
		
		for(int i=0; i<st.length; i++) {
			
			String c = st[i];
			if(map.containsKey(c)) {
				
				map.put(c, map.get(c)+1);
			}else {
				
				map.put(c, 1);
			}
		}
		
//		for(int j=0; j<st.length; j++) {
//			
//			if(map.get(st[j])==1) {
//				
//				System.out.println(st[j]);
//			}
//		}
		
		Set<String> keys = map.keySet();
		
		for(String s : keys) {
			
			if(map.get(s)>1) {
				
				System.out.println(s);
			}
		}
		
		
		
		
		return map;
}
}
