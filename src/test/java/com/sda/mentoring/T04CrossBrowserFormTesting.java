package com.sda.mentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class T04CrossBrowserFormTesting {
/*
/*
 Go to https://claruswaysda.github.io/ActionsForm.html
 Fill form and submit
 Do all actions and assert
 Do this test with Chrome, Edge and Firefox
 */

    WebDriver driver;

@Test
void test() throws InterruptedException {
    driver.get("https://claruswaysda.github.io/ActionsForm.html");
    driver.findElement(By.id("name")).sendKeys("name");
    driver.findElement(By.id("age")).sendKeys("17");
//    new Select(driver.findElement(By.id("options"))).selectByVisibleText("Marketing");
//    driver.findElement(By.xpath("//input[@value='female']")).click();
//    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.xpath("//button[normalize-space()=\"Generate Passcode\"]")).click();


    Thread.sleep(300);
    String alertText=driver.switchTo().alert().getText();
    String password=alertText.split(" ")[3];
    driver.switchTo().alert().accept();
    driver.switchTo().alert().sendKeys(password);
    driver.switchTo().alert().accept();

}





    @BeforeClass
    @Parameters("browser")
    void setup(@Optional("chrome") String browser){

        switch (browser.toLowerCase()){
            case "firefox":{
                driver=new FirefoxDriver();
                break;
            }
            case "edge":{
                driver=new EdgeDriver();
                break;
            }
            default:{
                driver=new ChromeDriver();
                break;
            }
        }
    }


    @AfterClass
    void tearDown(){
        driver.quit();

    }
}
