package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class NavigationSteps {

    private ChromeDriver driver;

    private final static String url = "http://localhost:8080/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+
                        File.separator +"src"+
                        File.separator + "main"+
                        File.separator + "resources" +
                        File.separator + "selenium" +
                        File.separator + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    private void goToPage(String page){
        driver.get(url +page);
    }


    @Given("^I opened homepage$")
    public void iOpenedHomepage() {
        setUp();
        driver.get(url);
        String homePageText = driver.findElementById("homePageText").getText();
        Assert.assertFalse(homePageText.isEmpty());
    }

    @When("^I go to different pages \"([^\"]*)\"$")
    public void iGoToDifferentPages(String page) {
        goToPage(page);
    }

    @Then("^I should see correct div's on screen \"([^\"]*)\"$")
    public void iShouldSeeCorrectDivSOnScreen(String divContent){
        assert driver.findElementById(divContent).isDisplayed();
    }

    @After
    public void quit(){
        driver.quit();
    }


    @And("^I login$")
    public void iLogin() {
        login_With_Google(this.driver);
    }

    @Then("^I should be logged in$")
    public void iShouldBeLoggedIn() {
        assert driver.findElementById("logout").isDisplayed();
    }


    public static void login_With_Google(ChromeDriver driver){
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("loginPageGoogle")));
        driver.findElementById("loginPageGoogle").click();
        WebElement email = driver.findElement(By.xpath("//input[@id='identifierId']"));
        email.sendKeys(String.valueOf(System.getenv("testGmailUser")));
        driver.findElement(By.id("identifierNext")).click();
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys(System.getenv("testGmailPassword"));
        driver.findElement(By.id("passwordNext")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("logout")));
    }

}
