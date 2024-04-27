package module_Java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
		
		Date date = new Date();
		
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("M/d/yyyy");
		SimpleDateFormat sd = new SimpleDateFormat("M/d/yyyy hh:mm:ss");
		System.out.println(sdFormat.format(date));
		System.out.println(sd.format(date));
				
	}

}
