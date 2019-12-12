package autmatizacion.automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TEST_registro_completo {

	WebDriver driver;
	automatizacion_OBJ obj = new automatizacion_OBJ(driver);
	
	@Before
	public void setUp() throws Exception {
		obj.before();
	}

	@After
	public void tearDown() throws Exception {
		obj.quit();
	}

	@Test
	public void test() throws InterruptedException {
		obj.click(obj.signInBtn);

		obj.waitForElementClickable(obj.registerEmail, 10);
		obj.randomEmail();
		obj.click(obj.registerBtn);
		
		obj.waitForElementClickable(obj.genderBtn, 10);
		obj.click(obj.genderBtn);
		
		obj.name_lsname_password("alvaro", "last name", "aaaaaa");
		obj.age_dropdown();
		obj.click(obj.newsletter);
		obj.click(obj.specialOffers);
		obj.company("GFI");
		obj.address("calle serrano galvache 46", "Madrid");
		obj.state_dropdown();
		obj.writeText(obj.postcode, "28010");
		obj.writeText(obj.mobile_phone, "123456789");
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
