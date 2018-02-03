package com.wipro.devops.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import com.wipro.devops.ResetPassword;

public class ResetPasswordTest extends Mockito {

	@Test
	public void ResetPasswordTest_1() throws ServletException, IOException {
		ResetPassword resetPassword = new ResetPassword();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("username")).thenReturn("Rahulkumar");
		when(request.getParameter("newpassword")).thenReturn("Rahulkumar");
		when(request.getParameter("confirmnewpassword")).thenReturn("Rahulkumar");
		when(request.getParameter("submit")).thenReturn("submit");

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);

		when(response.getWriter()).thenReturn(writer);

		resetPassword.doPost(request, response);

		assertTrue(stringWriter.toString().contains("Password Reset Successfully"));

	}

	@Test
	public void ResetPasswordTest_2() throws ServletException, IOException {
		ResetPassword resetPassword = new ResetPassword();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("username")).thenReturn("Rahul@Wipro");
		when(request.getParameter("newpassword")).thenReturn("Rahulkumar");
		when(request.getParameter("confirmnewpassword")).thenReturn("Rahulkumar");
		when(request.getParameter("submit")).thenReturn("submit");

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);

		when(response.getWriter()).thenReturn(writer);

		resetPassword.doPost(request, response);

		assertTrue(stringWriter.toString().contains("Username Does Not Exist"));

	}

	@Test
	public void ResetPasswordTest_3() throws ServletException, IOException {
		ResetPassword resetPassword = new ResetPassword();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("username")).thenReturn("Rahulkumar");
		when(request.getParameter("newpassword")).thenReturn("Rahulkumar");
		when(request.getParameter("confirmnewpassword")).thenReturn("Rahulkumar1");
		when(request.getParameter("submit")).thenReturn("submit");

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);

		when(response.getWriter()).thenReturn(writer);

		resetPassword.doPost(request, response);

		assertTrue(stringWriter.toString().contains("New and Confirm Password Does Not Match"));

	}

}
