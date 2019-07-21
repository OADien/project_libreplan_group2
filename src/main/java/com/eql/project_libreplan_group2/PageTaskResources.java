package com.eql.project_libreplan_group2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTaskResources extends BasePage {
	
	@FindBy(xpath="//div[contains(@class, 'taskassignmentinterval FULL_LOAD')]")
	private List<WebElement> resourcesBars;
	
	@FindBy(xpath="//tr[contains(@class,'resourceload-leftpanel-row z-treerow')]")//"//span[contains(@class, 'z-tree-ico')]")
	private List<WebElement> treeRows;

	public void test() {
		Assert.assertFalse(resourcesBars.isEmpty());
		Assert.assertFalse(treeRows.isEmpty());
	}
	
	private void clickTreeIcon(int index) {
		treeRows.get(index).findElement(By.xpath("//span[contains(@class, 'z-tree-ico')]")).click();
	}
	
	public void expandTree(int index) {
		WebElement currentRow = treeRows.get(index);
		clickTreeIcon(index);
		//check the label next to the tree icon
		String resourceName = currentRow.findElement(By.xpath("//descendant::span[contains(@class, 'z-label')]")).getText();
		System.out.println("Nom de la ressource = " + resourceName);
		
		WebElement followingRow = treeRows.get(index+1);
		List<WebElement> spacers = followingRow.findElements(By.xpath("//descendant::span[contains(@class, 'z-tree-line')]"));
		Assert.assertFalse(spacers.isEmpty());
		WebElement taskName = followingRow.findElement(By.xpath("//descendant::span[contains(@class, 'z-label')]"));
		System.out.println("Nom de la tâche = " + taskName);
	}
	
	public void hideTree(int index) {
		clickTreeIcon(index);
		try {
			WebElement followingRow = treeRows.get(index+1);
			Assert.assertFalse(followingRow.isDisplayed());
		} catch(Exception ex) {
			System.out.println("L'arborescence de la ressource et de la tâche s'est refermée");
		}
	}
}
