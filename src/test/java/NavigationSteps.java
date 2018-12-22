import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

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



}
