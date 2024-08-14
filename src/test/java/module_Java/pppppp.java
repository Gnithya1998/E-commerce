package module_Java;import org.apache.commons.math3.linear.AbstractFieldMatrix;import org.openqa.selenium.devtools.v120.emulation.model.SensorMetadata;

public class pppppp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] arr = { 4, 3, 25, 6, 7, 8, 9, 2, 3, 10 };
//
//		int count = 0;
//		int max =0;
//
//		for(int i = 0; i < arr.length-1; i++) {
//		if(arr[i] +1== arr[i+1]) {
//		count++;
//		System.out.print(arr[i]+ " ");
//		System.out.println(count);
//		}else {
//		count = 0;
//		}
//
//		max = Math.max(max, count+1);
//		}
//		System.out.println(max);
//		}
		
		
		
		//Program 2
		
//		String str = "a2b3c4";
//		for(int i=0; i<str.length(); i++) {
//			
//			if(Character.isAlphabetic(str.charAt(i))) {
//				
//				System.out.print(str.charAt(i));
//			}else {
//				
//				int a = Character.getNumericValue(str.charAt(i));
//				for(int j=0; j<a; j++) {
//					
//					System.out.print(str.charAt(i-1));
//				}
//			}
//		}
		
		int[] arr = {2, 4, 6, 9, 10, 2, 5, 10};
		
		int largest = Integer.MIN_VALUE;
		int secontLargest = Integer.MAX_VALUE;
		
		for(int num:arr) {
			
			if(num>largest) {
				
				secontLargest = largest;
				largest = num;
//			}else {
//				
//				if(num>secontLargest && num!=largest) {
//					
//					secontLargest = num;
//				}
			}
		}
		System.out.println(secontLargest);

	}
	
}
