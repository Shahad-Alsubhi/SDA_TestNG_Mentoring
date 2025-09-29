package com.sda.assignments.week4.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T02_GroupBasedTestExecution {
   /*
   1. Create tests with groups: "smoke", "regression", "api"
2. Create XML configurations to run specific groups
3. Implement include/exclude group scenarios

    */

    WebDriver driver;

    @Test (groups = {"smoke"})
    void test01(){
        System.out.println("smoke1");
    }

    @Test (groups = {"smoke"})
    void test02(){
        System.out.println("smoke2");
    }

    @Test (groups = {"api"})
    void test03(){
        System.out.println("api1");
    }

    @Test (groups = {"api"})
    void test04(){
        System.out.println("api2");
    }

    @Test (groups = {"regression"})
    void test05(){
        System.out.println("regression");
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
