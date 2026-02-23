package SeleniumFrameworkDesign.TestCamponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.apache.commons.io.FileUtils;

import SeleniumFrameworkDesign.POM.landingpage;

public class Base {

	public WebDriver driver;
	public landingpage lp;

	public WebDriver initialized() throws IOException {

		Properties p = new Properties();
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//SeleniumFrameworkDesign//Properties//Resuse.properties");
		p.load(f);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: p.getProperty("browser");

		if (browsername.contains("chrome")) {

			if (browsername.contains("headless")) {
				driver = new ChromeDriver(options);
				driver.manage().window().setSize(new Dimension(1440, 900));
			} else {
				driver = new ChromeDriver();
			}
		} else if ((browsername.equalsIgnoreCase("Firefox"))) {

			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public String getscreenshot(String Testcasename, WebDriver driver1 ) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//Reports//" + Testcasename + ".png";

		File des = new File(path);
		FileUtils.copyFile(source, des);
		return path;

	}

	@BeforeMethod
	public landingpage launchApp() throws IOException {

		driver = initialized();
		lp = new landingpage(driver);
		lp.goTo();
		return lp;

	}

	@AfterMethod
	public void teardown() {

		driver.close();

	}

}
