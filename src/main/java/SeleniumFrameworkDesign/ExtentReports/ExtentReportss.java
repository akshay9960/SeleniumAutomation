package SeleniumFrameworkDesign.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportss {
	

	public static ExtentReports reports() {

		String file = System.getProperty("user.dir") + "//Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("QA Reports");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Akshay", "Tester");

		//extent.createTest("My Test");
		return extent;

	}

}
