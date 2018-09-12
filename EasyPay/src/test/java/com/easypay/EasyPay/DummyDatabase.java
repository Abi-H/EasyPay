package com.easypay.EasyPay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DummyDatabase extends Database {

	private String dbUrl;
	private String uname;
	private String password;
	private Connection conn;
	private PreparedStatement preparedStmt;
	
	public DummyDatabase() throws ClassNotFoundException, SQLException {
		super();	
		this.dbUrl = "jdbc:mysql://localhost:3306/easypay";
		this.uname = "root";
		this.password = "";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dbUrl, uname, password);
	}
	
	@Override
	public boolean checkCredentials(String user, String pass) {
		try {
			String sql = "SELECT username,password FROM test_users WHERE username=? AND password=?";
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, user);
			preparedStmt.setString(2, pass);

			ResultSet rs = preparedStmt.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}
	
	@Override
	public String getCardId(String username) {
		String sql = "SELECT cardID FROM test_users WHERE username=?";

		try {
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, username);
			ResultSet rs = preparedStmt.executeQuery();

			if (rs.next()) {
				String result = rs.getString("cardID");
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	@Override
	public String getBalance(String username) {
		String sql = "SELECT balance FROM test_users WHERE username=?";

		try {
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, username);
			ResultSet rs = preparedStmt.executeQuery();

			if (rs.next()) {
				Double result = rs.getDouble("balance");
				String roundedResult = String.format("%.2f", result);
				return roundedResult;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "FAIL";
	}
	
	@Override
	public boolean checkExistingAccount(String username, int cardID) {
		String sql = "SELECT cardID, username FROM test_users WHERE cardID=? OR username=?";

		try {
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, username);
			preparedStmt.setInt(2, cardID);

			ResultSet rs = preparedStmt.executeQuery();

			if (rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@Override
	public ArrayList<String> getHistory(int cardID) {

		ArrayList<String> fields = new ArrayList<>();

		String sql = "SELECT * FROM test_history WHERE cardID=?";

		try {
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, cardID);

			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				fields.add(rs.getString(2));
				fields.add(rs.getString(3));
				fields.add(rs.getDate(4).toString());
				fields.add(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				preparedStmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fields;
	}
}
