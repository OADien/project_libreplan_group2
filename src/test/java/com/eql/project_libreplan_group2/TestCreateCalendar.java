package com.eql.project_libreplan_group2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TestCreateCalendar {
	WebDriver driver;
	String browser = "chrome";
	String name = "Calendrier - Test 1";
	String name_calendar_child = "Calendrier - Test Calendrier Dérivé";
	String name_calendar_copy = "Calendrier - Test 2";
	//private Object[] expected;
	//String name_calendar_child = "Calendrier - Test Calendrier Dérivé";
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
		 page_main.clickMenu(driver, "Ressources", "Calendriers");
		 PageCreateCalendar page_calendar = PageFactory.initElements(driver, PageCreateCalendar.class);
		
		//Vérification de l'affichage de la page "Liste de calendriers"
		 assertEquals("Liste de calendriers", driver.findElement(By.xpath("//*[contains(@class,'z-window-embedded-header')]")).getText());
		 System.out.println("[Liste de calendriers] =========> done");
		 
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
		 System.out.println("Col =========> done");
		 
		 //VERIFICATION : boutton "Créer"
		 assertTrue(driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Créer'])[1]")).isDisplayed());
		 System.out.println("Button [Créer] =========> done");
		
		 //ACTION : créer un calendrier - accès au formulaire de création
		 page_calendar.clicCreateCalendar();
		 
		//VERIFICATION : affichage de la page "Créer calendriers"
		 assertEquals("Créer Calendrier", driver.findElement(By.xpath("(//td[@class='z-caption-l' and text()='Créer Calendrier'])")).getText());
		 System.out.println("[Créer calendrier] =========> done");
		 
		//VERIFICATION : formulaire de saisie dans "Données de calendrier"
		 assertEquals("Données de calendrier", driver.findElement(By.xpath("(//span[@class='z-tab-text' and text()='Données de calendrier'])")).getText());
		 System.out.println("[Données de calendrier] =========> done");
		 
	     //VERIFICATION : bouttons [Enregistrer], [Enregistrer et continuer] et [Annuler]
		 assertEquals("Enregistrer", driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Enregistrer'])")).getText());
		 assertEquals("Enregistrer et continuer", driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Enregistrer et continuer'])")).getText());
		 assertEquals("Annuler", driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Annuler'])")).getText());
		 System.out.println("[Enregitrer], [Enregistrer et continuer] et [Annuler] =========> done");
		 
		 //ACTION : Créer un calendrier
		 page_calendar.createCalendar(name);
		 
		// ACTION : Vérifier que le checkboxecode « générer le code » est sélectionnées
		 assertTrue("[FAIL] la case [Générer le code] n'est pas cochée", Utils.checkBoxCode(driver.findElement(By.xpath("//input[@type='checkbox']"))));
		 
		 //VERIFICATION : case code n'est pas vide
		 assertFalse(driver.findElement(By.xpath("//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']")).getAttribute("disabled").isEmpty());
		 System.out.println("[Générer le code] est cochée =========> done");
		 
		 //ACTION : clic sur le boutton [Enregistrer]
		 page_calendar.clicSave();
		 System.out.println("Calendar =========> done");
		 
		//VERIFICATION : retour sur la page "Liste de calendriers"
		 Thread.sleep(1000); //attendre 10 sec ==> le temps de retour sur la page "Liste de calendriers"
		 assertEquals("Liste de calendriers", driver.findElement(By.xpath("//*[contains(@class,'z-window-embedded-header')]")).getText());
		 System.out.println("[Liste de calendriers] =========> done");
		 
		//VERIFICATION : message "Calendrier de base \"Calendrier - Test 1\" enregistré"
		 assertEquals("Calendrier de base \"Calendrier - Test 1\" enregistré", driver.findElement(By.xpath("//*[contains(@class,'z-label')]")).getText());
		
		 
//		 try {
//				WebElement msg_calendar=driver.findElement(By.xpath("//*[contains(@class,'z-label')]"));
//				//driver.findElement(By.xpath("//*[contains(@class= 'tick')]")).isDisplayed();
//				assertEquals("[FAIL] le message de calendrier n'est past affiché","Calendrier de base \"Calendrier - Test 1\" enregistré", msg_calendar.getText());
//				}
//				catch(Error ae) {
//					System.out.println("[FAIL] le message de calendrier n'est past affiché");
//				throw ae;
//				}
//				catch(Exception e) {
//					System.out.println("[FAIL] le calendrier existe");
//				throw e;
//				}
		 
		
		//ACTION : le calendrier "Calendrier - Test 1" est présent
		 List<WebElement> listCalendar = driver.findElements(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr"));
		 	assertFalse(listCalendar.isEmpty());
		 	System.out.println("Le nombre de ligne = "+ listCalendar.size());
			driver.findElement(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr[1]")).isDisplayed();
			
			WebElement line = getLine(listCalendar);
			
			
			System.out.println("Calendrier - Test 1 =========> done");
			
			//ACTION : Créer un calendrier dérivé
			for (WebElement e : listCalendar) {
				WebElement title=e.findElement(By.xpath("td[4]"));
				WebElement button_calendar_child = driver.findElement(By.xpath("//span[@title='Créer une dérive']"));
				//System.out.println(title.getText());
				button_calendar_child.click();
				if(button_calendar_child.isDisplayed()){
					line=e;
					button_calendar_child.click();
					break;
				}
				
			}
			
			System.out.println("calendrier dérivé =========> done");
			
			//VERIFICATION : Affichage de la page "Créer Calendrier"
			assertEquals("Créer Calendrier", driver.findElement(By.xpath("(//td[@class='z-caption-l' and text()='Créer Calendrier'])")).getText());
			System.out.println("[Créer calendrier] =========> done");
			
			//VERIFICATION : Les champs "Nom" et "Type"sont renseignés	
			WebElement field_nom = driver.findElement(By.xpath("//div[@class=\"calendar-data z-grid\"]/descendant::span[.='Nom']/ancestor::tr[1]/descendant::input"));
			assertTrue(field_nom.getText().isEmpty());
			
			WebElement field_type = driver.findElement(By.xpath("//div[@class=\"calendar-data z-grid\"]/descendant::span[.='Type']/ancestor::tr[1]/td[2]"));
		    assertEquals("Dérivé du calendrier Calendrier - Test 1", field_type.getText());
		    
		    System.out.println("champs [Nom] et [Type] =========> done");
			
		    //ACTION : Créer un calendrier dérivé - nom non conforme: remplir [Nom] / case code cochée / [Enregistré et continuer 
		    Utils.renseignerChamp(field_nom, name);
		    WebElement box_code = driver.findElement(By.xpath("//input[@type='checkbox']"));
		    
		    Utils.checkBoxCode(box_code);
		    System.out.println("La case [Générer le code est cochée =========> done");
		    
		    WebElement button_save_continue = driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Enregistrer et continuer'])"));
		    button_save_continue.click();
		    System.out.println("Calendrier dérivée =========> done");
		    
		    //VERIFICATION : message WARNING
		    WebElement message_warning = driver.findElement(By.xpath("//div[@class='message_WARNING']/descendant::span"));
		    assertEquals("Calendrier - Test 1 existe déjà", message_warning.getText());
		    
		    System.out.println("WARNING : calendrier existe =========> done");
		    
		    //ACTION / Créer un calendrier dérivé : remplir [Nom] / case code cochée / [Enregistré et continuer
		    Utils.renseignerChamp(field_nom, name_calendar_child);
		     
		    Utils.checkBoxCode(box_code);
		    System.out.println("La case [Générer le code est cochée =========> done");
		    
		    button_save_continue.click();
		    System.out.println("Calendrier dérivée =========> done");
		    
		    Thread.sleep(1000);
			//VERIFICATION : message "Calendrier de base \"Calendrier - Test Calendrier Dérivé\" enregistré"
			assertEquals("Calendrier de base \"Calendrier - Test Calendrier Dérivé\" enregistré", driver.findElement(By.xpath("//div[@class='message_INFO']/descendant::span")).getText());
			 
			//VERIFICATION : titre de la page est : "Créer Calendrier: Calendrier - Test Calendrier Dérivé"
		    assertEquals("Créer Calendrier: Calendrier - Test Calendrier Dérivé", driver.findElement(By.xpath("(//td[@class='z-caption-l' and text()='Créer Calendrier: Calendrier - Test Calendrier Dérivé'])")).getText());
		    System.out.println("message and title =========> done");
		    
		    //ACTION : Retour page de gestion des calendriers
		    WebElement button_cancel = driver.findElement(By.xpath("(//td[@class='z-button-cm' and text()='Annuler'])"));
		    button_cancel.click();
		    
			//VERIFICATION : affichage de la page "Liste de calendriers"
		    Thread.sleep(100);
			assertEquals("Liste de calendriers", driver.findElement(By.xpath("//*[contains(@class,'z-window-embedded-header')]")).getText());
			System.out.println("[Liste de calendriers] =========> done");
			
			//VERIFICATION : le calendrier "Calendrier - Test Calendrier Dérivé" est affiché en tant que sous-calendrier du calendrier "Calendrier - Test 1".
			 List<WebElement> listCalendar_child = driver.findElements(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr"));
			 	assertFalse(listCalendar_child.isEmpty());
			 	System.out.println("Le nombre de ligne = "+ listCalendar_child.size());
				driver.findElement(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr[1]")).isDisplayed();
				int i=0;
				WebElement ligne;
				for (WebElement e : listCalendar_child) {
					WebElement title=e.findElement(By.xpath("td[1]"));
					System.out.println(title.getText());
					if(name.equals(title.getText())){
						name_calendar_child.equals(title.getText());
						
						ligne=e;
						break;
					}
				i++;
				}
				System.out.println(listCalendar_child.get(i+1).getText());
				

				WebElement field_child = driver.findElement(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr[2]/descendant::span[2]"));
				if (field_child.isDisplayed()) {
					System.out.println("Calendrier - Test Calendrier Dérivé existe");
				}
				
				//ACTION : Affichage du calendrier dérivé ==>button fold out = boutton déroulant
				WebElement button_fold_out = driver.findElement(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr[1]/descendant::span[1]"));
				button_fold_out.click();
				
				//VERIFICATION : Calendrier - Test Calendrier Dérivé" n'est plus affiché
				assertFalse(field_child.isDisplayed());
				
				//ACTION : Créer un calendrier par copie
				listCalendar = driver.findElements(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr"));
				line = getLine(listCalendar);
				System.out.println(line.getText());
				
				WebElement button_calendar_copy = line.findElement(By.xpath("//span[contains(@title,'Créer une copie')]"));
				button_calendar_copy.click();
				
				//VERIFICATION : Affichage de la page "Créer Calendrier : Calendrier - Test 1"
				
				assertEquals("Créer Calendrier: Calendrier - Test 1", driver.findElement(By.xpath("//td[text()='Créer Calendrier: Calendrier - Test 1']")).getText());
				System.out.println("calendrier par copie");
					
				//VERIFICATION : les champs sont renseignés 
				WebElement field_nom_copy = driver.findElement(By.xpath("//div[@class='z-row-cnt z-overflow-hidden']/descendant::span[.='Nom']/ancestor::tr[1]/descendant::input"));
				//assertTrue(field_nom_copy.getText().isEmpty());
				
				WebElement field_type_copy = driver.findElement(By.xpath("//div[@class='z-row-cnt z-overflow-hidden']/descendant::span[.='Type']/ancestor::tr[1]/td[2]"));
			    assertEquals("Calendrier source", field_type.getText());
			    
			    System.out.println("champs [Nom] et [Type] =========> done");
				
			    //ACTION: Créer un calendrier par copie - Nom du calendrier non conforme
			    button_save_continue.click();
			    
			    //VERIFICATION : message WARNING
			    //Thread.sleep(1000);
			    WebElement msg_warning = driver.findElement(By.xpath("//div[@class='message_WARNING']/descendant::span"));
			    assertEquals("Calendrier - Test 1 existe déjà", msg_warning.getText());
			    
			    System.out.println("pas 11 ======> done");
			    
			    //ACTION : Créer un calendrier par copie : renseigner les champs [Nom] / case code cochée / [Enregistré
			    
			    Utils.renseignerChamp(field_nom_copy, name_calendar_copy);
			     
			    Utils.checkBoxCode(box_code);
			    System.out.println("La case [Générer le code est cochée =========> done");
			    
			    page_calendar.clicSave();
			    System.out.println("Calendrier dérivée =========> done");
			    
			    //VERIFICATION : Retour sur la page "Liste de calendriers"
				 Thread.sleep(1000); //attendre 10 sec ==> le temps de retour sur la page "Liste de calendriers"
				 assertEquals("Liste de calendriers", driver.findElement(By.xpath("//*[contains(@class,'z-window-embedded-header')]")).getText());
				 System.out.println("[Liste de calendriers] =========> done");
				 
				//VERIFICATION : message "Calendrier - Test 2" enregistré" enregistré"
				 assertEquals("Calendrier de base \"Calendrier - Test 2\" enregistré", driver.findElement(By.xpath("//div[@class='message_INFO']/descendant::span")).getText());
				 System.out.println("[Calendriers - Test 2] =========> done");
				 
				 //ACTION : le calendrier "Calendrier - Test 2" est présent
				 List<WebElement> listCalendar2 = driver.findElements(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr"));
				 	assertFalse(listCalendar.isEmpty());
				 	System.out.println("Le nombre de ligne = "+ listCalendar.size());
					driver.findElement(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr[3]")).isDisplayed();
					
					WebElement linecopy = getLinecopy(listCalendar2);
					System.out.println("Calendrier - Test 2 est présent =========> done");

				//VERIFICATION : Le "Calendrier - Test 2" n'est pas affiché en tant que sous-calendrier du calendrier "Calendrier - Test 1"
				
				List<WebElement> listElementCalendar = driver.findElements(By.xpath("//tbody[contains(@class,'z-treechildren')]/tr[3]/td[1]/descendant::div[@class='z-treecell-cnt z-overflow-hidden']/span[contains(@class,'z-dottree-line')]"));
				assertTrue(listElementCalendar.isEmpty());
			 	System.out.println("Calendrier 2 n'est pas un sous calendrier de calendrier 1 =======> done");
			 	System.out.println("Fin de CT Créer un calendrier");
			 	
								    
	}
	
	
	public WebElement getLine(List<WebElement> listCalendar) {
		for (WebElement e : listCalendar) {
			WebElement title=e.findElement(By.xpath("td[1]"));
			//System.out.println(title.getText());
			if(name.equals(title.getText())){
				return e;
			}
		
		}
		return null;
	}
	
	public WebElement getLinecopy(List<WebElement> listCalendar2) {
		for (WebElement e : listCalendar2) {
			WebElement title=e.findElement(By.xpath("td[1]"));
			System.out.println(title.getText());
			if(name_calendar_copy.equals(title.getText())){
				return e;
			}
		
		}
		return null;
	}
	
}
