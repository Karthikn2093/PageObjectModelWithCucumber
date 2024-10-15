package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelData;

public class ProjectSpecificMethods extends AbstractTestNGCucumberTests {

	public static ChromeDriver driver;

	public String excelFileName;

	public static ExtentHtmlReporter reporter;

	public static ExtentReports extent;

	public static ExtentTest test, node;

	public String testName, testDesc, testAuthor, testCategory;

	@BeforeSuite
	public void startReport() {
		reporter = new ExtentHtmlReporter("./ExtentReports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDesc);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);

	}

	public long takeSnap() throws IOException {
		
		long number = (long) Math.floor((Math.random() * 10000000 +100000000L));

		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snapshot/img"+number+".png");
		FileUtils.copyFile(source, target);
		
		return number; //534543534

	}

	public void reportStep(String msg, String status) throws IOException {

		if (status.equalsIgnoreCase("pass")) {
			node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snapshot/img"+takeSnap()+".png").build());
		} else if (status.equalsIgnoreCase("fail")) {
			node.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snapshot/img"+takeSnap()+".png").build());
			throw new RuntimeException();
		}

	}

	@BeforeMethod
	public void startApplication() {

		node = test.createNode(testName);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();

	}

	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		ReadExcelData red = new utils.ReadExcelData();
		String[][] data = red.readExcel(excelFileName);
		return data;
	}

	@AfterSuite
	public void endReport() {
		extent.flush();

	}

}
