package SeleniumFrameworkDesign.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponent.AbstractCamponent;

public class landingpage extends AbstractCamponent{
	  WebDriver driver;
	  public landingpage(WebDriver driver){
		  super(driver);
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
		  
		  
	  }
	  
	  @FindBy(id="userEmail")
	  WebElement userEmail;
	  
	  @FindBy(id="userPassword")
	  WebElement userPassword;
	  
	  @FindBy(id="login")
	  WebElement submit;
	  
	  
	  @FindBy(id="toast-container")
	  WebElement errormsg;
	  
	  By em=By.id("toast-container");
	  
	  
	  public void action(String Username, String Password) {
		  
		  userEmail.sendKeys(Username);
		  userPassword.sendKeys(Password);
		  submit.click();
		  
	  }
	  

	  public void goTo() {
		  driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		  
	  }
	  
	  public String errortext() {
		  
		  waittoelement(em);
		 return  errormsg.getText();
		  
	  }

	  
	  
  }

