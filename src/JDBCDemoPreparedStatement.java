
/*
 * check the notes for more description on preparedstatement dec 6th video "Notes.java" file
*/
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemoPreparedStatement{

	
	public static void main(String[] args) throws SQLException
	{
		Scanner User_Input = new Scanner(System.in);
		String first_name;
		first_name = User_Input.next();
		String last_name;
		last_name = User_Input.next();
		String email;
		email = User_Input.next();
		String street;
		street = User_Input.next();
		String state;
		state = User_Input.next();
		int zip;
		zip = User_Input.nextInt();
		int phone;
		phone = User_Input.nextInt();
		String sex;
		sex = User_Input.next();
		int lunch_cost;
		lunch_cost = User_Input.nextInt();
		int Student_id;
		Student_id = User_Input.nextInt();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//registering driver
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3","root", "hello"); 
		
		PreparedStatement ps = conn.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?,?");
		ps.setString(1, first_name);
		ps.setString(2, last_name);
		ps.setString(3, email);
		ps.setString(4,street);
		ps.setString(5, state);
		ps.setInt(5, zip);
		ps.setInt(6, phone);
		ps.setString(7, sex);
		ps.setInt(8, lunch_cost);
		ps.setInt(9, Student_id);
		
		int res = ps.executeUpdate();
		if (res==0)
				{
			System.out.println("data has not been updated");
				}else{
					System.out.println("data has been inserter");
				}
		ps.close();
		conn.close();
		User_Input.close();
	}
}