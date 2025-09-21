package com.sda.mentoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T03_DependencyTest {
    WebDriver driver;

    @BeforeClass
    void setup(){
       driver=new ChromeDriver();
    }


    @Test
    void openYahoo(){
        driver.get("https://www.yahoo.com");
//        Assert.fail();
    }
    @Test(dependsOnMethods = "openYahoo")
    void openBing(){
        driver.get("https://www.bing.com");
    }
    //I should write all dependencies even if the method is indirectly dependent
    @Test(dependsOnMethods = {"openYahoo","openBing"})
    void openDuckDuckGo(){
        driver.get("https://www.duckduckgo.com");
    }

    @AfterClass
    void tearDown(){
            driver.quit();

    }
}
