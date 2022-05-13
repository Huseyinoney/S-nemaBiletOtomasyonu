package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.DBConnection;

public class User {

	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	
	private int id;
	private String ad;
	private String soyad;
	private String username;
	private String password;
	private String mail;
	
	public User () {} //constructor
	
	public User(int id, String ad, String soyad, String username, String password, String mail) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.username = username;
		this.password = password;
		this.mail = mail;
		
	}

	public int getId() {
		return id;
	}
	
	public String getAd() {
		return ad;
	}
	
	public String getSoyad() {
		return soyad;
	}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public ArrayList<Film> getFilmList() throws SQLException{
		ArrayList<Film> list = new ArrayList<>();
		Film obj;

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM film");
			while (rs.next()) {
				obj = new Film(rs.getInt("FilmId"),rs.getString("filmName"),rs.getString("type"),rs.getString("image"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
	public boolean changeUserpassword(String username, String password) throws SQLException{
		String query = "UPDATE user SET password=? WHERE username=?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, username);
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

