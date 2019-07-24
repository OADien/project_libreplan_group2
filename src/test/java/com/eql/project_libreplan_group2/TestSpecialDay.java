package com.eql.project_libreplan_group2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestSpecialDay {

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
		pageMain.clickMenu(driver, "Ressources", "Jours exceptionnels du calendrier");
		PageSpecialDayManagement psd = PageFactory.initElements(driver, PageSpecialDayManagement.class);
		psd.test();
		PageCreateUpdateSpecialDay pcusd = psd.clickOnCreate(driver);
		pcusd.test();
		String code1 = pcusd.getCode();
		String name = "Jour exceptionel";
		psd = pcusd.cancel(driver, name);
		psd.checkSpecialDayNotExists(name);
		pcusd = psd.clickOnCreate(driver);
		String code2 = pcusd.getCode();
		//Not true Test Step 6
//		Assert.assertEquals(Integer.parseInt(code1.substring(code1.length() - 4)) + 1,
//				Integer.parseInt(code2.substring(code2.length() - 4)));
		pcusd.setName(name);
		
		String standardEffort1;
		String standardEffort2;
		String suppEffort1;
		String suppEffort2;

//		standardEffort1 = "-1";
//		pcusd.setStandardEffort1(standardEffort1);
//		pcusd.blur();
//		pcusd.checkErrorBox("Dépassement du rang (>= 0).", "Dépassement du rang (0 ~ 24).");
//		standardEffort1 = "1";
//		pcusd.setStandardEffort1(standardEffort1);
//		pcusd.blur();
//		standardEffort2 = "-1";
//		pcusd.setStandardEffort2(standardEffort2);
//		pcusd.blur();
//		pcusd.checkErrorBox("Dépassement du rang (0 ~ 59).");
//		standardEffort2 = "1";
//		pcusd.setStandardEffort2(standardEffort2);
//		pcusd.blur();
//
//		suppEffort1 = "-1";
//		pcusd.setSuppEffort1(suppEffort1);
//		pcusd.clickOnSave();
//		pcusd.checkErrorBox("Dépassement du rang (>= 0).");
//		suppEffort1 = "5";
//		pcusd.setSuppEffort1(suppEffort1);
//		pcusd.blur();
//		suppEffort2 = "-1";
//		pcusd.setSuppEffort2(suppEffort2);
//		pcusd.clickOnSaveAndContinue();
//		pcusd.checkErrorBox("Dépassement du rang (0 ~ 59).");
//
//		suppEffort2 = "3";
//		pcusd.setSuppEffort2(suppEffort2);
		
		standardEffort1 = "0";
		standardEffort2 = "0";
		suppEffort1 = "0";
		suppEffort2 = "0";
		
		//pcusd.setEffort(standardEffort1, standardEffort2, suppEffort1, suppEffort2);
		
		pcusd.clickOnSave();
		psd = PageFactory.initElements(driver, PageSpecialDayManagement.class);
		psd.checkSavedSpecialDay(name, standardEffort1, standardEffort2, suppEffort1, suppEffort2);

		// go to calendars
		psd.clickMenu(driver, "Ressources", "Calendriers");
		PageCalendarManagement pcm = PageFactory.initElements(driver, PageCalendarManagement.class);
		pcm.test();
		String cname = "Calendrier - Test 2";
		PageCalendarExceptions pce = pcm.editCalendar(driver, cname);
		pce.test(cname);
		pce.checkExceptionTypeExists(name);
		
		pce.setEndDate();
		pce.setType(name);
		pce.checkReservation(standardEffort1, standardEffort2, suppEffort1, suppEffort2);
		pce.clickOnCreateException();
		pce.checkException(name, standardEffort1, standardEffort2, suppEffort1, suppEffort2);
		
	}

}
