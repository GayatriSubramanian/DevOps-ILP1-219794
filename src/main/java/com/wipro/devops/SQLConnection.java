package com.wipro.devops;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindemo", "root", "1234");
		return conn;
	}
}
