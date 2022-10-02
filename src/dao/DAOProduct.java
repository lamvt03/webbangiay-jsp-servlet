package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import database.ConnectDB;
import model.Product;

public class DAOProduct {
	public static List<Product> getAllProducts(){
		List<Product> list = new ArrayList<>();
		
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM product";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5)));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	public static List<Product> getAllProductsByCateID(String id){
		List<Product> list = new ArrayList<>();
		
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM product WHERE cateID = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5)));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	public static Product getProductsByID(String id){
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM product WHERE id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
				return new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return null;
	}
	public static Product getLastProduct() {
		
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM product ORDER BY id DESC LIMIT 1";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
				return new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return null;
	}
	public static List<Product> getProductsBySearchInput(String inpTxt){
		List<Product> list = new ArrayList<>();
		
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * " + 
				"FROM product p " + 
				"WHERE " + 
				"p.title LIKE ? " + 
				"OR " + 
				"p.description LIKE ?";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+inpTxt+"%");
			pstm.setString(2, "%"+inpTxt+"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5)));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	public static void main(String[] args) {
		List<Product> list = DAOProduct.getProductsBySearchInput("jordan");
		for(Product p : list)
			System.out.println(p.toString());
	}
}
