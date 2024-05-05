package module_Selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql_Selenium {

	public static void main(String[] args) throws SQLException {
		
		String host = "localhost";
		int port = 3306;

		Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root",
				"Bashaa@1998");

		java.sql.Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery("select * from fruits where name = 'Banana';");

		while (rSet.next()) {
			System.out.println((rSet.getString("color")));
		}

	}

}
