package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCreateMachine {
	
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
		pageMain.clickMenu(driver, "Ressources", "Machines");
		PageEngineManagement pem = PageFactory.initElements(driver, PageEngineManagement.class);
		pem.test();
		PageCreateUpdateEngine pcue = pem.clickOnCreate(driver);
		pcue.test();
		pcue.checkEngineData();
		String name="MACHINETEST1";
		pcue.fillForm(false, name, name, name, "Ressource normale");
		pcue.checkSavedMachine(name);
		pem = pcue.clickOnCancel(driver);
		pem.checkEngine(name, name, name);
	}

}
