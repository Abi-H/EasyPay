package com.easypay.EasyPay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {

	String dbUrl;
	String uname;
	String password;
	Connection conn;
	ArrayList<String> fields;

	public Database() throws ClassNotFoundException, SQLException {
		this.dbUrl = "jdbc:mysql://localhost:3306/easypay";
		this.uname = "root";
		this.password = "";
		fields = new ArrayList<>();
		conn = DriverManager.getConnection(dbUrl, uname, password);	
	}

	public boolean checkCredentials(String user, String pass) {
		try {
			PreparedStatement preparedStmt = conn.prepareStatement("SELECT username,password FROM users WHERE username=? AND password=?");
			preparedStmt.setString(1, user);
			preparedStmt.setString(2, pass);
			
			ResultSet rs = preparedStmt.executeQuery();

			if (rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;	
	}
	
	public void getHistory(String username) {
		try {
			ArrayList<String> fields = new ArrayList<>();
			String sql = "SELECT date, amount FROM transactions WHERE username=?";	
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);			
			preparedStmt.setString(1, username);
			
			ResultSet rs = preparedStmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getFields() {
		return fields;
	}
}

