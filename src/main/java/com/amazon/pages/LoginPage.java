package com.amazon.pages;

import org.openqa.selenium.support.PageFactory;

import com.amazon.parentdriver.ParentDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends ParentDriver 
{
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	private AndroidElement Skip_SignIn_Button;
	
	public SearchItemPage SkipLogin() {
		Skip_SignIn_Button.click();
		return new SearchItemPage(driver);
	}
}
