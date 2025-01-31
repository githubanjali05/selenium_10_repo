package genericUtility;


import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListnerUtilityClass extends BaseClass implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getName();
		test = extreport.createTest(methodname);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName() + "is failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		String Screenshot = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(Screenshot);
		try {
			wUtil.getScreenshot(driver);
		}catch(IOException e) {
			e.printStackTrace();
		}

		

	}

}
