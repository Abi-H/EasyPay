package com.easypay.EasyPay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {

	private String dbUrl;
	private String uname;
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
			String sql = "SELECT username,password FROM users WHERE email=? AND password=?";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
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
			String sql = "SELECT date, amount FROM transactions WHERE email=?";

			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, username);

			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				fields.add(rs.getDate("date").toString());
				fields.add(rs.getBigDecimal("amount").toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateBalance(int cardID, double amount) {

	}

	public ArrayList<String> getFields() {
		return fields;
	}

	public void addUser(int cardID, String email, String password, String firstName, String lastName) {
	    double balance = 0;
		String sql = "INSERT INTO users(cardID, email, password, firstName, lastName, balance) VALUES (?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, cardID);
			preparedStmt.setString(2, email);
			preparedStmt.setString(3, password);
			preparedStmt.setString(4, firstName);
			preparedStmt.setString(5, lastName);
			preparedStmt.setDouble(6, balance);
			
			preparedStmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
