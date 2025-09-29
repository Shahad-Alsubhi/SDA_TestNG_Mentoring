package com.sda.mentoring.day4.pages;

import com.sda.utilities.DriverWithoutThreadlocal;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FormPage {


    By name=By.id("name");
    By age=By.id("age");
    By departments =By.id("options");
    By gender= By.xpath("//input[@value='female']");
    By clickBtn=By.xpath("//button[@type='button']");

    public FormPage enterName(String name){
        DriverWithoutThreadlocal.getDriver().findElement(this.name).sendKeys(name);
        return this;
    }

    public FormPage enterAge(String age){
        DriverWithoutThreadlocal.getDriver().findElement(this.age).sendKeys(age);

        return this;
    }

    public FormPage selectGender(){
        DriverWithoutThreadlocal.getDriver().findElement(this.gender).click();

        return this;
    }

    public FormPage selectDepartment(int index){
        new Select(DriverWithoutThreadlocal.getDriver().findElement(departments)).selectByIndex(index);

        return this;
    }

    public FormPage clickBtn(){
        DriverWithoutThreadlocal.getDriver().findElement(clickBtn).click();
        return this;
    }

    public FormPage generatePassword(String name,String age, int departmentIndex){
        enterName(name).enterAge(age).selectDepartment(departmentIndex).selectGender().clickBtn();
        return this;
    }

    public FormPage assertGeneration(){
        Assert.assertTrue(DriverWithoutThreadlocal.getDriver().switchTo().alert().getText().contains("Your passcode is:"));
        return this;
    }


}
