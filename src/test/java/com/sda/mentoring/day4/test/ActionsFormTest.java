package com.sda.mentoring.day4.test;

import com.github.javafaker.Faker;
import com.sda.mentoring.day4.pages.FormPage;
import com.sda.utilities.DriverWithoutThreadlocal;
import org.testng.annotations.Test;

public class ActionsFormTest {

    /*
Go to https://claruswaysda.github.io/ActionsForm.html
Fill form and submit
Do all actions and assert
*/


    @Test
    void test(){
        DriverWithoutThreadlocal.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");

        FormPage formPage=new FormPage();
        Faker faker=new Faker();
        formPage.generatePassword(faker.name().firstName(),faker.number().numberBetween(5,27)+"",faker.number().numberBetween(1,4))
                .assertGeneration();

    }
}
