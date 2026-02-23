package SeleniumFrameworkDesign.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.Listnerss.Retry;
import SeleniumFrameworkDesign.POM.cartpage;
import SeleniumFrameworkDesign.POM.catalogproduct;
import SeleniumFrameworkDesign.POM.checkout;
import SeleniumFrameworkDesign.POM.confirmationpage;
import SeleniumFrameworkDesign.POM.landingpage;
import SeleniumFrameworkDesign.TestCamponents.Base;

public class Testapp extends Base {
	@Test(dataProvider = "getdata")
	public void submitorder(String email, String password, String Productname)
			throws InterruptedException, IOException {

		String country = "India";
		lp.action(email, password);
		catalogproduct cp = new catalogproduct(driver);
		cp.clickproduct(Productname);
		cp.cardclick();
		cartpage c = new cartpage(driver);
		c.cartaction(Productname);
		checkout co = new checkout(driver);
		co.addtotext();
		co.clickselprod(country);
		co.clickplaceholder();
		confirmationpage order = new confirmationpage(driver);
		String name = order.orderconfirmation();
		Assert.assertEquals(name, "THANKYOU FOR THE ORDER.");

	}

	@DataProvider
	public Object[][] getdata() {

		return new Object[][] { { "akshaysabe@gmail.com", "Bullet@1111", "ZARA COAT 3" },
				{ "sabeakshay22@gmail.com", "One_4006", "ADIDAS ORIGINAL" }

		};

	}

	@Test(retryAnalyzer = Retry.class)
	public void errorhanding() {

		lp.action("Sabeakshay22@gmail.com", "One_400");

		String errormessage = lp.errortext();
		Assert.assertEquals(errormessage, "Incorrect email or passwor");

	}
}
