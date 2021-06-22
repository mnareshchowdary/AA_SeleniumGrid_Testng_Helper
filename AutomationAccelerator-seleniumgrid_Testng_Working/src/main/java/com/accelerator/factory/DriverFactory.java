package com.accelerator.factory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadlocal driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return tldriver.
     */
    public WebDriver init_driver(String browser) throws MalformedURLException {
    	DesiredCapabilities dc = null;
    	String host = "localhost";
    	System.out.println("browser value is: " + browser);
    	//System.out.println("The browser from cmd is :" + System.getProperty("BROWSER"));
    	if (browser.equals("chrome")) {
    	    //WebDriverManager.chromedriver().setup()
    	System.out.println("Inside chrome");
    	    dc = DesiredCapabilities.chrome();
    	    dc.setPlatform(Platform.ANY);
    	    //tlDriver.set(new ChromeDriver());
    	} else if (browser.equals("firefox")) {
    	    WebDriverManager.firefoxdriver().setup();
    	    //dc = DesiredCapabilities.firefox();
    	    tlDriver.set(new FirefoxDriver());
    	} else if (browser.equals("safari")) {
    	    //dc = DesiredCapabilities.safari();
    	    tlDriver.set(new SafariDriver());
    	} else {
    	    System.out.println("Please pass the correct browser value: " + browser);
    	}
    	if(System.getProperty("HUB_HOST") != null){
    	    host = System.getProperty("HUB_HOST");
    	}
    	String completeUrl = "http://" + host + ":4444/wd/hub";
    	System.out.println("The complete url is "+completeUrl );
    	this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    	System.out.println("tHE DRIVER IS %%%%%%%%%% "+this.driver);
    	tlDriver.set(this.driver);

    	//getDriver().manage().deleteAllCookies();
    	//getDriver().manage().window().maximize();
    	this.driver.manage().deleteAllCookies();
    	this.driver.manage().window().maximize();
    	//return getDriver();
    	System.out.println("tHE DRIVER IS 2%%%%%%%%%% "+this.driver);
    	return this.driver;
    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}