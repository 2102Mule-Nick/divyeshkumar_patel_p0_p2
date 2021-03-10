package com.bank.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.util.ConnectionFactoryPostgres;

class ConnectionFactoryTest {

	@BeforeEach
	private void setUp() {
		
	}
	
	@Test
	void test() {
	assertNotNull(ConnectionFactoryPostgres.getConnection(),"Connection to DB must be created");
	}

}
