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
		
    }
}
