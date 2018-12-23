package cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractPage {

    private final static String url = "http://localhost:8080/";

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") +
                            File.separator + "src" +
                            File.separator + "main" +
                            File.separator + "resources" +
                            File.separator + "selenium" +
                            File.separator + "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            this.driver = new ChromeDriver();
            return driver;
        }
        return driver;
    }

    private HomePage goToHomePage() {
        driver.get(url);
        return new HomePage(driver);
    }

    public void quit() {
        driver.quit();
    }
}
