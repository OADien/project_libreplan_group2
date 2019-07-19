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
		pageMain.testProjectsListsDisplay();
		pageMain.createTask("Tache1-P1", "5");
		pageMain.createTask("Tache2-P1", "10");
		pageMain.createTask("Tache3-P1", "20");
		pageMain.createTask("Tache4-P1", "8");
		pageMain.checkTasksList("Tache1-P1","Tache2-P1","Tache3-P1","Tache4-P1");
		pageMain.moveTaskDown("Tache1-P1");
		Thread.sleep(200);
		pageMain.checkTasksList("Tache2-P1","Tache1-P1","Tache3-P1","Tache4-P1");
		pageMain.moveTaskUp("Tache3-P1");
		Thread.sleep(200);
		pageMain.checkTasksList("Tache2-P1","Tache3-P1","Tache1-P1","Tache4-P1");
		pageMain.editTask("Tache1-P1", "T1", 5, null);
		Thread.sleep(200);
		pageMain.editTask("Tache2-P1", "T2", 8, null);
		Thread.sleep(200);
		pageMain.editTask("Tache3-P1", "T3", null, 3);
		Thread.sleep(200);
		pageMain.editTask("Tache4-P1", "T4", null, 5);
		Thread.sleep(200);
		pageMain.saveProject();
		PageTasks pageTasks = pageMain.gotoProjectPlanning(driver);
		pageTasks.test();
	}

}
