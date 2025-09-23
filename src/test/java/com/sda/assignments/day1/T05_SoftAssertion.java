package com.sda.assignments.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T05_SoftAssertion {
/*1. Navigate to https://claruswaysda.github.io/signIn.html
            2. Enter username: "wronguser"
            3. Enter password: "wrongpass"
            4. Click Submit button
5. Use soft assertions to verify:
    JavaScript alert is displayed
    Alert message text is "Incorrect username or password"*/

    WebDriver driver;
    @Test
    void testSoftAssertions(){
        driver.get("https://claruswaysda.github.io/signIn.html");
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//input[@value='Sign In']")).click();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.switchTo().alert().getText()!=null,"Alert is not present");
        softAssert.assertTrue(driver.switchTo().alert().getText().contains("Incorrect username or password"),"Alert message did not match");
        softAssert.assertAll();
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
