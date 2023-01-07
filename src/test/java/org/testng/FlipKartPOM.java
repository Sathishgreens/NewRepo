package org.testng;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartPOM extends BaseClass {
	
	public FlipKartPOM() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}
	@FindBy(xpath="(//div[@class='_4rR01T'])[1]")
	private WebElement selectFirst;

	public WebElement getSelectFirst() {
		return selectFirst;
	}

	@FindBy(xpath="(//button[contains(@class,'_2KpZ6l')])[1]")
	private WebElement popup;

	public WebElement getPopup() {
		return popup;
	}
	@FindBy(xpath="//div[@class='_30jeq3 _16Jk6d']")
	private WebElement price;

	public WebElement getPrice() {
		return price;
	}
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement addToCart;

	public WebElement getAddToCart() {
		return addToCart;
	}
	
	@FindBy(xpath="//button[text()='+']")
	private WebElement incQuantity;

	public WebElement getIncQuantity() {
		return incQuantity;
	}
	
	@FindBy(xpath="//span[@class='_2-ut7f _1WpvJ7']")
	private WebElement priceAfterInc;

	public WebElement getPriceAfterInc() {
		return priceAfterInc;
	}
	
}
