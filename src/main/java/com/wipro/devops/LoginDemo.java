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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("login") != null) {

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindemo", "root", "1234");

				PreparedStatement query = conn.prepareStatement(
						"SELECT db_username,db_password FROM logintable WHERE db_username=? AND db_password=?");
				query.setString(1, username);
				query.setString(2, password);

				ResultSet resultSetQuery = query.executeQuery();

				if (resultSetQuery.next()) {
					out.println("Correct login credentials");
				} else {
					
					out.println("Incorrect Username Or Password Entered.. Please Try Again!!");

/*					PreparedStatement post = conn
							.prepareStatement("INSERT INTO logintable (db_username,db_password) VALUES ('" + username
									+ "' , '" + password + "')");

					int resultSetPost = post.executeUpdate();

					if (resultSetPost == 1) {
						out.println("User Does not Exist and added!!");

					}*/

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("changepassword") != null) {
			
/*			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Page Under Construction");*/
			
			response.sendRedirect("index2.jsp");

		}
	}
}
