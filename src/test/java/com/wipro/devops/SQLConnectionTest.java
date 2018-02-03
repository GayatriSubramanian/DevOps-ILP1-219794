package com.wipro.devops;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.wipro.devops.SQLConnection;

public class SQLConnectionTest {

	@Test
	public void testPreparedStatementPooling() throws Exception {
		Connection conn = SQLConnection.getConnection();
		assertNotNull(conn);
	}

}
