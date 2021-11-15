package test;

import org.testng.annotations.Test;

import common.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;

public class SampleTest extends BaseTest{

	@Test
	public void sampleMethodEmail() {
		HomePageEvents homePageEvents=new HomePageEvents();
		homePageEvents.clickOnSignInButton();
		
		LoginPageEvents loginPageEvents=new LoginPageEvents();
		loginPageEvents.enterEmailId();
		
	}
	
}
