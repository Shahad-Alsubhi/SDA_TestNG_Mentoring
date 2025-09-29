package com.sda.mentoring.day4.test;

import com.sda.mentoring.day4.pages.AddRecordPage;
import com.sda.utilities.DriverWithoutThreadlocal;
import org.testng.annotations.Test;

public class WebTableManagement {
    /*
 Go to https://claruswaysda.github.io/addRecordWebTable.html
 Add 5 records
 Delete first record you created.
 (Use Fluent POM and don't use any index in locators)
     */


    @Test
    void test(){
        DriverWithoutThreadlocal.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");

        AddRecordPage addRecordPage=new AddRecordPage();

        addRecordPage.addFakeRecord(5).deleteLastAddedRecord();
    }

}
