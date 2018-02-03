package com.wipro.devops.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLoginDemoTest extends Mockito {

	@Before
	public void Setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Rahul\\Selenium\\geckodriver.exe");
	}

	@Test
	public void SeleniumTest_1() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/DevOps-ILP1-219794");
		driver.findElement(By.name("username")).sendKeys("Rahulkumar");
		driver.findElement(By.name("password")).sendKeys("Rahulkumar");
		driver.findElement(By.name("register")).click();

		System.out.println("Response: " + driver.getPageSource());
		assertTrue(driver.getPageSource().contains("Username Already Exist"));

		driver.quit();
	}

	@Test
	public void SeleniumTest_2() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/DevOps-ILP1-219794");
		driver.findElement(By.name("username")).sendKeys("Rahulkumar");
		driver.findElement(By.name("password")).sendKeys("Rahulkumar");
		driver.findElement(By.name("login")).click();

		System.out.println("Response: " + driver.getPageSource());
		assertTrue(driver.getPageSource().contains("Login Successful"));

		driver.quit();
	}
	
	@Test
	public void SeleniumTest_3() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/DevOps-ILP1-219794");
		driver.findElement(By.name("username")).sendKeys("Rahulkumar");
		driver.findElement(By.name("password")).sendKeys("Rahulkumar1");
		driver.findElement(By.name("login")).click();

		System.out.println("Response: " + driver.getPageSource());
		assertTrue(driver.getPageSource().contains("Incorrect Username Or Password Entered"));

		driver.quit();
	}

}
