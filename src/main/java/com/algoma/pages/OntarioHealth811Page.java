package com.algoma.pages;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;

import com.algoma.base.DSLBasePage;
import com.algoma.utils.PageConstants;

public class OntarioHealth811Page extends DSLBasePage {

	public OntarioHealth811Page(WebDriver driver) {
		super(driver);
	}

	public OntarioHealth811Page(String browser) {
		super(browser);
		goToPage(PageConstants.ONTARIO_811);
	}
}
