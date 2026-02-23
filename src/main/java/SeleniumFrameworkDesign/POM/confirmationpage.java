package SeleniumFrameworkDesign.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponent.AbstractCamponent;

public class confirmationpage  extends AbstractCamponent {

	
	

	WebDriver driver;

	public confirmationpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//h1[text()=' Thankyou for the order. ']")
	WebElement confirmmationtext;
	
	public  String orderconfirmation() {
		
		return confirmmationtext.getText();
		
		
		
	}
	

	
}
