<<<<<<< HEAD
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
=======
package com.eql.project_libreplan_group2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageParticipant {
	
	//Lien xpath du sous-menu "Participants"
	//a[@href="/libreplan/resources/worker/worker.zul"]

	@FindBy(xpath="//a[@href=\"/libreplan/resources/worker/worker.zul\"]")
	private WebElement worker;
	
	public PageCreate participant(WebDriver driver ) {
	
}
>>>>>>> d04fe11a29350fdd39b1586ccc73d393eb647e4b
}