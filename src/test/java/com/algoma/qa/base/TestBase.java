package com.algoma.qa.base;

import org.openqa.selenium.WebDriver;
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

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
