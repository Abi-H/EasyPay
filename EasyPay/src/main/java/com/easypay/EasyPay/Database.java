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
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dbUrl, uname, password);
	}

	public boolean checkCredentials(String user, String pass) {
		try {
			String sql = "SELECT username,password FROM users WHERE username=? AND password=?";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
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
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public ArrayList<String> getHistory(int cardID) {

		ArrayList<String> fields = new ArrayList<>();
		String sql = "SELECT amount, location, date, time FROM history WHERE cardID=?";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, cardID);

			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {				
				double amount = rs.getDouble("amount");
				String amountString = String.valueOf(amount);
				fields.add(rs.getString(amountString));
				fields.add(rs.getString("location"));
				fields.add(rs.getString("location").toString());
				fields.add(rs.getDate("date").toString());
				fields.add(rs.getString("time"));				
			}

			System.out.println("Retrieved history.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fields;
	}

//	public void updateBalance(int cardID, double amount) {
	public void updateBalance(String username, double amount) {
//		String sql = "SELECT balance FROM users WHERE cardID = ?";
		String sql = "SELECT balance FROM user WHERE username= = ?";
		double updatedBalance;

		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
//			preparedStmt.setInt(1, cardID);
			preparedStmt.setString(1, username);

			ResultSet rs = preparedStmt.executeQuery();

			if (rs.next()) {
				updatedBalance = rs.getDouble("balance");
				updatedBalance += amount;
//				sql = "UPDATE users SET balance = ? WHERE cardID = ?";
				sql = "UPDATE user SET balance =? WHERE username = ?";

				preparedStmt = conn.prepareStatement(sql);
				preparedStmt.setDouble(1, updatedBalance);
//				preparedStmt.setInt(2, cardID);
				preparedStmt.setString(2,  username);
				preparedStmt.executeUpdate();
				System.out.println("Updated balance.");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

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

			preparedStmt.executeUpdate();
			System.out.println("Added user.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public String getCardId(String username) {
		String sql = "SELECT cardID FROM users WHERE username=?";

		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, username);
			ResultSet rs = preparedStmt.executeQuery();

			if (rs.next()) {
				String result = rs.getString("cardID");
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public String getBalance(String username) {
		String sql = "SELECT balance FROM users WHERE username=?";
		
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, username);
			ResultSet rs = preparedStmt.executeQuery();
			
			if(rs.next()) {
				Double result = rs.getDouble("balance");
				String roundedResult = String.format("%.2f", result);
				return roundedResult;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}

	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isClosed(Connection conn) {
		if (conn != null) {
			return false;
		}

		return true;
	}
}
