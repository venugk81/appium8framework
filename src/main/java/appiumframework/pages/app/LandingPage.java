package appiumframework.pages.app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appiumframework.common.CommonActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage extends CommonActions{
	
	private AndroidDriver driver = null;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
	private WebElement lstView;
	
	public LandingPage(AndroidDriver _driver) {
		super(_driver);
		this.driver = _driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	//or
//		PageFactory.initElements(new AppiumFieldDecorator(driver), LandingPage.class);		
	}
	
	
	
	
	public void navigateToViewspage() {
//		lstView.click();
		clickElement(lstView, "Views");
		scrollToEnd();
	}
	
}
