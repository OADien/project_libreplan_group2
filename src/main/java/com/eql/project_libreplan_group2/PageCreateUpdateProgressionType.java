package com.eql.project_libreplan_group2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreateUpdateProgressionType extends BasePage {
	
	@FindBy(xpath="//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//li[contains(@class, 'z-tab z-tab-seld')]")
	private WebElement selectedTab;
	
	@FindBy(xpath="//span[.=\"Nom d'unité\"]/ancestor::tr[1]/descendant::input[1]")
	private WebElement inputUnitName;
	
	@FindBy(xpath="//span[.='Actif']/ancestor::tr[1]/descendant::input[@type='checkbox'][1]")
	private WebElement checkboxEnabled;
	
	@FindBy(xpath="//span[.=\"Valeur maximum par défaut\"]/ancestor::tr[1]/descendant::input[1]")
	private WebElement inputMaxValue;
	
	@FindBy(xpath="//span[.=\"Précision\"]/ancestor::tr[1]/descendant::input[1]")
	private WebElement inputPrecision;
	
	@FindBy(xpath="//span[.=\"Type\"]/ancestor::td[1]/following-sibling::td[1]/descendant::span[@class='z-label']")
	private WebElement labelType;
	
	@FindBy(xpath="//span[.='Pourcentage']/ancestor::tr[1]/descendant::input[@type='checkbox'][1]")
	private WebElement checkboxPercentage;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')][1]")
	private WebElement buttonSave;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')][2]")
	private WebElement buttonSaveContinue;
	
	@FindBy(xpath="//span[contains(@class, 'cancel-button')]")
	private WebElement buttonCancel;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private List<WebElement> infoMessages;
	
	public void test() throws InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals("Créer Type d'avancement", pageTitle.getText().trim());
		Assert.assertEquals("Modifier", selectedTab.getText().trim());
		Assert.assertEquals("", inputUnitName.getAttribute("value").trim());
		Assert.assertTrue(checkboxEnabled.isSelected());
		Assert.assertEquals("100,00", inputMaxValue.getAttribute("value").trim());
		Assert.assertEquals("0,1000", inputPrecision.getAttribute("value").trim());
		Assert.assertEquals("User", labelType.getText().trim());
		Assert.assertFalse(checkboxPercentage.isSelected());
		Assert.assertTrue(buttonSave.isDisplayed());
		Assert.assertTrue(buttonSaveContinue.isDisplayed());
		Assert.assertTrue(buttonCancel.isDisplayed());
	}
	
	public void fillForm(String unitName, Boolean isEnabled, String maxValue, String precision, Boolean isPercentage) {
		Utils.renseignerChamp(inputUnitName,  unitName);
		if(null != isEnabled && checkboxEnabled.isSelected() != isEnabled)
			checkboxEnabled.click();
		if(null != maxValue)
			Utils.renseignerChamp(inputMaxValue, maxValue);
		if(null != precision)
			Utils.renseignerChamp(inputPrecision, precision);
		if(null != isPercentage && isPercentage != checkboxPercentage.isSelected())
			checkboxPercentage.click();
	}
	
	public PageProgressionTypes clickOnSave(WebDriver driver) {
		buttonSave.click();
		return PageFactory.initElements(driver, PageProgressionTypes.class);
	}
	
	public void checkMaxValueDisabled() throws InterruptedException {
		Thread.sleep(100);
		Assert.assertFalse(inputMaxValue.isEnabled());
	}
	
	public void clickOnSaveAndContinue() {
		buttonSaveContinue.click();
	}
	
	public void checkProgressionTypeForm(String name) throws InterruptedException {
		Thread.sleep(500);
		Assert.assertEquals(String.format("Type d'avancement \"%s\" enregistré", name), infoMessages.get(infoMessages.size()-1).getText().trim());
		Assert.assertEquals(String.format("Modifier Type d'avancement: %s", name), pageTitle.getText().trim());
	}
	
	public PageProgressionTypes clickOnCancel(WebDriver driver) {
		buttonCancel.click();
		return PageFactory.initElements(driver,  PageProgressionTypes.class);
	}

}
