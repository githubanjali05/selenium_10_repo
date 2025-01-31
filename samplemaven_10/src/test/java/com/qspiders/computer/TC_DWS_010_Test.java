package com.qspiders.computer;

import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListnerUtilityClass;
import objectRepository.HomePage;

@Listeners(ListnerUtilityClass.class)
public class TC_DWS_010_Test extends BaseClass {
	public void clickOnComputers() {

		ExtentTest test = extreport.createTest("clickOnComputers");
		test.log(Status.INFO, "user logged in successfully");

		hp = new HomePage(driver);
		hp.getComputersLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop.Computers", "Computers Page is not displayed");
		test.log(Status.PASS, "Computers Page is Displayed");
	}

}
