package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    ChromeOptions options;
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//06318O744//Maven//chromedriver_win32//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        driver = new ChromeDriver(options);
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test(priority = 0)
    public void loggingToSite() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        Thread.sleep(2000);
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.name("Submit")).click();
    }
    @Test(priority = 1)
    public void editDetails() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
        Thread.sleep(2000);
        WebElement edit=driver.findElement(By.xpath("//input[@id='btnSave']"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();",edit);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).sendKeys("praveen");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).sendKeys("kumar4");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    }
    @Test(priority = 2)
    public void closeBrowser()
    {
        driver.close();
    }
}
