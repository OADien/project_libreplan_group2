package com.eql.project_libreplan_group2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestLogin {
	
	private String url;
	private WebDriver driver;
	
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@After
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void testLogin() {
		driver.get(url);
		PageLogin pageLogin = PageFactory.initElements(driver, PageLogin.class);
		PageMain mainPage = pageLogin.login(driver, "admin", "admin");
	}

}
