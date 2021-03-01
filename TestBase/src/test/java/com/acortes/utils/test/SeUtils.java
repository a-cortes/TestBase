package com.acortes.utils.test;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Scenario;

public class SeUtils {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		initializeDriver();
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		SeUtils.driver = driver;
	}

	public static boolean isDriverActive() {
		return driver != null && ((RemoteWebDriver)driver).getSessionId() != null;
	}

	public static void navigateTo(String url) {
		initializeDriver();
		driver.get(url);
	}

	private static void initializeDriver() {
		if (!isDriverActive()) {
			driver = DriverFactory.getDriver();
			driver.manage().window().maximize();
		}
	}

	public static void switchToWindow(int index) {
		driver.switchTo().window((String) (driver.getWindowHandles().toArray())[index]);
	}

	public static void switchToWindow(String id) {
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (windowHandle.equals(id)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public static void clickNewWindow(WebElement element) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).click(element).keyUp(Keys.SHIFT).build().perform();
	}

	public static void clickNewTab(WebElement element) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
	}

	public static void clickJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void screenshot() {
		Scenario myScenario = ReportUtils.getScenario();
		try {
			myScenario.write("Current Page URL is " + driver.getCurrentUrl());
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			myScenario.embed(screenshot, "image/png", ""); // Stick it in the report
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {

		} catch (ClassCastException cce) {

		}
	}

}
