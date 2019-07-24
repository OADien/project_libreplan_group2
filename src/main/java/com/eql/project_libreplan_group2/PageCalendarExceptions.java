package com.eql.project_libreplan_group2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCalendarExceptions extends BasePage {

	@FindBy(xpath = "//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;

	@FindBy(xpath = "//li[contains(@class, 'z-tab z-tab-seld')]")
	private WebElement selectedTab;

	@FindBy(xpath = "//span[contains(@class, 'save-button')]")
	private WebElement buttonSave;

	@FindBy(xpath = "//span[contains(@class, 'saveandcontinue-button')]")
	private WebElement buttonSaveContinue;

	@FindBy(xpath = "//span[contains(@class, 'cancel-button')]")
	private WebElement buttonCancel;

	@FindBy(xpath = "//td[contains(@class, 'z-button-cm')][.='Créer une exception']")
	private WebElement buttonCreateException;

	@FindBy(xpath = "//td[contains(@class, 'z-button-cm')][.=\"Mettre à jour l'exception\"]")
	private WebElement buttonUpdateException;

	@FindBy(xpath = "/html/body/div[contains(@class, 'z-errbox z-popup')]")
	private WebElement exceptionErrorPopup;

	@FindBy(xpath = "//span[@class='z-label'][.='Date de fin:']/ancestor::tr[1]/descendant::i[@class='z-datebox-btn'][2]")
	private WebElement buttonEndDate;

	@FindBy(xpath = "/html/body/div[contains(@class, 'z-datebox-pp')]/descendant::table[contains(@class, 'z-calendar-calday')][1]/tbody/tr/td[contains(@class, 'z-calendar-seld')]")
	private WebElement currentDay;

	@FindBy(xpath = "//span[@class='z-label'][.=\"Type d'exception\"]/ancestor::tr[1]/descendant::i[@class='z-combobox-btn'][1]")
	private WebElement buttonSelectType;

	@FindBy(xpath = "/html/body/div[contains(@class, 'z-combobox-pp')]/descendant::tr[contains(@class, 'z-comboitem')]")
	private List<WebElement> listType;

	@FindBy(xpath = "//fieldset[legend[.='Liste des exceptions']]/descendant::tr[contains(@class, 'z-listitem')]")
	private List<WebElement> exceptionsRows;

	@FindBy(xpath = "//div[contains(@class, 'day-details')]")
	private WebElement tableDaysDetails;

	@FindBy(xpath = "//div[contains(@class, 'day-details')]/descendant::tr[contains(@class, 'z-row')]")
	private List<WebElement> daysDetailsRows;

	@FindBy(xpath = "//span[.='Effort normal:']/ancestor::td[1]/following-sibling::td[2]/descendant::input[@class='z-spinner-inp']")
	private List<WebElement> inputNormalEffort;

	@FindBy(xpath = "//span[.='Effort en heures supplémentaires:']/ancestor::td[1]/following-sibling::td[2]/descendant::input[@class='z-spinner-inp']")
	private List<WebElement> inputSuppEffort;

	@FindBy(xpath = "//span[@class='z-label'][.='Code']/ancestor::tr[1]/descendant::input[@type='text']")
	private WebElement inputCode;

	@FindBy(xpath = "//span[@class='z-label'][.='Nom']/ancestor::tr[1]/descendant::input[@type='text']")
	private WebElement inputCalendarName;

	@FindBy(xpath = "//span[@class='z-label'][.='Type'][1]/ancestor::td[1]/following-sibling::td[1]/descendant::span[@class='z-label']")
	private WebElement calendarType;

	public void test(String name) throws InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals(String.format("Modifier Calendrier: %s", name), pageTitle.getText().trim());
		Assert.assertEquals("Données de calendrier", selectedTab.getText().trim());
		Assert.assertTrue(buttonSave.isDisplayed());
		Assert.assertTrue(buttonSaveContinue.isDisplayed());
		Assert.assertTrue(buttonCancel.isDisplayed());
	}

	public void clickOnCreateException() {
		buttonCreateException.click();
	}

	public void clickOnUpdateException() {
		buttonUpdateException.click();
	}

	public void checkErrorExceptionType() throws InterruptedException {
		Thread.sleep(100);
		Assert.assertTrue(exceptionErrorPopup.isDisplayed());
		Assert.assertEquals("Merci de choisir un type d'exception", exceptionErrorPopup.getText().trim());
	}

	public void checkErrorExceptionEndDate() throws InterruptedException {
		Thread.sleep(100);
		Assert.assertTrue(exceptionErrorPopup.isDisplayed());
		Assert.assertEquals("Merci de choisir une date de fin pour l'exception", exceptionErrorPopup.getText().trim());
	}

	public void setType(String type) throws InterruptedException {
		buttonSelectType.click();
		Thread.sleep(100);
		listType.stream().filter(item -> type.equals(item.getText().trim())).findFirst().get().click();
	}

	public void setEndDate() throws InterruptedException {
		buttonEndDate.click();
		Thread.sleep(100);
		currentDay.click();
	}

	public void checkException(String type, String normalEffectValue1, String normalEffectValue2,
			String suppEffectValue1, String suppEffectValue2) throws ParseException, InterruptedException {
		Thread.sleep(200);
		Assert.assertFalse(exceptionsRows.isEmpty());
		WebElement row = exceptionsRows.get(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
		String date = sdf.format(new Date());
		Assert.assertEquals(date, row.findElement(By.xpath("td[1]")).getText().trim());
		Assert.assertEquals(type, row.findElement(By.xpath("td[2]")).getText().trim());
		Assert.assertEquals(String.format("%s:%s", normalEffectValue1, normalEffectValue2),
				row.findElement(By.xpath("td[3]")).getText().trim());
		Assert.assertEquals(String.format("%s:%s", suppEffectValue1, suppEffectValue2),
				row.findElement(By.xpath("td[4]")).getText().trim());
		WebElement inputCode = row.findElement(By.xpath("td[5]/descendant::input[1]"));
		// Assert.assertEquals("", inputCode.getAttribute("value").trim());
		Assert.assertFalse(inputCode.isEnabled());
		String origin = row.findElement(By.xpath("td[6]")).getText().trim();
		Assert.assertTrue("Direct".equals(origin) || "Hérité".equals(origin));
		checkTableDaysDetails(type, normalEffectValue1, normalEffectValue2);
	}

	private void checkTableDaysDetails(String type, String normalEffectValue1, String normalEffectValue2)
			throws ParseException {
		Assert.assertTrue(tableDaysDetails.isDisplayed());
		// SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		// Date date =
		// sdf.parse(daysDetailsRows.get(0).findElement(By.xpath("td[2]")).getText().trim());
		// Calendar cal = Calendar.getInstance();
		// Date today = new Date(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
		// cal.get(Calendar.DAY_OF_MONTH));
		// Assert.assertEquals(today, date);
		Assert.assertTrue(daysDetailsRows.get(1).findElement(By.xpath("td[2]")).getText().trim()
				.startsWith(String.format("Exception: %s", type)));
		Assert.assertEquals(String.format("%s:%s", normalEffectValue1, normalEffectValue2),
				daysDetailsRows.get(2).findElement(By.xpath("td[2]")).getText().trim());
	}

	public void setEffort(String value1, String value2, String value3, String value4) throws InterruptedException {
		WebElement input1 = inputNormalEffort.get(0);
		WebElement input2 = inputNormalEffort.get(1);
		WebElement input3 = inputSuppEffort.get(0);
		WebElement input4 = inputSuppEffort.get(1);
		Utils.renseignerChamp(input1, value1);
		Thread.sleep(1000);
		Utils.renseignerChamp(input2, value2);
		Thread.sleep(1000);
		Utils.renseignerChamp(input3, value3);
		Thread.sleep(1000);
		Utils.renseignerChamp(input4, value4);
		Thread.sleep(1000);
	}

	public PageCalendarManagement clickOnSave(WebDriver driver) {
		buttonSave.click();
		return PageFactory.initElements(driver, PageCalendarManagement.class);
	}

	public void checkExceptionCode() {
		String code = inputCode.getAttribute("value").trim();
		WebElement row = exceptionsRows.get(0);
		String exceptionCode = row.findElement(By.xpath("td[5]/descendant::input[1]")).getAttribute("value").trim();
		Assert.assertTrue(exceptionCode.startsWith(code + "-000"));
	}

	public PageCalendarManagement clickOnCancel(WebDriver driver) {
		buttonCancel.click();
		return PageFactory.initElements(driver, PageCalendarManagement.class);
	}

	public void checkDerivativeCalendar(String name) throws InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals("Créer Calendrier", pageTitle.getText().trim());
		Assert.assertEquals("", inputCalendarName.getAttribute("value").trim());
		Assert.assertEquals(String.format("Dérivé du calendrier %s", name), calendarType.getText().trim());
	}

	public void checkCalendarCopy(String name) throws InterruptedException {
		Thread.sleep(100);
		Assert.assertEquals(String.format("Créer Calendrier: %s", name), pageTitle.getText().trim());
		Assert.assertEquals(name, inputCalendarName.getAttribute("value").trim());
		Assert.assertEquals("Calendrier source", calendarType.getText().trim());
	}

	public void checkExceptionTypeExists(String type) throws InterruptedException {
		buttonSelectType.click();
		Thread.sleep(100);
		Assert.assertNotNull(
				listType.stream().filter(item -> type.equals(item.getText().trim())).findFirst().orElse(null));
	}

	public void checkReservation(String normalEffectValue1, String normalEffectValue2, String suppEffectValue1,
			String suppEffectValue2) throws ParseException, InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals(normalEffectValue1, inputNormalEffort.get(0).getAttribute("value").trim());
		Assert.assertEquals(normalEffectValue2, inputNormalEffort.get(1).getAttribute("value").trim());
		Assert.assertEquals(suppEffectValue1, inputSuppEffort.get(0).getAttribute("value").trim());
		Assert.assertEquals(suppEffectValue2, inputSuppEffort.get(1).getAttribute("value").trim());
	}

}
