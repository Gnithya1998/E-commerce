package module_Java;

public class MinimumMatrix {
	
	public static void main(String args[]) {
		
		int[][] arr = {{2,1,7},{5,8,4},{3,7,5}};	
		int min = arr[0][0];
		int max = 0;
		int row = 0;
		int col = 0;
		
		for(int i =0; i<3; i++) {
			
			for(int j=0; j<3; j++) {
				
				if(arr[i][j]<min) {
					
					min = arr[i][j];
					row = i; 
					col = j;
				}		
			}
		}
		
		for(int i=0; i<3; i++) {
				
				if(arr[i][col]>max) {
					
					max = arr[i][col];
				}
		}
		
		System.out.println("Minimum: " + min);
		System.out.println("Maximum: " + max);
//		System.out.println(row);
//		System.out.println(col);
		
	}

}
