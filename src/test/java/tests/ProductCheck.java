package tests;

import application.entities.Category;
import application.entities.Product;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.junit4.SpringRunner;
import util.CategoryCreator;
import util.ProductCreator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
public class ProductCheck {

    private ChromeDriver driver;
    private final static String url = "http://localhost:8080/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") +
                        File.separator + "src" +
                        File.separator + "main" +
                        File.separator + "resources" +
                        File.separator + "selenium" +
                        File.separator + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void Add_Product_And_Category_Then_Check_In_Warehouse() throws IOException, JSONException, InterruptedException {
        NavigationTest.login_With_Google(this.driver);

        goToPage("products/add");
        //Creating random product and category
        Category category = new CategoryCreator().create();
        Product product = new ProductCreator(category).create();

        //Adding category to warehouse
        add_Category_To_Warehouse(category);
        //Getting response from ajax after registering category to DB
        String categoryName_In_DB = get_Category_Response_In_JsonObject().get("name").toString();
        System.out.println(categoryName_In_DB);

        //Adding product to warehouse
        add_Product_To_Warehouse(product, category);

        //Getting response from ajax request
        String productId_In_DB = get_Product_Response_In_JsonObject().get("id").toString();
        String categoryId_In_DB = get_Product_Response_In_JsonObject().get("categoryId").toString();
        System.out.println("Product ID in database: " + productId_In_DB);
        System.out.println("Category ID in database: " + categoryId_In_DB);

        //Searching product and checking id in warehouse
        search_Product_In_Warehouse_By_Id(productId_In_DB);

        //Searching category id in results
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()[contains(.,'" + categoryId_In_DB + "')]]")).isDisplayed());
        WebElement productDeleteHref = driver.findElementById(productId_In_DB);
        Assert.assertTrue(productDeleteHref.isDisplayed());
        productDeleteHref.click();

        search_Category_In_Warehouse(category);
        WebElement categortDeleteHref = driver.findElementById(categoryId_In_DB);
        categortDeleteHref.click();
        quitDriver();
    }

    private void add_Category_To_Warehouse(Category category) {
        WebElement categoryInput = driver.findElementById("cat_name");
        categoryInput.sendKeys(category.getName());
        driver.findElementById("submitCategory").click();
    }

    private JSONObject get_Category_Response_In_JsonObject() throws JSONException, InterruptedException {
        pause(1000);
        WebElement categoryAjaxResponse = driver.findElementById("getCategoryStatus");
        return new JSONObject(categoryAjaxResponse.getText());
    }

    private JSONObject get_Product_Response_In_JsonObject() throws JSONException, InterruptedException {
        pause(1000);
        WebElement productAjaxResponse = driver.findElementById("getAddingStatus");
        return new JSONObject(productAjaxResponse.getText());
    }

    private void add_Product_To_Warehouse(Product product, Category category) {
        driver.findElementById("name").sendKeys(product.getName());
        driver.findElementById("tag").sendKeys(product.getTag());
        driver.findElementById("description").sendKeys(product.getDescription());
        driver.findElementById("price").sendKeys(String.valueOf(product.getPrice()));
        driver.findElementById("amount").sendKeys(String.valueOf(product.getAmount()));
        Actions action = new Actions(driver);
        WebElement categorySelect = driver.findElementById("categorySelect");
        action.doubleClick(categorySelect).build().perform();
        Select dropdown = new Select(categorySelect);
        dropdown.selectByVisibleText(category.getName());
        driver.findElementById("addButton").click();
    }

    private void search_Category_In_Warehouse(Category category) {
        goToPage("products/warehouse");
        WebDriverWait wait = new WebDriverWait(this.driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(
                driver.findElementById("categoryRadio"),
                driver.findElementById("categoryRadio"),
                driver.findElementById("searchButton")));
        driver.findElementById("categoryRadio").click();
        driver.findElementById("categoryRadio").sendKeys(category.getName());
        driver.findElementById("searchButton").click();
    }

    private void search_Product_In_Warehouse_By_Id(String productId) {
        goToPage("products/warehouse");
        WebDriverWait wait = new WebDriverWait(this.driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(
                driver.findElementById("categoryRadio"),
                driver.findElementById("categoryRadio"),
                driver.findElementById("searchButton")));
        driver.findElementById("productsRadio").click();
        driver.findElementById("searchInput").sendKeys(productId);
        driver.findElementById("searchButton").click();
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToPage(String page) {
        driver.get(url + page);
    }
}