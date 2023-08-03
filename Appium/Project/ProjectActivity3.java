/*
Alchemy FST Batch May2023
ProjectActivity-3 Goal: Use the Google Keep app to add a note with a reminder [Bonus]
Open the Google Keep app.
Click the Create New Note button to add a new Note.
Add a title for the note and add a small description.
Click the reminder icon on the toolbar to add a reminder for Afternoon of the same day.
Press the back button and switch to the Reminders page.
Make an assertion to ensure that the note was added w
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class ProjectActivity3
{
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
        options.setCapability("appPackage", "com.google.android.keep");
        options.setCapability("appActivity", ".activities.BrowseActivity");
        options.setCapability("noReset", true);

        URL appiumserverUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver (appiumserverUrl,options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void activity3createGoogleNotes() throws InterruptedException
    {

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text = \"Title\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text = \"Title\"]")).sendKeys("This is the title");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text =\"Note\"]")).sendKeys("This is the description");

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Single-column view\"]")).click();

        wait(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = \"Tomorrow morning\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();

        wait(2000);
        String actualTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = \"This is the title\"]")).getText();

        Assert.assertEquals("This is the title", actualTitle);
    }

    //Close the browser
    @AfterClass

    public void closeBrowser() {

        driver.quit();
    }
}
