package com.amazon.pages;

import org.openqa.selenium.support.PageFactory;

import com.amazon.parentdriver.ParentDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartViewPage extends ParentDriver 
{
	public CartViewPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	} 
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Proceed to Buy\")")
	AndroidElement ProceedToBuy_Button;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.ListView/android.view.View[1]")
	AndroidElement Price_InCartView;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Redmi Note 7 (Onyx Black, 4GB RAM, 64GB Storage)']/android.widget.TextView")						
	AndroidElement ItemName_InCartView;
	
	public String getPrice_In_CartView() 
	{
		System.out.println("Item price in cart view is : " + Price_InCartView.getText());
		return Price_InCartView.getText();
	}
	public String getItemName_In_CartView() 
	{
		System.out.println("Entered_ItemName:"+Entered_ItemName);
		System.out.println("Item name in cart view is : " + ItemName_InCartView.getText().replaceAll(".", ""));
		return ItemName_InCartView.getText().replaceAll(".", "");
	}
	public void Select_ProceedToBuy() 
	{
		ProceedToBuy_Button.click();
	}
}
