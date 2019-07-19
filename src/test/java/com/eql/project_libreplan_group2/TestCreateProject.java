package com.eql.project_libreplan_group2;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
		pageMain.clickMenu(driver, "Calendrier", "Projets");
		PageProject pageProject  = PageFactory.initElements(driver, PageProject.class);
		Date now = new Date();
		Date date = new Date(now.getYear(), now.getMonth(), now.getDate());
		Calendar cal  = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 5);
		date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 10);
		Date echeance = cal.getTime();
		pageProject.check("PROJET_TEST1", "PRJTEST001", date, echeance, "", "0 €", "0", "PRE-VENTES");
	}

}
