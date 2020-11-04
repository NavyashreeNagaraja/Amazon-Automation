package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.parentdriver.ParentDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ItemsDisplayPage extends ParentDriver 
{
	public static String Price_BeforeAddingToCart;

	public ItemsDisplayPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add to Cart\")")
	AndroidElement AddToCart_Button;
	
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")
	//AndroidElement ItemPrice;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"₹\")")
	AndroidElement ItemPrice;
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_image")
	AndroidElement GoToCart_Image;

	public String getItemPrice(String ItemName) throws InterruptedException 
	{
		
		//waiting for the page to refresh
		//WebDriverWait wait = new WebDriverWait(this.driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atfRedesign_priceblock_priceToPay")));
		
		if (driver.findElementsByXPath("//android.view.View[contains(@text,\""+ ItemName + "\")]").size() > 0) 
		{
			//Trying to fetch the Item name before adding to the cart
			ItemName_BeforeAddingToCart= driver.findElementByXPath("//android.view.View[contains(@text,\"" + ItemName+ "\")]").getText();
			
			//scrolling until it finds the text "rupees"
			this.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().textContains(\"₹\"));");
			String Price_BeforeAddingToCart;
			//Trying to fetch the Item price before adding to the cart
			Price_BeforeAddingToCart = ItemPrice.getText();
			
		} 			
	return Price_BeforeAddingToCart;
	}
	public String getItemName_BeforeAddingToCart() 
	{
		return ItemName_BeforeAddingToCart;
	}
	
	public CartViewPage GoToCart() 
	{
		//scrolling until it finds the text "Add to cart"
		this.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().textContains(\"Add to Cart\"));");
		
		AddToCart_Button.click();
		String ProceedToCheckout = "Proceed to checkout";
		String Cart = "Cart";
		//If a screen pops up partially with 2 buttons named "Cart" and "Proceed to checkout", then the below code clicks on "cart" button
		if (driver.findElementsByXPath("//android.widget.Button[contains(@text,\""+ ProceedToCheckout + "\")]").size() > 0) 
		{
			driver.findElementByXPath("//android.widget.Button[contains(@text,\""+ Cart + "\")]").click();
		}
		else
		{
			GoToCart_Image.click();
		}
		
		return new CartViewPage(driver);
	}

}
