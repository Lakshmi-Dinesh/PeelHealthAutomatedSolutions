package com.algoma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.algoma.base.DSLBasePage;
import com.algoma.utils.PageConstants;

public class PeelRegionHealthPage extends DSLBasePage {

	By earlyOnLink = By.cssSelector(".relatedinfo > li:nth-child(1) > a:nth-child(1)");
	By longTermCareLink = By.cssSelector(".relatedinfo > li:nth-child(2) > a:nth-child(1)");
	By ontario811Link = By.cssSelector(".relatedinfo > li:nth-child(3) > a:nth-child(1)");
	By mentalHealthLink = By.cssSelector(".relatedinfo > li:nth-child(4) > a:nth-child(1)");
	By aboutPeelHealthLink = By.cssSelector(".relatedinfo > li:nth-child(5) > a:nth-child(1)");
	By peelStrategicPlanLink = By.cssSelector(".relatedinfo > li:nth-child(6) > a:nth-child(1)");
	By signupLink = By.xpath("//*[@id=\"footer\"]/div[1]/div/div[2]/ul/li[4]/a");

	public PeelRegionHealthPage(String browser) {
		super(browser);
		goToPage(PageConstants.PEEL_HEALTH);
	}

	public PeelRegionHealthPage(WebDriver driver) {
		super(driver);
	}

	public void navigateToPeelHealth() {
		String url = initProperties(PageConstants.PEEL_HEALTH);
		navigateTo(url);
	}

	public OntarioHealth811Page goToHealthConnectOntario(int timeOut) {
		waitForElementAndClick(ontario811Link, timeOut);
		return new OntarioHealth811Page(getDriver());
	}

	public PeelEarlyOnPage goToPeelEarlyOn(int timeOut) {
		waitForElementAndClick(earlyOnLink, timeOut);
		return new PeelEarlyOnPage(getDriver());
	}

	public LongTermCarePage goToLongTermCare(int timeOut) {
		waitForElementAndClick(longTermCareLink, timeOut);
		return new LongTermCarePage(getDriver());
	}

	public PeelMentalHealthPage goToPeelMentalHealth(int timeOut) {
		waitForElementAndClick(mentalHealthLink, timeOut);
		return new PeelMentalHealthPage(getDriver());
	}

	public AboutPeelPublicHealthPage goToAboutPeelPublicHealth(int timeOut) {
		waitForElementAndClick(aboutPeelHealthLink, timeOut);
		return new AboutPeelPublicHealthPage(getDriver());
	}

	public PeelHealthStrategicPlanPage goToPeelHealthStrategicPlan(int timeOut) {
		waitForElementAndClick(peelStrategicPlanLink, timeOut);
		return new PeelHealthStrategicPlanPage(getDriver());
	}

	public PeelNewsletterSignupPage goToPeelEmailSignup(int timeOut) {
		waitForElementScrollAndClick(signupLink, timeOut);
		return new PeelNewsletterSignupPage(getDriver());
	}

}
