package common;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Constants;


public class BaseTest {
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentTest logger;
	public static ExtentReports extent;
	@BeforeTest
	public void beforeTest() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("C:\\Users\\sawantm\\eclipse-workspace\\YT_FrameW\\reports\\ExtentReportResults.html"));
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test Result");
		htmlReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automatoion Tester","Mayur Sawant");
		
		
		
		
	}
	@BeforeMethod
	@Parameters(value= {"browserName"})
	public void beforeMethod(String browserName, Method testMethod) {
		logger=extent.createTest(testMethod.getName());
		setUpDriver("Chrome");//browserName
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(Constants.URL);
		
	}
	
	@Test
	public void mainTest() {
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case: "+ methodName +" Passed";
			Markup m=MarkupHelper.createLabel(logText,ExtentColor.GREEN);
			logger.log(Status.PASS,m);			
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case: "+ methodName +" Passed";
			Markup m=MarkupHelper.createLabel(logText,ExtentColor.RED);
			logger.log(Status.FAIL,m);
		}
		
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		extent.flush();
	}
	public void setUpDriver(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {//anotherString:
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sawantm\\eclipse-workspace\\YT_FrameW\\drivers\\chromedriver.exe");
			
		}
	}

}
