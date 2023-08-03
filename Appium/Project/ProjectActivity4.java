/*
Alchemy FST Batch May2023
ProjectActivity-4 Goal: Opening a page on the browser and testing a to-do list page
Open the Chrome app on your device.
Go to the following URL: https://www.training-support.net/selenium
Scroll to find the To-Do List card and click it.
Once the page loads, find the input field on the page and enter the following three tasks:
Add tasks to list
Get number of tasks
Clear the list
Click on each of the tasks added to strike them out.
Finally, clear the list.
Add assertions to verify that the test has passed or failed.

Auther: Bharat Gaikwad
Created on 04/07/2023

 */
package Project;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ProjectActivity4

{

    AndroidDriver driver ;
    WebDriverWait wait;

    @BeforeClass
    public void setDesiredCapabilities() throws MalformedURLException
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("deviceName", "MyphoneP4A28");
        options.setCapability("platformName", "android");
        options.setCapability("automationName", "UiAutomator2");
        options.setCapability("appPackage", "com.android.chrome");
        options.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        options.setCapability("noReset", true);


        URL appiumserverUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(appiumserverUrl,options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void activity4ToDoList() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View")));
        driver.findElement(AppiumBy.androidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5).scrollIntoView(textContains(\"To-Do List\"))")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id = \"taskInput\"]"))).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text = \"Add Task\"]")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id = \"taskInput\"]"))).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text = \"Add Task\"]")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id = \"taskInput\"]"))).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text = \"Add Task\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@text= \"Add tasks to list\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@text= \"Get number of tasks\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@text= \"Clear the list\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View/android.view.View[4]/android.view.View[3]")).click();
        Thread.sleep(2000);
    }
    //Close the browser
    @AfterClass
    public void closeBrowser() {

        driver.quit();
    }
}
