
package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set Desired Capabilities
    @BeforeClass
    public void setDesiredCapabilities() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.PeopleActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Test method
    @Test
    public void createContact() throws IOException {
        // Find and click the add button
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();

        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));

        // Enter the details
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Bharat");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Gaikwad");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("8007779885");
        // Click Save
        driver.findElement(AppiumBy.id("editor_menu_save_button")).click();

        // Wait for contact to save
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
        util.takeScreenshot(testName,this.driver);
        // Assertion
        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
        Assert.assertEquals(contactName, "Bharat Gaikwad");
    }
    @Test
    public void deleteContact() throws IOException {

        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        // Click on More options button
        driver.findElement(AppiumBy.accessibilityId("More options")).click();

        // Wait for More options menu to appear
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Delete']")));

        // Click on the Delete option
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Delete']")).click();

        // Wait for Delete confirmation pop up to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='DELETE']")));
        util.takeScreenshot(testName,this.driver);
        // Click on the Delete button
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='DELETE']")).click();

    }
    @Test
    public void verifyContactListEmpty() throws IOException {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        // Wait for the Contact list to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Your contacts list is empty']")));
        util.takeScreenshot(testName, this.driver);
        // Assertion
        String emptyContactList = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Your contacts list is empty']")).getText();
        Assert.assertEquals(emptyContactList, "Your contacts list is empty");
    }
    // Close the app
    @AfterClass
    public void closeApp() {

        //driver.quit();
    }
}
