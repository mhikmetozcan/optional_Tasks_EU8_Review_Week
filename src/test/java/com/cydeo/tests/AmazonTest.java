package com.cydeo.tests;

import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        WebElement amazonSearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        amazonSearchBox.sendKeys(ConfigurationReader.getProperty("searchText") + Keys.ENTER);

        WebElement hat = driver.findElement(By.xpath("//span[.='EINSKEY Sun Hat for Men/Women, Waterproof Wide Birm Bucket Hat UV Protection Boonie Hat for Fishing Hiking Garden Beach']"));
        hat.click();

        WebElement quantityDropDown = driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']//span[@class='a-dropdown-label']"));
        quantityDropDown.click();


    }


}
