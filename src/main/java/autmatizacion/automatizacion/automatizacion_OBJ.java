package autmatizacion.automatizacion;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class automatizacion_OBJ extends BasePage {

	public automatizacion_OBJ(WebDriver driver) {
		super(driver);
	}
	
	By signInBtn   = By.xpath("//a[@class='login']");
	By usernameBox = By.xpath("//input[@id='email']");
	By passwordBox = By.xpath("//input[@id='passwd']");
	By logInBtn    = By.xpath("//i[@class='icon-lock left']");
	By signOutBtn  = By.xpath("//a[@class='logout']");
	By registerEmail = By.xpath("//input[@id='email_create']");
	By registerBtn = By.xpath("//form[@id='create-account_form']//span[1]");
	By genderBtn   = By.xpath("//div[@class='clearfix']//div[1]//label[1]");
	By firstName   = By.xpath("//input[@id='customer_firstname']");
	By lastName    = By.xpath("//input[@id='customer_lastname']");
	By password    = By.xpath("//input[@id='passwd']");
	By dropdown_day = By.id("days");
	By dropdown_months = By.id("months");
	By dropdown_years = By.id("years");
	By newsletter  = By.id("newsletter");
	By specialOffers = By.id("optin");
	By company     = By.id("company");
	By address     = By.id("address1");
	By city        = By.id("city");
	By dropdown_state = By.id("id_state");
	By postcode    = By.id("postcode");
	By mobile_phone = By.id("phone_mobile");
	By accountCreationBtn = By.id("submitAccount");
	By hoverWomen   = By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]");
	By hoverTshirts = By.xpath("//li[@class='sfHover']//a[contains(text(),'T-shirts')]");
	By TshirtText   = By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
	By AddToCart    = By.xpath("//span[contains(text(),'Add to cart')]");
	By checkout     = By.xpath("//a[@class='btn btn-default button button-medium']");
	
	
	
	public void before() {
		chromeDriverConnection();
		window();
		navigateTo("http://automationpractice.com/index.php");
	}
	
	public void quit() {
		driver.quit();
	}

	public void randomEmail() {
		click(registerEmail);
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(10000); 
		writeText(registerEmail, "username" + randomInt + "@gmail.com");
	}
	
	public void name_lsname_password(String name, String surname, String pass) {
		writeText(firstName, name);
		writeText(lastName, surname);
		writeText(password, pass);
	}
	
	public void age_dropdown() {
		selectDropDownOption("10", dropdown_day);
		selectDropDownOption("11", dropdown_months);
		selectDropDownOption("1998", dropdown_years);
	}
	
	public void company(String writeCompany) {
		writeText(company, writeCompany);
	}
	
	public void address(String calle, String ciudad) {
		writeText(address, calle);
		writeText(city, ciudad);
	}
	
	public void state_dropdown() {
		selectDropDownOption("5", dropdown_state);
	}
}
