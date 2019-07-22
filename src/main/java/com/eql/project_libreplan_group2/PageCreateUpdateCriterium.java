package com.eql.project_libreplan_group2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreateUpdateCriterium {
	
	@FindBy(xpath="//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//li[contains(@class, 'z-tab z-tab-seld')]")
	private WebElement selectedTab;
	
	@FindBy(xpath="//span[.='Nom']/ancestor::tr[1]/descendant::input[1]")
	private WebElement inputName;
	
	@FindBy(xpath="//span[.='Type']/ancestor::tr[1]/descendant::i[contains(@class, 'z-combobox-btn')]")
	private WebElement buttonSelectType;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-combobox-pp')]/descendant::tr[contains(@class, 'z-comboitem')]")
	private List<WebElement> listType;
	
	@FindBy(xpath="//span[.='Valeurs multiples par ressource']/ancestor::tr[1]/descendant::input[@type='checkbox'][1]")
	private WebElement checkboxMultipleValues;
	
	@FindBy(xpath="//span[.='Hiérarchie']/ancestor::tr[1]/descendant::input[@type='checkbox'][1]")
	private WebElement checkboxHierarchy;
	
	@FindBy(xpath="//span[.='Activé']/ancestor::tr[1]/descendant::input[@type='checkbox'][1]")
	private WebElement checkboxEnabled;
	
	@FindBy(xpath="//span[.='Description']/ancestor::tr[1]/descendant::textarea[1]")
	private WebElement textareaDescription;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')]")
	private WebElement buttonSave;
	
	@FindBy(xpath="//span[contains(@class, 'saveandcontinue-button')]")
	private WebElement buttonSaveContinue;
	
	@FindBy(xpath="//span[contains(@class, 'cancel-button')]")
	private WebElement buttonCancel;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private WebElement infoMessage;
	
	public void test() throws InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals("Créer Type de critère", pageTitle.getText().trim());
		Assert.assertEquals("Modifier", selectedTab.getText().trim());
		Assert.assertTrue(buttonSave.isDisplayed());
		Assert.assertTrue(buttonSaveContinue.isDisplayed());
		Assert.assertTrue(buttonCancel.isDisplayed());
	}
	
	public void fillForm(String name, String type, boolean isMultipleValues, boolean isHierarchy, boolean isEnabled, String description) {
		Utils.renseignerChamp(inputName, name);
		buttonSelectType.click();
		listType.stream().filter(item -> type.equals(item.getText().trim())).findFirst().get().click();
		if(isMultipleValues != checkboxMultipleValues.isSelected())
			checkboxMultipleValues.click();
		if(isHierarchy != checkboxHierarchy.isSelected())
			checkboxHierarchy.click();
		if(isEnabled != checkboxEnabled.isSelected())
			checkboxEnabled.click();
		Utils.renseignerChamp(textareaDescription, description);
		buttonSaveContinue.click();
	}
	
	public void checkCriteriumForm(String name) {
		Assert.assertEquals(String.format("Type de critère \"%s\" enregistré", name), infoMessage.getText().trim());
		Assert.assertEquals(String.format("Modifier Type de critère: %s", name), pageTitle.getText().trim());
	}
	
	public void checkPageTitle(String name) throws InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals(String.format("Modifier Type de critère: %s", name), pageTitle.getText().trim());
	}
	
	public PageCriteriaManagement clickOnCancel(WebDriver driver) {
		buttonCancel.click();
		return PageFactory.initElements(driver, PageCriteriaManagement.class);
	}
	
	public void setName(String name) {
		Utils.renseignerChamp(inputName, name);
	}
	public void blur() {
		textareaDescription.sendKeys("");
	}
	
	public void clickOnSaveAndContinue() {
		buttonSaveContinue.click();
	}

}
