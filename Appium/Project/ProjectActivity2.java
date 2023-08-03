/*
Alchemy FST Batch May2023
ProjectActivity-2 Goal: Use the Google Keep app to add a note.
Open the Google Keep app.
Click the Create New Note button to add a new Note.
Add a title for the note and add a small description.
Press the back button and make an assertion to ensure that the note was added.
Auther: Bharat Gaikwad
Created on 05/07/2023
 */
package Project;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ProjectActivity2 {
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
    public void activity2createNote() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='New text note']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text = 'Title']")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text = 'Title']")).sendKeys("This is the title");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text ='Note']")).sendKeys("This is the description");

        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();

        Thread.sleep(5000);
    }
    @Test
    public void activity2verifyNoteIsCreated() throws InterruptedException{

        String actualtitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'This is the title']")).getText();

        Assert.assertEquals("This is the title", actualtitle);
    }

    //Close the browser
    @AfterClass

    public void closeBrowser() {

        driver.quit();
    }
}
