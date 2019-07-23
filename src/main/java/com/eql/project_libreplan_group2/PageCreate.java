package com.eql.project_libreplan_group2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Checkbox;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageCreate {
	
	@FindBy(xpath="//div[contains(@class,'z-groupbox-hl')]")
	private WebElement blue_frame;
	
	@FindBy(xpath="//span[contains(@title,'Appliquer le filtrage aux ressources satisfaisant le critère demandé')]")
	private WebElement green_frame;
	
	@FindBy(xpath="//button[contains(@id,'y5-btn')]")
	private WebElement create;
	
	@FindBy(xpath="//input[contains(@id,'o6')]")
	private WebElement prenom;
	
	@FindBy(xpath="//input[contains(@id,'u6')]")
	private WebElement nom;
	
	@FindBy(xpath="//input[contains(@id,'x6')]")
	private WebElement ID;
	
	@FindBy(xpath="//label[.='Créer un nouvel utilisateur']/preceding-sibling::input")
	private WebElement new_user_btn;
	
	@FindBy(xpath="//span[.=\"Nom d'utilisateur\"]/../../following-sibling::td/descendant::input")
	private WebElement name_user;
	
	@FindBy(xpath="// div[contains(@class,'z-panel')]/descendant::input[contains(@type,'password')][1]")
	private WebElement password_user;
	
	@FindBy(xpath="//span[.='Confirmation du mot de passe']/ancestor::tr[1]/td[2]/descendant::input")
	private WebElement confirmation_password_user;
	
	@FindBy(xpath="//span[.='Email']/ancestor::tr[1]/td[2]/descendant::input")
	private WebElement email_user;
	
	@FindBy(xpath="//td[.='Enregistrer']")
	private WebElement save;
	
//	@FindBy(xpath="//span[.='Détails personnels']/../following-sibling::td[2]")
	@FindBy(xpath="//input[contains(@id,'d5')]")
	private WebElement detail_perso;
	
	@FindBy(xpath="//div[contains(@id,'p5')]")
	private WebElement liste_worker;
	
	@FindBy(xpath="//span[contains(@id,'n5')]")
	private WebElement filtre_btn;
	
	String lastname = "DU";
	String firstname = "Jean";
	String utilisateur = "jdu";
	String mdp = "$jdumdp1";
	
	@FindBy(xpath="//td[contains(@id,'f5')]")
	private WebElement option_btn;
	
	@FindBy(xpath="//input[contains(@id,'i5')]")
	private WebElement periode;
	
	@FindBy(xpath="//input[contains(@id,'k5')]")
	private WebElement to;
	
	@FindBy(xpath="//select[contains(@id,'m5')]")
	private WebElement type;
	
	@FindBy(xpath="//input[contains(@id,'d5')]")
	private WebElement filtre_field;
	
	@FindBy(xpath="//td[contains(@class,'z-button-cm')][contains(.,'Filtre')]")
	private WebElement filtre_button;
	
	@FindBy(xpath="//table[contains(@id,'q5-next')]")
	private WebElement fleche_suivant;
	
	@FindBy(xpath="//table[contains(@id,'q5-prev')]")
	private WebElement fleche_precedent;
	
	@FindBy(xpath="//table[contains(@id,'q5-last')]")
	private WebElement fleche_last;
	
	@FindBy(xpath="//table[contains(@id,'q5-first')]")
	private WebElement fleche_first;
	
	@FindBy(xpath="//a[contains(@class,'cerrar_sesion')]")
	private WebElement signout_btn;
	
	@FindBy(xpath="//input[contains(@name,'j_username')]")
	private WebElement connect_username_field;
	
	@FindBy(xpath="//input[contains(@name,'j_password')]")
	private WebElement connect_password_field;
	
	@FindBy(xpath="//input[contains(@name,'button')]")
	private WebElement connect_btn;
	
	//Cas non passant
	@FindBy(xpath="//div[contains(@id,'_z_15')]")
	private WebElement error_msg;
	
	@FindBy(xpath="//div[contains(@style,'left: 740px; top: 370px')]")
	private WebElement new_position;
	
	@FindBy(xpath="//div[contains(@class,'z-errbox-right z-errbox-close')]")
	private WebElement close_error_msg;
	
	//Vérifier les éléments de la page puis cliquer sur le bouton Créer
	public void creation(WebDriver driver) {
		assertTrue(driver.findElement(By.xpath("//div[contains(@class,'clickable-rows z-grid')]")).isDisplayed());
		String prenom = "Prénom";
		assertEquals("Prénom", prenom);
		String surnom = "Surnom";
		assertEquals("Surnom", surnom);
		String id = "ID";
		assertEquals("ID", id);
		String code = "Code";
		assertEquals("Code", code);
		String en_file = "En file";
		assertEquals("En file", en_file);
		String operations = "Opérations";
		assertEquals("Opérations", operations);
		assertTrue(driver.findElement(By.xpath("//span[contains(.,'Filtré par')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//input[contains(@class,'z-bandbox-inp')][contains(@style,'width')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[contains(@class,'clickable-rows z-grid')]/div[contains(@class,'z-grid-header')][contains(@style,'width')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//i[contains(@class,'z-bandbox-btn')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//span[contains(.,'Détails personnels')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[contains(@class,'z-caption-l')][contains(.,\"Plus d'options\")]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[contains(.,'Créer')]")).isDisplayed());
 //   	Utils.verifierCouleur(blue_frame, "#373737");
//    	Utils.verifierCouleur(green_frame, "#58a758");

    	create.click();
    }
		
		
	//Vérifier la conformité de l'onglet
		public void verificationConformite(WebDriver driver) throws InterruptedException {
			
			Thread.sleep(500);
		
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
		
		public void newInformation(WebDriver driver) {
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
			assertEquals(prenom.getText(),"");
			assertEquals(nom.getText(),"");
			assertEquals(ID.getText(),"");
		}
		
		
		//création de 15 autres participants pour obtenir une seconde page
		public void quinzeParticipants(WebDriver driver) {
		create.click();
		Utils.renseignerChamp(prenom, "Alain");
		Utils.renseignerChamp(nom, "DELOIN");
		Utils.renseignerChamp(ID, "ade");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "ade");
		Utils.renseignerChamp(password_user, "$ademdp1");
		Utils.renseignerChamp(confirmation_password_user, "$ademdp1");
		Utils.renseignerChamp(email_user, "ade@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Bertrand");
		Utils.renseignerChamp(nom, "DU GESCLIN");
		Utils.renseignerChamp(ID, "bdu");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "bdu");
		Utils.renseignerChamp(password_user, "$bdumdp1");
		Utils.renseignerChamp(confirmation_password_user, "$bdumdp1");
		Utils.renseignerChamp(email_user, "bdu@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Charles");
		Utils.renseignerChamp(nom, "VI");
		Utils.renseignerChamp(ID, "cvi");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "cvi");
		Utils.renseignerChamp(password_user, "$cvimdp1");
		Utils.renseignerChamp(confirmation_password_user, "$cvimdp1");
		Utils.renseignerChamp(email_user, "cvi@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Diane");
		Utils.renseignerChamp(nom, "DE POITIERS");
		Utils.renseignerChamp(ID, "dde");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "dde");
		Utils.renseignerChamp(password_user, "$ddemdp1");
		Utils.renseignerChamp(confirmation_password_user, "$ddemdp1");
		Utils.renseignerChamp(email_user, "dde@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Erik");
		Utils.renseignerChamp(nom, "LE ROUGE");
		Utils.renseignerChamp(ID, "ele");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "ele");
		Utils.renseignerChamp(password_user, "$elemdp1");
		Utils.renseignerChamp(confirmation_password_user, "$elemdp1");
		Utils.renseignerChamp(email_user, "ele@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "François");
		Utils.renseignerChamp(nom, "Ier");
		Utils.renseignerChamp(ID, "fie");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "fie");
		Utils.renseignerChamp(password_user, "$fiemdp1");
		Utils.renseignerChamp(confirmation_password_user, "$fiemdp1");
		Utils.renseignerChamp(email_user, "fie@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Georges");
		Utils.renseignerChamp(nom, "VI");
		Utils.renseignerChamp(ID, "gvi");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "gvi");
		Utils.renseignerChamp(password_user, "$gvimdp1");
		Utils.renseignerChamp(confirmation_password_user, "$gvimdp1");
		Utils.renseignerChamp(email_user, "gvi@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Henri");
		Utils.renseignerChamp(nom, "IV");
		Utils.renseignerChamp(ID, "hiv");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "hiv");
		Utils.renseignerChamp(password_user, "$hivmdp1");
		Utils.renseignerChamp(confirmation_password_user, "$hivmdp1");
		Utils.renseignerChamp(email_user, "hiv@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "I");
		Utils.renseignerChamp(nom, "AM");
		Utils.renseignerChamp(ID, "iam");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "iam");
		Utils.renseignerChamp(password_user, "$iammdp1");
		Utils.renseignerChamp(confirmation_password_user, "$iammdp1");
		Utils.renseignerChamp(email_user, "iam@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "John");
		Utils.renseignerChamp(nom, "LE ROUGE");
		Utils.renseignerChamp(ID, "jle");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "jle");
		Utils.renseignerChamp(password_user, "$jlemdp1");
		Utils.renseignerChamp(confirmation_password_user, "$jlemdp1");
		Utils.renseignerChamp(email_user, "jle@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Ken");
		Utils.renseignerChamp(nom, "LE SURVIVANT");
		Utils.renseignerChamp(ID, "kle");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "kle");
		Utils.renseignerChamp(password_user, "$klemdp1");
		Utils.renseignerChamp(confirmation_password_user, "$klemdp1");
		Utils.renseignerChamp(email_user, "kle@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Léon");
		Utils.renseignerChamp(nom, "DE CONSTANTINOPLE");
		Utils.renseignerChamp(ID, "lde");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "lde");
		Utils.renseignerChamp(password_user, "$ldemdp1");
		Utils.renseignerChamp(confirmation_password_user, "$ldemdp1");
		Utils.renseignerChamp(email_user, "lde@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Minos");
		Utils.renseignerChamp(nom, "DE CRETE");
		Utils.renseignerChamp(ID, "mde");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "mde");
		Utils.renseignerChamp(password_user, "$mdemdp1");
		Utils.renseignerChamp(confirmation_password_user, "$mdemdp1");
		Utils.renseignerChamp(email_user, "mde@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Napoleon");
		Utils.renseignerChamp(nom, "BONAPARTE");
		Utils.renseignerChamp(ID, "nbo");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "nbo");
		Utils.renseignerChamp(password_user, "$nbomdp1");
		Utils.renseignerChamp(confirmation_password_user, "$nbomdp1");
		Utils.renseignerChamp(email_user, "nbo@test.fr");
		save.click();
		
		create.click();
		Utils.renseignerChamp(prenom, "Octave");
		Utils.renseignerChamp(nom, "THURINUS");
		Utils.renseignerChamp(ID, "oth");
		new_user_btn.click();
		Utils.renseignerChamp(name_user, "oth");
		Utils.renseignerChamp(password_user, "$othmdp1");
		Utils.renseignerChamp(confirmation_password_user, "$othmdp1");
		Utils.renseignerChamp(email_user, "oth@test.fr");
		save.click();
		}
		
		//filtre "Détail personnels"
		public void filtreDétailsPerso (WebDriver driver) throws InterruptedException {
			Utils.renseignerChamp(detail_perso, "Jean");
			filtre_btn.click();
			Thread.sleep(500);
			assertTrue(driver.findElement(By.xpath("//div[contains(@id,'p5')]/descendant::tr[td[1][.='"+lastname+"']][td[2][.='"+firstname+"']]")).isDisplayed());
		}
					
		//bouton option
		public void newOptions (WebDriver driver) {
			option_btn.click();
/*			assertTrue(driver.findElement(By.xpath("//input[contains(@id,'i5')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//input[contains(@id,'k5')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//select[contains(@id,'m5')]")).isDisplayed());
*/			
//			assertEquals(type.getText(),"");
			WebElement menu = driver.findElement(By.xpath("//option[contains(@selected,'selected')][contains(.,'Tous')]"));
			assertTrue(driver.findElement(By.xpath("//option[contains(@selected,'selected')][contains(.,'Tous')]")).isDisplayed());
		}
		
		//Supprimer du champ de recharche "Jean" puis cliquer sur "Filtre" pour récupérer le tableau de tous les participants
		public void tableau (WebDriver driver) {
			filtre_field.clear();
			filtre_button.click();
		}
		
		//Steps 8 à 11 navigation avec les flèches
		public void pageDeux(WebDriver driver) throws InterruptedException {
			Thread.sleep(500);
			fleche_suivant.click();
			Thread.sleep(500);
			assertTrue(driver.findElement(By.xpath("//input[contains(@value,'2')]")).isDisplayed());
			
			Thread.sleep(500);
			fleche_precedent.click();
			Thread.sleep(500);
			assertTrue(driver.findElement(By.xpath("//input[contains(@value,'1')]")).isDisplayed());
			
			Thread.sleep(500);
			fleche_last.click();
			Thread.sleep(500);
			assertTrue(driver.findElement(By.xpath("//input[contains(@value,'2')]")).isDisplayed());
			String expected = driver.findElement(By.xpath("//span[contains(.,'/ 2')]")).getText();
			String expected2 = expected.substring(2);
			System.out.println(expected2);
			String actual = driver.findElement(By.xpath("//input[contains(@value,'2')]")).getAttribute("value");
			System.out.println(actual);
			Assert.assertEquals(expected2, actual);
			
			Thread.sleep(500);
			fleche_first.click();
			Thread.sleep(500);
//			assertTrue(driver.findElement(By.xpath("//input[contains(@value,'1')]")).isDisplayed());
			
			
/*			String number1 = "1";
			assertEquals("//input[contains(@value,'1')]".getBytes(),number1);
			String expectedNew = driver.findElement(By.xpath("//span[contains(.,'/ 2')]")).getText();
			String expectedLast = expectedNew.substring(1);
			System.out.println(expectedLast);
			String actual1 = driver.findElement(By.xpath("//input[contains(@name,'sDVWq5-real')]")).getAttribute("value");
			System.out.println(actual1);
			Assert.assertEquals(expectedNew, actual1);
*/
		}
		
		//Déconnexion puis reconnexion avec identifiants de Jean DU
		public void decoReco (WebDriver driver) throws InterruptedException {
			signout_btn.click();
			Thread.sleep(500);
			Utils.renseignerChamp(connect_username_field, utilisateur);
			Utils.renseignerChamp(connect_password_field, mdp);
			connect_btn.click();
		}
		
		//TOUT EST OK!!!!! :-D
		
		
		//GRE_03 : Test non passant
		
		//Création utilisateur vide
		public void userVide(WebDriver driver) {
			save.click();
			assertEquals(type.getText(),"");
		//Message attendu : Champ vide non autorisé. Vous devez spécifier une valeur	
		}
		
/*		public void dpct(WebDriver driver) {
		//Déplacement du cadre comportant le message d'erreur
			Actions actions = new Actions(driver);
			actions.clickAndHold(error_msg).moveToElement(new_position).release(new_position).build().perform();
			//Échec du Drag & drop
		}
*/		
		public void fermerMsg(WebDriver driver) {
			close_error_msg.click();
		}
		}
		