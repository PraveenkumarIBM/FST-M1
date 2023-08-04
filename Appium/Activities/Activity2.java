
package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity2{
    AndroidDriver driver;
    WebDriverWait wait;
    //setup desired capabilities
    @BeforeClass
    public void setupDesiredCapabilities() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        //Set server address
        URL appiumserverURL=new URL("http://localhost:4723/wd/hub");

        //Initialize the driver
        driver = new AndroidDriver(appiumserverURL,options);

        //Navigate to Training support portal
        driver.get("https://www.training-support.net/");


    }
    // Test method
    @Test (priority=1)
    public void VerifyTheHeadingPageText(){

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/");

        String pageTitle = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();
        Assert.assertEquals(pageTitle, "Training Support");
        System.out.println("Title on Homepage: " + pageTitle);
    }
    @Test (priority=2)
    public void searchAboutUsandClickOnit(){
        String aboutPageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText();
        // Find and click the About Us link
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']")).click();
        // Verify heading of new page and print to console
        Assert.assertEquals(aboutPageHeading, "About Us");
        System.out.println(aboutPageHeading);

    }
    //Close the browser
    @AfterClass
    public void closeBrowser(){

        driver.quit();
    }
}
