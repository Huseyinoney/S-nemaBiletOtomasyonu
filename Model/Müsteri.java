package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Controller.DBConnection;

public class M�steri extends User {

	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public M�steri(int id, String userName, String password) {
		super(id, userName, password);
		
	}

	//filmgöster eklenecek
	
	
}
