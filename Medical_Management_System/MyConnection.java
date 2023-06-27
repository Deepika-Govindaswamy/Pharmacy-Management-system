package Medical_Management_System;

import java.sql.*;

public class MyConnection {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system", "deepu");
		
		return connection;
	}
}
