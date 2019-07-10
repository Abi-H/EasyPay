package com.easypay.EasyPay;

import static org.junit.Assert.*;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
	
	DummyDatabase instance;
	
	public DatabaseTest() {
		
	}

	@Before
	public void setUp() throws Exception {
		instance = new DummyDatabase();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void testCheckCredentials() throws ClassNotFoundException, SQLException {
		instance = new DummyDatabase();
		
		String usernameTrue = "test@test.com";
		String passwordTrue = "test";
		String usernameFalse = "false@test.com";
		String passwordFalse = "false";
				
		assertTrue(instance.checkCredentials(usernameTrue, passwordTrue));
		assertFalse(instance.checkCredentials(usernameFalse, passwordFalse));
		assertFalse(instance.checkCredentials(usernameTrue, passwordFalse));
		assertFalse(instance.checkCredentials(usernameFalse, passwordTrue));
	}
	
	@Test
	public void isClosed() {
		assertNotNull(instance.isClosed());
	}

}
