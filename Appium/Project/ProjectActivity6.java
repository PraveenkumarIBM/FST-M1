/*
Alchemy FST Batch May 2023
ProjectActivity-6 Goal: Goal: Opening a page on the browser and testing a simple login page with correct and incorrect credentials [Bonus]
Open the Chrome app on your device.
Go to the following URL: https://www.training-support.net/selenium
Scroll to find the Popups card and click it.
Once the page loads, find the Sign In button on the page to open a popup with the login form.
Find the username and password input fields in the popup and enter the following credentials in it:
Username: admin
Password: password
Click on the Log in button to submit.
If the credentials are correct, the message "Welcome Back,Admin should appear:
If the credentials are incorrect, the message"Invalid Credentials appears:
Write a test case for each scenario - One with the correct credentials and one with incorrect credentials
Finally, write assertions for both test cases to verify results.
Auther: Bharat Gaikwad
Created on 04/07/2023
 */
package Project;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class ProjectActivity6
{
    AppiumDriver driver ;
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

        URL appiumserverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(appiumserverURL,options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.training-support.net/selenium");
    }

    @Test (priority = 1)
    public void LoginTestWithValidCredentials () throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View")));

        driver.findElement(AppiumBy.androidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5).scrollIntoView(textContains(\"Popups\"))")).click();

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.view.View[1]/android.view.View[4]/android.widget.Button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id= \"username\"]"))).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id= \"password\"]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text= \"Log in\"]")).click();

        String actualMessage = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text = \"Welcome Back, admin\"]"))).getText();
        Assert.assertEquals(actualMessage, "Welcome Back, admin");

    }

    @Test (priority = 2)
    public void LoginTestWithInValidCredentials() throws InterruptedException
    {
        Thread.sleep(3000);

        driver.findElement(AppiumBy.xpath("//android.view.View[1]/android.view.View[5]/android.widget.Button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id= \"username\"]"))).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id= \"password\"]")).sendKeys("passw0rd");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text= \"Log in\"]")).click();

        String actualMessage = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text = \"Invalid Credentials\"]"))).getText();
        Assert.assertEquals(actualMessage, "Invalid Credentials");
    }
    //Close the Browser
    @AfterClass
    public void close() {

        driver.quit();
    }
}