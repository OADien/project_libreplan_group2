package com.eql.project_libreplan_group2;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PageTimeSheet {
	
	@FindBy (xpath = "(//option[text()='Default'])[3]/parent::select")
	private WebElement menu_modele;
	
	
	@FindBy (xpath = "\"//input[@class='z-textbox']")
	private WebElement string_to_number;
	
	
	public int stringToInt(String number) {
		return Utils.putStringToInt(number);
	}
	
	public void selectModele(String modele) {
		Utils.selectOptionFromMenu(menu_modele, modele);
	}

}
