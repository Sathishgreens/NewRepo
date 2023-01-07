package org.testng;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase2 extends BaseClass {

	PageManager manager;
	
	int flipkartPrice;
	int amazonPrice;

	@BeforeClass
	private void browserLaunch() {
		browser("chrome");
		manager = new PageManager();
	}

	@Test(priority = 1,enabled=true)
	private void flipkart() throws InterruptedException {

		launchUrl("https://www.flipkart.com/");
		manager.getFlipkart().getPopup().click();
		manager.getFlipkart().getSearch().sendKeys("google pixel 7 pro snow 128gb", Keys.ENTER);

		String parentWindow = windowHandle();
		Thread.sleep(3000);
		manager.getFlipkart().getSelectFirst().click();
		Set<String> allWindows = windowHandles();
		for (String windowHandle : allWindows) {

			if (!windowHandle.equals(parentWindow)) {
				switchToWindow(windowHandle);

			}
		}

		String price = manager.getFlipkart().getPrice().getText();
		String productPrice = price.substring(1).replaceAll(",", "");
		System.out.println("Flipkart Price : " + productPrice);
		
		flipkartPrice = Integer.parseInt(productPrice);
		
		Thread.sleep(3000);
		manager.getFlipkart().getAddToCart().click();
		

		Thread.sleep(3000);
		WebElement priceAfterInc = manager.getFlipkart().getPriceAfterInc();
		String text = text(priceAfterInc);
		System.out.println(text);
	}

	@Test(priority = 2)
	private void amazon() {
		driver.switchTo().newWindow(WindowType.TAB);
		launchUrl("https://www.amazon.in/");
		manager.getAmazon().getSearch().sendKeys("google pixel 7 pro snow 128gb", Keys.ENTER);

		String parentWindow = windowHandle();
		manager.getAmazon().getSelectFirst().click();
		Set<String> allWindows = windowHandles();
		for (String windowHandle : allWindows) {

			if (!windowHandle.equals(parentWindow)) {
				switchToWindow(windowHandle);

			}
		}
		
		WebElement price = manager.getAmazon().getPrice();
		String text = text(price);
		System.out.println(text);
		String productPrice = text.replaceAll(",", "");
		System.out.println("Amazon Price : "+productPrice);
		
		amazonPrice = Integer.parseInt(productPrice);
		

	}
	
	@Test(priority=3)
	private void compare() {
		
		if(amazonPrice>flipkartPrice) {
			int diff = amazonPrice-flipkartPrice;
			System.out.println("Flipkart is Cheaper than Amazon by Rs."+diff);
		}
		
		else {
			int diff = flipkartPrice-amazonPrice;
			System.out.println("Amazon is Cheaper than Flipkart by Rs."+diff);
		}
			

	}

}
