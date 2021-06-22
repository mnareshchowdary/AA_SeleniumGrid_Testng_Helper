package com.accelerator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.accelerator.factory.DriverFactory;
import com.accelerator.helper.NavigationHelper;
// import com.accelerator.helper.LinkHelper;
import com.accelerator.helper.*;

public class LoginPage extends DriverFactory {

    private WebDriver driver = super.getDriver() ;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private NavigationHelper nobj=new NavigationHelper(driver);
    private LinkHelper lobj = new LinkHelper(driver);
    private TextBoxHelper tobj = new TextBoxHelper(driver);
    private ButtonHelper bobj = new ButtonHelper(driver);

    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.linkText("Forgot your password?");

 

    public String getLoginPageTitle() {
    //    return driver.getTitle();
    	return nobj.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
    //    return driver.findElement(forgotPwdLink).isDisplayed();
    	return lobj.getHyperLink_visible(forgotPwdLink);
    }

    public void enterUserName(String username) {
     //   driver.findElement(emailId).sendKeys(username);
    	 tobj.clearAndSendKeys(emailId, username);
    }

    public void enterPassword(String pwd) {
    //    driver.findElement(password).sendKeys(pwd);
    	tobj.clearAndSendKeys(password, pwd);
    }

    public void clickOnLogin() {
    //    driver.findElement(signInButton).click();
    	bobj.click(signInButton);
    }

    public AccountsPage doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
   //     driver.findElement(emailId).sendKeys(un);
   //     driver.findElement(password).sendKeys(pwd);
   //     driver.findElement(signInButton).click();
        tobj.clearAndSendKeys(emailId, un);
        tobj.clearAndSendKeys(password, pwd);
        bobj.click(signInButton);         
        return new AccountsPage(driver);
    }


}
