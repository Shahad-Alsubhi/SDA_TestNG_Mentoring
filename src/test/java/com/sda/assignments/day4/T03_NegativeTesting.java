package com.sda.assignments.day4;

import com.sda.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class T03_NegativeTesting extends TestBase {
    /*
 Go to https://claruswaysda.github.io/signIn.html
 Do negative test with all scenarios

 */

    @Test(dataProvider = "getData")
    void testExcelData(String name,String password){
        driver.get("https://claruswaysda.github.io/signIn.html");

        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        try{
            driver.switchTo().alert().accept();
        }catch (Exception e){

        }
        Assert.assertFalse(driver.findElement(By.id("employeeTable")).isDisplayed());


    }


    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"username","password"},
                {"",""},
                {"","56uy"},
                {"name3",""},
                {"admin","568"},
                {"username","123"},
        };
    }
}
