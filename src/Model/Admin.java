package Model;

import java.sql.*;
import java.util.ArrayList;

import Controller.DBConnection;

public class Admin {

	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int id;
	private String adminname;
	private String password;
	
	public Admin() {}
	
	public Admin(int id, String adminname, String password) {
		
		this.id = id;
		this.adminname = adminname;
		this.password = password;
	
	}
	

	
	//Admin İşlemleri
	
	public boolean updateAdmin(int ID, String kAdi, String Sifre) throws SQLException{
		String query = "UPDATE admin SET kAdi=?, Sifre=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kAdi);
			preparedStatement.setString(2, Sifre);
			preparedStatement.setInt(3, ID);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}	
	}
	
	
	//SÄ°NEMA Ä°Å�LEMLERÄ°

	
	public boolean addSinema(String sinemaAdi,String Tarih,String Saat, String Salon) throws SQLException{
		String query = "INSERT INTO sinema" + "(sinemaAdi,Tarih,Saat,Salon) VALUES" + "(?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, sinemaAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteSinema(int ID) throws SQLException{
		String query = "DELETE FROM sinema WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, ID);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}	
	}
	
	public boolean updateFilm(int ID, String sinemaAdi, String Tarih, String Saat, String Salon) throws SQLException{
		String query = "UPDATE admin SET sinemaAdi=?, Tarih=?, Saat=?, Salon=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, sinemaAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
			preparedStatement.setInt(5, ID);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}	
	}
	public ArrayList<User> getUserList() throws SQLException{
		ArrayList<User> list = new ArrayList<>();
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				obj = new User(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("username"), rs.getString("password"), rs.getString("Mail"));
				list.add(obj);
			} 	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	public boolean addUser(String UserName, String Password) throws SQLException{
		int key = 0;
		boolean duplicate = false;
		String query = "INSERT INTO user" + "(kAdi, Sifre) VALUES" + "(?,?)";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE kAdi = '" + UserName +  "'");
			while (rs.next()) {
				duplicate = true;
				break;
			}
			
			if (!duplicate) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, UserName);
				preparedStatement.setString(2, Password);
				
				
				preparedStatement.executeUpdate();
				key = 1;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (key==1) {
			return true;
		} else {
			return false;
		}	
	}
	
	
	public boolean deleteUser(int ID) throws SQLException{
		String query = "DELETE FROM user WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, ID);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public boolean updateUser(int ID,String UserName, String Password) throws SQLException{
		String query = "UPDATE user SET UserName=?, Password=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, UserName);
			preparedStatement.setString(2, Password);
			preparedStatement.setInt(3, ID);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}	
	}
	
	
	
	

}
