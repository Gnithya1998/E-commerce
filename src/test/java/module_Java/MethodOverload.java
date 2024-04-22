package module_Java;

public class MethodOverload {

	public static void main(String[] args) {
		
		MethodOverload obj = new MethodOverload();
		obj.getData("Happiness");
		obj.getData(12, 13);
		obj.getData(5, "Number of mangoes is ");

	}
	
	public void getData(int a, int b) {
		
		System.out.println(a+b);
	}
	
	public void getData(String s) {
		
		System.out.println(s);
	}
	
	public void getData(int a, String s) {
		
		System.out.println(s + a);
	}

}
