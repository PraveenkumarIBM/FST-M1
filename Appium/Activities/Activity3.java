/*
Alchemy FST Batch May2023
Activity-3 : Description: ACTIVITY 3
In @Test methods, perform the following operations:
Calculate 1050 + 2582 and print the result to the console.
Calculate 7250 - 5280 and print the result to the console.
Calculate 5137 * 6289 and print the result to the console.
Calculate 5025 / 2005 and print the result to the console.
Write assertions for all the results.
Auther: Bharat Gaikwad
Created on 03/07/2023
 */
package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity3{
    AndroidDriver  driver;

    @BeforeClass
    //set desired capabilities
    public void setupDesiredCapabilities() throws MalformedURLException {
        UiAutomator2Options options =new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        //Set server address
        URL serverURL=new URL("http://localhost:4723/wd/hub");

        //initialize the Android driver
        driver=new AndroidDriver(serverURL,options);
    }
    //Calculators methods
    @Test(priority = 0)
    public void calculateAdditionMethod() throws IOException {
        // Perform the calculation
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_8")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        util.takeScreenshot(testName,this.driver);

        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();

        // Assertion
        Assert.assertEquals(result, "3,632");
        System.out.println("Addition Result :"+result);
    }
    @Test(priority = 1)
    public void calculateSubstractionMethod() throws IOException {
        // Perform the calculation
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        driver.findElement(AppiumBy.id("digit_7")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("digit_8")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        util.takeScreenshot(testName,this.driver);
        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();

        // Assertion
        Assert.assertEquals(result, "1,970");
        System.out.println("Subtraction Result :"+result);
    }
    @Test(priority = 2)
    public void calculateMultiplicationMethod() throws IOException {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        // Perform the calculation
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_3")).click();
        driver.findElement(AppiumBy.id("digit_7")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_6")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("digit_8")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        util.takeScreenshot(testName,this.driver);
        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        // Assertion
        Assert.assertEquals(result, "32,306,593");
        System.out.println("Multiplication Result :"+result);
    }
    @Test(priority = 3)
    public void calculateDivisionMethod() throws IOException {
        // Perform the calculation
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        util.takeScreenshot(testName,this.driver);
        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        // Assertion
        Assert.assertEquals(result, "2.506234413965");
        System.out.println("Division Result :"+result);
    }
    //Close the calculator app
    @AfterClass
    public void closeCalculatorApp(){
        driver.quit();
    }
}

