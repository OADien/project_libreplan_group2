package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestDisplayPlanning {
	
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
		pageMain.testProjectsListsDisplay();
		PageTasks pageTasks = pageMain.gotoProjectPlanning(driver);
		pageTasks.test();
		String zoom = "Année";
		pageTasks.setZoom(zoom);
		zoom = "Trimestre";
		pageTasks.setZoom(zoom);
		pageTasks.checkQuarters();
		zoom = "Mois";
		pageTasks.setZoom(zoom);
		pageTasks.checkMonths();
	}

}
