package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class BaseClass {

	public static ExtentReports extreport;
	public static WebDriver driver;
	public static ExtentTest test;

	public JavaUtilityClass Jutil = new JavaUtilityClass();
	public WebDriverUtilityClass wUtil = new WebDriverUtilityClass();
	public FileutilityClass fUtil = new FileutilityClass();

	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;

	@BeforeSuite
	public void configReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"./HTML_reports/ExtentReport_" + Jutil.getSystemDateTime() + ".html");
		extreport = new ExtentReports();
		extreport.attachReporter(spark);

	}

	@Parameters("Browser")
	@BeforeClass
	public void openBrowser(@Optional("chrome") String browserName) throws IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		wUtil.implicitWait(driver);
		driver.get(fUtil.getDataFromProperty("url"));
	}

	@BeforeMethod
	public void login() throws IOException {
		wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("password"));
		lp.getLoginButton().click();

	}

	@AfterMethod
	public void logout() {
		hp = new HomePage(driver);
		hp.getLogoutLink().click();

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void reportBackup() {
		extreport.flush();
	}

}
