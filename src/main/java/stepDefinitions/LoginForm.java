package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class login_Form {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Given("Visit Test Automation Page")
    public void visit_test_automation_page() throws InterruptedException {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(3000);
    }
    @When("I Enter UserName")
    public void i_enter_user_name() {
        driver.findElement(By.id("username")).sendKeys("student");
    }
    @When("I Enter Password")
    public void i_enter_password() {
        driver.findElement(By.id("password")).sendKeys("Password123");
    }
    @When("I Click on the Submit Button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.className("btn")).click();
    }
    @Then("A Successful login message coming")
    public void a_successful_login_message_coming() {
        WebElement ExpectedText = driver.findElement(By.xpath("//*[text()= 'Logged In Successfully']"));
        Assert.assertEquals(ExpectedText.getText(), "Logged In Successfully");
    }


}
