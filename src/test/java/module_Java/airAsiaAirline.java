package module_Java;

public class airAsiaAirline extends airCraftDesign{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		airCraftDesign air = new airAsiaAirline();
		air.engineGuidelines();
		air.saftyGuidelines();
		air.bodyColor();

	}

	@Override
	public void bodyColor() {
		// TODO Auto-generated method stub
		System.out.println("Red is the body of the color");
		
	}

}
