package com.amazon.pages;

import org.openqa.selenium.support.PageFactory;

import com.amazon.parentdriver.ParentDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;

public class SearchItemPage extends ParentDriver 
{
	public SearchItemPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	} 
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	AndroidElement SearchItem_TextBox;
	
	@AndroidFindBy(className="android.widget.TextView")
	List<AndroidElement> ItemList;
	
	public ItemsDisplayPage SearchItem(String ItemName) {
		SearchItem_TextBox.click();
		//entering the Item name in the search product text box
		SearchItem_TextBox.sendKeys(ItemName.toLowerCase());
		
		for(int i=0; i<=ItemList.size(); i++)
		{
			String CurrentItemName = ItemList.get(i).getText();
			
			//The below loop helps us to not select the first product and the last product i.e.., it clicks any other product in the product list apart from first and last one.
			if(i!=0 && i!=ItemList.size())
			{
				if(CurrentItemName.contains(ItemName)) {
					ItemList.get(i).click();
					break;
				}
			}
		}
		return new ItemsDisplayPage(driver);
	}
}
