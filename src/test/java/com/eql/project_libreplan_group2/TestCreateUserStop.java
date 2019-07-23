package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCreateUserStop {
	
	@FindBy(xpath="//a[@href=\"/libreplan/resources/worker/worker.zul\"]")
	private WebElement participant;

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
	public void testSection() throws InterruptedException {
		PageMain pageMain = Utils.login(driver);
		pageMain.clickMenu(driver, "Ressources", "Participants");
		PageCreate pageCreate = PageFactory.initElements(driver, PageCreate.class);
		pageCreate.creation();
		pageCreate.verificationConformite(driver);
		
	//Creation utilisateur vide
		pageCreate.userVide(driver);
		
/*	//Déplacement du cadre
		pageCreate.dpct(driver);
*/
		//Fermeture de la pop up message d'erreur
		pageCreate.fermerMsg(driver);
}
}