package DAO;
import java.sql.*;

import Beans.ProductBean;
import DBInfo.DBConnection;
public class UpdateAndDeleteDAO 
{
	public int UpdateStack(ProductBean pb,int qty)
	{
		int k=0;
		try {
			Connection con=DAO.DBConnection.getDBconnection();
			PreparedStatement ps=con.prepareStatement("Update product55 set pqty=? where pcode=?");
			ps.setString(2, pb.getCode());
			ps.setInt(1, (pb.getQty()- qty));
			k=ps.executeUpdate();
		} 
		catch (Exception e) {
			
		}
		return k;
	}

}