package com.eql.project_libreplan_group2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTaskResources {
	
	@FindBy(xpath="//div[contains(@class, 'taskassignmentinterval FULL_LOAD')]")
	private List<WebElement> resourcesBars;

	public void test() {
		Assert.assertFalse(resourcesBars.isEmpty());
	}
}
