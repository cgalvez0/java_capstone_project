import org.testng.Assert;
import org.testng.annotations.*;

import pom.pages.loginPage;
import pom.pages.productsPage;
import pom.pages.cartPage;
import pom.utils.playwrightBase;
import static pom.data.constants.*;

public class cartTest extends playwrightBase{
    @BeforeMethod
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(validUsername, validPassword);
    }

    @Test(testName = "As a standard user, I should be able to add a product in my cart and validate if the product information is correct.", priority = 1, groups = "smoke")
    public void testValidateProductInfoOnCart() {
        productsPage productsPage = new productsPage(page);
        cartPage cartPage = new cartPage(page);
        Assert.assertEquals(cartPage.checkProductsOnCartInfo(productsPage.saveProductInfo(minimumItem)),true);
    }

    @AfterMethod
    public void browserClose() {
        closePlaywright();
    }
}
