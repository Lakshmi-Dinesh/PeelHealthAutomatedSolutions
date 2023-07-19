package com.algoma.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.algoma.qa.base.TestBase;
import com.algoma.qa.utils.TestConstants;

public class PeelRegionHealthFailedSubscribeTest extends TestBase {

	@BeforeMethod
	public void goToPeelEmailSignup() {
		signupPage = peelPage.goToPeelEmailSignup(TestConstants.EXTENDED_WAIT);
	}

	@DataProvider
	public Object[][] incorrectEmailIds() {
		return new Object[][] { { "abc" }, { "a b" }, { "@" }, { ".xyz" } };
	}

	@Test(dataProvider = "incorrectSubscribeEmailIds", dataProviderClass = com.algoma.qa.dataproviders.PeelHealthDataProviders.class)
	public void doSignupWithIncorrectEmailID(String emailId) {
		String errorMessage = signupPage.typeIncorrectEmail(emailId, TestConstants.EXTENDED_WAIT);
		Assert.assertEquals(errorMessage, TestConstants.SIGNUP_ERROR);
	}
}
