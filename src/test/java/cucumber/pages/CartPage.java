package cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends AbstractPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private void isContentDisplayed() {
        Assert.assertTrue(driver.findElement(By.id("cart")).isDisplayed());
    }
}
