 package SeleniumFrameworkDesign.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponent.AbstractCamponent;

public class cartpage extends AbstractCamponent {

	WebDriver driver;

	public cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='cartSection']")
	List<WebElement> cartitems;
	
	//@FindBy(xpath = "//div[@class='cart']//button[1]")
	//WebElement myfinalitem;
	
	
	

	public List<WebElement> getcartlist() {

		return cartitems;

	}

	public WebElement mycartiteam(String Searchproduct) {

		WebElement selectedcart = cartitems.stream()
				.filter(l -> l.findElement(By.xpath("//div[@class='cart']//h3")).getText().equals(Searchproduct))
				.findFirst().orElse(null);
		return selectedcart;
	}
	
	public void cartaction(String Searchproduct) {
		
		WebElement wee=mycartiteam(Searchproduct);
		
		wee.findElement(By.xpath("//div[@class='cart']//button[1]")).click();
		
	}
	
	
	
	
	
	

}
