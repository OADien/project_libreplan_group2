package com.eql.project_libreplan_group2;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCreerFeuilleDeTemps {

	private WebDriver driver;
	String modele="Overtime";
	

	@Before
		public void init() throws Exception {
//		Utils.insertData("src\\main\\resources\\datasets\\insert_resource.xml");
//		Utils.insertData("src\\main\\resources\\datasets\\insert_worker.xml");
//		Utils.insertData("src\\main\\resources\\datasets\\insert_order_element.xml");
//		Utils.insertData("src\\main\\resources\\datasets\\insert_order_line_group.xml");
		driver = Utils.chooseBrowser("chrome");
	}

	@After
	public void quit() throws Exception {
//		Utils.deleteAllData("src\\main\\resources\\datasets\\delete_resource.xml");
//		Utils.deleteAllData("src\\main\\resources\\datasets\\delete_worker.xml");
//		Utils.deleteAllData("src\\main\\resources\\datasets\\delete_order_element.xml");
//		Utils.deleteAllData("src\\main\\resources\\datasets\\insert_order_line_group.xml");
		//driver.quit();
	}

	@Test
	public void test_creer_feuille_de_temps() throws InterruptedException, ParseException, Exception {
		
		//ACTION :  Accéder à la page de gestion des feuilles de temps
		PageMain pageMain = Utils.login(driver);
		pageMain.clickMenu(driver, "Coût", "Feuille de temps");
		PageTimeSheet page_time_sheet = PageFactory.initElements(driver, PageTimeSheet.class);
		
		
		//VERIFICATION :  apparition du tableau
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Date de début')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Date de fin')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Modèle')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Travail total')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Code')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt'][contains(.,'Actions')]")).isDisplayed());
		
		
		//VERIFICATION :  présence d'une liste déroulante, de deux champs à remplir et du bouton filtre
		assertTrue(driver.findElement(By.xpath("//select[contains(.,'Montrer tout')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//i[@class='z-datebox'][1]/input[1]")).isDisplayed());
		System.out.println("Vérification liste déroulante");
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Filtre']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//select[contains(.,'Default')])[2]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Nouvelle feuille de temps']")).isDisplayed());
		
		
		
		
		//ACTION :  Créer une feuille de temps - Accès au formulaire de création :
		driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Nouvelle feuille de temps']")).click();
		
		//VERIFICATION : Affichage de la page "Créer la feuille de temps"
		//Ajout du Thread.sleep sinon le test est FAIL
		Thread.sleep(1000);
		assertEquals("Données générales", driver.findElement(By.xpath("//span[text()='Données générales']")).getText());
		assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
		assertFalse(driver.findElement(By.xpath("//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']")).getAttribute("disabled").isEmpty());
		assertEquals("Champs Rubriques", driver.findElement(By.xpath("//span[text()='Champs Rubriques']")).getText());
		List<WebElement> input = driver.findElements(By.xpath("(//fieldset[@class='z-fieldset'])[2]/descendant::input"));
		boolean visible=false;
		for (WebElement element:input) {
			visible = element.isDisplayed();
			if (visible)
				break;
		}
		assertFalse(visible);
		List<WebElement> tableau1 = driver.findElements(By.xpath("(//tr[@class='z-columns'])[6]/descendant::tr"));
		boolean visible2=false;
		for (WebElement element:tableau1) {
			visible2 = element.isDisplayed();
			if (visible2)
				break;
		}
		assertFalse(visible2);
		
		assertEquals("Lignes de feuille de temps", driver.findElement(By.xpath("//span[text()='Lignes de feuille de temps']")).getText());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Ajouter une ligne']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt' and text()='Date']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt' and text()='Ressource']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt' and text()='Tâche']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt' and text()='Heures']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[19]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[20]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[21]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[22]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Enregistrer']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Sauver et continuer']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Sauvegarder & Nouvelle feuille de temps']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Annuler']")).isDisplayed());
	

	
		
		//ACTION : Ajouter une ligne de feuille de temps
		driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Ajouter une ligne']")).click();
		
		//VERIFICATION : Affichage des éléments du bloc
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath("(//div[@class='z-grid-body'])[6]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//input[@class='z-datebox-inp' and @value='22 juil. 2019']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//input[@class='z-datebox-inp' and @value='22 juil. 2019']")).getAttribute("value").equals("22 juil. 2019"));
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
		
		//ACTION : Ajouter une feuille de temps - bouton [Enregistrer] :
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
		
		//VERIFICATION : Affichage de la ligne correspondant à la feuille de temps créée sur la page "liste des feuilles de temps"
		System.out.println("Création feuille de temps1");
		Thread.sleep(6000);
		assertTrue(driver.findElement(By.xpath("//div[@class='z-window-embedded-header' and text()='Liste des feuilles de temps']")).isDisplayed());
		System.out.println("Création feuille de temps2");
		List<WebElement> list_tableau = driver.findElements(By.xpath("//div[substring(@id,5)='x4-head']/table/tbody/tr"));
		System.out.println(list_tableau.size());
		String ligne_ajoutee = driver.findElement(By.xpath("(//span[ @class='z-label'])[6]")).getText();
		System.out.println("Date : " +ligne_ajoutee);
		assertEquals("31 juil. 2019", ligne_ajoutee);
		
		
		
		//ACTION : création d'une deuxième feuille de temps pour faire les steps suivants : 
		pageMain.clickMenu(driver, "Coût", "Feuille de temps");
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
		page_time_sheet.selectModele(modele);
		WebElement heures2 = driver.findElement(By.xpath("//input[@class='z-textbox']"));
		heures2.clear();
		heures2.sendKeys("9");
		driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Enregistrer']")).click();
		
		
		
		
		
		
		//ACTION : Tri du tableau des feuilles de temps - tri par défaut :
		
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Date de fin" (1/2) :
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[2]")).click();
		
		//VERIFICATION : tri croissant date de fin
		SimpleDateFormat sdf = new SimpleDateFormat ("dd MMMM yyyy", Locale.FRENCH);
		Thread.sleep(1000);
		Date date1 = sdf.parse(driver.findElement(By.xpath("(//span[@class='z-label'])[7]")).getText());
		Date date2 = sdf.parse(driver.findElement(By.xpath("(//span[@class='z-label'])[12]")).getText());
		Thread.sleep(1000);
		assertTrue(date2.after(date1));
		
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Date de fin" (2/2) :
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[2]")).click();
		
		//VERIFICATION : tri décroissant date de fin
		SimpleDateFormat sdf2 = new SimpleDateFormat ("dd MMMM yyyy", Locale.FRENCH);
		Thread.sleep(1000);
		Date date3 = sdf2.parse(driver.findElement(By.xpath("(//span[@class='z-label'])[7]")).getText());
		Date date4 = sdf2.parse(driver.findElement(By.xpath("(//span[@class='z-label'])[12]")).getText());
		Thread.sleep(1000);
		assertTrue(date4.before(date3));
		
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Travail total" (1/2) :
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[4]")).click();
		String temps1 = driver.findElement(By.xpath("(//span[@class='z-label'])[8]")).getText();
		int inttemps1 = Integer.parseInt(temps1);
		String temps2 = driver.findElement(By.xpath("(//span[@class='z-label'])[13]")).getText();
		int inttemps2 = Integer.parseInt(temps2);
		Thread.sleep(1000);
		assertTrue(inttemps2>inttemps1);
		
		
		
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Travail total" (2/2) :
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[4]")).click();
		
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Modèle" (1/2) :
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Modèle" (1/2) :
		//ACTION : Redimensionner la taille des colonnes (1/2) :
		//ACTION : Redimensionner la taille des colonnes (1/2) :
		
	}
	
}
		
		
