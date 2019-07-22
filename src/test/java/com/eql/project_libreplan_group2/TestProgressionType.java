package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestProgressionType {

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
		pageMain.clickMenu(driver, "Ressources", "Types d'avancement");
		PageProgressionTypes ppt = PageFactory.initElements(driver, PageProgressionTypes.class);
		ppt.test();
		PageCreateUpdateProgressionType pcupt = ppt.clickOnCreate(driver);
		pcupt.test();

		String name = "Type avancement - Test 1";
		boolean isEnabled = false;
		boolean isPercentage = false;
		boolean isPredefined = false;
		pcupt.fillForm(name, isEnabled, "10,00", null, isPercentage);
		ppt = pcupt.clickOnSave(driver);
		ppt.checkProgressionType(name, isEnabled, isPredefined);

		pcupt = ppt.clickOnCreate(driver);
		name = "Type avancement - Test 2";
		isPercentage = true;
		pcupt.fillForm(name, null, null, null, isPercentage);
		pcupt.checkMaxValueDisabled();
		pcupt.clickOnSaveAndContinue();
		pcupt.checkProgressionTypeForm(name);
		ppt = pcupt.clickOnCancel(driver);
		ppt.checkProgressionType(name, true, isPredefined);
	}

}
