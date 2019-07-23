package com.eql.project_libreplan_group2;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTasks extends BasePage {

	@FindBy(xpath = "//div[contains(@class, 'standard-task')]")
	private List<WebElement> tasksDateBars;

	@FindBy(xpath = "//div[@class='deadline']")
	private List<WebElement> tasksDeadlineBars;

	@FindBy(xpath = "/html/body/div[contains(@class, 'z-menu-popup')]")
	private WebElement contextMenu;

	@FindBy(xpath = "/html/body/div[contains(@class, 'z-menu-popup')]/descendant::li[@class='z-menu-item']")
	private List<WebElement> contextItems;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]")
	private WebElement editTaskPopup;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]/descendant::div[@class='z-tabs-header']/ul/li[contains(@class,'z-tab') and not(contains(@style, 'display: none'))]")
	private List<WebElement> editTasksTabs;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]/descendant::div[@class='z-tabs-header']/ul/li[contains(@class,'z-tab-seld')]")
	private WebElement editTasksSelectedTab;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]/descendant::div[contains(@class, 'z-window-modal-header')][1]")
	private WebElement editTaskPopupTitle;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]/descendant::span[contains(@class, 'save-button')]")
	private WebElement editTasksSaveButton;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]/descendant::span[contains(@class, 'cancel-button')]")
	private WebElement editTasksCancelButton;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]/descendant::div[@class='z-tabpanels']/div[@class ='z-tabpanel' and not(contains(@style, 'display:none')) and not(contains(@style, 'display: none'))]/descendant::legend[.='Allocations']/../descendant::i[@class='z-bandbox-btn']")
	private WebElement editTasksSearchButton;

	@FindBy(xpath = "/html/body/div[contains(@class, 'z-bandbox-pp')]/descendant::div[contains(@class, 'bandbox-search z-listbox')]")
	private WebElement boxResources;

	@FindBy(xpath = "/html/body/div[contains(@class, 'z-bandbox-pp')]/descendant::div[contains(@class, 'bandbox-search z-listbox')]/div[@class='z-listbox-body']/table/descendant::tr[contains(@class, 'z-listitem')]")
	private List<WebElement> listResources;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]/descendant::div[@class='z-tabpanels']/div[@class ='z-tabpanel' and not(contains(@style, 'display:none')) and not(contains(@style, 'display: none'))]/descendant::legend[.='Allocations']/../descendant::input[@class='z-bandbox-inp']")
	private WebElement inputResource;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]/descendant::div[@class='z-tabpanels']/div[@class ='z-tabpanel' and not(contains(@style, 'display:none')) and not(contains(@style, 'display: none'))]/descendant::legend[.='Allocations']/../descendant::td[.='Ajouter'][@class='z-button-cm']")
	private WebElement buttonAddResource;

	@FindBy(xpath = "//div[@class='message_ERROR']")
	private WebElement errorMessage;

	@FindBy(xpath = "//div[contains(@class, 'edit-task-window')]/descendant::div[@class='z-tabpanels']/div[@class ='z-tabpanel' and not(contains(@style, 'display:none')) and not(contains(@style, 'display: none'))]/descendant::legend[.='Allocations']/../descendant::tr[contains(@class, 'allocation-not-satisfied z-row')]")
	private List<WebElement> resourcesRows;
	
	@FindBy(xpath="//span[.='Zoom:']/ancestor::td[1]/following-sibling::td[2]/descendant::select")
	private WebElement selectZoom;
	
	@FindBy(xpath="//div[@id='timetrackerheader']/descendant::tr[@class='z-columns'][2]")
	private WebElement zoomRow;
	
	@FindBy(xpath="//div[@id='timetrackerheader']/descendant::tr[@class='z-columns'][1]")
	private WebElement zoomRowHead;

	public void test() {
		Assert.assertFalse(tasksDateBars.isEmpty());
		Assert.assertFalse(tasksDeadlineBars.isEmpty());
	}

	public void rightClickBar(WebDriver driver, int index) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.contextClick(tasksDateBars.get(index)).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOf(contextMenu));
		List<String> contextElements = contextItems.stream().map(element -> element.getText().trim())
				.filter(element -> !element.isEmpty()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Ajouter une dépendance", "Ajouter un jalon", "Propriétés de la tâche",
				"Allocation de ressources", "Allocation avancée", "Sous-contrat", "Allocation de calendrier",
				"Affectation d'avancement", "Consolidation d'avancement");
		Assert.assertEquals(expected, contextElements);
	}

	public void clickOnContextItem(String item) {
		contextItems.stream().filter(element -> element.getText().trim().equals(item)).findFirst().get().click();
	}

	public void testPopup(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(editTaskPopup));
		Assert.assertTrue(editTaskPopupTitle.getText().trim().contains("Modifier la tâche: "));
		List<String> tabs = editTasksTabs.stream().map(element -> element.getText().trim())
				.filter(element -> !element.isEmpty()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Propriétés de la tâche", "Allocation de ressource normale");
		Assert.assertEquals(expected, tabs);
		Assert.assertTrue(editTasksSaveButton.isDisplayed());
		Assert.assertTrue(editTasksCancelButton.isDisplayed());
		Assert.assertEquals("Allocation de ressource normale", editTasksSelectedTab.getText().trim());
		editTasksSearchButton.click();
		wait.until(ExpectedConditions.visibilityOf(boxResources));
		Assert.assertTrue(boxResources.isDisplayed());
	}

	public void clickResource(int index) throws InterruptedException {
		listResources.get(index).click();
		Thread.sleep(200);
		Assert.assertFalse(inputResource.getAttribute("value").trim().isEmpty());
		try {
			Assert.assertFalse(boxResources.isDisplayed());
		} catch (Exception ex) {
			System.out.println("La liste déroulante des critères et des ressources n'est pas affichée");
		}
		buttonAddResource.click();
		// check that there are rows
		try {
			if (errorMessage.isDisplayed() && !errorMessage.getText().trim().isEmpty()) {
				Assert.fail("Le critère ou la ressource sélectionnné n'a pas été rajouté");
			}
		} catch (Exception ex) {

		}
		Thread.sleep(200);
		Assert.assertFalse(resourcesRows.isEmpty());
	}
	
	public void saveTaskResources() throws InterruptedException {
		editTasksSaveButton.click();
		Thread.sleep(100);
		try {
			Assert.assertFalse(editTaskPopup.isDisplayed());
		}catch(Exception ex) {
			System.out.println("La fenêtre d'allocation des ressources de la tache est fermée");
		}
	}

	public void checkTaskResourcesAllocation(int index) {
		Assert.assertTrue(Arrays.asList(tasksDateBars.get(index).getAttribute("class").split(" ")).contains("assigned"));
	}
	
	public void setZoom(String zoom) {
		Select select = new Select(selectZoom);
		select.selectByVisibleText(zoom);
	}
	
	public void checkH1h2() throws InterruptedException {
		Thread.sleep(500);
		Assert.assertEquals("H1", zoomRow.findElement(By.xpath("td[1]")).getText().trim());
		Assert.assertEquals("H2", zoomRow.findElement(By.xpath("td[2]")).getText().trim());
	}
	
	public void checkQuarters() throws InterruptedException {
		Thread.sleep(500);
		Assert.assertEquals("Q1", zoomRow.findElement(By.xpath("td[1]")).getText().trim());
		Assert.assertEquals("Q2", zoomRow.findElement(By.xpath("td[2]")).getText().trim());
		Assert.assertEquals("Q3", zoomRow.findElement(By.xpath("td[3]")).getText().trim());
		Assert.assertEquals("Q4", zoomRow.findElement(By.xpath("td[4]")).getText().trim());
	}
	
	public void checkMonths() throws InterruptedException {
		Thread.sleep(500);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		Assert.assertEquals(year +",H1", zoomRowHead.findElement(By.xpath("th[1]")).getText().trim());
		Assert.assertEquals(year +",H2", zoomRowHead.findElement(By.xpath("th[2]")).getText().trim());
		
		Assert.assertEquals("janv.", zoomRow.findElement(By.xpath("td[1]")).getText().trim());
		Assert.assertEquals("févr.", zoomRow.findElement(By.xpath("td[2]")).getText().trim());
		Assert.assertEquals("mars", zoomRow.findElement(By.xpath("td[3]")).getText().trim());
		Assert.assertEquals("avr.", zoomRow.findElement(By.xpath("td[4]")).getText().trim());
		Assert.assertEquals("mai", zoomRow.findElement(By.xpath("td[5]")).getText().trim());
		Assert.assertEquals("juin", zoomRow.findElement(By.xpath("td[6]")).getText().trim());
	}
	
}
