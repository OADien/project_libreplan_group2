package com.eql.project_libreplan_group2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class PageCreateUpdateEngine extends BasePage{
	
	@FindBy(xpath="//div[contains(@class,'machinewindow')][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//li[contains(@class, 'z-tab z-tab-seld')]")
	private WebElement selectedTab;
	
	@FindBy(xpath="//span[@class='z-label'][.='Code']/ancestor::tr[1]/descendant::input[@type='text']")
	private WebElement inputCode;
	
	@FindBy(xpath="//span[@class='z-label'][.='Code']/ancestor::tr[1]/descendant::input[@type='checkbox']")
	private WebElement checkboxCode;
	
	@FindBy(xpath="//span[@class='z-label'][.='Nom']/ancestor::tr[1]/descendant::input[@type='text']")
	private WebElement inputName;
	
	@FindBy(xpath="//span[@class='z-label'][.='Description']/ancestor::tr[1]/descendant::input[@type='text']")
	private WebElement inputDescription;
	
	@FindBy(xpath="//div[contains(@class, 'z-tabpanel')]/descendant::span[@class='z-label'][.='Type']/ancestor::tr[3]/descendant::select")
	private WebElement selectType;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')][1]")
	private WebElement buttonSave;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')][2]")
	private WebElement buttonSaveContinue;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')][2]/following-sibling::span[contains(@class, 'cancel-button')][1]")
	private WebElement buttonCancel;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private List<WebElement> infoMessages;
	
	public void test() throws InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals("Créer Machine", pageTitle.getText().trim());
		Assert.assertEquals("Donnée de la machine", selectedTab.getText().trim());
	}

	public void checkEngineData() {
		Assert.assertFalse(inputCode.getAttribute("value").trim().isEmpty());
		Assert.assertTrue(checkboxCode.isSelected());
		Assert.assertEquals("", inputName.getAttribute("value").trim());
		Assert.assertEquals("", inputDescription.getAttribute("value").trim());
		Select select = new Select(selectType);
		Assert.assertEquals("Ressource normale", select.getFirstSelectedOption().getText().trim());
	}
	
	public void fillForm(boolean isGenerateCode, String code, String name, String description, String type) throws InterruptedException {
		Select select = new Select(selectType);
		if(isGenerateCode != checkboxCode.isSelected())
			checkboxCode.click();
		Thread.sleep(100);
		if(null != code)
			Utils.renseignerChamp(inputCode, code);
		Utils.renseignerChamp(inputName, name);
		Utils.renseignerChamp(inputDescription, description);
		select.selectByVisibleText(type);
		buttonSaveContinue.click();
	}
	
	public void checkSavedMachine(String name) throws InterruptedException {
		Thread.sleep(100);
		Assert.assertEquals(String.format("Machine \"%s\" enregistré", name), infoMessages.get(0).getText().trim());
		Assert.assertEquals(String.format("Modifier Machine: %s", name), pageTitle.getText().trim());
	}
	
	public PageEngineManagement clickOnCancel(WebDriver driver) {
		buttonCancel.click();
		return PageFactory.initElements(driver, PageEngineManagement.class);
	}
}
