package com.eql.project_libreplan_group2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestProfile {

	private WebDriver driver;

	@Before
	public void init() {
		driver = Utils.chooseBrowser("chrome");
	}

	// @After
	public void quit() {
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		PageMain pageMain = Utils.login(driver);
		pageMain.clickMenu(driver, "Configuration", "Profils");
		PageProfiles pageProfiles = PageFactory.initElements(driver, PageProfiles.class);
		pageProfiles.test();
		PageCreateUpdateProfile pageCreateUpdateProfile = pageProfiles.createProfile(driver);
		pageCreateUpdateProfile.test();
		String profile = "Profile 1";
		pageCreateUpdateProfile.fillForm(driver, profile, "Super utilisateur");
		
		pageCreateUpdateProfile.addRole("consommateur de web service");
		pageCreateUpdateProfile.addRole("fournisseur de web service");
		pageCreateUpdateProfile.addRole("Créer des projets");
		pageCreateUpdateProfile.addRole("Calendrier");
		
		//check duplicate roles
		pageCreateUpdateProfile.addRole("Calendrier");
		pageCreateUpdateProfile.checkDuplicateRole("Calendrier");
		
		//delete role
		pageCreateUpdateProfile.deleteRole("Super utilisateur");
		//delete all roles
		pageCreateUpdateProfile.deleteAllRoles();
		pageProfiles = pageCreateUpdateProfile.saveProfile(driver);
		Thread.sleep(1000);
		pageProfiles.checkProfileCreation(profile);
		pageCreateUpdateProfile = pageProfiles.clickOnEditProfile(driver, profile);
		pageCreateUpdateProfile.checkUpdatePage(profile);
		
		pageCreateUpdateProfile.addRole("Super utilisateur");
		pageCreateUpdateProfile.addRole("consommateur de web service");
		pageCreateUpdateProfile.addRole("fournisseur de web service");
		profile = "Profile 2";
		pageCreateUpdateProfile.setProfileName(profile);
		pageProfiles = pageCreateUpdateProfile.saveProfile(driver);
		pageProfiles.checkProfileCreation(profile);
	}
}
