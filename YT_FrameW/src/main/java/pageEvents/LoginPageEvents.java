package pageEvents;

import org.testng.Assert;

import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	
	ElementFetch elementFetch=new ElementFetch();
	public void verifyLoginPageAppear() {
		Assert.assertEquals(elementFetch.getWebElement("XPATH", LoginPageElements.loginText), "Login Page not opened");
	}
	
	public void enterEmailId() {
		elementFetch.getWebElement("ID", LoginPageElements.emailAddress).sendKeys("abcbd@pqrs.com");
	}

}
