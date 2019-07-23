package com.eql.project_libreplan_group2;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class PageCreateCalendar{
	
	@FindBy(xpath = ("(//td[@class='z-button-cm' and text()='Créer'])[1]")) private WebElement button_create;
	@FindBy(xpath = ("//input[@class='z-textbox']")) private WebElement field_name;
	@FindBy(xpath = ("//input[@type='checkbox']")) private WebElement check_box_code;
	@FindBy(xpath = ("(//td[@class='z-button-cm' and text()='Enregistrer'])")) private WebElement button_save;
	@FindBy(xpath = ("//span[@title='Créer une dérive']")) private WebElement button_calendar_child;
	@FindBy(xpath = ("//td[@class='z-button-cm']")) private WebElement button_calendar_copy;

	public void clicCreateCalendar() {
		button_create.click();
	}
	
	public void createCalendar(String name) {
		Utils.renseignerChamp(field_name, name);
	}

	public void clicSave() {
		button_save.click();
	}
	
}



