package com.easypay.EasyPay;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * JUnit test of the Java functionality of dashboard.jsp
 */

public class DashboardTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPrintHistory() throws ClassNotFoundException, SQLException {

		DummyDatabase db = new DummyDatabase();
		ArrayList<String> fields = db.getHistory(12345678);

		for (int i = 0; i < fields.size(); i++) {
			System.out.println("Amount:" + fields.get(i++));
			System.out.println("Location: " + fields.get(i++));
			System.out.println("Date: " + fields.get(i++));
			System.out.println("Time: " + fields.get(i++));
		}
	}

	@Test
	public void testGetbalance() {

		try {
			DummyDatabase db = new DummyDatabase();
			String username = "test@test.com";
			assertNotEquals("FAIL", db.getBalance(username));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGetCardID() throws ClassNotFoundException, SQLException {
		DummyDatabase db = new DummyDatabase();
		String validUsername = "test@test.com";
		String invalidUsername = "invalid@test.com";
		
		assertNotNull(db.getCardId(validUsername));
		assertNull(db.getCardId(invalidUsername));
	}
}
