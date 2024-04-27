package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "//reports//FlyEmiratesAutomationResult.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("VAI assignment Test Results");
		reporter.config().setDocumentTitle("VAI assignment Test Result");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Author", "Anjali Jirole");
		extent.createTest(path);
		return extent;
	}	

}
