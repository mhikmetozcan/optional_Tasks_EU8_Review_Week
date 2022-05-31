package com.cydeo.tests;

import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonTest {

    WebDriver driver;

    @BeforeMethod
    public void browserSetup(){
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void getToAmazonDotCom(){
        driver.get("https://www.amazon.com");
    }

}
