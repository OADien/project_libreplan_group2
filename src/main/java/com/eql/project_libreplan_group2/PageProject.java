package com.eql.project_libreplan_group2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageProject {

	@FindBy(xpath = "//span[contains(@class, 'perspective-active')]")
	private WebElement selectedLeft;

	@FindBy(xpath = "//tr[contains(@class, 'projects-list')]")
	private List<WebElement> projectsList;

	public void check(String projectname, String code, Date datedebut, Date echeance, String client, String budgettotal,
			String heure, String etat) throws ParseException {

		Assert.assertEquals("Liste des projets", selectedLeft.getText().trim());
		WebElement line = null;
		for (WebElement proj : projectsList) {
			WebElement pname = proj.findElement(By.xpath("td[1]"));
			if (pname.getText().trim().equals(projectname)) {
				line = proj;
				break;
			}
		}
		Assert.assertTrue(line != null);
		// check the other info of the line
		Assert.assertEquals(code, line.findElement(By.xpath("td[2]")).getText().trim());
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.FRENCH);
		Assert.assertTrue(datedebut.equals(sdf.parse(line.findElement(By.xpath("td[3]")).getText().trim())));
		Assert.assertTrue(echeance.equals(sdf.parse(line.findElement(By.xpath("td[4]")).getText().trim())));
		Assert.assertEquals(client, line.findElement(By.xpath("td[5]")).getText().trim());
		Assert.assertEquals(budgettotal, line.findElement(By.xpath("td[6]")).getText().trim());
		Assert.assertEquals(heure, line.findElement(By.xpath("td[7]")).getText().trim());
		Assert.assertEquals(etat, line.findElement(By.xpath("td[8]")).getText().trim());

		// check the icons
		WebElement iconsContainer = line.findElement(By.xpath("td[9]"));
		Assert.assertTrue(iconsContainer.findElement(By.xpath("//span[@title='Modifier']")).isDisplayed());
		Assert.assertTrue(iconsContainer.findElement(By.xpath("//span[@title='Supprimer']")).isDisplayed());
		Assert.assertTrue(iconsContainer.findElement(By.xpath("//span[@title='Voir la prévision']")).isDisplayed());
		Assert.assertTrue(iconsContainer.findElement(By.xpath("//span[@title='Créer un modèle']")).isDisplayed());
	}

}
