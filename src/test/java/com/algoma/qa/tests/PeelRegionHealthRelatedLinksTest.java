package com.algoma.qa.tests;

import static org.slf4j.LoggerFactory.getLogger;
import static java.lang.invoke.MethodHandles.lookup;

import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.algoma.qa.base.TestBase;
import com.algoma.qa.utils.TestConstants;

public class PeelRegionHealthRelatedLinksTest extends TestBase {
	final Logger log = getLogger(lookup().lookupClass());

	@BeforeMethod
	public void navigateToPeelHealth() {
		peelPage.navigateToPeelHealth();
	}

	@Test
	public void goToOntario811PageTest() {
		ontario811Page = peelPage.goToHealthConnectOntario(TestConstants.ELEMENT_WAIT);
		String title = ontario811Page.getPageTitleWithWait(TestConstants.PAGE_WAIT,
				TestConstants.ONTARIO_811_PARTIAL_TITLE);
		log.debug("\nURL: {}\nTITLE: {}", ontario811Page.getPageURL() , title);
		Assert.assertTrue(title.contains(TestConstants.ONTARIO_811_TITLE));
	}

	@Test
	public void goToPeelEarlyOnPageTest() {
		peelEarlyOnPage = peelPage.goToPeelEarlyOn(TestConstants.ELEMENT_WAIT);
		String title = peelEarlyOnPage.getPageTitleWithWait(TestConstants.PAGE_WAIT,
				TestConstants.EARLY_ON_PARTIAL_TITLE);
		log.debug("\nURL: {}\nTITLE: {}", peelEarlyOnPage.getPageURL() , title);
		Assert.assertTrue(title.contains(TestConstants.EARLY_ON_TITLE));
	}

	@Test
	public void goToPeelLongTermCarePageTest() {
		longTermCarePage = peelPage.goToLongTermCare(TestConstants.ELEMENT_WAIT);
		String title = longTermCarePage.getPageTitleWithWait(TestConstants.PAGE_WAIT,
				TestConstants.LONG_TERM_CARE_PARTIAL_TITLE);
		log.debug("\nURL: {}\nTITLE: {}", longTermCarePage.getPageURL() , title);
		Assert.assertTrue(title.contains(TestConstants.LONG_TERM_CARE_TITLE));
	}

	@Test
	public void goToPeelMentalHealthPageTest() {
		peelMentalhealthPage = peelPage.goToPeelMentalHealth(TestConstants.ELEMENT_WAIT);
		String title = peelMentalhealthPage.getPageTitleWithWait(TestConstants.PAGE_WAIT,
				TestConstants.PEEL_MENTAL_HEALTH_PARTIAL_TITLE);
		log.debug("\nURL: {}\nTITLE: {}", peelMentalhealthPage.getPageURL() , title);
		Assert.assertTrue(title.contains(TestConstants.PEEL_MENTAL_HEALTH_TITLE));
	}

	@Test
	public void goToAboutPeelPublicHealthPageTest() {
		aboutPeelPage = peelPage.goToAboutPeelPublicHealth(TestConstants.ELEMENT_WAIT);
		String title = aboutPeelPage.getPageTitleWithWait(TestConstants.PAGE_WAIT,
				TestConstants.ABOUT_PEEL_PARTIAL_TITLE);
		log.debug("\nURL: {}\nTITLE: {}", aboutPeelPage.getPageURL() , title);
		Assert.assertTrue(title.contains(TestConstants.ABOUT_PEEL_TITLE));
	}

	@Test
	public void goToPeelHealthStrategicPlanPageTest() {
		strategicPlanPage = peelPage.goToPeelHealthStrategicPlan(TestConstants.ELEMENT_WAIT);
		String title = strategicPlanPage.getPageTitleWithWait(TestConstants.PAGE_WAIT,
				TestConstants.PEEL_STRATEGIC_PLAN_PARTIAL_TITLE);
		log.debug("\nURL: {}\nTITLE: {}", strategicPlanPage.getPageURL() , title);
		Assert.assertTrue(title.contains(TestConstants.PEEL_STRATEGIC_PLAN_TITLE));
	}

}
