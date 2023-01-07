package org.testng;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPOM extends BaseClass{
	
	public AmazonPOM() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(xpath="//div[@data-index='2']")
	private WebElement selectProduct;

	public WebElement getSelectFirst() {
		return selectProduct;
	}
	
	@FindBy(xpath="//div[@id='corePriceDisplay_desktop_feature_div']//child::span[@class='a-price-whole']")
	private WebElement price;

	public WebElement getPrice() {
		return price;
	}
	

}
