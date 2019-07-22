package com.eql.project_libreplan_group2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageCreateUpdateProfile extends BasePage{
	
	@FindBy(xpath="//td[@class='z-caption-l']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//span[.='Nom']/ancestor::tr[1]/descendant::input[1]")
	private WebElement inputName;
	
	@FindBy(xpath="//fieldset[legend[.='Association avec les rôles']]")
	private WebElement rolesSection;
	
	@FindBy(xpath="//input[contains(@class, 'z-combobox-inp')]")
	private WebElement inputRole;
	
	@FindBy(xpath="//i[@class='z-combobox-btn']")
	private WebElement buttonComboboxRole;
	
	@FindBy(xpath="/html/body/div[contains(@class, 'z-combobox-pp')]/descendant::tr[contains(@class, 'z-comboitem')]")
	private List<WebElement> listRoles;
	
	@FindBy(xpath="//td[.='Ajouter un rôle'][contains(@class, 'z-button-cm')]")
	private WebElement buttonAddRole;
	
	@FindBy(xpath="//fieldset[legend[.='Association avec les rôles']]/descendant::tr[@class='z-columns']")
	private WebElement rolesTableHeader;
	
	@FindBy(xpath="//fieldset[legend[.='Association avec les rôles']]/descendant::tr[contains(@class, 'z-row')]")
	private List<WebElement> rolesRows;
	
	@FindBy(xpath="//span[contains(@class, 'save-button')]")
	private WebElement buttonSave;
	
	@FindBy(xpath="//span[contains(@class, 'saveandcontinue-button')]")
	private WebElement buttonSaveContinue;
	
	@FindBy(xpath="//span[contains(@class, 'cancel-button')]")
	private WebElement buttonCancel;
	
	public void test() throws InterruptedException {
		Thread.sleep(100);
		Assert.assertEquals("", inputName.getAttribute("value").trim());
		Assert.assertTrue(rolesSection.isDisplayed());
		Assert.assertEquals("", inputRole.getAttribute("value").trim());
		Assert.assertTrue(buttonAddRole.isDisplayed());
		Assert.assertEquals("Nom du rôle", rolesTableHeader.findElement(By.xpath("th[1]")).getText().trim());
		Assert.assertEquals("Actions", rolesTableHeader.findElement(By.xpath("th[2]")).getText().trim());
		Assert.assertTrue(buttonSave.isDisplayed());
		Assert.assertTrue(buttonSaveContinue.isDisplayed());
		Assert.assertTrue(buttonCancel.isDisplayed());
	}

	public void fillForm(WebDriver driver, String name, String role) throws InterruptedException {
		Utils.renseignerChamp(inputName, name);
		WebElement selectedRoleRow = addRole(role);
		//check the bin icon
		WebElement iconDelete = getIconDeleteRole(selectedRoleRow);
		Assert.assertTrue(iconDelete.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(iconDelete).build().perform();
		Thread.sleep(1000);
	}
	
	public WebElement getRoleRow(String role) {
		return rolesRows.stream().filter(row -> role.equals(row.findElement(By.xpath("td[1]")).getText().trim())).findFirst().orElse(null);
	}
	
	public WebElement getIconDeleteRole(WebElement roleRow) {
		return roleRow.findElement(By.xpath("td[2]/descendant::span[@title='Supprimer']"));
	}
	
	public WebElement addRole(String role) throws InterruptedException {
		buttonComboboxRole.click();
		listRoles.stream().filter(element -> role.equals(element.getText().trim())).findFirst().get().click();
		buttonAddRole.click();
		Thread.sleep(100);
		Assert.assertFalse(rolesRows.isEmpty());
		//find the row with the seelected role
		WebElement selectedRoleRow = getRoleRow(role);
		Assert.assertNotNull(selectedRoleRow);
		return selectedRoleRow;
	}
	
	
	public void checkDuplicateRole(String role) {
		Assert.assertEquals(1, rolesRows.stream().filter(row -> role.equals(row.findElement(By.xpath("td[1]")).getText().trim())).count());
	}
	
	public void deleteRole(String role) throws InterruptedException {
		WebElement roleRow = getRoleRow(role);
		getIconDeleteRole(roleRow).click();
		Thread.sleep(100);
		//check that the role row has been deleted from the table
		Assert.assertNull(getRoleRow(role));
	}
	public void deleteAllRoles() throws InterruptedException {
		System.out.println("rolesRows size = " + rolesRows.size());
		for(int i = rolesRows.size()-1; i >=0 ; i--) {
			getIconDeleteRole(rolesRows.get(i)).click();
			Thread.sleep(100);
		}
		Assert.assertEquals(0, rolesRows.size());
	}
	
	public PageProfiles saveProfile(WebDriver driver) {
		buttonSave.click();
		return PageFactory.initElements(driver, PageProfiles.class);
	}
	
	public void checkUpdatePage(String profileName) throws InterruptedException {
		Thread.sleep(200);
		Assert.assertEquals("Modifier Profil: "+profileName, pageTitle.getText().trim());
		Assert.assertEquals(0, rolesRows.size());
	}
	
	public void setProfileName(String profileName) {
		Utils.renseignerChamp(inputName, profileName);
		
	}
}
