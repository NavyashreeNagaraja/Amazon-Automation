package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.parentdriver.ParentDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends ParentDriver{
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[2]/android.widget.EditText")
	private AndroidElement Password_TextBox;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[6]/android.view.View[2]/android.widget.EditText")
	private AndroidElement Password_TextBox_Highlighted;
												 
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[6]/android.widget.Button")
	private AndroidElement Login_Button_Before;
			
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[7]/android.widget.Button")
	private AndroidElement Login_Button_AfterEnteringWrongPassword;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[6]/android.view.View[6]/android.widget.Button")
	private AndroidElement Login_Button_AfterEnteringRightPassword;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View")
	private AndroidElement InvalidPassword_Text;
	
	String invalid_login_password = "123";
	
	public void VerifyFunctionality_WhenNoPasswordIsEntered()
	{
		//click on the Login button without entering any password
		Login_Button_Before.click();
		boolean isEnterPassword_TextVisible = (this.driver.findElements(By.xpath(" /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[3]/android.view.View/android.view.View[2]")).size()) == 1 ? true : false;
		if(isEnterPassword_TextVisible == true)
		{
			System.out.println("When user doesn't enter login password and clicks on Login button, then the text 'Enter your password' is visible");
		}
		else
		{
			Assert.fail("When user doesn't enter login password and clicks on Login button, then the text 'Enter your password' is NOT visible");
		}
	}
	public void VerifyFunctionality_WhenInvalidPasswordIsEntered()
	{
		Password_TextBox.sendKeys(invalid_login_password);
		Login_Button_AfterEnteringWrongPassword.click();
		boolean isInvalidPassword_TextVisible = (this.driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View"))
				.size())== 1 ? true : false;
		if(isInvalidPassword_TextVisible == true)
		{
			System.out.println("When user entered invalid password, then the text 'Your password is incorrect' is visible on the screen");
		}
		else
		{
			Assert.fail("When user entered invalid password, then the text 'Your password is incorrect' is NOT visible on the screen");
		}
		
	}
	
	public SearchItemPage VerifyFunctionality_WhenValidPasswordIsEntered(String valid_login_password)
	{
		Password_TextBox_Highlighted.sendKeys(valid_login_password);
		
		Login_Button_AfterEnteringRightPassword.click();
		return new SearchItemPage(driver);
	}
	
}
