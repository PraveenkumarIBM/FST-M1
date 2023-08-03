/*
Alchemy FST Batch May2023
ProjectActivity-1 Goal: Use the Google Tasks app to create a list of activities that need to be completed.
Open the Google Tasks app.
Click the button to add a new task.
Add the following tasks:
Complete Activity with Google Tasks
Complete Activity with Google Keep
Complete the second Activity Google Keep
After each task is added, the Save button should be clicked.
Write an assertion to ensure all three tasks have been added to the list.
Auther: Bharat Gaikwad
Created on 05/07/2023
 */
package Project;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity1 {


    AndroidDriver driver ;
    WebDriverWait wait;

    @BeforeClass
    public void setDesiredCapabilities() throws MalformedURLException
    {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("deviceName", "MyphoneP4A28");
        options.setCapability("platformName", "android");
        options.setCapability("automationName", "UiAutomator2");
        options.setCapability("appPackage", "com.google.android.apps.tasks");
        options.setCapability("appActivity", ".ui.TaskListsActivity");
        options.setCapability("noReset", true);

        URL appiumserverUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver (appiumserverUrl,options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test

    public void CompleteActivityWithGoogleTask() throws InterruptedException {

        String activityGoogleTask = "Complete Activity with Google Tasks";
        WebElement elementofact1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = \"Complete Activity with Google Tasks\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text = \"New task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text = \"New task\"]")).sendKeys("Complete Activity with Google Tasks");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Save\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Save\"]")).click();
        Assert.assertEquals(elementofact1.getText(), activityGoogleTask);

    }
    @Test
    public void CompleteActivityWithGoogleKeep() throws InterruptedException {

        String activityGoogleKeep = "Complete Activity with Google Keep";
        WebElement elementforact2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = \"Complete Activity with Google Keep\"]"));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text = \"New task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text = \"New task\"]")).sendKeys("Complete Activity with Google Keep");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Save\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Save\"]")).click();

        Assert.assertEquals(elementforact2.getText(), activityGoogleKeep);
    }
    @Test
    public void CompleteActivity2WithGoogleKeep() throws InterruptedException {


        String activity2GoogleKeep = "Complete the second Activity Google Keep";
        WebElement elementofact3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = \"Complete the second Activity Google Keep\"]"));


        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text = \"New task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text = \"New task\"]")).sendKeys("Complete the second Activity Google Keep");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Save\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Save\"]")).click();

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text = \"Complete Activity with Google Tasks\"]")));
        Thread.sleep(10000);
        Assert.assertEquals(elementofact3.getText(), activity2GoogleKeep);
    }
    //Close the browser
    @AfterClass
    public void closeBrowser() {

        driver.quit();
    }
}
