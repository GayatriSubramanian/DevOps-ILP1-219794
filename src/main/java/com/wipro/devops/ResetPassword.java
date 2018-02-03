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

public class ResetPassword extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("submit") != null) {

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String newpassword = request.getParameter("newpassword");
			String confirmnewpassword = request.getParameter("confirmnewpassword");
			try {
				Connection conn = SQLConnection.getConnection();
				
				PreparedStatement query = conn
						.prepareStatement("SELECT db_username FROM logintable WHERE db_username=? ");
				query.setString(1, username);

				ResultSet resultSetQuery = query.executeQuery();

				if (resultSetQuery.next()) {
					if (newpassword.equals(confirmnewpassword)) {
						PreparedStatement update = conn
								.prepareStatement("UPDATE logintable SET db_password = ? where db_username = ?");

						update.setString(1, newpassword);
						update.setString(2, username);

						int resultSetPost = update.executeUpdate();

						if (resultSetPost == 1) {
							out.println("Password Reset Successfully !!");
						} else {
							out.println("Password Reset Failed !!");

						}
					} else {
						out.println("New and Confirm Password Does Not Match!!");
					}
				} else {
					out.println("Username Does Not Exist.. Please Try Again!!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
