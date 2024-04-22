package module_Java;

public class Nestedloop_Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k = 3;
		for(int i=1; i<=4; i++) {
			
			for(int j=1; j<i+1; j++) {
				
				System.out.print(k);
				System.out.print("\t");
				k += 3;
			}
			
			System.out.println();
		}

	}

}
