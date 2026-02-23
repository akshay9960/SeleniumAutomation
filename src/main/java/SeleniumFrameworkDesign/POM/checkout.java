package SeleniumFrameworkDesign.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponent.AbstractCamponent;

public class checkout extends AbstractCamponent {

	WebDriver driver;

	public checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button")
	List<WebElement> selprod;
    
	//driver.findElement(By.cssSelector(".action__submit")).click();
	
	@FindBy(css = ".action__submit")
	WebElement placeholder;
	
	@FindBy(css = ".form-group input")
	WebElement textbox;

	public void addtotext() {

		textbox.sendKeys("ind");

	}

	public List<WebElement> getselprod() {

		return selprod;

	}
	
	public void clickselprod(String country) {
		//List<WebElement> sp =getselprod();
		for (WebElement as : getselprod()) {
			if (as.getText().equalsIgnoreCase(country)) {

				as.click();
				break;

			}
		}
		
		
	}
	
	
	public void clickplaceholder() {
		
		
		placeholder.click();
		
	}
	

}
