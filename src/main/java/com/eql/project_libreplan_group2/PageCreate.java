package com.eql.project_libreplan_group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.*;

public class PageCreate {
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(.,'Créer')]")
	private WebElement create;
	
	
	
	//Cliquer sur le bouton Créer
	public void creation(WebDriver driver) {
		create.click();
	}	
	//Vérifier la conformité de l'onglet
		public void verificationConformite(WebDriver driver) {
		
		assertTrue(driver.findElement(By.xpath("//span[contains(.,'Données de base')]")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//span[contains(.,'Prénom')]")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//span[contains(.,'Nom')]")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//span[contains(.,'ID')]")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//option[contains(.,'Ressource normale')]")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//span[contains(.,'Utilisateur lié')]")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//label[contains(.,'Non lié')]")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//label[contains(.,'Utilisateur existant')]")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//label[contains(.,'Créer un nouvel utilisateur')]")).isDisplayed());
	
		assertTrue(driver.findElement(By.xpath("//td[contains(.,'Enregistrer')]")).isDisplayed());
	
		assertTrue(driver.findElement(By.xpath("//td[contains(.,'Sauver et continuer')]")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//div[@class='z-window-embedded-cnt-noborder']/span[@class='cancel-button global-action z-button']")).isDisplayed());
	
}

}