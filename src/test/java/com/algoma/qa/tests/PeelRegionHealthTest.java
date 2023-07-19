package com.algoma.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.algoma.qa.base.TestBase;
import com.algoma.qa.utils.TestConstants;

public class PeelRegionHealthTest extends TestBase {

	@Test
	public void peelRegionHealthPageTitleTest() {
		String title = peelPage.getPageTitleWithWait(TestConstants.PAGE_WAIT, TestConstants.PEEL_HEALTH_PARTIAL_TITLE);
		Assert.assertEquals(title, TestConstants.PEEL_HEALTH_TITLE);
	}

	@Test
	public void peelRegionHealthPageURLTest() {
		String url = peelPage.getPageURLWithWait(TestConstants.PAGE_WAIT, TestConstants.PEEL_HEALTH_PARTIAL_URL);
		Assert.assertTrue(url.contains(TestConstants.PEEL_HEALTH_PARTIAL_URL));
	}

}
