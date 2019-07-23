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

public class PageCalendarManagement extends BasePage {
	
	@FindBy(xpath = "//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[contains(@class, 'z-dottree')]/descendant::tr[contains(@class, 'z-treecols')][1]/th")
	private List<WebElement> columnTitles;
	
	@FindBy(xpath = "//div[contains(@class, 'z-dottree')]/descendant::tr[contains(@class, 'z-treerow')]")
	private List<WebElement> calendarRows;
	
	@FindBy(xpath = "//span[contains(@class, 'create-button')]")
	private WebElement buttonCreate;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private WebElement infoMessage;
	
	public void test() {
		Assert.assertEquals("Liste de calendriers", pageTitle.getText().trim());
		List<String> list = columnTitles.stream().map(col -> col.getText().trim()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Nom", "Hérité de la date", "Héritages à jour", "Opérations");
		Assert.assertEquals(expected, list);
		Assert.assertTrue(buttonCreate.isDisplayed());
	}
	
	public WebElement getCalendarRow(String name) {
		return calendarRows.stream().filter(item -> name.equals(item.findElement(By.xpath("td[1]")).getText().trim()))
				.findFirst().orElse(null);
	}
	
	public PageCalendarExceptions editCalendar(WebDriver driver, String name) throws InterruptedException {
		Thread.sleep(100);
		getCalendarRow(name).findElement(By.xpath("td[4]/descendant::span[@title='Modifier']")).click();
		return PageFactory.initElements(driver, PageCalendarExceptions.class);
	}
	
	public void checkSavedCalendar(String name) {
		Assert.assertEquals(String.format("Calendrier de base \"%s\" enregistré", name), infoMessage.getText().trim());
	}
	
	public PageCalendarExceptions createDerivativeCalendar(WebDriver driver, String name) throws InterruptedException {
		Thread.sleep(100);
		getCalendarRow(name).findElement(By.xpath("td[4]/descendant::span[@title='Créer une dérive']")).click();
		return PageFactory.initElements(driver, PageCalendarExceptions.class);
	}
	
	public PageCalendarExceptions createCalendarCopy(WebDriver driver, String name) throws InterruptedException {
		Thread.sleep(100);
		getCalendarRow(name).findElement(By.xpath("td[4]/descendant::span[@title='Créer une copie']")).click();
		return PageFactory.initElements(driver, PageCalendarExceptions.class);
	}

}
