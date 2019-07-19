package com.eql.project_libreplan_group2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Lists;

public class PageMain {
	
	@FindBy(xpath="//span[@title='Créer un nouveau projet']")
	private WebElement buttonAdd;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]")
	private WebElement createModal;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal-header')][1]")
	private WebElement createModalHeader;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::input[ancestor::tr[1]/descendant::span[.='Nom']]")
	private WebElement inputNom;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::input[ancestor::tr[1]/descendant::span[.='Modèle']]")
	private WebElement inputModel;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::input[ancestor::tr[3]/descendant::span[.='Code']]")
	private WebElement inputCode;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::input[@type='checkbox'][1]")
	private WebElement inputGenerer;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::input[ancestor::tr[1]/descendant::span[.='Date de début']]")
	private WebElement inputDatedebut;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::i[contains(@class, 'z-datebox-btn')][ancestor::tr[1]/descendant::span[.='Date de début']]")
	private WebElement buttonCal;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::input[ancestor::tr[1]/descendant::span[.='Echéance']]")
	private WebElement inputEcheance;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::input[ancestor::tr[1]/descendant::span[.='Client']]")
	private WebElement inputClient;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::input[ancestor::tr[1]/descendant::span[.='Calendrier']]")
	private WebElement inputCalendrier;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')]")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[contains(@class, 'cancel-button')]")
	private WebElement cancelButton;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-datebox-pp')]/descendant::table[contains(@class, 'z-calendar-calday')][1]/tbody/tr/td")
	private List<WebElement> days;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-modal')][1]/descendant::i[contains(@class, 'z-datebox-btn')][ancestor::tr[1]/descendant::span[.='Echéance']]")
	private WebElement buttonCal2;
	
	@FindBy(xpath="//span[contains(@class, 'perspective-active')]")
	private WebElement selectedLeft;
	
	@FindBy(xpath="//li[contains(@class, 'z-tab-seld')]")
	private WebElement selectedTab;
	
	@FindBy(xpath="//span[contains(@class, 'perspective')]")
	private List<WebElement> left;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-embedded')][2]/descendant::li[contains(@class, 'z-tab')]")
	private List<WebElement> tabs;
	
	@FindBy(xpath="//div[contains(@class, 'z-window-embedded')][2]")
	private WebElement tabsContainer;
	
	@FindBy(xpath="//span[contains(@title, 'Enregistrer le projet')]")
	private WebElement saveProject;
	
	@FindBy(xpath="//span[contains(@title, \"Annuler l'édition\")]")
	private WebElement cancelProject;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::div[contains(@class, 'z-window-modal-header')]")
	private WebElement cancelModalTitle;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::div[contains(@class, 'z-messagebox')]")
	private WebElement cancelModalBody;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::span[contains(@class, 'z-messagebox-btn')][.='OK']")
	private WebElement cancelModalButtonOk;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::span[contains(@class, 'z-messagebox-btn')][.='Annuler']")
	private WebElement cancelModalButtonAnnuler;
	
	@FindBy(xpath="//td[.='Liste des projets']")
	private WebElement buttonProjectsList;
	
	
	@FindBy(xpath="//tr[@class='ruta']")
	private WebElement breadcrumb;
	
	@FindBy(xpath="//span[.='Nouvelle tâche']/following::input[1]")
	private WebElement taskTitle;
	
	@FindBy(xpath="//span[.='Heures']/following::input[1]")
	private WebElement taskHour;
	
	@FindBy(xpath="//div[contains(@class, 'orderelements-tab')]/descendant::td[.='Ajouter'][2]")
	private WebElement  buttonAddTask;
	
	@FindBy(xpath="//span[@title='Fully scheduled']")
	private WebElement  buttonTaskScheduling;
	
	@FindBy(xpath="//span[@title='Déprogrammé']")
	private WebElement  buttonTaskUnplanned;
	
	@FindBy(xpath="//tr[contains(@class, 'z-treerow')]")
	private List<WebElement> tasks;
	
	@FindBy(xpath="//span[@title='Descendre la tâche sélectionnée']")
	private WebElement buttonTaskDown;
	
	@FindBy(xpath="//span[@title='Remonter la tâche sélectionnée']")
	private WebElement buttonTaskUp;
	
	@FindBy(xpath="//span[.='Code ']/ancestor::tr[1]/descendant::input[1]")
	private WebElement inputTaskCode;
	
	@FindBy(xpath="//span[.='Date de début']/ancestor::tr[1]/descendant::i[contains(@class, 'z-datebox-btn')]")
	private WebElement buttonTaskDatedebut;
	
	@FindBy(xpath="//span[.='Echéance']/ancestor::tr[1]/descendant::i[contains(@class, 'z-datebox-btn')]")
	private WebElement buttonTaskEcheance;
	
	@FindBy(xpath="//span[contains(@class, 'back-button')]")
	private WebElement buttonTaskReturn;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::span")
	private WebElement savedProjectModalBody;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::td[.='OK']")
	private WebElement savedProjectModalButtonOk;
	
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::div[contains(@class, 'z-window-modal-close')]")
	private WebElement savedProjectModalButtonClose;
	
	@FindBy(xpath="//td[.='Planification de projet']")
	private WebElement buttonProjectPlanning;
	
	@FindBy(xpath="//div[contains(@class, 'standard-task')]")
	private List<WebElement> tasksDateBars;
	
	@FindBy(xpath="//div[@class='deadline']")
	private List<WebElement> tasksDeadlineBars;
	
//	@FindBy(xpath="//div[contains(@class, 'orderelements-tab')]/descendant::td[.='Ajouter'][2]")
//	private WebElement 
//	
//	
	public void clickMenu(WebDriver driver, String title, String subtitle) {
		WebElement section = driver.findElement(By.xpath("//*[contains(@class,'mainmenu')]/descendant::button[contains(.,'"+ title.trim()+"')]/.."));
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions actions = new Actions(driver);
		actions.moveToElement(section);
		actions.build().perform();
		
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(wait.until(ExpectedConditions.visibilityOf(section.findElement(By.xpath("//div[contains(@class, 'submenu')]/ul/li/descendant::a[contains(., '"+subtitle+"')]")))));
		actions2.click();
		actions2.build().perform();
	}
	
	public void createProject(WebDriver driver) throws InterruptedException {
		buttonAdd.click();
		Thread.sleep(100);
		Assert.assertTrue(createModal.isDisplayed());
		Assert.assertEquals("Créer un nouveau projet", createModalHeader.getText().trim());
	}
	
	
	public void testModal() throws ParseException {
		Assert.assertEquals("", inputNom.getAttribute("value"));
		Assert.assertEquals("", inputModel.getAttribute("value"));
		//check that the code is not empty and grayed
		Assert.assertFalse(inputCode.getAttribute("value").isEmpty());
		Assert.assertFalse(inputCode.getAttribute("disabled").isEmpty());
		Assert.assertTrue(inputGenerer.isSelected());
		//Date début  = date du jour
		String datedebut = inputDatedebut.getAttribute("value");
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.FRENCH);
		Date date = sdf.parse(datedebut);
		Date now = new Date();
		Assert.assertTrue(now.getYear() == date.getYear() && now.getMonth() == date.getMonth() && now.getDay() == date.getDay());
		Assert.assertEquals("", inputEcheance.getAttribute("value"));
		Assert.assertEquals("", inputClient.getAttribute("value"));
		Assert.assertEquals("Default", inputCalendrier.getAttribute("value"));
		Assert.assertTrue(saveButton.isDisplayed());
		Assert.assertTrue(cancelButton.isDisplayed());
	}
	
	
	public void fillForm() throws InterruptedException {
		Utils.renseignerChamp(inputNom, "PROJET_TEST1");
		inputGenerer.click();
		Thread.sleep(100);
		Utils.renseignerChamp(inputCode, "PRJTEST001");
		buttonCal.click();
		Thread.sleep(100);
		int index = 0;
		for(int i = 0; i< days.size();i++) {
			if(days.get(i).getAttribute("class").contains("z-calendar-seld")) {
				index = i;
				break;
			}
		}
		index += 5;
		System.out.println("days number = " + days.size());
		System.out.println("day = " + days.get(index).getText());
		days.get(index).click();
		
		buttonCal2.click();
		Thread.sleep(100);
		index = 0;
		for(int i = 0; i< days.size();i++) {
			if(days.get(i).getAttribute("class").contains("z-calendar-seld")) {
				index = i;
				break;
			}
		}
		index += 15;
		System.out.println("days number = " + days.size());
		System.out.println("day = " + days.get(index).getText());
		days.get(index).click();
		saveButton.click();
		
		Thread.sleep(2000);
		Assert.assertEquals("Détail du projet", selectedLeft.getText().trim());
		Assert.assertEquals("WBS (tâches)", selectedTab.getText().trim());
		
		//check that there are 5 left buttons
		List<String> leftText= left.stream().filter(element -> element.isDisplayed()).map(element -> element.getText().trim()).collect(Collectors.toList());
		System.out.println(String.join(",", leftText));
		List<String> expected = Arrays.asList("Planification de projet", "Détail du projet","Chargement des ressources","Allocation avancée","Tableau de bord" );
		Assert.assertEquals(expected, leftText);
		
		List<String> tabsText= tabs.stream().map(element -> element.getText().trim()).filter(element -> !element.isEmpty()).collect(Collectors.toList());
		System.out.println(String.join(",", tabsText));
		expected = Arrays.asList("WBS (tâches)", "Données générales", "Coût", "Avancement", "Libellés", "Exigence de critère", "Matériels", "Formulaires qualité des tâches", "Autorisation" );
		Assert.assertEquals(expected, tabsText);
		
		Assert.assertTrue(saveProject.isDisplayed());
		Assert.assertTrue(cancelProject.isDisplayed());
		
		//click on the cancel button
		cancelProject.click();
		
		Thread.sleep(100);
		
		Assert.assertEquals("Confirmer la fenêtre de sortie", cancelModalTitle.getText().trim());
		Assert.assertEquals("Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", cancelModalBody.getText().trim());
		Assert.assertTrue(cancelModalButtonOk.isDisplayed());
		Assert.assertTrue(cancelModalButtonAnnuler.isDisplayed());
		
		
		//click on Annuler on the popup
		cancelModalButtonAnnuler.click();
		
		Thread.sleep(1000);
		
		//click on the button to cancel the editing of the project
		cancelProject.click();
		
		Thread.sleep(100);
		
		Assert.assertEquals("Confirmer la fenêtre de sortie", cancelModalTitle.getText().trim());
		Assert.assertEquals("Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", cancelModalBody.getText().trim());
		Assert.assertTrue(cancelModalButtonOk.isDisplayed());
		Assert.assertTrue(cancelModalButtonAnnuler.isDisplayed());
		
		cancelModalButtonOk.click();
		
		Thread.sleep(1000);
		
		Assert.assertEquals("Planification des projets", selectedLeft.getText().trim());
		//no horizontal menu
		try {
			Assert.assertFalse(tabsContainer.isDisplayed());
		} catch(Exception ex) {
			System.out.println("Pas de menu horizontal");
		}
	}
	
	public void clickOnProjectsList() {
		buttonProjectsList.click();
	}
	
	public void testProjectTasks() {
		Assert.assertEquals("WBS (tâches)", selectedTab.getText().trim());
		Assert.assertEquals("DEBUT Calendrier Détail du projet PROJET_TEST1", breadcrumb.getText().trim().replace("\r", "").replace("\n", " "));
	}
	
	public void createTask(String title, String hour) throws InterruptedException {
		Utils.renseignerChamp(taskTitle, title);
		Utils.renseignerChamp(taskHour,  hour);
		buttonAddTask.click();
		Thread.sleep(1000);
		//check the table
		WebElement line = getTaksRow(title);
		Assert.assertEquals(title+".  Avancement:0.", line.getAttribute("title").trim());
		Assert.assertEquals("",getTaskCellValue(line, 2));
		Assert.assertEquals(hour, getTaskCellValue(line, 4));
		Assert.assertEquals("0 €", getTaskCellValue(line, 5));
		Assert.assertEquals("", getTaskCellValue(line, 6));
		Assert.assertEquals("", getTaskCellValue(line, 7));
		WebElement iconsContainer = line.findElement(By.xpath("td[8]"));
		//Assert.assertTrue(iconsContainer.findElement(By.xpath("//span[@title='Modifier']")).isDisplayed());
		//Assert.assertTrue(iconsContainer.findElement(By.xpath("//span[@title='Supprimer']")).isDisplayed());
	}
	
	public WebElement getTaksRow(String taskname) {
		for(WebElement task: tasks) {
			System.out.println("task name = " + getTaskCellValue(task, 3));
			if(taskname.equals(getTaskCellValue(task, 3)))
				return task;
		}
		return null;
	}
	
	public String getTaskCellValue(WebElement line, int col) {
		return line.findElement(By.xpath("td["+col+"]/descendant::input[@type='text'][1]")).getAttribute("value").trim();
	}
	
	public void checkTasksList(String... expected) {
		List<String> tasksTitle = tasks.stream().map(task -> getTaskCellValue(task, 3)).filter(str -> !str.isEmpty()).collect(Collectors.toList());
		Assert.assertEquals(Arrays.asList(expected), tasksTitle);
	}
	
	public void moveTaskDown(String task) {
		this.getTaksRow(task).click();
		buttonTaskDown.click();
	}
	public void moveTaskUp(String task) {
		this.getTaksRow(task).click();
		buttonTaskUp.click();
	}
	
	public void editTask(String taskname, String code, Integer datedebut, Integer echeance) throws InterruptedException {
		getTaksRow(taskname).findElement(By.xpath("td[8]/descendant::span[@title='Modifier']")).click();
		Thread.sleep(200);
		Utils.renseignerChamp(inputTaskCode, code);
		if(datedebut != null) {
			buttonTaskDatedebut.click();
			Thread.sleep(100);
			int index = 6 + datedebut;
			System.out.println("day = " + days.get(index).getText());
			days.get(index).click();
		}
		if(echeance != null) {
			buttonTaskEcheance.click();
			Thread.sleep(100);
			int index = 6 + echeance;
			System.out.println("day = " + days.get(index).getText());
			days.get(index).click();
			Thread.sleep(100);
		}
		
		buttonTaskReturn.click();
	}
	
	public void saveProject() throws InterruptedException {
		saveProject.click();
		Thread.sleep(100);
		Assert.assertEquals("Projet enregistré", savedProjectModalBody.getText().trim());
		Assert.assertTrue(savedProjectModalButtonOk.isDisplayed());
		Assert.assertTrue(savedProjectModalButtonClose.isDisplayed());
		savedProjectModalButtonOk.click();
		Thread.sleep(100);
	}
	
	public void gotoProjectPlanning() {
		buttonProjectPlanning.click();
		//check that bars are visible on the planning
		Assert.assertFalse(tasksDateBars.isEmpty());
		Assert.assertFalse(tasksDeadlineBars.isEmpty());
	}

}
