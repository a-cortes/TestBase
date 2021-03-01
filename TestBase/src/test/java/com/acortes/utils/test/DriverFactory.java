package com.acortes.utils.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.acortes.utils.core.ConfigReader;

public class DriverFactory {
	private static final Map<String, Supplier<WebDriver>> BROWSERS = new HashMap<String, Supplier<WebDriver>>();

	private static final Supplier<WebDriver> chromeSupplier = () -> {
		// System.setProperty("webdriver.chrome.driver","src\\test\\\\resources\\drivers\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\\\libs\\\\drivers\\\\chromedriver.exe");
		return new ChromeDriver();
	};

	private static final Supplier<WebDriver> firefoxSupplier = () -> {
		return null;
	};

	private static final Supplier<WebDriver> IESupplier = () -> {
		return null;
	};

	static {
		BROWSERS.put("chrome", chromeSupplier);
		BROWSERS.put("firefox", firefoxSupplier);
		BROWSERS.put("ie", IESupplier);
	}

	public static WebDriver getDriver(String name) {
		return BROWSERS.get(name).get();
	}

	public static WebDriver getChromeDriver() {
		return getDriver("chrome");
	}

	public static WebDriver getFirefoxDriver() {
		return getDriver("firefox");
	}

	public static WebDriver getIEDriver() {
		return getDriver("ie");
	}

	public static WebDriver getDriver() {
		System.out.println("New Driver");
		return BROWSERS.get(System.getProperty("browser") != null ? System.getProperty("browser")
				: ConfigReader.readProp("defaultBrowser")).get();
	}

}
