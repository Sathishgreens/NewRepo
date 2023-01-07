package org.testng;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void browser(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Enter Correct browser");
		}
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void minimize() {
		driver.manage().window().minimize();
	}

	public static void setSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);
	}

	public static void setPosition(int x, int y) {
		Point point = new Point(x, y);
		driver.manage().window().setPosition(point);
	}

	public static WebElement findElement(String locator, String value) throws Exception {

		WebElement element = null;
		if (locator.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(value));
		} else if (locator.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(value));
		} else if (locator.equalsIgnoreCase("classname")) {
			element = driver.findElement(By.className(value));
		} else if (locator.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(value));
		} else if (locator.equalsIgnoreCase("linntext")) {
			element = driver.findElement(By.linkText(value));
		} else if (locator.equalsIgnoreCase("partiallinktext")) {
			element = driver.findElement(By.partialLinkText(value));
		} else if (locator.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(value));
		} else if (locator.equalsIgnoreCase("cssselector")) {
			element = driver.findElement(By.cssSelector(value));
		} else {
			System.out.println("Enter correct locator");
			throw new Exception();
		}
		return element;
	}

	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static String pageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	public static String title() {
		String title = driver.getTitle();
		return title;
	}

	public static void quit() {
		driver.quit();
	}

	public static void close() {
		driver.close();
	}

	public static String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public static Set<String> windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public static void navigateBack() {
		driver.navigate().back();
	}
	public static void navigateTo() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	
	public static void switchToAlert() {
		driver.switchTo().alert();
	}
	public static void switchToDefault() {
		driver.switchTo().defaultContent();
	}
	public static void switchToWindow(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);
	}
	public static void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public static void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public static void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	public static void sendKeys(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static void click(WebElement ele) {
		ele.click();
	}
	
	

	public static String attribute(WebElement ele, String name) {
		String attribute = ele.getAttribute(name);
		return attribute;
	}

	public static String text(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public static boolean dropDown(WebElement ele, String selectBy, Object value) {
		Select select = new Select(ele);
		switch (selectBy) {

		case "index":
			select.selectByIndex((int) value);
			break;
		case "value":
			select.selectByValue((String) value);
			break;
		case "text":
			select.selectByVisibleText((String) value);
			break;
		default:
			throw new InvalidArgumentException("Enter Correct Method");
		}

		boolean selected = ele.isSelected();
		return selected;
	}

}
