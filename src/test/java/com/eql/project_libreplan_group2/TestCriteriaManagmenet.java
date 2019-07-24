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
		String name = "Critère - Test bouton [Annuler]";
		pcuc.fillForm(name, "PARTICIPANT", true, true, true, name);
		pcm = pcuc.clickOnCancel(driver);
		pcm.checkCriteriumNotExists(name);
		
		String othername = "Critère - Test bouton [Enregistrer]";
		pcuc = pcm.clickOnCreate(driver);
		pcuc.test();
		pcuc.fillForm(othername, "PARTICIPANT", true, true, true, othername);
		pcuc.clickOnSave();
		pcm.checkCriterium(othername);
		
		pcuc = pcm.clickOnCreate(driver);
		pcuc.test();
		String cname="Critère - Test bouton [Sauver et continuer]";
		pcuc.fillForm(cname, "PARTICIPANT", true, true, true, cname);
		pcuc.clickOnSaveAndContinue();
		pcuc.checkCriteriumForm(cname);
		
		pcm = pcuc.clickOnCancel(driver);
		pcuc = pcm.editCriterium(driver, cname);
		pcuc.checkPageTitle(cname);
		String name2 = "Critère - Test bouton [Sauver et continuer] 2";
		pcuc.setName(name2);
		pcm = pcuc.clickOnCancel(driver);
		pcm.checkCriterium(cname);
		pcuc = pcm.clickOnCriteriumName(driver, cname);
		pcuc.checkPageTitle(cname);
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
