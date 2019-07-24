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

public class PageSpecialDayManagement extends BasePage{
	
	@FindBy(xpath = "//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-columns')][1]/th")
	private List<WebElement> columnTitles;
	
	@FindBy(xpath = "//span[contains(@class, 'create-button')]")
	private WebElement buttonCreate;
	
	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-row')]")
	private List<WebElement> specialDayRows;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private WebElement infoMessage;
	
	public void test() {
		Assert.assertEquals("Jours exceptionnels du calendrier Liste", pageTitle.getText().trim());
		List<String> list = columnTitles.stream().map(col -> col.getText().trim()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Nom", "Couleur", "Sur-affecté", "Effort standard", "Effort en heures supplémentaires", "Opérations");
		Assert.assertEquals(expected, list);
		Assert.assertTrue(buttonCreate.isDisplayed());
	}
	
	public PageCreateUpdateSpecialDay clickOnCreate(WebDriver driver) {
		buttonCreate.click();
		return PageFactory.initElements(driver,  PageCreateUpdateSpecialDay.class);
	}
	
	public WebElement getSpecialDayRow(String name) {
		return specialDayRows.stream().filter(item -> name.equals(item.findElement(By.xpath("td[1]")).getText().trim()))
				.findFirst().orElse(null);
	}
	
	public void checkSpecialDay(String name) throws InterruptedException {
		Thread.sleep(100);
		Assert.assertNotNull(getSpecialDayRow(name));
	}
	
	public void checkSavedSpecialDay(String name, String standardEffort1, String standardEffort2, String suppEffort1, String suppEffort2) throws InterruptedException {
		Thread.sleep(100);
		Assert.assertEquals(String.format("Jour du calendrier exceptionnel \"%s\" enregistré",  name), infoMessage.getText().trim());
		WebElement row = getSpecialDayRow(name);
		Assert.assertEquals(name, row.findElement(By.xpath("td[1]")).getText().trim());
		Assert.assertEquals(String.format("%s:%s", standardEffort1, standardEffort2), row.findElement(By.xpath("td[4]")).getText().trim());
		Assert.assertEquals(String.format("%s:%s", suppEffort1, suppEffort2), row.findElement(By.xpath("td[5]")).getText().trim());
	}
	
	public void checkSpecialDayNotExists(String name) throws InterruptedException {
		Thread.sleep(100);
		Assert.assertNull(getSpecialDayRow(name));
	}

}
