package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con;
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	public static Connection getDBconnection()
	{
		return con;
	}
}
