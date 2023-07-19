package com.algoma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.algoma.base.DSLBasePage;

public class PeelNewsletterSignupPage extends DSLBasePage {

	By signupEmailLink = By.cssSelector("input#email.join_email");
	By joinButton = By.cssSelector(
			"#content-main > div:nth-child(3) > div > form > div > input.join_btn.btn-orange.bradius.in-page-btn.btn-homebox");
	By errorTitle = By.cssSelector("#content-main > div:nth-child(3) > p.page-intro");

	public PeelNewsletterSignupPage(WebDriver driver) {
		super(driver);
	}

	public PeelNewsletterSignupPage(String browser) {
		super(browser);
	}

	public void type(String text, int timeOut) {
		waitForElementAndType(signupEmailLink, text, timeOut);
		waitForElementAndClick(joinButton, timeOut);
	}

	public String typeIncorrectEmail(String text, int timeOut) {
		type(text, timeOut);
		return waitForElementAndGetText(errorTitle, timeOut);
	}

}
