import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection 
{
	static Connection con;
	static String url="jdbc:mysql://localhost:3306/opddb";
	static String user="root";
	static String pass="root";
	public static Connection getDBConnection()
	{
	   try
	   {
		   Class.forName("com.mysql.jdbc.Driver");
		   con=DriverManager.getConnection(url,user,pass);
		
	   }
	   catch(ClassNotFoundException e)
	   {
		   
	   }
	   catch(SQLException e)
	   {
		   
	   }
	   return con;
	}

}
