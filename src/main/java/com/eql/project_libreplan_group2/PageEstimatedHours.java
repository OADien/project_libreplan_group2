package com.eql.project_libreplan_group2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageEstimatedHours extends BasePage {
	
	@FindBy(xpath="//div[contains(@class, 'z-panel-header ')]")
	private List<WebElement> sectionsTitles;
	
	@FindBy(xpath="//td[.='Montrer']")
	private WebElement buttonShow;
	
	@FindBy(xpath="//i[@class='z-datebox-btn']")
	private WebElement buttonReferenceDate;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-datebox-pp')]/descendant::table[contains(@class, 'z-calendar-calday')][1]/tbody/tr/td[contains(@class, 'z-calendar-seld')]")
	private WebElement currentDay;
	
	@FindBy(xpath="//span[.='Code projet:']/following-sibling::*[1]/descendant::i[@class='z-bandbox-btn']")
	private WebElement buttonSearchProjectCode;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-bandbox-pp')]/descendant::tr[contains(@class, 'z-listitem')]")
	private List<WebElement> listProjectCode;
	
	@FindBy(xpath="//span[.='Format de sortie']/ancestor::tr[1]/descendant::i[@class='z-combobox-btn']")
	private WebElement buttonOutputFormat;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-combobox-pp')]/descendant::tr[contains(@class, 'z-comboitem')]")
	private List<WebElement> listOutputFormat;
	
	@FindBy(xpath="//a[.='lien direct']/ancestor::table[1]")
	private WebElement messageDirectDownload;
	
	@FindBy(xpath="//a[.='lien direct']")
	private WebElement linkDirectDownload;
	
	
	public void checkBlocs() {
		List<String> list = sectionsTitles.stream().map(title -> title.getText().trim()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Date", "Filtrer par projet", "Filtrer par libellé", "Filtrer par critère", "Format");
		Assert.assertEquals(expected, list);
		Assert.assertTrue(buttonShow.isDisplayed());
	}
	
	public void fillForm(WebDriver driver, String projectName, String outputFormat) throws InterruptedException {
		buttonReferenceDate.click();
		Thread.sleep(100);
		currentDay.click();
		buttonSearchProjectCode.click();
		Assert.assertFalse(listProjectCode.isEmpty());
		listProjectCode.stream().filter(row -> projectName.equals(row.findElement(By.xpath("td[2]")).getText().trim())).findFirst().get().click();
		buttonOutputFormat.click();
		Thread.sleep(100);
		listOutputFormat.stream().filter(item -> outputFormat.equals(item.getText().trim())).findFirst().get().click();
		buttonShow.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(messageDirectDownload)).isDisplayed());
		Assert.assertEquals("Cliquer ici lien direct si le rapport ne s'est pas ouvert automatiquement", messageDirectDownload.getText().trim().replace("\r", "").replace("\n",""));
		linkDirectDownload.click();
		Assert.assertTrue(driver.getCurrentUrl().trim().endsWith("completedEstimatedHours.pdf"));
	}

}
