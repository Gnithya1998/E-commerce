package module_Java;



public class EncapsulationExample {
	
	private String name;
	private int adNum;
	private String city;
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		if(name==null) {
			
			System.out.println("Provide a valid name");
			throw new IllegalArgumentException();
		}
		
		this.name = name;
	}
	
	public int getAdNum() {
		
		return adNum;
	}
	
	public void setAdNum(int adNum) {
		
		this.adNum = adNum;
	}
	
	public String getCity() {
		
		return city;
	}
	
	public void setCity(String city) {
		
		this.city = city;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EncapsulationExample cap = new EncapsulationExample();
		
		cap.setName("Nikki");
		cap.setAdNum(30081998);
		cap.setCity("Chennai");
		
		System.out.println(cap.getName()+ " " + cap.getAdNum()+ " " + cap.getCity());
		

	}

}
