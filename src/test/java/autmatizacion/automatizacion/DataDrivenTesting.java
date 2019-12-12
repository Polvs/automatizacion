package autmatizacion.automatizacion;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTesting {

	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");
	private By signIn           = By.xpath("//a[@class='login']");
	private By email            = By.xpath("//input[@id='email']");
	private By password         = By.xpath("//input[@id='passwd']");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver_win32/chromedriver.exe");
		driver    = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile  = new ReadExcelFile();
		
		driver.get("http://automationpractice.com");
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() throws IOException {
		
		String filepath = "C:\\Users\\usuario\\Downloads\\excel.xlsx";
		String emailExcel = readFile.getCellValue(filepath, "Hoja1", 4, 0);
		String passwordExcel = readFile.getCellValue(filepath, "Hoja1", 5, 0);
		
		driver.findElement(signIn).click();
		driver.findElement(email).sendKeys(emailExcel);
		driver.findElement(password).sendKeys(passwordExcel);
		
		
		
		//ESTO USA LOS VALORES DE EL EXCEL PARA RELLENAR CAMPOS
		/*
		String filepath = "C:\\Users\\usuario\\Downloads\\excel.xlsx";
		String searchText = readFile.getCellValue(filepath, "Hoja1", 0, 0);

		driver.findElement(searchBoxLocator).clear();
		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		
		readFile.readExcel(filepath, "Hoja1");
		*/
		
		
		//ESTO ESCRIBE EN EL EXCEL
		/*
		String resultText = driver.findElement(resultTextLocator).getText();
		System.out.println("Page result text:" + resultText);
		writeFile.writeCellValue(filepath, "Hoja1", 0, 1, resultText);
		readFile.readExcel(filepath, "Hoja1");
		 */
	}

}