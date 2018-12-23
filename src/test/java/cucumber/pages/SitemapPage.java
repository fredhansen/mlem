package cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SitemapPage extends AbstractPage {

    public SitemapPage(WebDriver driver) {
        super(driver);
    }

    public void isContentDisplayed() {
        Assert.assertTrue(driver.findElement(By.id("sitemap_li")).isDisplayed());
    }
}
