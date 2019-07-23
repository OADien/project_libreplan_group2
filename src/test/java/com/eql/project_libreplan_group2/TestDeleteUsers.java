package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestDeleteUsers{
	
	@FindBy(xpath="//a[@href=\"/libreplan/resources/worker/worker.zul\"]")
	private WebElement participant;
	
	@FindBy(xpath = "//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")
	private WebElement delete_btn;
	
	@FindBy(xpath = "//span[contains(@class,'z-messagebox-btn z-button')]")
	private WebElement ok_btn;
	
	@FindBy(xpath = "//span[contains(@class,'z-messagebox-btn z-button')]")
	private WebElement confirm_btn;

	private WebDriver driver;

	@Before
	public void init() {
		driver = Utils.chooseBrowser("chrome");
	}
	
	PageMain pageMain = Utils.login(driver);

	
	@Test
	public void TestDelete () throws InterruptedException {
		pageMain.clickMenu(driver, "Ressources", "Participants");
		delete_btn.click();
		ok_btn.click();
		confirm_btn.click();
	}

}
