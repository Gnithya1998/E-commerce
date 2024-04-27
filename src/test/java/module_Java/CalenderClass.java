package module_Java;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderClass {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sd1 = new SimpleDateFormat("M/d/yyyy hh:mm:ss");
		System.out.println(sd1.format(cal.getTime()));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));

	}

}
