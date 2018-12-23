package cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    protected WebDriver driver = getDriver();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private void isContentDisplayed() {
        Assert.assertFalse(driver.findElement(By.id("homePageText")).getText().isEmpty());
    }

    private ProductsPage goToProductsPage() {
        driver.findElement(By.id("productsPage")).click();
        return new ProductsPage(driver);
    }


}
