package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity7 {

    WebDriver driver;
    @Given("^The user is on the homepage$")
    public void the_user_is_on_the_homepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");

        //System.out.println("Driver Path"+System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.calculator.net/");

        driver.manage().window().maximize();

    }

    @When("^The user verifies the page title$")
    public void the_user_verifies_the_page_title() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        driver.getTitle();

        System.out.println(driver.getTitle());

    }

    @When("^Clicks on the BMI Calculator link$")
    public void clicks_on_the_BMI_Calculator_link() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        driver.findElement(By.xpath("//a[@href='/bmi-calculator.html']")).click();
        Thread.sleep(3000);
    }

    @When("^Enters the \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void enters_the_and(String age, String height, String weight) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@id='cage']")).clear();
        driver.findElement(By.xpath("//input[@id='cage']")).sendKeys(age);
        driver.findElement(By.xpath("//input[@id='cheightmeter']")).clear();
        driver.findElement(By.xpath("//input[@id='cheightmeter']")).sendKeys(height);
        driver.findElement(By.xpath("//input[@id='ckg']")).clear();
        driver.findElement(By.xpath("//input[@id='ckg']")).sendKeys(weight);
    }

    @When("^Clicks on the calculate button$")
    public void clicks_on_the_calculate_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions


        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

    }

    @When("^Should get the corresponding BMI$")
    public void should_get_the_corresponding_BMI() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        String bmi=driver.findElement(By.xpath("//div[@class='bigtext']")).getText();

        System.out.println("The bmi is " + bmi);

    }

    @Then("^Close the Browsers$")
    public void CloseTheBrowser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        driver.close();


    }

}
