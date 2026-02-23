package SeleniumFrameworkDesign.Listnerss;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;

import SeleniumFrameworkDesign.ExtentReports.ExtentReportss;
import SeleniumFrameworkDesign.TestCamponents.Base;

public class Listners extends Base implements ITestListener {
	ExtentTest test;

	ExtentReports extent = ExtentReportss.reports();
    ThreadLocal<ExtentTest> tc=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
        tc.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		tc.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {

			e.printStackTrace();
		}

		String filepath = null;
		try {
			filepath = getscreenshot(result.getMethod().getMethodName(),driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tc.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

	}



	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
