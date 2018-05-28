/*
 * check the notes for more description on preparedstatement dec 6th video "Notes.java" file
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	
	public static void main(String[] args) throws SQLException
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//registering driver
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3","root", "hello"); 
		
		/*//normal statement
		Statement stmt = conn.Statement();
		*/
		
		//prepared statement
		String query = "insert into classes values(?,?)";
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement(query);
		//here test3 is database name, saigopal is username and hello is password  
		
		/*//execute query1
		String query = "select * from classes";
		ResultSet rs= stmt.executeQuery(query);  
		while(rs.next())  
			System.out.println(rs.getString(1)+" \t "+rs.getInt(2));  */
		
		
		long beforeExec = System.currentTimeMillis();//for checking the time before execution.
		System.out.println(beforeExec);
		//execute query 2 
		for(int i=101;i<=200;i++)
		{
			/*String query = "insert into classes values('chemistry',"+i+")";
			stmt.executeUpdate(query);*/
			
			//passing prepared statement values
			pstmt.setString(1, "physics");
			pstmt.setInt(2,i);
			pstmt.executeUpdate();
			
		}
		long afterExec = System.currentTimeMillis();
		System.out.println(afterExec);
		
		System.out.println(afterExec - beforeExec);
		
		conn.close();  
		
	}
	
	

}

