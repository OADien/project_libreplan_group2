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
import org.openqa.selenium.support.ui.Select;

public class PageCreateUpdateQualityForm extends BasePage{
	
	@FindBy(xpath="//div[@class='z-window-embedded'][1]/descendant::div[@class='z-window-embedded'][not(contains(@style, 'display: none'))][1]/descendant::div[@class='z-window-embedded-header'][1]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//li[contains(@class, 'z-tab z-tab-seld')]")
	private WebElement selectedTab;
	
	@FindBy(xpath="//span[.='Nom']/ancestor::tr[1]/descendant::input[1]")
	private WebElement inputName;
	
	@FindBy(xpath="//span[.='Description']/ancestor::tr[1]/descendant::textarea[1]")
	private WebElement textareaDescription;
	
	@FindBy(xpath="//span[.='Type de formulaire qualité']/ancestor::tr[@class='z-row'][1]/descendant::select[1]")
	private WebElement selectType;
	
	@FindBy(xpath="//span[.='Avancement du rapport']/ancestor::tr[1]/descendant::input[@type='checkbox'][1]")
	private WebElement checkboxReportProgression;
	
	@FindBy(xpath="//div[contains(@class, 'z-panel-header')]")
	private WebElement sectionTitle;
	
	@FindBy(xpath="//td[@class='z-button-cm'][.='Nouvel élément du formulaire qualité']")
	private WebElement buttonNewElement;
	
	@FindBy(xpath="//div[contains(@class, 'z-panel-header')]/../descendant::tr[@class='z-columns']/th")
	private List<WebElement> tableHeader;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')]")
	private WebElement buttonSave;
	
	@FindBy(xpath="//span[contains(@class, 'saveandcontinue-button')]")
	private WebElement buttonSaveContinue;
	
	@FindBy(xpath="//span[contains(@class, 'cancel-button')]")
	private WebElement buttonCancel;
	
	@FindBy(xpath="//div[contains(@class, 'z-panel-header')]/../descendant::tr[contains(@class,'z-row')]")
	private List<WebElement> itemsRows;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private List<WebElement> infoMessages;
	
	public void test() throws InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals("Créer Formulaire qualité", pageTitle.getText().trim());
		Assert.assertEquals("Formulaire qualité", selectedTab.getText().trim());
		Assert.assertEquals("", inputName.getText().trim());
		Assert.assertEquals("", textareaDescription.getText().trim());
		List<String> options = selectType.findElements(By.xpath("option")).stream().map(option->option.getText().trim()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("par pourcentage","par élément");
		Assert.assertEquals(expected, options);
		Select select = new Select(selectType);
		Assert.assertEquals("par pourcentage", select.getFirstSelectedOption().getText().trim());
		Assert.assertFalse(checkboxReportProgression.isSelected());
		Assert.assertEquals("Liste d'éléments du formulaire qualité", sectionTitle.getText().trim());
		Assert.assertTrue(buttonNewElement.isDisplayed());
		List<String> list = tableHeader.stream().map(element -> element.getText().trim()).collect(Collectors.toList());
		expected = Arrays.asList("Nom", "Position", "Pourcentage", "Opérations");
		Assert.assertEquals(expected, list);
		Assert.assertTrue(buttonSave.isDisplayed());
		Assert.assertTrue(buttonSaveContinue.isDisplayed());
		Assert.assertTrue(buttonCancel.isDisplayed());
	}
	
	public void fillForm(String name, String description, String type, boolean isReportProgression) {
		Utils.renseignerChamp(inputName, name);
		Utils.renseignerChamp(textareaDescription, description);
		Select select = new Select(selectType);
		select.selectByVisibleText(type);
		if(isReportProgression != checkboxReportProgression.isSelected())
			checkboxReportProgression.click();
	}
	
	public void clickOnCreateNewElement() throws InterruptedException {
		buttonNewElement.click();
		Thread.sleep(100);
		WebElement row = itemsRows.get(0);
		WebElement itemName = row.findElement(By.xpath("td[1]/descendant::input[1]"));
		Assert.assertEquals("", itemName.getAttribute("value").trim());
		WebElement itemPosition = row.findElement(By.xpath("td[2]/descendant::span[@class='z-label']"));
		Assert.assertEquals("1", itemPosition.getText().trim());
		WebElement itemPercentage = row.findElement(By.xpath("td[3]/descendant::input[1]"));
		Assert.assertEquals("", itemPercentage.getAttribute("value").trim());
		WebElement itemDeleteIcon = row.findElement(By.xpath("td[4]/descendant::span[@title='Supprimer']"));
		Assert.assertTrue(itemDeleteIcon.isDisplayed());
	}
	
	public void fillFormCreateNewElement(int index, String name, String percentage) {
		WebElement row = itemsRows.get(index);
		WebElement itemName = row.findElement(By.xpath("td[1]/descendant::input[1]"));
		Utils.renseignerChamp(itemName, name);
		WebElement itemPercentage = row.findElement(By.xpath("td[3]/descendant::input[1]"));
		Utils.renseignerChamp(itemPercentage, percentage);
	}
	
	public void checkPosition(int index, String value) {
		WebElement row = itemsRows.get(index);
		WebElement itemPosition = row.findElement(By.xpath("td[2]/descendant::span[@class='z-label']"));
		Assert.assertEquals(value, itemPosition.getText().trim());
	}
	
	public void doubleClickReportProgression() {
		checkboxReportProgression.click();
		checkboxReportProgression.click();
	}
	
	public void checkItemIndex(String name, int index) {
		int i = 0;
		int size = itemsRows.size();
		for(; i < size; i++) {
			if(name.equals(itemsRows.get(i).findElement(By.xpath("td[1]/descendant::input[1]")).getAttribute("value").trim())){
				break;
			}
		}
		Assert.assertEquals(i, index);
	}
	
	public void clickOnSaveandContinue() {
		buttonSaveContinue.click();
	}
	
	public void checkQualityForm(String name) throws InterruptedException {
		Thread.sleep(500);
		Assert.assertEquals(String.format("Formulaire qualité \"%s\" enregistré", name), infoMessages.get(infoMessages.size()-1).getText().trim());
		Assert.assertEquals(String.format("Modifier Formulaire qualité: %s", name), pageTitle.getText().trim());
	}
	
	public PageQualityFormManagement clickOnCancel(WebDriver driver) {
		buttonCancel.click();
		return PageFactory.initElements(driver, PageQualityFormManagement.class);
	}
	
	public void checkPageTitle(String name) throws InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals(String.format("Modifier Formulaire qualité: %s", name), pageTitle.getText().trim());
	}
	
	public void setType(String type) throws InterruptedException {
		Select select = new Select(selectType);
		select.selectByVisibleText(type);
		Thread.sleep(100);
		//Percentage column disappears
		List<String> list = tableHeader.stream().map(element -> element.getText().trim()).filter(str -> !str.isEmpty()).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Nom", "Position", "Opérations");
		Assert.assertEquals(expected, list);
	}
	
	public PageQualityFormManagement clickOnSave(WebDriver driver) {
		buttonSave.click();
		return PageFactory.initElements(driver, PageQualityFormManagement.class);
	}

}
