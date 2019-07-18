package com.eql.project_libreplan_group2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class Utils {

	private static final String URL = "http://localhost:8090/libreplan";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";

	public static WebDriver chooseBrowser(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			return new FirefoxDriver();

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			return new ChromeDriver();

		case "ie":
			System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
			return new InternetExplorerDriver();
		default:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			return new FirefoxDriver();
		}
	}

	public static PageCalendar login(WebDriver driver) {
		driver.get(URL);
		PageLogin pageLogin = PageFactory.initElements(driver, PageLogin.class);
		return pageLogin.login(driver, USERNAME, PASSWORD);
	}
	
	public static void renseignerChamp(WebElement field, String str) {
		field.clear();
		field.sendKeys(str);
	}

}
