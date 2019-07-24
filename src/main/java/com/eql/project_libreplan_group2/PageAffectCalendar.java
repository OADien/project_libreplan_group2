package com.eql.project_libreplan_group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;


public class PageAffectCalendar extends BasePage {
	
	@FindBy(xpath="//div[substring(@id,5)='j4-cap']")
	private WebElement title_page;
	
	@FindBy(xpath="//div[substring(@id,5)='s5-cave']")
	private WebElement field_nick_name;
	@FindBy(xpath="//div[substring(@id,5)='t5-cave']")
	private WebElement field_first_name;
	@FindBy(xpath="//div[substring(@id,5)='u5-cave']")
	private WebElement field_id;
	@FindBy(xpath="//div[substring(@id,5)='v5-cave']")
	private WebElement field_code;
	@FindBy(xpath="//div[substring(@id,5)='w5-cave']")
	private WebElement field_file;
	@FindBy(xpath="//div[substring(@id,5)='x5-cave']")
	private WebElement field_operations;
	
	@FindBy(xpath="//td[substring(@id,5)='n4-chdex']/span")
	private WebElement filtered_by_name;
	@FindBy(xpath="//input[substring(@id,5)='q4-real']")
	private WebElement field_filtered_by;
	@FindBy(xpath="//i[substring(@id,5)='q4-btn']")
	private WebElement icon_loupe;
	
	@FindBy(xpath="//td[substring(@id,5)='c5-chdex']/span")
	private WebElement personal_details_name;
	@FindBy(xpath="//td[substring(@id,5)='d5-chdex']/input")
	private WebElement field_personal_details;
	@FindBy(xpath="//td[substring(@id,5)='f5-cnt']")
	private WebElement more_options_name;
	@FindBy(xpath="//td[substring(@id,5)='n5-chdex']/span")
	private WebElement filtered_name;
	
	@FindBy(xpath="//button[contains(@id,'y5-btn')]")
	private WebElement button_create;
	
	@FindBy(xpath="//td[substring(@id,5)='_6-cnt']")
	private WebElement title_create_participant;
	
	@FindBy(xpath="//input[contains(@id,'o6')]")
	private WebElement first_name;
	
	@FindBy(xpath="//input[contains(@id,'u6')]")
	private WebElement last_name;
	
	@FindBy(xpath="//input[contains(@id,'x6')]")
	private WebElement ID;
	
	@FindBy(xpath="//input[contains(@id,'kf')]")
	private WebElement new_user_btn;
	
	@FindBy(xpath="//input[contains(@id,'i8')]")
	private WebElement name_user;
	
	@FindBy(xpath="//input[contains(@id,'l8')]")
	private WebElement password_user;
	
	@FindBy(xpath="//span[.='Confirmation du mot de passe']/ancestor::tr[1]/td[2]/descendant::input")
	private WebElement confirmation_password_user;
	
	@FindBy(xpath="//span[.='Email']/ancestor::tr[1]/td[2]/descendant::input")
	private WebElement email_user;
	
	@FindBy(xpath="//td[.='Enregistrer']")
	private WebElement button_save;

	@FindBy(xpath="//div[substring(@id,5)='da-cell']/span")
	private WebElement field_check_last_name;
	
	@FindBy(xpath="//div[substring(@id,5)='na-cell']/span")
	private WebElement field_check_first_name;
	
	@FindBy(xpath="//div[substring(@id,5)='pa-cell']/span")
	private WebElement field_check_id;
	
	@FindBy(xpath="//div[substring(@id,5)='ib-cell']/span")
	private WebElement field_type;
	
	@FindBy(xpath="//div[substring(@id,5)='66-hm']/span")
	private WebElement tab_calendar;
	
	@FindBy(xpath="//tr[substring(@id,5)='vb-chdex']/descendant::div/table")
	private WebElement calendar;
	
	@FindBy(xpath="//div[substring(@id,5)='wb-body']/table")
	private WebElement table_days;
	
	@FindBy(xpath="//table[substring(@id,5)='ce-box']/descendant::tbody/tr[2]/td[2]")
	private WebElement button_delete_calendar;

	@FindBy(xpath="//span[@class='z-tab-text' and text()='Exceptions']")
	private WebElement tab_exceptions;
	
	@FindBy(xpath="//span[@class='z-tab-text' and text()='Semaine de travail']")
	private WebElement tab_week_job;

	@FindBy(xpath="//span[@class='z-tab-text' and text()='Semaine de travail']")
	private WebElement tab_activation_period;
	
	@FindBy(xpath="//td[.='Sauver et continuer']")
	private WebElement button_save_continue;
	
	@FindBy(xpath="(//td[.='Annuler'])[3]")
	private WebElement button_delete;

	@FindBy(xpath="//span[@class='z-label']/..")
	private WebElement green_frame;
	
	
	//VERIFICATION : PageParticipant
	public void checkPagePartipant() {
		//VERIFICATION : le titre de la page
		 assertEquals("Liste des participants", title_page.getText());
		//VERIFICATION : les champs suivant : Surnom, Prénom, ID, Code, En file et Opérations
		 assertTrue(field_nick_name.isDisplayed());
		 assertTrue(field_first_name.isDisplayed());
		 assertTrue(field_id.isDisplayed());
		 assertTrue(field_code.isDisplayed());
		 assertTrue(field_file.isDisplayed());
		 assertTrue(field_operations.isDisplayed());
		//VERIFICATION : le champ de recherche "Filtré par" 
		 assertTrue(filtered_by_name.isDisplayed());
		 assertTrue(field_filtered_by.isDisplayed());
		 assertTrue(icon_loupe.isDisplayed());
		 assertTrue(personal_details_name.isDisplayed());
		 assertTrue(field_personal_details.isDisplayed());
		 assertTrue(more_options_name.isDisplayed());
		 assertTrue(filtered_name.isDisplayed());
		 assertTrue(button_create.isDisplayed());
	}
	
	
	//ACTION : clic sur le boutton [Créer]
	public void clicButtonCreate() {
		button_create.click();	
	}
	
	
	//VERIFICATION : la conformité de l'onglet
	public void verificationConformite(WebDriver driver) throws InterruptedException {
		
		   Thread.sleep(100);
		   assertEquals("Créer un participant", driver.findElement(By.xpath("//td[substring(@id,5)='_6-cnt']")).getText());
		   
			assertTrue(driver.findElement(By.xpath("//span[contains(.,'Données de base')]")).isDisplayed());
			
			assertTrue(driver.findElement(By.xpath("//span[contains(.,'Prénom')]")).isDisplayed());
			
			assertTrue(driver.findElement(By.xpath("//div[@class='z-fieldset-cnt']/descendant::span[.='Nom']")).isDisplayed());
			
			assertTrue(driver.findElement(By.xpath("//span[contains(.,'ID')]")).isDisplayed());
		
			assertTrue(driver.findElement(By.xpath("//select[@selectedindex='1']")).isDisplayed());
			
			assertTrue(driver.findElement(By.xpath("//span[contains(.,'Utilisateur lié')]")).isDisplayed());
			
			assertTrue(driver.findElement(By.xpath("//label[contains(.,'Non lié')]")).isDisplayed());
			
			assertTrue(driver.findElement(By.xpath("//label[contains(.,'Utilisateur existant')]")).isDisplayed());
			
			assertTrue(driver.findElement(By.xpath("//label[contains(.,'Créer un nouvel utilisateur')]")).isDisplayed());

			assertTrue(driver.findElement(By.xpath("//span[contains(@class, 'save-button')][not(contains(@style, 'display:none'))]")).isDisplayed());
		
			assertTrue(driver.findElement(By.xpath("//td[contains(.,'Sauver et continuer')]")).isDisplayed());
			
			assertTrue(driver.findElement(By.xpath("//div[@class='z-window-embedded-cnt-noborder']/span[@class='cancel-button global-action z-button']")).isDisplayed());
	}
	
	
	//ACTION : Renseigner les champs (Prénom, nom, ID)
	public void basicInformation() {
		
		Utils.renseignerChamp(first_name, "Jean");
		Utils.renseignerChamp(last_name, "DU");		
		Utils.renseignerChamp(ID, "jdu");
	}
	
	
	//ACTION : créer un nouveau participant
	public void createNewParticipant() {
		
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "jdu");
		Utils.renseignerChamp(password_user, "$jdumdp1");
		Utils.renseignerChamp(confirmation_password_user, "$jdumdp1");
		Utils.renseignerChamp(email_user, "jdu@test.fr");
		button_save.click();
	}
	
	
	//VERIFICATION : enregistrement nouveau participant
	public void checkNewParticipantSave(WebDriver driver) {
		
		assertTrue(driver.findElement(By.xpath("//span[.='Participant enregistré']")).isDisplayed());
		assertEquals("DU", field_check_last_name.getText());
		assertEquals("Jean", field_check_first_name.getText());
		assertEquals("jdu", field_check_id.getText());
	}
	
	
	//ACTION : Accéder au formulaire de modification d'un participant
	public void accessTheForm() {
		
		field_check_last_name.click();
	}
	
	//VERIFICATION :check page modifier participant
	public void checkPageModifyParticipant(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(1000);
		assertEquals("Modifier le participant: Jean DU", driver.findElement(By.xpath("//td[substring(@id,5)='_6-cnt']")).getText());
		assertEquals("Jean", driver.findElement(By.xpath("//div[substring(@id,5)='o6-cell']/input")).getAttribute("value"));
		assertEquals("DU", driver.findElement(By.xpath("//div[substring(@id,5)='u6-cell']/input")).getAttribute("value"));
	}
	
	
	//ACTION : Accéder à l'onglet "Calendrier" 
	public void accessTabCalendar() {
		
		tab_calendar.click();
	}
	
	
	//VERIFICATION : check l'onglet calendrier
	public void checkLabCalendar(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		assertTrue(field_type.isDisplayed());
		assertEquals("Dérivé du calendrier Default", driver.findElement(By.xpath("//td[substring(@id,5)='jb-chdextr']/div")).getText());
		assertTrue(calendar.isDisplayed());
		assertTrue(table_days.isDisplayed());
		assertTrue(button_delete_calendar.isDisplayed());
		assertTrue(tab_exceptions.isDisplayed());
		assertTrue(tab_activation_period.isDisplayed());
		assertTrue(button_save.isDisplayed());
		assertTrue(button_save_continue.isDisplayed());
		assertTrue(button_delete.isDisplayed());
	}
	
	
	//ACTION : Supprimer le calendrier affecté par défaut (1/2) 
	public void removeDefaultCalendar() {
		button_delete_calendar.click();
	}
	
	
	//VERIFICATION : check liste déroulante
    public void checkListDeroulante(WebDriver driver) throws InterruptedException {
    	Thread.sleep(1000);
	   assertEquals("Choisir un calendrier parent", driver.findElement(By.xpath("//span[@class='z-label' and text()='Choisir un calendrier parent']")).getText());
	   assertTrue(driver.findElement(By.xpath("//i[@class='z-combobox']/i")).isDisplayed());
	   assertEquals("Default", driver.findElement(By.xpath("//i[@class='z-combobox']/input")).getAttribute("value"));
   }
   	
    
	//ACTION : Supprimer le calendrier affecté par défaut (2/2)
    public void selectCalendar(WebDriver driver)  throws InterruptedException{

    	assertTrue(driver.findElement(By.xpath("(//i[@class='z-combobox-btn'])[1]")).isDisplayed());
    	driver.findElement(By.xpath("(//i[@class='z-combobox-btn'])[1]")).click();

	    List<WebElement> listCalendar = driver.findElements(By.xpath("//tr[@class='z-comboitem z-comboitem-seld']/../tr"));
	 	assertFalse(listCalendar.isEmpty());
	 	//System.out.println("Le nombre de calendrier est "+ listCalendar.size());
	 	driver.findElement(By.xpath("//tr[@class='z-comboitem z-comboitem-seld']/../tr[1]/td[2]")).click();
	 	
    	Thread.sleep(10);
    	driver.findElement(By.xpath("//td[.='Sauver et continuer']")).click();
	}
    
    
	//VERIFICATION : check données personnelles
    public void checkPersonalData(WebDriver driver) {
    	
    	assertTrue(driver.findElement(By.xpath("//span[@class='z-tab-text' and text()='Données personnelles']")).isDisplayed());
    	assertTrue(driver.findElement(By.xpath("//span[@class='z-label' and text()='Participant enregistré']")).isDisplayed());
    }
    
    
    public void checkGreenColor() {
    	
    	Utils.checkColor(green_frame, "#cceecc");
    }
    
    
    //ACTION : Vérifier l'affectation du calendrier :
    public void clicTabCalendar() {
    	
    	tab_calendar.click();
    }
    
    
    //VERIFICATION : onglet calendrier
    public void checkTabCalendar(WebDriver driver) { 
    	
    	assertEquals("Dérivé du calendrier Calendrier - Test 1", driver.findElement(By.xpath("//span[@class='z-label' and text()='Dérivé du calendrier Calendrier - Test 1']")).getText());
      
    }
	
	
}
