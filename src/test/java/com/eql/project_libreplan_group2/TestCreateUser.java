package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCreateUser {

	private WebDriver driver;

	@Before
	public void init() {
		driver = Utils.chooseBrowser("chrome");
	}

/*	// @After
	public void quit() {
		driver.quit();
	}
*/
	//@Test
	public void testLogin() {
		PageMain pageMain = Utils.login(driver);
	}
	
	@Test
	public void testSection() {
		PageMain pageMain = Utils.login(driver);
		pageMain.clickMenu(driver, "Ressources", "Participants");
	}
	
	@Test
	public void createUser() {
		Actions create = new Actions(driver);
		create.click();
		
}
}