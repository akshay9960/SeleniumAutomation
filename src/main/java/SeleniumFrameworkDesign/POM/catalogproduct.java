package SeleniumFrameworkDesign.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponent.AbstractCamponent;

public class catalogproduct extends AbstractCamponent {

	WebDriver driver;

	public catalogproduct(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By ele = By.id("toast-container");
	By product = By.cssSelector(".mb-3");
	By myele = By.cssSelector(".w-10");

	public List<WebElement> getproduct() {

		waittoelement(product);
		return products;

	}

	public WebElement item(String Searchproduct) {

		WebElement we = products.stream()
				.filter(p1 -> p1.findElement(By.cssSelector("b")).getText().equals(Searchproduct)).findFirst()
				.orElse(null);

		return we;

	}

	public void clickproduct(String Searchproduct) {

		waittoelementappear(ele);
		WebElement finalitem = item(Searchproduct);
		finalitem.findElement(myele).click();

	}

}
