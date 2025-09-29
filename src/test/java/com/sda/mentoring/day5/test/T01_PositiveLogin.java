package com.sda.mentoring.day5.test;

import com.sda.mentoring.day5.pages.CLContactListPage;
import com.sda.mentoring.day5.pages.CLHomePage;
import com.sda.utilities.ConfigReader;
import com.sda.utilities.Driver;
import org.testng.annotations.Test;

public class T01_PositiveLogin {

    @Test
    void positiveLoginTest() {

        CLHomePage homePage = new CLHomePage();
        CLContactListPage contactListPage = new CLContactListPage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        homePage.email.sendKeys(ConfigReader.getProperty("cl_email"));
        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
        homePage.submit.click();
        assert contactListPage.logout.isDisplayed();
        Driver.closeDriver();

    }


}
