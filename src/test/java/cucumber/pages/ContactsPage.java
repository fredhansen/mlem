package cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends AbstractPage {

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public void isContentDisplayed() {
        Assert.assertTrue(driver.findElement(By.id("mapid")).isDisplayed());
    }
}
