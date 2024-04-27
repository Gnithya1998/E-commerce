package module_Java;

public class TryCatchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 20;
		int b = 0;
		
		try {
			
			int sum = a/b;
			System.out.println("Sum: " + sum);
		}catch(ArithmeticException ae) {
			
			System.out.println("An aritheatic exception has occured");
		}
		catch (Exception e) {
			
			System.out.println("An error/exception has occured");
		}
		finally {
			
			System.out.println("The code has finally executed");
		}

	}

}
