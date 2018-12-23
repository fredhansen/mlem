package cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends AbstractPage {

    protected WebDriver driver = getDriver();

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private void checkContentIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.id("products")).isDisplayed());
    }
}
