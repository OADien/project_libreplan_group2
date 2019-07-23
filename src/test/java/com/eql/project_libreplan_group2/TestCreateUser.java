package com.eql.project_libreplan_group2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCreateUser {
	
	@FindBy(xpath="//a[@href=\"/libreplan/resources/worker/worker.zul\"]")
	private WebElement participant;

	private WebDriver driver;

	@Before
	public void init() {
		driver = Utils.chooseBrowser("chrome");
	}

	@After
	public void quit() throws InterruptedException {
		//driver.quit();
		driver.findElement(By.xpath("//a[contains(@class,'cerrar_sesion')]")).click();
//		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("admin");
		PageMain pageMain = Utils.login(driver);
//		driver.findElement(By.xpath("//input[@name='button']")).click();
		pageMain.clickMenu(driver, "Ressources", "Participants");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'/libreplan/common/img/ico_borrar1.png')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'z-messagebox-btn z-button')]")).click();
	}


	@Test
	public void testSection() throws InterruptedException {
		PageMain pageMain = Utils.login(driver);
		pageMain.clickMenu(driver, "Ressources", "Participants");
		PageCreate pageCreate = PageFactory.initElements(driver, PageCreate.class);
		
		pageCreate.creation(driver);
		
		pageCreate.verificationConformite(driver);
		
		pageCreate.newInformation(driver);
		
		pageCreate.newUser(driver);
		
		pageCreate.verificationEnregistrement(driver);
		
		pageCreate.quinzeParticipants(driver);
		
		pageCreate.filtreDétailsPerso(driver);
		
		pageCreate.newOptions(driver);
		
		pageCreate.tableau(driver);
		
		pageCreate.pageDeux(driver);
		
		pageCreate.decoReco(driver);
		//Partie vérifiée OK
	}
	}
