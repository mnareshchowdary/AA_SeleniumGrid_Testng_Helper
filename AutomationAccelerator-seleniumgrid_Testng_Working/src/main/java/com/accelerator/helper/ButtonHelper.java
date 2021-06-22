
package com.accelerator.helper;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.accelerator.interfaces.IwebComponent;



public class ButtonHelper extends GenericHelper implements IwebComponent {
	com.accelerator.helper.WaitHelper waithelper;
	
	private WebDriver driver;
//	private Logger oLog = LoggerHelper.getLogger(ButtonHelper.class);
	
	public ButtonHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
//		oLog.debug("Button Helper : " + this.driver.hashCode());
	}
	
	public void click(By locator) {
	//	waithelper.waitForExpectedElement(driver.findElement(locator)).click();
	//	click(driver.findElement(locator));
//		oLog.info(locator);
		getElement(locator).click();
	}
	
	public void click(WebElement element){
		//com.accelerator.helper.Wait.WaitHelper.waitForElementVisible(element,30,5);
	//	waithelper.waitForExpectedElement(element).click();
	//		oLog.info(element);
		element.click();
	}
}
