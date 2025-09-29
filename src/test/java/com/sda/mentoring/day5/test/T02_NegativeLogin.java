package com.sda.mentoring.day5.test;


import com.sda.mentoring.day5.pages.CLHomePage;
import com.sda.utilities.ConfigReader;
import com.sda.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class T02_NegativeLogin {

    @Test
    void negativeLoginTest() {
        CLHomePage homePage = new CLHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
        homePage.submit.click();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(homePage.error));
        assert homePage.error.isDisplayed();
        Driver.closeDriver();
    }
}
