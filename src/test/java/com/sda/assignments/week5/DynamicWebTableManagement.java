package com.sda.assignments.week5;

import com.sda.mentoring.day4.pages.AddRecordPage;
import com.sda.utilities.Driver;
import com.sda.utilities.DriverWithoutThreadlocal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicWebTableManagement {


    /*
 Go to https://claruswaysda.github.io/addRecordWebTable.html
 Add records to the table using DataProvider
 */

    @Test(dataProvider = "provider")
    void test(String name,String age ,int country){

        DriverWithoutThreadlocal.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");

        AddRecordPage addRecordPage=new AddRecordPage();
        addRecordPage.clearTable().addRecord(name,age,country).validate(name);

    }



    @DataProvider(name = "provider")
    public Object[][] getData(){
        return new Object[][]{
                {"name1","23",1},{"name2","33",2},{"name3","56",1}
        };
    }

}
