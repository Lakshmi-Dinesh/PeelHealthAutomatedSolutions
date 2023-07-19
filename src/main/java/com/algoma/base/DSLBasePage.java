package com.algoma.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import com.algoma.exceptions.IncorrectBrowserNameException;
import com.algoma.exceptions.IncorrectPageNameException;
import com.algoma.utils.PageConstants;

public class DSLBasePage {

	WebDriver driver;
	Properties properties;
	int timeOut = 10;

	public DSLBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public DSLBasePage(String browser) {

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			throw new IncorrectBrowserNameException(browser + PageConstants.INCORRECT_BROWER_MESSAGE);
		}

	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public String initProperties(String pageName) {
		FileInputStream fis = null;
		properties = new Properties();
		try {
			fis = new FileInputStream("./src/main/resources/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String url = properties.getProperty(pageName);
		if (url == null)
			throw new IncorrectPageNameException(pageName + PageConstants.INCORRECT_PAGE_NAME_MESSAGE);
		return url;
	}

	public void goToPage(String pageName) {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		String url = initProperties(pageName);
		driver.get(url);

	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	public void click(WebElement e) {
		e.click();
	}

	public void waitForElementAndClick(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public void waitForElementScrollAndClick(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// placeholder script for the element that cannot be scrolled into view
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public String getPageURLWithWait(int timeout, String partialUrl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.urlContains(partialUrl)))
			return getPageURL();
		else
			return null;
	}

	public String getPageTitleWithWait(int timeout, String partialTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.titleContains(partialTitle)))
			return getPageTitle();
		else
			return null;
	}

	public boolean isPageLoadComplete() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (js.executeScript("return document.readyState").toString().equals("complete"))
			return true;
		else
			return false;
	}

	public void waitForElementAndType(By locator, String text, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		input.click();
		type(input, text);
	}

	private void type(WebElement element, String text) {
		element.sendKeys(text);
	}

	protected String waitForElementAndGetText(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement errorTitleText = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return errorTitleText.getText();
	}

	@SuppressWarnings("unused")
	private void moveToElementAndClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

}
