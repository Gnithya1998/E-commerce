package module_Java;

import net.bytebuddy.implementation.bind.annotation.Super;

public class ChildSuperClass extends ParentSuperClass{
	
	String name = "Child name";
	
	public ChildSuperClass() {
		
		super();
		System.out.println("Child class constructor");
	}
	
	public void getAddress() {
		
		System.out.println("Child method address");
		super.getAddress();
	}
	
	public void getNameData() {
		
		System.out.println(name);
		System.out.println(super.name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChildSuperClass cd = new ChildSuperClass();	
		cd.getNameData();
		cd.getAddress();
		

	}

}
