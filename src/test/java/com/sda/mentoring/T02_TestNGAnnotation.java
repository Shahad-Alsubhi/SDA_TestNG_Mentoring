package com.sda.mentoring;

import org.testng.annotations.Test;

public class T02_TestNGAnnotation {
    /*
    Objective: Implement various TestNG annotation attributes
 Requirements:
1. Create a class called
AttributePracticeTest
 2. Create 5 test methods with different priorities (1, 3, 2, 5, 4)
 3. Create one test method with
enabled = false
 4. Create a test method with timeout of 3 seconds that includes
Thread.sleep(2000)
 5. Create a test method with timeout of 1 second that includes
Thread.sleep(2000) (should fail)
 6. Add meaningful descriptions to all test methods
 7. Create test methods with groups: "smoke", "regression", "api"
     */
    @Test(priority=1,description = "This is test with priority 1",groups="smoke")
    void Test01(){
        System.out.println("This is test with priority 1");
    }
    @Test(priority=2)
    void Test02(){
        System.out.println("This is test with priority 2");
    }

    @Test(priority=3,description = "This is test with priority 3",groups={"regression","api"})
    void Test03(){
        System.out.println("This is test with priority 3");
    }

    @Test(priority=4,description = "This is test with priority 4")
    void Test04(){
        System.out.println("This is test with priority 4");

    }
    @Test(priority=5,description = "This is test with priority 5")
    void Test05(){
        System.out.println("This is test with priority 5");
    }
    @Test(enabled=false,description="This test is disabled and will not run")
    void disabledTest(){
        System.out.println("This test is disabled and will not run");
    }

    @Test(timeOut = 3000,description="This test should pass within timeout")
    void timeoutTestPass() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("This test should pass");
    }

    @Test(timeOut=1000,description="This test should fail due to timeout")
    void timeoutTestFail() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("This test should fail");
    }
    @Test(groups="smoke",description="This is a smoke test")
     void smokeTest(){
    System.out.println("This is a smoke test");}

    @Test(groups={"regression","api"},description="This is a regression and api test")
    void groupedTest(){
        System.out.println("This is a regression and api test");
    }
}

