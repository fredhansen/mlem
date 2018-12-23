package cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartIDPage extends AbstractPage {

    public SmartIDPage(WebDriver driver) {
        super(driver);
    }

    public void isContentDisplayed(){
        Assert.assertTrue(driver.findElement(By.id("countryCode")).isDisplayed());
    }
}
