package tests;

import application.entities.Category;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.junit4.SpringRunner;
import util.CategoryCreator;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
public class CategoryAddingCheck {

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
    public void Add_Category_Check(){
        Category category = new CategoryCreator().create();

        NavigationTest.login_With_Google(this.driver);
        goToPage("products/add");
        //Adding category
        add_Category_To_Warehouse(category.getName());

        //go to Warehouse page
        search_Category_In_Warehouse(category.getName());

        Assert.assertTrue(driver.findElement(By.name(category.getName())).isDisplayed());
        driver.findElement(By.name(category.getName())).click();
        quitDriver();
    }

    private void search_Category_In_Warehouse(String category){
        goToPage("products/warehouse");
        driver.findElementById("categoryRadio").click();
        driver.findElementById("searchInput").sendKeys(category);
        driver.findElementById("searchButton").click();
    }

    private void add_Category_To_Warehouse(String categoryName){
        WebElement categoryInput = driver.findElementById("cat_name");
        categoryInput.sendKeys(categoryName);
        driver.findElementById("submitCategory").click();
    }

    private void goToPage(String page){
        driver.get(url +page);
    }
}
