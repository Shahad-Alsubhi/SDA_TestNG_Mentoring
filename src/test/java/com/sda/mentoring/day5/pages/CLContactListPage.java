package com.sda.mentoring.day5.pages;

import com.sda.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CLContactListPage {

    public CLContactListPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="logout")
    public WebElement logout;
}
