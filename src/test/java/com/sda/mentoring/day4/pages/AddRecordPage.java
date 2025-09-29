package com.sda.mentoring.day4.pages;

import com.github.javafaker.Faker;
import com.sda.utilities.DriverWithoutThreadlocal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class AddRecordPage {


    By nameInput=By.xpath("//input[@id='nameInput']");
    By ageInput=By.id("ageInput");
    By countrySelect=By.id("countrySelect");
    By addRecordBtn=By.xpath("//button[text()='Add Record']");
    By addedRecordsBy = By.xpath("//tbody/tr");
    By deleteBtn=By.className("delete-button");
    String nameXpath="//td[normalize-space()='%s']";


    public AddRecordPage enterAge(String age){
        DriverWithoutThreadlocal.getDriver().findElement(ageInput).sendKeys(age);
        return this;
    }

    public AddRecordPage enterName(String name){
        DriverWithoutThreadlocal.getDriver().findElement(nameInput).sendKeys(name);
        return this;
    }

    public AddRecordPage selectCountryByIndex(int index){
       new Select(DriverWithoutThreadlocal.getDriver().findElement(countrySelect)).selectByIndex(index);
        return this;
    }

    public AddRecordPage clickAddButton(){
        DriverWithoutThreadlocal.getDriver().findElement(addRecordBtn).click();
        return this;
    }


    public AddRecordPage addFakeRecord(int num){
        Faker faker =new Faker();
        for(int i=0;i<num;i++){
            this.enterName(faker.name().firstName());
            this.enterAge(faker.number().numberBetween(5,65)+"");
            selectCountryByIndex(faker.number().numberBetween(1,5));
            clickAddButton();

        }

        return this;
    }

    public AddRecordPage addRecord(String name,String age ,int country){

            this.enterName(name);
            this.enterAge(age);
            selectCountryByIndex(country);
            clickAddButton();



        return this;
    }

    public AddRecordPage deleteLastAddedRecord(){
        List<WebElement> recordsList = DriverWithoutThreadlocal.getDriver().findElements(addedRecordsBy);
        recordsList.getLast().findElement(By.xpath(".//button[.='Delete']")).click();
        return this;
    }

    public AddRecordPage clearTable(){

       List<WebElement> deleteBtns= DriverWithoutThreadlocal.getDriver().findElements(deleteBtn);
        deleteBtns.forEach(WebElement::click);
        return this;
    }

    public AddRecordPage validate(String name) {
        Assert.assertTrue(DriverWithoutThreadlocal.getDriver().
                findElement(By.xpath(String.format(nameXpath,name))).isDisplayed());
        return this;
    }
}
