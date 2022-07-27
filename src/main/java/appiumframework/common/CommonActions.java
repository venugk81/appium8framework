package appiumframework.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.android.AndroidDriver;

public class CommonActions {
	AndroidDriver driver = null;

	public CommonActions(AndroidDriver _driver) {
		driver = _driver;
	}

	public void clickElement(WebElement ele, String strElementDesc) {
		if (visibilityOfElement(ele) != null) {
			ele.click();
			System.out.println("Clicked on element: " + strElementDesc);
		} else {
			Assert.fail("Failed to click on element: " + strElementDesc);
		}
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void scrollToEnd() {
		boolean canScrollMoreflag = false;
		do {
			canScrollMoreflag = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, 
							"top", 100, 
							"width", 200, 
							"height", 200, 
							"direction", "down",
							"percent", 1.0));
		} while (canScrollMoreflag);
	}

	public WebElement presenceOfElementLocated(By by) {
		WebElement ele = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			ele = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception oExp) {
			oExp.printStackTrace();
		}
		return ele;
	}

	public WebElement visibilityOfElement(WebElement ele) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			element = wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception oExp) {
			oExp.printStackTrace();
		}
		return element;
	}

}
