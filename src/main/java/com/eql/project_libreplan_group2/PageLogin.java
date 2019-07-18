package com.eql.project_libreplan_group2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {
	
	
	@FindBy(name="j_username")
	private WebElement username;
	
	
	@FindBy(name="j_password")
	private WebElement password;
	
	@FindBy(name="button")
	private WebElement loginButton;
	
	
	public PageCalendar login(WebDriver driver, String uname, String pwd) {
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);
		loginButton.click();
		return PageFactory.initElements(driver, PageCalendar.class);
	}
	

}
