package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestQualityFormManagement {

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
		pageMain.clickMenu(driver, "Ressources", "Formulaires qualité");
		PageQualityFormManagement pqfm = PageFactory.initElements(driver, PageQualityFormManagement.class);
		pqfm.test();
		PageCreateUpdateQualityForm pcuqf = pqfm.clickOnCreate(driver);
		pcuqf.test();
		String name = "Formulaire Test 1";
		//bug if reportProgression = true
		pcuqf.fillForm(name, name, "par pourcentage", false);
		pcuqf.clickOnCreateNewElement();
		String element1 = "Formulaire - Element 1";
		pcuqf.fillFormCreateNewElement(0, element1, "20");
		pcuqf.clickOnCreateNewElement();
		pcuqf.checkPosition(1, "2");
		String element2 = "Formulaire - Element 2";
		pcuqf.fillFormCreateNewElement(0, element2, "40");
		pcuqf.doubleClickReportProgression();
		int inexElement1 = 0;
		int inexElement2 = 1;
		pcuqf.checkItemIndex(element1, inexElement1);
		pcuqf.checkItemIndex(element2, inexElement2);
		pcuqf.checkPosition(inexElement1, "1");
		pcuqf.checkPosition(inexElement2, "2");
		pcuqf.clickOnSaveandContinue();
		pcuqf.checkQualityForm(name);
		pqfm = pcuqf.clickOnCancel(driver);
		pqfm.checkQualityForm(name);
		pcuqf = pqfm.clickOnQualityFormName(driver, name);
		pcuqf.checkPageTitle(name);
		pcuqf.setType("par élément");
		pcuqf.clickOnSave(driver);
	}

}
