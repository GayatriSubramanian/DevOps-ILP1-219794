package com.wipro.devops;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("register") != null) {

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				Connection conn = SQLConnection.getConnection();
				PreparedStatement query = conn
						.prepareStatement("SELECT db_username FROM logintable WHERE db_username=? ");
				query.setString(1, username);
				ResultSet resultSetQuery = query.executeQuery();

				if (!resultSetQuery.next()) {
					PreparedStatement post = conn
							.prepareStatement("INSERT INTO logintable (db_username,db_password) VALUES ('" + username
									+ "' , '" + password + "')");

					int resultSetPost = post.executeUpdate();

					if (resultSetPost == 1) {
						out.println("Registered Successfully !!");
					} else {
						out.println("Registration Failed... Please Try Again !!");
					}
				} else {
					out.println("Username Already Exist !!");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("login") != null) {

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				Connection conn = SQLConnection.getConnection();

				PreparedStatement query = conn.prepareStatement(
						"SELECT db_username,db_password FROM logintable WHERE db_username=? AND db_password=?");
				query.setString(1, username);
				query.setString(2, password);

				ResultSet resultSetQuery = query.executeQuery();

				if (resultSetQuery.next()) {
					out.println("Login Successful !!");
				} else {
					out.println("Incorrect Username Or Password Entered.. Please Try Again !!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("resetpassword") != null) {
			response.sendRedirect("ResetPassword.jsp");
		}
	}
}
