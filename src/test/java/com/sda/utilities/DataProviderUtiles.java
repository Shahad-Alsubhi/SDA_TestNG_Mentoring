package com.sda.utilities;
import org.testng.annotations.DataProvider;

public class DataProviderUtiles {

    @DataProvider
    public Object[][] utilitiesData(){
       return new Object[][]{
               {"name4","23","USA"},{"name5","33","UK"},{"name6","56","USA"}
       };
    }

 @DataProvider
    public Object[][] excelData(){
        ExcelUtilities eu=new ExcelUtilities("testData/Users.xlsx","Employees");
        return eu.getExcelDataAsArray();
    }
}
