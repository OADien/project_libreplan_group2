package com.eql.project_libreplan_group2;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageParticipant {
	
	@FindBy(xpath="//a[@href=\"/libreplan/resources/worker/worker.zul\"]")
	private WebElement participant;
	
	public PageCreate access(WebDriver driver, String p) {
		participant.click();
		
		return PageFactory.initElements(driver, PageCreate.class);
	
/*	@Test
	public void testSection() {
		PageMain pageMain = Utils.login(driver);
		pageMain.clickMenu(driver, "Ressources", "Participants");
	}
*/
}
}