package SeleniumFrameworkDesign.stepDefination;

import java.io.IOException;

import org.testng.Assert;

import SeleniumFrameworkDesign.POM.cartpage;
import SeleniumFrameworkDesign.POM.catalogproduct;
import SeleniumFrameworkDesign.POM.checkout;
import SeleniumFrameworkDesign.POM.confirmationpage;
import SeleniumFrameworkDesign.TestCamponents.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefenation extends Base {

	String country = "India";

	@Given("I landed on ecommerce website")
	public void I_landed_on_ecommerce_website() throws IOException {

		launchApp();

	}

	@Given("^Login with username (.+) and password (.+)$")
	public void login_with_username_and_password(String username, String password) {

		lp.action(username, password);

	}

	@When("^Select the product (.+) from the cart$")
	public void Select_prod_from_cart(String Productname) throws InterruptedException {

		catalogproduct cp = new catalogproduct(driver);
		cp.clickproduct(Productname);
		cp.cardclick();
		cartpage c = new cartpage(driver);
		c.cartaction(Productname);
		checkout co = new checkout(driver);
		co.addtotext();
		co.clickselprod(country);
		co.clickplaceholder();

	}

	@Then("{string} should be displayed")
	public void verify_confirmation_msg(String string) {
		
		confirmationpage order = new confirmationpage(driver);
		String name = order.orderconfirmation();
		Assert.assertEquals(name, string);
		driver.close();

		

	}

}
