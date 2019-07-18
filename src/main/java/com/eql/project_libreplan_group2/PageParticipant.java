package com.eql.project_libreplan_group2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageParticipant {
	
	//Lien xpath du sous-menu "Participants"
	//a[@href="/libreplan/resources/worker/worker.zul"]

	@FindBy(xpath="//a[@href=\"/libreplan/resources/worker/worker.zul\"]")
	private WebElement worker;
	
	public PageCreate participant(WebDriver driver ) {
	
}
}