package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestEstimatedHours {
	
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
		pageMain.clickMenu(driver, "Rapports", "Heures estimées/planifiées par tâche");
		PageEstimatedHours pageEstimatedHours = PageFactory.initElements(driver, PageEstimatedHours.class);
		pageEstimatedHours.checkBlocs();
		pageEstimatedHours.fillForm(driver, "PROJET_TEST1", "PDF");
	}

}
