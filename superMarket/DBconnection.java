package superMarket;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.xdevapi.Statement;

public class DBconnection{
	public static void dbConnection() throws Exception {
		
		String url="jdbc:mysql://localhost:3306/supermarket";
		String uname="collectionadmin";
		String pass="collectionadmin";
		String query="select * from items";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
		System.out.println("DataBase Connected");
		Statement st=(Statement) con.createStatement();
		
	}
	
}
