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
		driver.findElement(By.xpath("(//img[@src='/libreplan/common/img/ico_borrar1.png'])[1]")).click();
		driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@src='/libreplan/common/img/ico_borrar1.png'])[1]")).click();
		driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='OK']")).click();
	}

	@Test
	public void test_creer_feuille_de_temps() throws InterruptedException, ParseException, Exception {
		
		//ACTION :  Accéder à la page de gestion des feuilles de temps
		PageMain pageMain = Utils.login(driver);
		pageMain.clickMenu(driver, "Coût", "Feuille de temps");
		PageTimeSheet page_time_sheet = PageFactory.initElements(driver, PageTimeSheet.class);
		
		//VERIFICATION :  apparition du tableau
		page_time_sheet.verifApparitionTableau(driver);
		
		//VERIFICATION :  présence d'une liste déroulante, de deux champs à remplir et du bouton filtre
		page_time_sheet.verifListeDeroulante(driver);
		
		//ACTION :  Créer une feuille de temps - Accès au formulaire de création :
		driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Nouvelle feuille de temps']")).click();
		
		//VERIFICATION : Affichage de la page "Créer la feuille de temps"
		page_time_sheet.verifaffichagePageCreerFeuilleDeTemps(driver);
		
		//ACTION : Ajouter une ligne de feuille de temps
		driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Ajouter une ligne']")).click();
		
		//VERIFICATION : Affichage des éléments du bloc
		page_time_sheet.verifAffichageBloc(driver);
		
		//ACTION : Ajouter une feuille de temps - bouton [Enregistrer] :
		page_time_sheet.actionAjouterFeuilleDeTemps(driver);
				
		//VERIFICATION : Affichage de la ligne correspondant à la feuille de temps créée sur la page "liste des feuilles de temps"
		page_time_sheet.verifAffichageLigneFeuilleDeTemps(driver);		
		
		//ACTION : création d'une deuxième feuille de temps pour faire les steps suivants : 
		
		pageMain.clickMenu(driver, "Coût", "Feuille de temps");
		page_time_sheet.actionCreationDeuxiemeFeuilleDeTemps(driver);
		page_time_sheet.selectModele(modele);
		WebElement heures2 = driver.findElement(By.xpath("//input[@class='z-textbox']"));
		heures2.clear();
		heures2.sendKeys("9");
		driver.findElement(By.xpath("//td[@class='z-button-cm' and text()='Enregistrer']")).click();
		
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Date de fin" (1/2) :
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[2]")).click();
		
		//VERIFICATION : tri croissant date de fin
		page_time_sheet.verifTriCroissantDateDeFin(driver);
		
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Date de fin" (2/2) :
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[2]")).click();
		
		//VERIFICATION : tri décroissant date de fin
		page_time_sheet.verifTriDecroissantDateDeFin(driver);
		
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Travail total" (1/2) :
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[4]")).click();
		
		//VERIFICATION : tri croissant par colonne "Travail total"
	
		page_time_sheet.verifTriCroissantTravailTotal(driver);
		
		//ACTION : Tri du tableau des feuilles de temps - tri par colonne "Travail total" (2/2) :
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='z-column-cnt'])[4]")).click();

		//VERIFICATION : tri décroissant par colonne "Travail total"
		page_time_sheet.verifTriDecroissantTravailTotal(driver);

	
		
	}
	
}
		
		
