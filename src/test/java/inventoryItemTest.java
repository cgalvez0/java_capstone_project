import org.testng.Assert;
import org.testng.annotations.*;

import pom.pages.loginPage;
import pom.pages.productsPage;
import pom.pages.inventoryItemPage;
import pom.utils.playwrightBase;
import static pom.data.constants.*;
public class inventoryItemTest extends playwrightBase{

    @BeforeMethod(alwaysRun=true)
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(validUsername, validPassword);
    }

    @Test(testName = "As a standard user, I should be able to click on a product's image and validate the product name, description and price on the inventory item details.", priority = 1, groups = "smoke", description = "As a standard user, I should be able to click on a product's image and validate the product name, description and price on the inventory item details.")
    public void testInventoryItem() {
        productsPage productsPage = new productsPage(page);
        inventoryItemPage inventoryDetailPage = new inventoryItemPage(page);
        Assert.assertEquals(inventoryDetailPage.checkProductInfo(productsPage.saveProductInfo(minimumItem)),true);
    }

    @AfterMethod(alwaysRun=true)
    public void browserClose() {
        closePlaywright();
    }
}
