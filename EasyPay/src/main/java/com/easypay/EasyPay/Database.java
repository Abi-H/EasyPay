package com.easypay.EasyPay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	private String dbUrl;
	private String uname;
	private String password;
	private Connection conn;
	private PreparedStatement preparedStmt;

	public Database() throws ClassNotFoundException, SQLException {
		this.dbUrl = "jdbc:mysql://localhost:3306/easypay";
		this.uname = "root";
		this.password = "";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dbUrl, uname, password);
	}

	public boolean checkCredentials(String user, String pass) {
		try {
			String sql = "SELECT username,password FROM users WHERE username=? AND password=?";
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

	public ArrayList<String> getHistory(int cardID) {

		ArrayList<String> fields = new ArrayList<>();

		String sql = "SELECT * FROM history WHERE cardID=?";

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

	public void updateBalance(String username, double amount) {
		String sql = "SELECT balance FROM users WHERE username = ?";

		try {
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, username);

			ResultSet rs = preparedStmt.executeQuery();

			if (rs.next()) {
				double updatedBalance;
				updatedBalance = rs.getDouble("balance");
				updatedBalance += amount;

				sql = "UPDATE users SET balance=? WHERE username=?";

				preparedStmt = conn.prepareStatement(sql);
				preparedStmt.setDouble(1, updatedBalance);
				preparedStmt.setString(2, username);
				preparedStmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				preparedStmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void addUser(int cardID, String email, String password) {
		double balance = 0;
		String sql = "INSERT INTO users(cardID, email, password, balance) VALUES (?,?,?,?)";

		try {
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, cardID);
			preparedStmt.setString(2, email);
			preparedStmt.setString(3, password);
			preparedStmt.setDouble(6, balance);

			preparedStmt.executeUpdate();

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

	}

	public String getCardId(String username) {
		String sql = "SELECT cardID FROM users WHERE username=?";

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

	public String getBalance(String username) {
		String sql = "SELECT balance FROM users WHERE username=?";

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

	public boolean checkExistingAccount(String username, int cardID) {
		String sql = "SELECT cardID, username FROM users WHERE cardID=? OR username=?";

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

	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isClosed() {
		if (conn != null) {
			return false;
		}

		return true;
	}
}
