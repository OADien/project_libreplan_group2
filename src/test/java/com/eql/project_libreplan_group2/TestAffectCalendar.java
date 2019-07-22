package com.eql.project_libreplan_group2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestAffectCalendar {
	

	WebDriver driver;
	String browser = "chrome";
	
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
	
	public void testPageCalendar() throws InterruptedException {
		
		 //ACTION : connexiont à la l'application Profil Admin + accéder à la page d'administration des calendriers
		 PageMain page_main = Utils.login(driver);		
		 page_main.clickMenu(driver, "Ressources", "Participants");
		 PageAffectCalendar page_affect_calendar = PageFactory.initElements(driver, PageAffectCalendar.class);
		 
		 //ACTION : 
		 page_affect_calendar.checkPagePartipant();
		 
		 //ACTION : Accéder au formulaire de modification d'un participant
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
		
    }
}
