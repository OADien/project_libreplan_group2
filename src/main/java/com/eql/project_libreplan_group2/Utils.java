package com.eql.project_libreplan_group2;

import java.io.File;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Utils {

	private static final String URL = "http://localhost:8090/libreplan";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hotel";
	private static final String USER = "username";
	private static final String PASSWORDBDD = "password";

	
	public static WebDriver chooseBrowser(String browser) {
		WebDriver driver;
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
	}

	public static PageMain login(WebDriver driver) {
		driver.get(URL);
		PageLogin pageLogin = PageFactory.initElements(driver, PageLogin.class);
		return pageLogin.login(driver, USERNAME, PASSWORD);
	}

	public static void renseignerChamp(WebElement field, String str) {
		field.clear();
		field.sendKeys(str);
	}
	
	public static boolean checkBoxCode(WebElement code) {
		if(code.isSelected()) {
			System.out.println("la case est cochée");
		}
		else {
			code.click();	
		}
		return code.isSelected();
    }

	public static void checkColor(WebElement msgBox, String couleurHexminuscule) {
		System.out.println(msgBox.getText());
		String rgbCode = msgBox.getCssValue("Background").substring(0, 18);
		//System.out.println(rgbCode);
		String[] numbers = rgbCode.replace("rgb(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
		//System.out.println(hex);
		assertTrue("[FAIL] Pas la bonne couleur", couleurHexminuscule.equals(hex));
	}

	private static IDataSet readDataSet (String filename) throws Exception{
		return new FlatXmlDataSetBuilder().build(new File(filename));
		}

	public static void insertData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORDBDD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
		}
	
	public static void deleteAllData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORDBDD);
		databaseTester.setSetUpOperation(DatabaseOperation.DELETE_ALL);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
		}

	public static void compareData(String table, String path_to_file, String...col) throws SQLException, Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORDBDD);
		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
		ITable actualTable =databaseDataSet.getTable(table);
		IDataSet expectedDataSet=readDataSet(path_to_file);
		ITable expectedTable =expectedDataSet.getTable(table);
		String tab[]= col;
		Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, tab);
		}

	public static void selectOptionFromMenu(WebElement menu,String option) {
		Select select = new Select(menu);
		select.selectByValue(option);
	}
	
}
