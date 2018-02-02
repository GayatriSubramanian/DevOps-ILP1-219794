package com.wipro.devops;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindemo", "root", "1234");
			PreparedStatement pst = conn.prepareStatement(
					"Select db_username,db_password from logintable where db_username=? and db_password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				out.println("Correct login credentials");
			} else {
				out.println("Incorrect login credentials");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
