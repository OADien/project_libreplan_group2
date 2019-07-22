package com.eql.project_libreplan_group2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCriteriaManagement extends BasePage {

	@FindBy(xpath = "//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-columns')][1]/th")
	private List<WebElement> columnTitles;

	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-row')]")
	private List<WebElement> criteriaRows;

	@FindBy(xpath = "//span[contains(@class, 'create-button')]")
	private WebElement buttonCreate;
	
	
	@FindBy(xpath = "//div[@class = 'z-window-modal z-window-modal-shadow']")
	private WebElement deleteCriteriumPopup;
	
	@FindBy(xpath = "//div[@class = 'z-window-modal z-window-modal-shadow']/descendant::div[contains(@class, 'z-window-modal-header')][1]")
	private WebElement deleteCriteriumPopupTitle;
	
	@FindBy(xpath="//div[@class = 'z-window-modal z-window-modal-shadow']/descendant::div[contains(@class, 'z-messagebox')][1]")
	private WebElement deleteCriteriumPopupMessage;
	
	@FindBy(xpath = "//span[contains(@class, 'z-messagebox-btn z-button')][.='OK']")
	private WebElement deleteCriteriumPopupOkButton;

	@FindBy(xpath = "//span[contains(@class, 'z-messagebox-btn z-button')][.='Annuler']")
	private WebElement deleteCriteriumPopupCancelButton;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private WebElement infoMessage;

	public void test() {
		Assert.assertEquals("Types de critères Liste", pageTitle.getText().trim());
		List<String> list = columnTitles.stream().map(col -> col.getText().trim()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Nom", "Code", "Type", "Activé", "Opérations");
		Assert.assertEquals(expected, list);
		Assert.assertTrue(buttonCreate.isDisplayed());
	}

	public PageCreateUpdateCriterium clickOnCreate(WebDriver driver) {
		buttonCreate.click();
		return PageFactory.initElements(driver, PageCreateUpdateCriterium.class);
	}

	public WebElement getCriteriumRow(String name) {
		return criteriaRows.stream().filter(item -> name.equals(item.findElement(By.xpath("td[1]")).getText().trim()))
				.findFirst().orElse(null);
	}

	public void checkCriterium(String name) throws InterruptedException {
		Thread.sleep(100);
		Assert.assertNotNull(getCriteriumRow(name));
	}

	public WebElement getEditCriteriumIcon(String name) {
		return getCriteriumRow(name).findElement(By.xpath("td[5]/descendant::span[@title='Modifier']"));
	}

	public PageCreateUpdateCriterium editCriterium(WebDriver driver, String name) {
		getEditCriteriumIcon(name).click();
		return PageFactory.initElements(driver, PageCreateUpdateCriterium.class);
	}

	public PageCreateUpdateCriterium clickOnCriteriumName(WebDriver driver, String name) {
		getCriteriumRow(name).findElement(By.xpath("td[1]")).click();
		return PageFactory.initElements(driver,  PageCreateUpdateCriterium.class);
	}
	
	public void deleteCriterium(String name) throws InterruptedException {
		getCriteriumRow(name).findElement(By.xpath("td[5]/descendant::span[@title='Supprimer']")).click();
		Thread.sleep(100);
		Assert.assertTrue(deleteCriteriumPopup.isDisplayed());
		Assert.assertEquals("Confirmer", deleteCriteriumPopupTitle.getText().trim());
		Assert.assertEquals(String.format("Supprimer Type de critère \"%s\". Êtes-vous sûr ?", name), deleteCriteriumPopupMessage.getText().trim());
		Assert.assertTrue(deleteCriteriumPopupOkButton.isDisplayed());
		Assert.assertTrue(deleteCriteriumPopupCancelButton.isDisplayed());
	}
	
	public void cancelDeleteCriterium() throws InterruptedException {
		deleteCriteriumPopupCancelButton.click();
		Thread.sleep(100);
		Assert.assertFalse(deleteCriteriumPopup.isDisplayed());
	}
	
	public void confirmDeleteCriterium(String name) throws InterruptedException {
		deleteCriteriumPopupOkButton.click();
		Thread.sleep(100);
		Assert.assertFalse(deleteCriteriumPopup.isDisplayed());
		Assert.assertEquals(String.format("Type de critère \"%s\" supprimé", name), infoMessage.getText().trim());
		Assert.assertNull(getCriteriumRow(name));
	}
}
