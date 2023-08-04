
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

public class ProjectActivity5
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


        URL appiumserverUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(appiumserverUrl,options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.training-support.net/selenium");
    }

    @Test (priority = 1)
    public void LoginTestWithValidCredentials () throws InterruptedException
    {


        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

        driver.findElement(AppiumBy.androidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward(10).scrollIntoView(textContains(\"Login Form\"))")).click();
        Thread.sleep(3000);
        //driver.findElement(AppiumBy.xpath("//android.view.View[@text='Login Form']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id= \"username\"]"))).sendKeys("admin");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id= \"password\"]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text= \"Log in\"]")).click();

        String actualMessage = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text = \"Welcome Back, admin\"]"))).getText();
        Assert.assertEquals(actualMessage, "Welcome Back, admin");




    }

    @Test (priority = 2)
    public void LoginTestWithInvalidCredentials()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id= \"username\"]"))).sendKeys("admin");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id= \"password\"]")).sendKeys("passw0rd");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text= \"Log in\"]")).click();

        String actualMessage = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text = \"Invalid Credentials\"]"))).getText();
        Assert.assertEquals(actualMessage, "Invalid Credentials");
    }

    //Close the Browser
    @AfterClass
    public void closeBrowser() {

        driver.quit();
    }
}
