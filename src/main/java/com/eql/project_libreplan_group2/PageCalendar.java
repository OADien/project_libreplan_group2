package com.eql.project_libreplan_group2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class PageCalendar{
	
	@FindBy(xpath = ("(//td[@class='z-button-cm' and text()='Créer'])[1]")) private WebElement button_create;
	@FindBy(xpath = ("//input[@class='z-textbox']")) private WebElement field_name;
	@FindBy(xpath = ("//input[@type='checkbox']")) private WebElement check_box_code;
	
	
	public void clicCreateCalendar() {
		button_create.click();
	}
	
	public void createCalendar(String name) {
		Utils.renseignerChamp(field_name, name);
	}

	
//	public  boolean checkBoxCode() {
//		if(check_box_code.isSelected()) {
//			System.out.println("la case est cochée");
//		}
//		else {
//			check_box_code.click();	
//		}
//		return check_box_code.isSelected();
//	}
}



