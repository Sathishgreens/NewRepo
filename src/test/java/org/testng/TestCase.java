package org.testng;

import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase extends BaseClass{
	
	FlipKartPOM locators;

	@BeforeClass
	private void login() {
		browser("chrome");
		locators=new FlipKartPOM();
		launchUrl("https://www.flipkart.com/");
		locators.getPopup().click();
	}
	
	@Test(priority=1)
	private void search() throws InterruptedException {
		
		locators.getSearch().sendKeys("google pixel 7 pro snow 128gb",Keys.ENTER);
		
		String parentWindow = windowHandle();
		Thread.sleep(3000);
		locators.getSelectFirst().click();
		Set<String> allWindows = windowHandles();
		for (String windowHandle : allWindows) {
			
			if(!windowHandle.equals(parentWindow)) {
				switchToWindow(windowHandle);
				
			}			
		}
	}
	
	@Test(priority=2)
	private void productDetails() throws InterruptedException {
		String price = locators.getPrice().getText();
		String productPrice = price.substring(1).replaceAll(",", "");
		System.out.println("Price : "+productPrice);
		Thread.sleep(3000);
		locators.getAddToCart().click();
		
		try {
			locators.getIncQuantity().click();
		WebElement priceAfterInc = locators.getPriceAfterInc();
		String text = text(priceAfterInc);
		}
		catch (NoSuchElementException e) {
			System.out.println("Out Of Stock");
		}
		
		
	}
	
}


