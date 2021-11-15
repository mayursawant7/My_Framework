package pageEvents;

import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {
	ElementFetch elementFetch=new ElementFetch();
	public void clickOnSignInButton() {
		elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();;
	}
	
}
