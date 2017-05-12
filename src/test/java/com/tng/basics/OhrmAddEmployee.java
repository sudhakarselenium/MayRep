package com.tng.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OhrmAddEmployee {
	WebDriver driver;
	@BeforeClass
	public void OpenApplication(){
		//configure driver
		System.setProperty("webdriver.chrome.driver",
				"F:/SeleniumSoftware/BrowserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://opensource.demo.orangehrmlive.com/");		

	}
	
	@Test
	public void Login(){
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

	}
	@Test(dependsOnMethods="Login")
	public void AddEmployee(){
		driver.findElement(By.xpath("//a[.='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("hq");		
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();

	}
	@AfterClass
	public void CloseApplication(){
		driver.quit();
	}
}












