package com.sda.mentoring;

import org.testng.annotations.*;

public class T01_AnnotationHierarchyTest {

    @BeforeSuite
     void beforeSuite() {
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    //we don't mention groups in hierarchy
//    @BeforeGroups
//    public void beforeGroups() {
//        System.out.println("Before Groups");
//    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");

    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");

    }
    @Test
    public void test2() {
        System.out.println("Test 2");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

//    @AfterGroups
//    public void afterGroups() {
//        System.out.println("After Groups");
//    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }







}
