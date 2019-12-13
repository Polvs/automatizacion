package autmatizacion.automatizacion;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TEST_registro_completo {

	WebDriver driver;
	automatizacion_OBJ obj = new automatizacion_OBJ(driver);
	
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	
	@Before
	public void setUp() throws Exception {
		obj.before();
		//writeFile = new WriteExcelFile();
		readFile  = new ReadExcelFile();
	}

	@After
	public void tearDown() throws Exception {
		obj.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		
		String filepath     = "C:\\Users\\usuario\\Downloads\\excel.xlsx";
		String nameExcel    = readFile.getCellValue(filepath, "Hoja1", 0, 1);
		String surnameExcel = readFile.getCellValue(filepath, "Hoja1", 1, 1);
		String password     = readFile.getCellValue(filepath, "Hoja1", 2, 1);
		String company      = readFile.getCellValue(filepath, "Hoja1", 3, 1);
		String address      = readFile.getCellValue(filepath, "Hoja1", 4, 1);
		String city         = readFile.getCellValue(filepath, "Hoja1", 5, 1);   
		Double postcode     = readFile.getIntCellValue(filepath, "Hoja1", 6, 1);
		Double phone        = readFile.getIntCellValue(filepath, "Hoja1", 8, 1);
		
		obj.click(obj.signInBtn);

		obj.waitForElementClickable(obj.registerEmail, 10);
		obj.randomEmail();
		obj.click(obj.registerBtn);
		
		obj.waitForElementClickable(obj.genderBtn, 10);
		obj.click(obj.genderBtn);
		
		obj.name_lsname_password(nameExcel, surnameExcel, password);
		obj.age_dropdown();
		obj.click(obj.newsletter);
		obj.click(obj.specialOffers);
		obj.company(company);
		obj.address(address, city);
		obj.state_dropdown();
		obj.writeInt(obj.postcode, postcode);
		obj.writeInt(obj.mobile_phone, phone);
		obj.click(obj.accountCreationBtn);
		
		obj.waitForElementClickable(obj.signOutBtn, 10);
		assertTrue(obj.existElement(obj.signOutBtn));
		Thread.sleep(2000);
		
		//hover over women and clicks the tab tshirts thats hidden if not hover.
		obj.hoverElement(obj.hoverWomen);
		obj.click(obj.hoverTshirts);
		obj.click(obj.TshirtText);
		obj.click(obj.AddToCart);
		//obj.click(obj.checkout);
		//obj.click(obj.pTocheckout);
	}
}
