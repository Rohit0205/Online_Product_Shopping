package DAO;
import java.sql.*;

import DBInfo.DBConnection;
public class DeleteProductDAO 
{
	public int delete(String code)
	{
		int k=0;
		try {
			Connection con =DAO.DBConnection.getDBconnection();
			PreparedStatement ps=con.prepareStatement("Delete from Product55 where pcode=?");
			ps.setString(1, code);
			 k = ps.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
