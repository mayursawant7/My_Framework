package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest;

public class ElementFetch {
	
	public WebElement getWebElement(String identifierType,String identifierValue) {
		switch(identifierType) {
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
		case "CLASSNAME":
			return BaseTest.driver.findElement(By.className(identifierValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifierValue));
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));
		case "LINKTEXT":
			return BaseTest.driver.findElement(By.linkText(identifierValue));	
		case "PARTIALLINKTEXT":
			return BaseTest.driver.findElement(By.partialLinkText(identifierValue));	
		case "NAME":
			return BaseTest.driver.findElement(By.name(identifierValue));	
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(identifierValue));			
		default: 
			return null;
		
		}
		
	}	
		public List<WebElement> getListWebElements(String identifierType,String identifierValue) {
			switch(identifierType) {
			case "ID":
				return BaseTest.driver.findElements(By.id(identifierValue));
			case "CLASSNAME":
				return BaseTest.driver.findElements(By.className(identifierValue));
			case "CSS":
				return BaseTest.driver.findElements(By.cssSelector(identifierValue));
			case "XPATH":
				return BaseTest.driver.findElements(By.xpath(identifierValue));
			case "LINKTEXT":
				return BaseTest.driver.findElements(By.linkText(identifierValue));	
			case "PARTIALLINKTEXT":
				return BaseTest.driver.findElements(By.partialLinkText(identifierValue));	
			case "NAME":
				return BaseTest.driver.findElements(By.name(identifierValue));	
			case "TAGNAME":
				return BaseTest.driver.findElements(By.tagName(identifierValue));			
			default: 
				return null;
			
			}
		
		
	}

}
