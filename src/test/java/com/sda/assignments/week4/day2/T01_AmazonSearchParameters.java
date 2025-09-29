package com.sda.assignments.week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class T01_AmazonSearchParameters  {

    /*
    1. Navigate to: https://www.amazon.com
2. Search for different keywords: Java, Selenium
3. Assert that result text contains the searched word
4. Run tests from XML file using parameters
     */
    WebDriver driver;

    @Test
    @Parameters("searchKeyword")
    void searchAmazon(@Optional("java") String searchKey){
        driver.get("https://www.amazon.com");

        //search input
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchKey, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains(searchKey));
    }

    @BeforeMethod
    void setup(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
