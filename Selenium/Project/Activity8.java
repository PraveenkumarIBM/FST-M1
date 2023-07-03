package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
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
    public void dashBoard() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/a[1]/img[1]")).click();
        Thread.sleep(2000);
        WebElement select=driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']"));
        Select sel= new Select(select);
        sel.selectByIndex(1);
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content']/div[@id='apply-leave']/div[2]/form[1]/fieldset[1]/ol[1]/li[3]/img[1]")).click();
        //driver.findElement(By.xpath("//tbody/tr[2]/td[1]/a[1]")).click();
        WebElement clearyear=driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
        clearyear.clear();
        clearyear .sendKeys("2023-06-03");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='applyBtn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")).click();
        Thread.sleep(2000);
        WebElement text=driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]"));
        String gettex=text.getText();
        System.out.println(gettex);
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void closeBrowser()
    {
        driver.close();
    }
}
