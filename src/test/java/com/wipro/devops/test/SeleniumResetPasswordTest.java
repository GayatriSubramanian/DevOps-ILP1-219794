package com.wipro.devops.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumResetPasswordTest extends Mockito {

	@Before
	public void Setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Rahul\\Selenium\\geckodriver.exe");
	}

	@Test
	public void SeleniumTest_1() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/DevOps-ILP1-219794/ResetPassword.jsp");
		driver.findElement(By.name("username")).sendKeys("Rahulkumar");
		driver.findElement(By.name("newpassword")).sendKeys("Rahulkumar");
		driver.findElement(By.name("confirmnewpassword")).sendKeys("Rahulkumar");
		driver.findElement(By.name("submit")).click();

		System.out.println("Response: " + driver.getPageSource());
		assertTrue(driver.getPageSource().contains("Password Reset Successfully"));

		driver.quit();
	}

	@Test
	public void SeleniumTest_2() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/DevOps-ILP1-219794/ResetPassword.jsp");
		driver.findElement(By.name("username")).sendKeys("Rahul@Wipro");
		driver.findElement(By.name("newpassword")).sendKeys("Rahulkumar");
		driver.findElement(By.name("confirmnewpassword")).sendKeys("Rahulkumar");
		driver.findElement(By.name("submit")).click();

		System.out.println("Response: " + driver.getPageSource());
		assertTrue(driver.getPageSource().contains("Username Does Not Exist"));

		driver.quit();
	}

	@Test
	public void SeleniumTest_3() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/DevOps-ILP1-219794/ResetPassword.jsp");
		driver.findElement(By.name("username")).sendKeys("Rahulkumar");
		driver.findElement(By.name("newpassword")).sendKeys("Rahulkumar");
		driver.findElement(By.name("confirmnewpassword")).sendKeys("Rahulkumar1");
		driver.findElement(By.name("submit")).click();

		System.out.println("Response: " + driver.getPageSource());
		assertTrue(driver.getPageSource().contains("New and Confirm Password Does Not Match"));

		driver.quit();
	}

}
