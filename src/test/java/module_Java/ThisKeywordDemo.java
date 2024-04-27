package module_Java;

public class ThisKeywordDemo {
	
	int num = 2;
	
	public void sumData() {
		
		int num = 3;
		int sum = num + this.num;
		System.out.println(sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThisKeywordDemo k = new ThisKeywordDemo();
		k.sumData();
	}

}
