package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestTasks {
	
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
		pageMain.clickOnProjectsList();
		PageProject pageProject = PageFactory.initElements(driver, PageProject.class);
		pageProject.clickOnProject("PROJET_TEST1");
		pageMain.testProjectTasks();
		pageMain.createTask("Tache1-P1", "5");
		pageMain.createTask("Tache2-P1", "10");
		pageMain.createTask("Tache3-P1", "20");
		pageMain.createTask("Tache4-P1", "8");
	}

}
