package com.eql.project_libreplan_group2;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageCreateUpdateSpecialDay extends BasePage{
	
	@FindBy(xpath="//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//li[contains(@class, 'z-tab z-tab-seld')]")
	private WebElement selectedTab;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')][1]")
	private WebElement buttonSave;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')][2]")
	private WebElement buttonSaveContinue;
	
	@FindBy(xpath="//span[contains(@class, 'cancel-button')]")
	private WebElement buttonCancel;
	
	@FindBy(xpath="//span[@class='z-label'][.='Code:']/ancestor::tr[1]/descendant::input[@type='text']")
	private WebElement inputCode;
	
	@FindBy(xpath="//span[@class='z-label'][.='Code:']/ancestor::tr[1]/descendant::input[@type='checkbox']")
	private WebElement checkboxCode;
	
	@FindBy(xpath="//span[@class='z-label'][.='Nom']/ancestor::tr[1]/descendant::input[@type='text']")
	private WebElement inputName;
	
	@FindBy(xpath="//span[@class='z-label'][.='Couleur']/ancestor::tr[1]/descendant::select")
	private WebElement selectColor;
	
	@FindBy(xpath="//span[.='Effort standard']/ancestor::tr[1]/descendant::input[@class='z-spinner-inp']")
	private List<WebElement> inputStandardEffort;
	
	@FindBy(xpath="//span[.='Effort supplémentaire']/ancestor::tr[1]/descendant::input[@class='z-spinner-inp']")
	private List<WebElement> inputSuppEffort;
	
	@FindBy(xpath="//span[@class='z-label'][.='Effort supplémentaire']/ancestor::tr[1]/descendant::input[@type='checkbox']")
	private WebElement checkboxSuppEffort;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-errbox z-popup')]")
	private WebElement errorBox;
	
	public void test() throws InterruptedException {
		
		Thread.sleep(200);
		Assert.assertEquals("Créer Jour du calendrier exceptionnel", pageTitle.getText().trim());
		Assert.assertEquals("Modifier", selectedTab.getText().trim());
		Assert.assertFalse(inputCode.getAttribute("value").trim().isEmpty());
		Assert.assertFalse(inputCode.isEnabled());
		Assert.assertTrue(checkboxCode.isSelected());
		Assert.assertEquals("",  inputName.getAttribute("value").trim());
		Select select = new Select(selectColor);
		Assert.assertEquals("rouge (par défaut)", select.getFirstSelectedOption().getText().trim());
		for(WebElement element: inputStandardEffort) {
			Assert.assertTrue(element.isDisplayed());
		}
		for(WebElement element: inputSuppEffort) {
			Assert.assertTrue(element.isDisplayed());
		}
		Assert.assertFalse(checkboxSuppEffort.isSelected());
		Assert.assertTrue(buttonSave.isDisplayed());
		Assert.assertTrue(buttonSaveContinue.isDisplayed());
		Assert.assertTrue(buttonCancel.isDisplayed());
		
	}
	
	public String getCode() {
		String code =  inputCode.getAttribute("value").trim();
		System.out.println("Code = " +code);
		return code;
	}
	
	public void setName(String name) {
		Utils.renseignerChamp(inputName, name);
	}
	
	public void setStandardEffort1(String value) {
		Utils.renseignerChamp(inputStandardEffort.get(0), value);
	}
	
	public void setStandardEffort2(String value) {
		Utils.renseignerChamp(inputStandardEffort.get(1), value);
	}
	
	public void setSuppEffort1(String value) {
		Utils.renseignerChamp(inputSuppEffort.get(0), value);
	}
	
	public void setSuppEffort2(String value) {
		Utils.renseignerChamp(inputSuppEffort.get(1), value);
	}
	
	public PageSpecialDayManagement cancel(WebDriver driver, String name) {
		Utils.renseignerChamp(inputName, name);
		buttonCancel.click();
		return PageFactory.initElements(driver, PageSpecialDayManagement.class);
	}
	
	public void blur() throws InterruptedException {
		selectedTab.click();
		Thread.sleep(100);
	}
	
	public void checkErrorBox(String... error) throws InterruptedException {
		Thread.sleep(100);
		boolean found = false;
		String err = errorBox.getText().trim();
		for(String str: error) {
			if(err.equals(str)) {
				found = true;
				break;
			}
		}
		Assert.assertTrue(found);
	}
	
	public void clickOnSave() throws InterruptedException {
		buttonSave.click();
		Thread.sleep(100);
	}
	
	public void clickOnSaveAndContinue() {
		buttonSaveContinue.click();
	}
	
	public void setEffort(String value1, String value2, String value3, String value4) throws InterruptedException {
		WebElement input1 = inputStandardEffort.get(0);
		WebElement input2 = inputStandardEffort.get(1);
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

}
