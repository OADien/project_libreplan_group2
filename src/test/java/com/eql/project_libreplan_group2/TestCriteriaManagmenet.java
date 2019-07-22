package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCriteriaManagmenet {

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
		pageMain.clickMenu(driver, "Ressources", "Critère");
		PageCriteriaManagement pcm = PageFactory.initElements(driver, PageCriteriaManagement.class);
		pcm.test();
		PageCreateUpdateCriterium pcuc = pcm.clickOnCreate(driver);
		pcuc.test();
		String name = "Test bouton [Sauver et continuer]";
		pcuc.fillForm(name, "PARTICIPANT", true, true, true, "Critère - Test bouton [Sauver et continuer]");
		pcm = pcuc.clickOnCancel(driver);
		pcm.checkCriterium(name);
		pcuc = pcm.editCriterium(driver, name);
		pcuc.checkPageTitle(name);
		String name2 = "Critère - Test bouton [Sauver et continuer] 2";
		pcuc.setName(name2);
		pcm = pcuc.clickOnCancel(driver);
		pcm.checkCriterium(name);
		pcuc = pcm.clickOnCriteriumName(driver, name);
		pcuc.checkPageTitle(name);
		pcuc.setName(name2);
		pcuc.blur();
		pcuc.checkPageTitle(name2);
		pcuc.clickOnSaveAndContinue();
		pcuc.checkCriteriumForm(name2);
		pcm = pcuc.clickOnCancel(driver);
		pcm.checkCriterium(name2);
		
		pcm.deleteCriterium(name2);
		pcm.cancelDeleteCriterium();
		pcm.checkCriterium(name2);
		
		pcm.deleteCriterium(name2);
		pcm.confirmDeleteCriterium(name2);
	}

}
