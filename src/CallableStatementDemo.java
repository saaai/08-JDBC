

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.jdbc.CallableStatement;

public class CallableStatementDemo 
{
	public static void main (String[] args) throws SQLException
	{
		//from here to line 22 "connection conn this code is used to connect with mysql database.
		try {
			Class.forName("com.mysql.jdbc.Driver");//registering driver
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3","root", "hello"); 
		CallableStatement cstmt = (CallableStatement) conn.prepareCall("{call myproc(?,?)}");
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.setInt(1, 5);
		cstmt.executeUpdate();
		System.out.println("Inceremented score by: " +cstmt.getInt(2));
		conn.close();
		

	}

}
