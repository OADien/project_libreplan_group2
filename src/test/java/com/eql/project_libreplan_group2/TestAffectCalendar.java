package com.eql.project_libreplan_group2;


import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestAffectCalendar {
	

	WebDriver driver;
	String browser = "chrome";
	String str_test = "Calendrier - Test 2";
	
	@Before
	public void setup(){
		System.out.println("\n@Before");
		driver= Utils.chooseBrowser(browser);
		
	}
	
	@After
	public void after() throws Exception {
		System.out.println("\n@After");
		//driver.close();
	}
	
	
	
	@Test
	public void testPageAffectCalendar() throws SQLException, Exception {
		
	    PageMain page_main = Utils.login(driver);		
	    page_main.clickMenu(driver, "Ressources", "Participants");
	    PageAffectCalendar page_affect_calendar = PageFactory.initElements(driver, PageAffectCalendar.class);
		page_affect_calendar.checkPagePartipant();
		page_affect_calendar.clicButtonCreate();
		page_affect_calendar.verificationConformite(driver);
		page_affect_calendar.basicInformation();
		page_affect_calendar.createNewParticipant();
		page_affect_calendar.checkNewParticipantSave(driver);
		page_affect_calendar.accessTheForm();
		page_affect_calendar.checkPageModifyParticipant(driver);
		page_affect_calendar.accessTabCalendar();
		page_affect_calendar.checkLabCalendar(driver);
		page_affect_calendar.removeDefaultCalendar();
		page_affect_calendar.checkListDeroulante(driver);
		page_affect_calendar.selectCalendar(driver);
		page_affect_calendar.checkPersonalData(driver);
		page_affect_calendar.checkGreenColor();
		page_affect_calendar.clicTabCalendar();
		page_affect_calendar.checkTabCalendar(driver);
		
    }
}
