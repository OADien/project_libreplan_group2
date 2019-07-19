package com.eql.project_libreplan_group2;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreate {
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(.,'Créer')]")
	private WebElement create;
	
	@FindBy(xpath="//span[contains(.,'Prénom')]")
	private WebElement prenom;
	
	@FindBy(xpath="//span[contains(.,'Nom')]")
	private WebElement nom;
	
	@FindBy(xpath="//span[contains(.,'ID')]")
	private WebElement ID;
	
	@FindBy(xpath="//label[contains(.,'Créer un nouvel utilisateur')]/preceding-sibling::input")
	private WebElement new_user_btn;
	
	@FindBy(xpath="//span[.='Nom d'utilisateur']/ancestor::tr[1]/td[2]/descendant::input")
	private WebElement name_user;
	
	@FindBy(xpath="//span[.='Mot de passe']/ancestor::tr[1]/td[2]/descendant::input")
	private WebElement password_user;
	
	@FindBy(xpath="//span[.='Confirmation du mot de passe']/ancestor::tr[1]/td[2]/descendant::input")
	private WebElement confirmation_password_user;
	
	@FindBy(xpath="//span[.='Email']/ancestor::tr[1]/td[2]/descendant::input")
	private WebElement email_user;
	
	@FindBy(xpath="//td[.='Enregistrer']")
	private WebElement save;
	
	@FindBy(xpath="//span[.='Détails personnels']/../following-sibling::td[2]")
	private WebElement detail_perso;
	
	
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
	
		
		//1) Renseigner les champs (Prénom, nom, ID)
		Utils.renseignerChamp(prenom, "Jean");
		
		Utils.renseignerChamp(nom, "DU");
		
		Utils.renseignerChamp(ID, "jdu");
		}
		// 2) Renseigner le bloc "Utilisateur lié", cocher "Créer un nouvel utilisateur" puis remplir nom d'utilisateur, mot de passe, confirmation et Email puis enregistrer 
		public void newUser(WebDriver driver) {
			new_user_btn.click();
			Utils.renseignerChamp(name_user, "jdu");
			Utils.renseignerChamp(password_user, "$jdumdp1");
			Utils.renseignerChamp(confirmation_password_user, "$jdumdp1");
			Utils.renseignerChamp(email_user, "jdu@test.fr");
			save.click();
		}
		
		//vérification enregistrement nouveau participant
		public void verificationEnregistrement(WebDriver driver) {
			
			assertTrue(driver.findElement(By.xpath("//span[.='Participant enregistré']")).isDisplayed());
			
		
		}
}