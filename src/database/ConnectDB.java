package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB{
	public static Connection getConnection()
	{
		Connection conn = null;
		
		//đăng ký với DriverManager
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//thông tin databse
		String url = "jdbc:mySQL://localhost:3306/web";
		String username = "root";
		String password = "";
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void close(Connection conn)
	{
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}