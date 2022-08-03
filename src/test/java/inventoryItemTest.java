import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.*;
import java.lang.Object;
import java.util.Arrays;

import pom.pages.loginPage;
import pom.pages.productsPage;
import pom.pages.inventoryItemPage;
import pom.utils.playwrightBase;
public class inventoryItemTest extends playwrightBase{

    @BeforeMethod
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm("standard_user", "secret_sauce");
    }

    @Test(testName = "As a standard user, I should be able to click on a product's image and validate the product name, description and price on the inventory item details.", priority = 1)
    public void testInventoryItem() {
        productsPage productsPage = new productsPage(page);
        inventoryItemPage inventoryDetailPage = new inventoryItemPage(page);
        Assert.assertEquals(inventoryDetailPage.checkProductInfo(productsPage.saveProductInfo(1,3)),true);
    }

    @AfterMethod
    public void browserClose() {
        closePlaywright();
    }
}
