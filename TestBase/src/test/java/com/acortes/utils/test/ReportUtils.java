package com.acortes.utils.test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;

public class ReportUtils {

	@Getter @Setter
	public static Scenario scenario;

	public static void takeScreenshot() {
		WebDriver driver = SeUtils.getDriver();
		if (driver != null) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png", scenario.getName());
		}
	}

}
