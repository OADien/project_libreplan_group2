package com.eql.project_libreplan_group2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PageProfiles extends BasePage {
	
	@FindBy(xpath="//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-columns')][1]")
	private WebElement columnTitles;
	
	@FindBy(xpath="//div[contains(@class, 'clickable-rows z-grid')]//descendant::tr[contains(@class, 'z-row')]")
	private List<WebElement> profileRows;
	
	@FindBy(xpath="//span[contains(@class, 'create-button')]")
	private WebElement buttonCreate;
	
	@FindBy(xpath="//div[@class='message_INFO']")
	private WebElement infoMessage;
	
	public void test() {
		Assert.assertEquals("Nom de profil", columnTitles.findElement(By.xpath("descendant::th[1]")).getText().trim());
		Assert.assertEquals("Actions", columnTitles.findElement(By.xpath("descendant::th[2]")).getText().trim());
		//check the icons
		WebElement iconsContainer = profileRows.get(0).findElement(By.xpath("td[2]"));
		Assert.assertTrue(iconsContainer.findElement(By.xpath("//descendant::span[@title='Modifier'][1]")).isDisplayed());
		Assert.assertTrue(iconsContainer.findElement(By.xpath("//descendant::span[@title='Supprimer'][1]")).isDisplayed());
		Assert.assertTrue(buttonCreate.isDisplayed());
	}
	
	public PageCreateUpdateProfile createProfile(WebDriver driver) {
		buttonCreate.click();
		return PageFactory.initElements(driver, PageCreateUpdateProfile.class);
	}
	
	public WebElement getProfileRow(String profileName) {
		return profileRows.stream().filter(row->profileName.equals(row.findElement(By.xpath("td[1]")).getText().trim())).findFirst().orElse(null);
	}
	
	public void checkProfileCreation(String profileName) {
		Assert.assertEquals("Profil \""+profileName+"\" enregistré", infoMessage.getText().trim());
		Assert.assertTrue(getProfileRow(profileName).isDisplayed());
	}
	
	public PageCreateUpdateProfile clickOnEditProfile(WebDriver driver, String profileName) {
		getProfileRow(profileName).findElement(By.xpath("td[2]/descendant::span[@title='Modifier'][1]")).click();
		return PageFactory.initElements(driver,  PageCreateUpdateProfile.class);
	}

}
