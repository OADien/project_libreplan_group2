package com.eql.project_libreplan_group2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TestCalendar {
	WebDriver driver;
	String browser = "chrome";
	String name = "Calendrier - Test 1";
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
	
	public void testPageCalendar() {
		
		 //ACTION : connexiont à la l'application Profil Admin + accéder à la page d'administration des calendriers
		 PageMain page_main = Utils.login(driver);		
		 page_main.clickMenu(driver, "Ressources", "Calendriers");
		 PageCalendar page_calendar = PageFactory.initElements(driver, PageCalendar.class);
		
		//Vérification de l'affichage de la page "Liste de calendriers"
		 assertEquals("Liste de calendriers", driver.findElement(By.xpath("//*[contains(@class,'z-window-embedded-header')]")).getText());
		 System.out.println("[Liste de calendriers] done");
		 
		 //VERIFICATION : tableau (4 colonnes)
//		 assertTrue(driver.findElement(By.xpath("//tr[contains(@class,'z-treecol')]/th[1]")).isDisplayed());
//		 assertTrue(driver.findElement(By.xpath("//tr[contains(@class,'z-treecol')]/th[2]")).isDisplayed());
//		 assertTrue(driver.findElement(By.xpath("//tr[contains(@class,'z-treecol')]/th[3]")).isDisplayed());
//		 assertTrue(driver.findElement(By.xpath("//tr[contains(@class,'z-treecol')]/th[4]")).isDisplayed());
		 
			List<WebElement> listItem = driver.findElements(By.xpath("//tr[contains(@class,'z-treecol')]/th"));
			System.out.println("Le nombre de colonnes = "+ listItem.size());
			assertFalse(listItem.isEmpty());
			assertTrue("[FAIL] pas le bon nombre de produits" ,listItem.size() == 4);
			System.out.println("Le tableau a les colonnes suivantes");
			for (WebElement e : listItem) {
				System.out.println(e.getText());
			}
		 System.out.println("Col done");
		 
		 //VERIFICATION : boutton "Créer"
		 assertTrue(driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Créer'])[1]")).isDisplayed());
		 System.out.println("Button [Créer] done");
		
		 //ACTION : créer un calendrier - accès au formulaire de création
		 page_calendar.clicCreateCalendar();
		 
		//VERIFICATION : affichage de la page "Créer calendriers"
		 assertEquals("Créer Calendrier", driver.findElement(By.xpath("(//td[@class='z-caption-l' and text()='Créer Calendrier'])")).getText());
		 System.out.println("[Créer calendrier] done");
		 
		//Vérification formulaire de saisie dans "Données de calendrier"
		 assertEquals("Données de calendrier", driver.findElement(By.xpath("(//span[@class='z-tab-text' and text()='Données de calendrier'])")).getText());
		 System.out.println("[Données de calendrier] done");
		 
	     //VERIFICATION : bouttons [Enregistrer], [Enregistrer et continuer] et [Annuler]
		 assertEquals("Enregistrer", driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Enregistrer'])")).getText());
		 assertEquals("Enregistrer et continuer", driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Enregistrer et continuer'])")).getText());
		 assertEquals("Annuler", driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Annuler'])")).getText());
		 System.out.println("[Enregitrer], [Enregistrer et continuer] et [Annuler] done");
		 
		 //ACTION : Créer un calendrier
		 page_calendar.createCalendar(name);
		 
		// ACTION : Vérifier que le checkboxecode « générer le code » est sélectionnées
		 assertTrue("[FAIL] la case [Générer le code] n'est pas cochée", Utils.checkBoxCode(driver.findElement(By.xpath("//input[@type='checkbox']"))));
		// assertFalse("[FAIL] la case [Générer le code] n'est pas cochée", Utils.checkBoxCode(driver.findElement(By.xpath("//input[@type='checkbox']")))).getAttribute("disabled").isEmpty());
		 System.out.println("[Générer le code] est cochée");
		 
	}

}
