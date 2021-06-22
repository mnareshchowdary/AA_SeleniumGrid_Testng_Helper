package com.accelerator.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.accelerator.factory.DriverFactory;
import com.accelerator.helper.NavigationHelper;

public class AccountsPage extends DriverFactory {

    private WebDriver driver = super.getDriver();

    private By accountSections = By.cssSelector("div#center_column span");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private NavigationHelper nobj=new NavigationHelper(driver);

    public String getAccountsPageTitle() {
     //   return driver.getTitle();
    return	nobj.getTitle();
    }

    public int getAccountsSectionCount() {
        return driver.findElements(accountSections).size();
    }

    public List<String> getAccountsSectionsList() {

        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements(accountSections);

        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountsList.add(text);
        }

        return accountsList;

    }

}