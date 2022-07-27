package com.apidemos.tests.app;

import org.testng.annotations.Test;

import appiumframework.base.BaseHybridApp;
import appiumframework.common.CommonActions;
import appiumframework.pages.app.LandingPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FirstAppTest extends BaseHybridApp {
	LandingPage landingPage = null;
	

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test has begun");
		launchApp("apidemos");
		landingPage = new LandingPage(driver);
		
	}

	@Test
	public void f() {		
		landingPage.navigateToViewspage();		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Im in after Test annotation");
	}

}
