package com.wipro.devops.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import com.wipro.devops.LoginDemo;

public class LoginDemoTest extends Mockito {

	@Test
	public void LoginDemoTest_1() throws ServletException, IOException {
		LoginDemo loginDemo = new LoginDemo();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("username")).thenReturn("Rahulkumar");
		when(request.getParameter("password")).thenReturn("Rahulkumar");
		when(request.getParameter("register")).thenReturn("register");

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);

		when(response.getWriter()).thenReturn(writer);
		
		loginDemo.doPost(request, response);

		assertTrue(stringWriter.toString().contains("Username Already Exist"));

	}

	@Test
	public void LoginDemoTest_2() throws ServletException, IOException {
		LoginDemo loginDemo = new LoginDemo();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("username")).thenReturn("Rahulkumar");
		when(request.getParameter("password")).thenReturn("Rahulkumar");
		when(request.getParameter("login")).thenReturn("login");

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);

		when(response.getWriter()).thenReturn(writer);
		
		loginDemo.doPost(request, response);

		assertTrue(stringWriter.toString().contains("Login Successful"));

	}

}
