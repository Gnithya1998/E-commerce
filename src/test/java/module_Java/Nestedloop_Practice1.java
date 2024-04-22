package module_Java;

public class Nestedloop_Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 1;
		
		for(int i=4; i>0; i--) {
			
			for(int j = 1; j<=i; j++) {
				
				System.out.print(n);
				n++;
				
			}
			System.out.println();
			
		} 
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		int k =1;
		
		for(int i=0; i<4; i++) {
			
			for(int j=1; j<=4-i; j++) {
				
				System.out.print(k);
				k++;
				
			}
			System.out.println();
		}

	}

}
