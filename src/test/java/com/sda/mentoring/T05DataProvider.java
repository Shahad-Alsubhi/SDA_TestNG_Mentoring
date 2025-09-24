package com.sda.mentoring;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;

public class T05DataProvider {

    /*
 Go to https://claruswaysda.github.io/addRecordWebTable.html
 Add records to the table using DataProvider
 Do it with all 3 ways
     */

    WebDriver driver;


    @Test(dataProvider = "provider")
    void testUsingData(@Optional("name") String name, @Optional("34") String age, @Optional("UK") String country) {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age);
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();


    }

    @Test(dataProvider = "utilitiesData", dataProviderClass = com.sda.utilities.DataProviderUtiles.class)
    void testUtilitiesData(@Optional("name") String name, @Optional("34") String age, @Optional("UK") String country) {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age);
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();


    }


    @Test(dataProvider = "excelData",dataProviderClass =com.sda.utilities.DataProviderUtiles.class )
    void testExcelData(@Optional("name") String name,@Optional("34") double age,@Optional("UK") String country){
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys((int) age+" ");
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();


    }


    @DataProvider(name = "provider")
    public Object[][] getData(){
        return new Object[][]{
                {"name1","23","USA"},{"name2","33","UK"},{"name3","56","USA"}
        };
    }

    @BeforeClass
    void setup(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }


    @AfterClass
    void tearDown(){
        driver.quit();

    }

}
