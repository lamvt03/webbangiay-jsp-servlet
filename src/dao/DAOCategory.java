package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import model.Category;

public class DAOCategory {
	public static List<Category> getAllCategories(){
		List<Category> list = new ArrayList<Category>();
		
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM category";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
				list.add(new Category(rs.getInt(1),
						rs.getString(2)));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	
}
