package org.testng;

public class PageManager {
	
	private FlipKartPOM flipkart;
	private AmazonPOM amazon;
	
	
	public FlipKartPOM getFlipkart() {
		if (flipkart==null) {
			flipkart = new FlipKartPOM();
		}
		return flipkart;
	}
	
	public AmazonPOM getAmazon() {
		if (amazon==null) {
			amazon=new AmazonPOM();
		}
		return amazon;
	}

}
