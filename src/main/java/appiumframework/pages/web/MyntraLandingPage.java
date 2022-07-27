package appiumframework.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appiumframework.base.BaseHybridApp;
import appiumframework.common.CommonActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyntraLandingPage extends CommonActions{
	
	private AndroidDriver driver=null;
	private BaseHybridApp page;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
	private WebElement lstView;
	
	public MyntraLandingPage(AndroidDriver _driver) {
		super(_driver);
		this.driver = _driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	//or
//		PageFactory.initElements(driver, this);	this will not work for mobile devices. so use above statement
		page = new BaseHybridApp();
	}
	
	
	
	
	public void navigateToHomePage() {
		page.navigateToMyntraHome();
		
	}
	
}
