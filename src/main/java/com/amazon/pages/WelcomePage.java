package com.amazon.pages;

import org.openqa.selenium.support.PageFactory;

import com.amazon.parentdriver.ParentDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage extends ParentDriver {
	public WelcomePage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Continue\")")
	AndroidElement Continue_Button;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText")
	private AndroidElement EmailLogin_TextBox;
	
	
	public LoginPage EnterLoginEmail(String login_emailid) throws InterruptedException{
		Thread.sleep(5000);
		EmailLogin_TextBox.sendKeys(login_emailid);
		Continue_Button.click();

		return new LoginPage(driver);
	}
}
