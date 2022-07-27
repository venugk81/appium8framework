package appiumframework.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class BaseHybridApp {
	
	public AppiumDriverLocalService locService = null;
	
	public DesiredCapabilities cap = null;
	public AndroidDriver driver = null;

//	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		System.out.println("=================Before Suite=======================");

		// Start the server programmatically
//		locService = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\gopve\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1")
//				.usingPort(4723)
//				.build();
//		locService.start();

		File file = new File(System.getProperty("user.dir") + "/apks");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.getAbsolutePath());
		File file1 = new File(file, "ApiDemos-debug.apk");
		if (file1.exists()) {
			System.out.println(file1.getAbsolutePath());
			UiAutomator2Options options = new UiAutomator2Options();
			options.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel5API32");
			options.setCapability(MobileCapabilityType.APP, file1.getAbsolutePath());			
			options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			options.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}else {
			Assert.fail("Failed to find apk file");
		}		
	}
	
	public AndroidDriver launchApp(String app) {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel5API32");
		options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		options.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");		
		
		try {
			if(app.trim().equalsIgnoreCase("apidemos")) {
				File file = new File(System.getProperty("user.dir") + "/apks");
				System.out.println(file.exists());
				System.out.println(file.isDirectory());
				System.out.println(file.getAbsolutePath());
				File file1 = new File(file, "ApiDemos-debug.apk");
				options.setCapability(MobileCapabilityType.APP, file1.getAbsolutePath());	
				
			}else if(app.trim().equalsIgnoreCase("web")) {
				options.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
				options.setCapability("session-override",true);
			}
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}catch(Exception oExp) {
			oExp.printStackTrace();
		}
		return driver;
	}
	
	public void navigateToMyntraHome() {
		driver.get("httmps://myntra.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
