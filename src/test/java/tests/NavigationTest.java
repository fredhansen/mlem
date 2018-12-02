package tests;

import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.springframework.test.util.AssertionErrors.assertTrue;


@RunWith(SpringRunner.class)
public class NavigationTest {

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

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Test
    public void Home_Page_Test(){
        driver.get(url);
        String homePageText = driver.findElementById("homePageText").getText();
        Assert.assertFalse(homePageText.isEmpty());
        quitDriver();
    }

    @Test
    public void Products_Page_Check(){
        goToPage("products");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"));
        quitDriver();
    }

    @Test
    public void Contact_Page_Check(){
        goToPage("contact");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"));
        quitDriver();
    }

    @Test
    public void Smart_Id_Page_Check(){
        goToPage("smart-Id/login");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"));
        quitDriver();
    }

    @Test
    public void Sitemap_Page_Check(){
        goToPage("sitemap");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"));
        quitDriver();
    }

    @Test
    public void Cart_Page_Check(){
        goToPage("cart");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"));
        quitDriver();
    }

    @Test
    public void Switch_To_English_And_Back_To_Estonian_Check(){
        goToPage("");
        driver.findElementById("eng").click();
        WebElement homePageText= driver.findElementById("homePageText");
        Assert.assertTrue(homePageText.getText().contains("Welding Group Ltd’s main products are vacuum packing pouches and packaging"));
        driver.findElementById("est").click();
        homePageText = driver.findElementById("homePageText");
        Assert.assertTrue(homePageText.getText().contains("Welding Group OÜ põhitoodanguks on vaakumpakkekotid ja pakkekiled pakkeautomaatidele. Tarnime trük"));
        quitDriver();
    }

    @Test
    public void Login_With_Google_Check_Logout_Button(){
        login_With_Google(this.driver);
        Assert.assertTrue(driver.findElementById("logout").isDisplayed());
        quitDriver();
    }

    @Test
    public void Show_Add_Product_Page_With_Login(){
        login_With_Google(this.driver);
        goToPage("products");
        goToPage("products/add");
        Assert.assertTrue(driver.findElementById("name").isDisplayed());
        quitDriver();
    }

    @Test
    public void Show_Warehouse_Page_With_Login(){
        login_With_Google(this.driver);
        goToPage("products");
        goToPage("products/warehouse");
        Assert.assertTrue(driver.findElementById("searchInputBox").isDisplayed());
        quitDriver();
    }

    @Test
    public void Show_Statistics_Page_With_Login(){
        login_With_Google(this.driver);
        goToPage("stats");
        Assert.assertTrue(driver.findElementById("oschart").isDisplayed());
        Assert.assertTrue(driver.findElementById("devicechart").isDisplayed());
        Assert.assertTrue(driver.findElementById("browserchart").isDisplayed());
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


    private void goToPage(String page){
        driver.get(url +page);
    }

}
