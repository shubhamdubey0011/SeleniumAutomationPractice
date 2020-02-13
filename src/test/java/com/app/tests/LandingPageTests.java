package com.app.tests;

import org.testng.annotations.Test;
import com.app.pages.LandingPage;
import utility.BaseConfiguration;
import utility.Driver;

public class LandingPageTests extends BaseConfiguration {
            
	@Test(enabled = true, priority = 1)
	public void testUserIsSignedUp() {
		System.out.println("=====1=======");
		LandingPage landingPage = new LandingPage();
		System.out.println(Driver.getDriver().getTitle());
		landingPage.moveToSignInLabel();
		landingPage.clickOnSignUp();
	}

}
