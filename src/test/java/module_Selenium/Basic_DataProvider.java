package module_Selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.sym.Name;

public class Basic_DataProvider {
	
	@Test(dataProvider="data")
	public void getData(String mood, String handle, String visit) {
		
		System.out.println(mood + " " + handle + " " + visit);
	}
	
	
	
	@DataProvider(name = "data")
	public Object[][] setData() {
		
		Object[][] data = {{"Like", "Instagram", "10"},{"Hate", "Facebook", "1"}, {"Love", "Youtube", "23"}};
		return data;
	}

}
