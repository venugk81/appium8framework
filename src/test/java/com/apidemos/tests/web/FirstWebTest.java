package com.apidemos.tests.web;

import org.testng.annotations.Test;

import appiumframework.base.BaseHybridApp;
import appiumframework.pages.app.LandingPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FirstWebTest extends BaseHybridApp {
	LandingPage landingPage = null;

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test has begun");
		launchApp("web");
	}

	@Test
	public void f() {
		driver.get("https://www.myntra.com/");	
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Im in after Test annotation");
	}

}
