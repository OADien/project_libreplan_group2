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

public class PageEngineManagement extends BasePage{
	
	@FindBy(xpath = "//div[contains(@class,'machinewindow')][1]/descendant::div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-columns')][1]/th")
	private List<WebElement> columnTitles;
	
	@FindBy(xpath = "//span[contains(@class, 'create-button')]")
	private WebElement buttonCreate;
	
	@FindBy(xpath="//span[@class='z-label'][.='Filtré par']/ancestor::td[1]/following-sibling::td[2]/descendant::input[1]")
	private WebElement inputSearch;
	
	@FindBy(xpath="//span[@class='z-label'][.='Filtré par']/ancestor::td[1]/following-sibling::td[2]/descendant::i[@class='z-bandbox-btn']")
	private WebElement buttonSearch;
	
	@FindBy(xpath="//span[@class='z-label'][.='Détails personnels']/ancestor::td[1]/following-sibling::td[2]/descendant::input[1]")
	private WebElement inputDetails;
	
	@FindBy(xpath="//div[contains(@class, 'filter-more-options')]")
	private WebElement buttonFilterMoreOptions;
	
	@FindBy(xpath="//td[@class='z-button-cm'][.='Filtre']")
	private WebElement buttonFilter;
	
	@FindBy(xpath = "//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-row')]")
	private List<WebElement> engineRows;
	
	public void test() {
		Assert.assertEquals("Machines Liste", pageTitle.getText().trim());
		List<String> list = columnTitles.stream().map(col -> col.getText().trim()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Nom", "Description", "Code", "En file", "Opérations");
		Assert.assertEquals(expected, list);
		Assert.assertTrue(inputSearch.isDisplayed());
		Assert.assertTrue(inputDetails.isDisplayed());
		Assert.assertTrue(buttonCreate.isDisplayed());
		Assert.assertTrue(inputSearch.isDisplayed());
		Assert.assertTrue(buttonSearch.isDisplayed());
		Assert.assertTrue(buttonFilterMoreOptions.isDisplayed());
		Assert.assertTrue(buttonFilter.isDisplayed());
	}
	
	public PageCreateUpdateEngine clickOnCreate(WebDriver driver) {
		buttonCreate.click();
		return PageFactory.initElements(driver, PageCreateUpdateEngine.class);
	}
	
	public WebElement getEngineRow(String name) {
		return engineRows.stream().filter(item -> name.equals(item.findElement(By.xpath("td[1]")).getText().trim()))
				.findFirst().orElse(null);
	}

	public void checkEngine(String name, String code, String description) throws InterruptedException {
		Thread.sleep(100);
		WebElement row = getEngineRow(name);
		Assert.assertEquals(code, row.findElement(By.xpath("td[2]")).getText().trim());
		Assert.assertEquals(description, row.findElement(By.xpath("td[3]")).getText().trim());
	}

}
