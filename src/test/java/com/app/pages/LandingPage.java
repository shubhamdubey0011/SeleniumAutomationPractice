package com.app.pages;

import org.openqa.selenium.interactions.Actions;

import com.app.locators.LandingPageLoc;

import utility.BaseConfiguration;
import utility.Driver;

public class LandingPage extends BaseConfiguration implements LandingPageLoc{

	public void moveToSignInLabel() {
		waitforPresent(SIGN_IN_LABLE);
		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(findElement(SIGN_IN_LABLE)).build().perform();
	}
	
	public void clickOnSignUp() {
		waitforPresent(START_HERE_LABEL);
		clickOnElement(START_HERE_LABEL);
	}
	
}
