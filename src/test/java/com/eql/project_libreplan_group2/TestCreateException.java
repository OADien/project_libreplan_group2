package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCreateException {

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
		pageMain.clickMenu(driver, "Ressources", "Calendriers");
		PageCalendarManagement pcm = PageFactory.initElements(driver, PageCalendarManagement.class);
		pcm.test();
		String name = "Calendrier - Test 1";
		PageCalendarExceptions pce = pcm.editCalendar(driver, name);
		pce.test(name);
		pce.clickOnCreateException();
		pce.checkErrorExceptionType();
		String type = "RESOURCE_HOLIDAY";
		pce.setType(type);
		pce.clickOnCreateException();
		pce.checkErrorExceptionEndDate();
		pce.setEndDate();
		pce.clickOnCreateException();
		pce.checkException(type, "0", "0", "0", "0");
		String normalEffectValue1 = "1";
		String normalEffectValue2 = "0";
		String suppEffectValue1 = "2";
		String suppEffectValue2 = "0";
		pce.setEffort(normalEffectValue1, normalEffectValue2, suppEffectValue1, suppEffectValue2);
		pce.clickOnUpdateException();
		pce.checkException(type, normalEffectValue1, normalEffectValue2, suppEffectValue1, suppEffectValue2);
		pcm = pce.clickOnSave(driver);
		pcm.checkSavedCalendar(name);
		pce = pcm.editCalendar(driver, name);
		pce.checkExceptionCode();
		pcm = pce.clickOnCancel(driver);
		
		pce = pcm.createDerivativeCalendar(driver, name);
		pce.checkDerivativeCalendar(name);
		pce.checkException(type, normalEffectValue1, normalEffectValue2, suppEffectValue1, suppEffectValue2);
		pcm = pce.clickOnCancel(driver);
		
		pce = pcm.createCalendarCopy(driver, name);
		pce.checkException(type, normalEffectValue1, normalEffectValue2, suppEffectValue1, suppEffectValue2);
	}

}
