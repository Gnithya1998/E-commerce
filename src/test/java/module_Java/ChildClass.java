package module_Java;

import java.util.Arrays;

public class ChildClass extends ParentClass{

	public static void main(String[] args) {
		
		//ChildClass obj = new ChildClass();
		ParentClass obj = new ParentClass();
		
		obj.wheel();
	//	obj.backCamera();
		obj.colour();
		
		

	}
	
	public void backCamera() {
		
		System.out.println("Back camera for parking is present");
	}
	
	public void colour() {
		
		System.out.println("Colour of the car is nightly black");
	}

}
