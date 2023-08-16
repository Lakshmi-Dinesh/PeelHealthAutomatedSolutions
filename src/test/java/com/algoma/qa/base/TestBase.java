package com.algoma.qa.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.algoma.pages.AboutPeelPublicHealthPage;
import com.algoma.pages.LongTermCarePage;
import com.algoma.pages.OntarioHealth811Page;
import com.algoma.pages.PeelEarlyOnPage;
import com.algoma.pages.PeelHealthStrategicPlanPage;
import com.algoma.pages.PeelMentalHealthPage;
import com.algoma.pages.PeelNewsletterSignupPage;
import com.algoma.pages.PeelRegionHealthPage;

public class TestBase {

	WebDriver driver;
	protected PeelRegionHealthPage peelPage;
	protected OntarioHealth811Page ontario811Page;
	protected PeelEarlyOnPage peelEarlyOnPage;
	protected LongTermCarePage longTermCarePage;
	protected PeelHealthStrategicPlanPage strategicPlanPage;
	protected AboutPeelPublicHealthPage aboutPeelPage;
	protected PeelMentalHealthPage peelMentalhealthPage;
	protected PeelNewsletterSignupPage signupPage;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {
		peelPage = new PeelRegionHealthPage(browser);
		driver = peelPage.getDriver();
	}

	@AfterMethod
	public void captureScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File tempScreenshot = ts.getScreenshotAs(OutputType.FILE);
			String destinationPath = "./test-output/screenshots/" + result.getName() + "_" + System.currentTimeMillis()
					+ ".png";
			try {
				FileUtils.copyFile(tempScreenshot, new File(destinationPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
