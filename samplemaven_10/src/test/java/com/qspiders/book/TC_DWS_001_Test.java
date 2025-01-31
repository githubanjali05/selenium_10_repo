package com.qspiders.book;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListnerUtilityClass;
import objectRepository.HomePage;

@Listeners(ListnerUtilityClass.class)
public class TC_DWS_001_Test extends BaseClass {
	@Test
	public void clickOnBooks() {
		ExtentTest test = extreport.createTest("clickOnBooks");
		hp = new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books", "Books Page is not displayed");
		test.log(Status.PASS, "Books Page is Displayed");
	}

}
