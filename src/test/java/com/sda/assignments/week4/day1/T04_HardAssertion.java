package com.sda.assignments.week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T04_HardAssertion {

    /*
    1. Navigate to https://claruswaysda.github.io/signIn.html
2. Enter username: "admin"
3. Enter password: "123"
4. Click Submit button
5. Use hard assertions to verify:
New page URL is "https://claruswaysda.github.io/signIn.html"
Page contains text "Employee Table"
     */

    WebDriver driver;
    @Test
    void testHardAssertions(){
        driver.get("https://claruswaysda.github.io/signIn.html");
      driver.findElement(By.id("username")).sendKeys("admin");
      driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//input[@value='Sign In']")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://claruswaysda.github.io/signIn.html","URL did not match");

        Assert.assertTrue(driver.findElement(By.id("employeeTable")).isDisplayed(),"Employee Table is not displayed");
    }



    @BeforeClass
    void setup(){
        driver=new ChromeDriver();
    }

    @AfterClass
    void tearDown(){
        driver.quit();

    }
}
