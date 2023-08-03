/*
Alchemy FST Batch May2023
Activity-6 : Description :Write a Appium test script to perform the following:
Open Google Chrome on your mobile device/emulator and open the following URL: https://www.training-support.net/selenium/lazy-loading
Get the number of images shown in the view
Scroll to the card with Helen's post
Get number of images shown on the screen after scrolling.
Auther: Bharat Gaikwad
Created on 03/07/2023
 */
package activities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class Activity6
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
        options.setCapability("appPackage", "com.android.chrome");
        options.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        options.setCapability("noReset", true);

        URL appiumserverUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver (appiumserverUrl,options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }

    @Test
    public void imageScrollTest() {

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));

        // Find all the image elements on the page
        List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));

        // Print the number of images
        System.out.println("Image count Before scroll: " + imageElements.size());

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Scroll using UiScrollable
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"helen\")"));

        // Get image elements after scroll
        imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));

        // Print the number of images after scroll
        System.out.println("Image count After scroll: " + imageElements.size());

        // Assertions
        Assert.assertEquals(5,imageElements.size());
    }

    //Close the Browser
    @AfterClass
    public void closeBrowser() {

        driver.quit();
    }
}