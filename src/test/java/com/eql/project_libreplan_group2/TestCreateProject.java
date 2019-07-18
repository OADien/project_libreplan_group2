package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestCreateProject {
	
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
	public void test() throws Exception {
		
		
		PageMain pageMain = Utils.login(driver);
		pageMain.createProject(driver);
		pageMain.testModal();
		pageMain.fillForm();
	}

}
