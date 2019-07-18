package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestLogin2 {

	private WebDriver driver;

	@Before
	public void init() {
		driver = Utils.chooseBrowser("chrome");
	}

	// @After
	public void quit() {
		driver.quit();
	}

	@Test
	public void testLogin() {
		PageCalendar pageCalendar = Utils.login(driver);
	}

}
