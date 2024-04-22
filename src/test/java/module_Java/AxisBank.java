package module_Java;

public class AxisBank implements BankIntrest, BankFixedDeposite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankIntrest obj = new AxisBank();
		obj.interestOfHomeLoan();
		obj.interestOfCarLoan();
		
		AxisBank axisBank = new AxisBank();
		axisBank.intrestOfMedicalLoan();
		
		BankFixedDeposite obj2 = new AxisBank();
		obj2.fixedDepositeIntrest();
		
		
		

	}

	@Override
	public void interestOfHomeLoan() {
		// TODO Auto-generated method stub
		System.out.println("Home loan intrest");
		
	}

	@Override
	public void interestOfCarLoan() {
		// TODO Auto-generated method stub
		System.out.println("Car loan intrest");
		
	}

	@Override
	public void interestOfPerdonalLoan() {
		// TODO Auto-generated method stub
		System.out.println("Personal loan intrest");
		
	}

	@Override
	public void interestOfStudentLoan() {
		// TODO Auto-generated method stub
		System.out.println("Student loan intrest");
		
	}

	@Override
	public void interestOfGoldLoan() {
		// TODO Auto-generated method stub
		System.out.println("Gold loan intrest");
		
	}
	
	public void intrestOfMedicalLoan() {
		
		System.out.println("Medical loan intrest");
	}

	@Override
	public void fixedDepositeIntrest() {
		// TODO Auto-generated method stub
		System.out.println("Fixed deposite Intrest");
	}

}
