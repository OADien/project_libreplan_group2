package com.eql.project_libreplan_group2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageTimeSheet {

	@FindBy(xpath = "(//option[text()='Default'])[3]/parent::select")
	private WebElement menu_modele;

	@FindBy(xpath = "\"//input[@class='z-textbox']")
	private WebElement string_to_number;

	public int stringToInt(String number) {
		return Utils.putStringToInt(number);
	}

	public void selectModele(String modele) {
		Utils.selectOptionFromMenu(menu_modele, modele);
	}

	public void verifApparitionTableau(WebDriver driver) {
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Date de début')]"))
				.isDisplayed());
		assertTrue(
				driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Date de fin')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Modèle')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Travail total')]"))
				.isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Code')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Actions')]")).isDisplayed());
	}

	public void verifListeDeroulante(WebDriver driver) {
		assertTrue(driver.findElement(By.xpath("//select[contains(.,'Montrer tout')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//i[@class='z-datebox'][1]/input[1]")).isDisplayed());
		System.out.println("Vérification liste déroulante");
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Filtre']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//select[contains(.,'Default')])[2]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Nouvelle feuille de temps']"))
				.isDisplayed());
	}

	public void verifaffichagePageCreerFeuilleDeTemps(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		assertEquals("Données générales", driver.findElement(By.xpath("//span[text()='Données générales']")).getText());
		assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
		assertFalse(driver.findElement(By.xpath("//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']"))
				.getAttribute("disabled").isEmpty());
		assertEquals("Champs Rubriques", driver.findElement(By.xpath("//span[text()='Champs Rubriques']")).getText());
		List<WebElement> input = driver
				.findElements(By.xpath("(//fieldset[@class='z-fieldset'])[2]/descendant::input"));
		boolean visible = false;
		for (WebElement element : input) {
			visible = element.isDisplayed();
			if (visible)
				break;
		}
		assertFalse(visible);
		List<WebElement> tableau1 = driver.findElements(By.xpath("(//tr[@class='z-columns'])[6]/descendant::tr"));
		boolean visible2 = false;
		for (WebElement element : tableau1) {
			visible2 = element.isDisplayed();
			if (visible2)
				break;
		}
		assertFalse(visible2);

		assertEquals("Lignes de feuille de temps",
				driver.findElement(By.xpath("//span[text()='Lignes de feuille de temps']")).getText());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Ajouter une ligne']"))
				.isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt' and text()='Date']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt' and text()='Ressource']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt' and text()='Tâche']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt' and text()='Heures']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[19]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[20]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[21]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[22]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Enregistrer']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Sauver et continuer']"))
				.isDisplayed());
		assertTrue(driver
				.findElement(
						By.xpath("//td[@class='z-button-cm' and text()='Sauvegarder & Nouvelle feuille de temps']"))
				.isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Annuler']")).isDisplayed());
	}
	public void verifAffichageBloc (WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-grid-body'])[6]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//input[@class='z-datebox-inp' and @value='23 juil. 2019']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//input[@class='z-datebox-inp' and @value='23 juil. 2019']")).getAttribute("value").equals("23 juil. 2019"));
		assertTrue(driver.findElement(By.xpath("(//input[@class='z-combobox-inp'])[2]")).getText().isEmpty());
		assertTrue(driver.findElement(By.xpath("(//input[@class='z-bandbox-inp'])[3]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//i[@class='z-combobox-btn'])[2]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//input[@class='z-textbox']")).getAttribute("value").equals("0"));
		assertTrue(driver.findElement(By.xpath("(//select[@selectedindex='0'])[3]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-row-cnt z-overflow-hidden']/descendant::select/descendant::option[1]")).isSelected());
		assertFalse(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected());
		assertTrue(driver.findElement(By.xpath("(//input[@class='z-textbox z-textbox-disd z-textbox-text-disd'])[2]")).getText().isEmpty());
		assertFalse(driver.findElement(By.xpath("(//input[@class='z-textbox z-textbox-disd z-textbox-text-disd'])[2]")).getAttribute("disabled").isEmpty());
		assertTrue(driver.findElement(By.xpath("//img[@src='/libreplan/common/img/ico_borrar1.png']")).isDisplayed());
	}
	
	public void actionAjouterFeuilleDeTemps (WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("(//i[@class='z-datebox-btn'])[5]")).click();
		driver.findElement(By.xpath("(//td[@class='z-calendar-wkday' and text()='31'])[5]")).click();
		driver.findElement(By.xpath("(//i[@class='z-combobox-btn'])[2]")).click();
		driver.findElement(By.xpath("(//td[@class='z-comboitem-text'])[3]")).click();
		driver.findElement(By.xpath("(//i[@class='z-bandbox-btn'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='z-listcell-cnt z-overflow-hidden'])[17]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='z-row-cnt z-overflow-hidden']/descendant::select")).click();
		driver.findElement(By.xpath("//div[@class='z-row-cnt z-overflow-hidden']/descendant::select/descendant::option[1]")).click();
		WebElement heures = driver.findElement(By.xpath("//input[@class='z-textbox']"));
		heures.clear();
		heures.sendKeys("8");
		driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Enregistrer']")).click();
	}


		public void verifAffichageLigneFeuilleDeTemps (WebDriver driver) throws InterruptedException {
			System.out.println("Création feuille de temps1");
			Thread.sleep(1000);
			assertTrue(driver.findElement(By.xpath("//div[@class='z-window-embedded-header' and text()='Liste des feuilles de temps']")).isDisplayed());
			System.out.println("Création feuille de temps2");
			List<WebElement> list_tableau = driver.findElements(By.xpath("//div[substring(@id,5)='x4-head']/table/tbody/tr"));
			System.out.println(list_tableau.size());
			String ligne_ajoutee = driver.findElement(By.xpath("(//span[ @class='z-label'])[6]")).getText();
			System.out.println("Date : " +ligne_ajoutee);
			assertEquals("31 juil. 2019", ligne_ajoutee);
		}
		
		public void actionCreationDeuxiemeFeuilleDeTemps (WebDriver driver) throws InterruptedException {
			
			driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Nouvelle feuille de temps']")).click();
			driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Ajouter une ligne']")).click();
			driver.findElement(By.xpath("(//i[@class='z-datebox-btn'])[5]")).click();
			driver.findElement(By.xpath("(//td[@class='z-calendar-wkend' and text()='27'])[5]")).click();
			driver.findElement(By.xpath("(//i[@class='z-combobox-btn'])[2]")).click();
			driver.findElement(By.xpath("(//td[@class='z-comboitem-text'])[3]")).click();
			driver.findElement(By.xpath("(//i[@class='z-bandbox-btn'])[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='z-listcell-cnt z-overflow-hidden'])[21]")).click();
			driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
			
		}
		
		public void verifTriCroissantDateDeFin (WebDriver driver) throws InterruptedException, ParseException {
			SimpleDateFormat sdf = new SimpleDateFormat ("dd MMMM yyyy", Locale.FRENCH);
			Thread.sleep(1000);
			Date date1 = sdf.parse(driver.findElement(By.xpath("(//span[@class='z-label'])[7]")).getText());
			Date date2 = sdf.parse(driver.findElement(By.xpath("(//span[@class='z-label'])[12]")).getText());
			Thread.sleep(1000);
			assertTrue(date2.after(date1));
		}
		
		public void verifTriDecroissantDateDeFin (WebDriver driver) throws InterruptedException, ParseException {
			SimpleDateFormat sdf2 = new SimpleDateFormat ("dd MMMM yyyy", Locale.FRENCH);
			Thread.sleep(1000);
			Date date3 = sdf2.parse(driver.findElement(By.xpath("(//span[@class='z-label'])[7]")).getText());
			Date date4 = sdf2.parse(driver.findElement(By.xpath("(//span[@class='z-label'])[12]")).getText());
			Thread.sleep(1000);
			assertTrue(date4.before(date3));
		}
		
		public void verifTriCroissantTravailTotal (WebDriver driver) throws InterruptedException, ParseException {
			String temps1 = driver.findElement(By.xpath("(//span[@class='z-label'])[9]")).getText();
			System.out.println(temps1);
			Thread.sleep(1000);
			int inttemps1 = Integer.parseInt(temps1);
			String temps2 = driver.findElement(By.xpath("(//span[@class='z-label'])[14]")).getText();
			System.out.println(temps2);
			int inttemps2 = Integer.parseInt(temps2);
			Thread.sleep(1000);
			assertTrue(inttemps2>inttemps1);
		}
		
		public void verifTriDecroissantTravailTotal (WebDriver driver) throws InterruptedException, ParseException {
			Thread.sleep(1000);
			String temps3 = driver.findElement(By.xpath("(//span[@class='z-label'])[9]")).getText();
			System.out.println(temps3);
			Thread.sleep(1000);
			int inttemps3 = Integer.parseInt(temps3);
			String temps4 = driver.findElement(By.xpath("(//span[@class='z-label'])[14]")).getText();
			System.out.println(temps4);
			int inttemps4 = Integer.parseInt(temps4);
			Thread.sleep(1000);
			assertTrue(inttemps4<inttemps3);
		}
}
