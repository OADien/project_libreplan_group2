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

public class PageProgressionTypes extends BasePage{
	
	@FindBy(xpath = "//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-columns')][1]/th")
	private List<WebElement> columnTitles;
	
	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-row')]")
	private List<WebElement> progressionTypesRows;
	
	@FindBy(xpath = "//span[contains(@class, 'create-button')]")
	private WebElement buttonCreate;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private List<WebElement> infoMessages;
	
	public void test() {
		Assert.assertEquals("Types d'avancement Liste", pageTitle.getText().trim());
		List<String> list = columnTitles.stream().map(col -> col.getText().trim()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Nom", "Activé", "Prédéfini", "Opérations");
		Assert.assertEquals(expected, list);
		Assert.assertTrue(buttonCreate.isDisplayed());
	}
	
	public PageCreateUpdateProgressionType clickOnCreate(WebDriver driver) {
		buttonCreate.click();
		return PageFactory.initElements(driver, PageCreateUpdateProgressionType.class);
	}
	
	public WebElement getProgressionTypeRow(String name) {
		return progressionTypesRows.stream().filter(item -> name.equals(item.findElement(By.xpath("td[1]")).getText().trim()))
				.findFirst().orElse(null);
	}
	
	public void checkProgressionType(String name, Boolean isEnabled, Boolean isPredefined) throws InterruptedException {
		Thread.sleep(100);
		Assert.assertEquals(String.format("Type d'avancement \"%s\" enregistré", name), infoMessages.get(infoMessages.size()-1).getText().trim());
		WebElement row = getProgressionTypeRow(name);
		WebElement checkboxEnabled = row.findElement(By.xpath("td[2]/descendant::input[@type='checkbox'][1]"));
		Assert.assertEquals(isEnabled, checkboxEnabled.isSelected());
		Assert.assertFalse(checkboxEnabled.isEnabled());
		WebElement checkboxPredefined = row.findElement(By.xpath("td[3]/descendant::input[@type='checkbox'][1]"));
		Assert.assertEquals(isPredefined, checkboxPredefined.isSelected());
		Assert.assertFalse(checkboxPredefined.isEnabled());
		Assert.assertTrue(row.findElement(By.xpath("td[4]/descendant::span[@title='Modifier'][1]")).isDisplayed());
		Assert.assertTrue(row.findElement(By.xpath("td[4]/descendant::span[@title='Supprimer'][1]")).isDisplayed());
	}

}
