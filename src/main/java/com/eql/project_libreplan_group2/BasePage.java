package com.eql.project_libreplan_group2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	@FindBy(xpath="//span[@title='Créer un nouveau projet']")
	protected WebElement buttonAdd;
	
	@FindBy(xpath="//span[contains(@class, 'perspective-active')]")
	protected WebElement selectedLeft;
	
	@FindBy(xpath="//li[contains(@class, 'z-tab-seld')]")
	protected WebElement selectedTab;
	
	@FindBy(xpath="//span[contains(@class, 'perspective')]")
	protected List<WebElement> left;
	
	@FindBy(xpath="//table[contains(@class, 'toolbar-box global-commands')]/descendant::span[contains(@title, 'Enregistrer')]")
	protected WebElement saveProject;
	
	@FindBy(xpath="//table[contains(@class, 'toolbar-box global-commands')]/descendant::span[contains(@title, 'Annuler')]")
	protected WebElement cancelProject;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::div[contains(@class, 'z-window-modal-header')]")
	protected WebElement cancelModalTitle;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::div[contains(@class, 'z-messagebox')]")
	protected WebElement cancelModalBody;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::span[contains(@class, 'z-messagebox-btn')][.='OK']")
	protected WebElement cancelModalButtonOk;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::span[contains(@class, 'z-messagebox-btn')][.='Annuler']")
	protected WebElement cancelModalButtonAnnuler;
	
	@FindBy(xpath="//td[.='Liste des projets']")
	protected WebElement buttonProjectsList;
	
	@FindBy(xpath="//tr[@class='ruta']")
	protected WebElement breadcrumb;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::span")
	protected WebElement savedProjectModalBody;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::td[.='OK']")
	protected WebElement savedProjectModalButtonOk;
	
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-window-modal')]/descendant::div[contains(@class, 'z-window-modal-close')]")
	protected WebElement savedProjectModalButtonClose;
	
	@FindBy(xpath="//td[.='Planification de projet']")
	protected WebElement buttonProjectPlanning;
	
	@FindBy(xpath="//td[.='Chargement des ressources']")
	protected WebElement buttonResourcesList;
	
	public void clickMenu(WebDriver driver, String title, String subtitle) {
		WebElement section = driver.findElement(By.xpath("//*[contains(@class,'mainmenu')]/descendant::button[contains(.,\""+ title.trim()+"\")]/.."));
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions actions = new Actions(driver);
		actions.moveToElement(section);
		actions.build().perform();
		
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(wait.until(ExpectedConditions.visibilityOf(section.findElement(By.xpath("//div[contains(@class, 'submenu')]/ul/li/descendant::a[contains(., \""+subtitle+"\")]")))));
		actions2.click();
		actions2.build().perform();
	}
	
	public void clickOnProjectsList() {
		buttonProjectsList.click();
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
	
	public PageTasks gotoProjectPlanning(WebDriver driver) {
		buttonProjectPlanning.click();
		//check that bars are visible on the planning
		return PageFactory.initElements(driver, PageTasks.class);
	}
	
	public PageTaskResources gotoResourcesList(WebDriver driver) throws InterruptedException {
		buttonResourcesList.click();
		Thread.sleep(100);
		return PageFactory.initElements(driver, PageTaskResources.class);
	}

}
