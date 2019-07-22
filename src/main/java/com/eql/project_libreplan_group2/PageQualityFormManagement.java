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

public class PageQualityFormManagement extends BasePage {
	
	@FindBy(xpath = "//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-columns')][1]/th")
	private List<WebElement> columnTitles;
	
	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-row')]")
	private List<WebElement> qualityFormRows;
	
	@FindBy(xpath = "//span[contains(@class, 'create-button')]")
	private WebElement buttonCreate;
	
	@FindBy(xpath="//input[@class='z-textbox']")
	private WebElement inputSearch;
	
	@FindBy(xpath="//td[@class='z-button-cm'][.='Filtre']")
	private WebElement buttonSearch;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private WebElement infoMessage;
	
	public void test() {
		Assert.assertEquals("Formulaires qualité Liste", pageTitle.getText().trim());
		List<String> list = columnTitles.stream().map(col -> col.getText().trim()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Nom", "Description", "Opérations");
		Assert.assertEquals(expected, list);
		Assert.assertTrue(buttonCreate.isDisplayed());
		Assert.assertTrue(inputSearch.isDisplayed());
		Assert.assertTrue(buttonSearch.isDisplayed());
	}
	
	public PageCreateUpdateQualityForm clickOnCreate(WebDriver driver) {
		buttonCreate.click();
		return PageFactory.initElements(driver, PageCreateUpdateQualityForm.class);
	}
	
	public WebElement getQualityFormRow(String name) {
		return qualityFormRows.stream().filter(item -> name.equals(item.findElement(By.xpath("td[1]")).getText().trim()))
				.findFirst().orElse(null);
	}
	
	public void checkQualityForm(String name) throws InterruptedException {
		Thread.sleep(100);
		Assert.assertNotNull(getQualityFormRow(name));
	}
	
	public PageCreateUpdateQualityForm clickOnQualityFormName(WebDriver driver, String name) {
		getQualityFormRow(name).findElement(By.xpath("td[1]")).click();
		return PageFactory.initElements(driver,  PageCreateUpdateQualityForm.class);
	}
	
	public void checkSavedQualityForm(String name) throws InterruptedException {
		Thread.sleep(100);
		Assert.assertEquals(String.format("Formulaire qualité \"%s\" enregistré", name), infoMessage.getText().trim());
		Assert.assertNotNull(getQualityFormRow(name));
	}

}
