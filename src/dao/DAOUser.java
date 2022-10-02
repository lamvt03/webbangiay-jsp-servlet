package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectDB;
import model.User;

public class DAOUser {
	public static User findUserByUsernameAndPassword(String username, String password) {
		Connection conn = ConnectDB.getConnection();
		
		String sql = "SELECT *\r\n" + 
				"FROM _user\r\n" + 
				"WHERE _username = ?\r\n" + 
				"AND _password = ?";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			
			ResultSet rs  = pstm.executeQuery();
			if(rs.next())
				return new User(rs.getString(1)
							, rs.getString(2)
							,rs.getBoolean(3)
							,rs.getBoolean(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return null;
	}
	public static boolean isAvailableUsername(String username) {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT _username\r\n" + 
				"FROM _user\r\n" + 
				"WHERE _username = ? ;" ;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			ResultSet rs = pstm.executeQuery();
			
			//nếu resultset rỗng => chưa có người dùng mang username này
			if(rs.next() == false)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return true;
	}
	public static void insertUser(User u) {
		Connection conn = ConnectDB.getConnection();
		String sql = "INSERT INTO _user (_username, _password)\r\n" + 
					"VALUES (?, ?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,u.getUsername());
			pstm.setString(2, u.getPassword());
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
	}
	public static void main(String[] args) {
		System.out.println(DAOUser.findUserByUsernameAndPassword("tom", "123"));
	}
	
}
