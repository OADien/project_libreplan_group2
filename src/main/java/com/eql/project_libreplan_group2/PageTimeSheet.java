package com.eql.project_libreplan_group2;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageTimeSheet {
	
	@FindBy (xpath = "//div[@class='z-row-cnt z-overflow-hidden']/descendant::select")
	private WebElement menu_type_heures;

	public void selectTypeHeures(String type_heures) {
		Utils.selectOptionFromMenu(menu_type_heures, type_heures);
	}
}
