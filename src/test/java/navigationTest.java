import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.*;
import pom.pages.cartPage;
import pom.pages.loginPage;
import pom.pages.productsPage;
import pom.utils.playwrightBase;
import static pom.data.constants.*;

public class navigationTest extends playwrightBase{
    @BeforeMethod
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
    }

    @Test(testName = "As a standard user, I should be able to navigate to the Login page.", priority = 1, description = "As a standard user, I should be able to navigate to the Login page.")
    public void testNavigateToTheLogin() {
        assertThat(page).hasURL(LOGIN_URL.getConstant());
    }

    @Test(testName = "As a standard user, I should be able to navigate to the Product page.", priority = 2, description = "As a standard user, I should be able to navigate to the Product page.")
    public void testNavigateToTheProductPage() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(VALID_USERNAME.getConstant(), VALID_PASSWORD.getConstant());
        productsPage productsPage = new productsPage(page);
        assertThat(page).hasURL(PRODUCT_URL.getConstant());
        assertThat(productsPage.pageTitle).hasText(PRODUCT_PAGE_TITLE.getConstant());
    }

    @Test(testName = "As a standard user, I should be able to navigate to the Cart page.", priority = 3, description = "As a standard user, I should be able to navigate to the Cart page.")
    public void testNavigateToTheCartPage() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(VALID_USERNAME.getConstant(), VALID_PASSWORD.getConstant());
        productsPage productsPage = new productsPage(page);
        productsPage.cartLink.click();
        cartPage cartPage = new cartPage(page);
        assertThat(page).hasURL(CART_URL.getConstant());
        assertThat(cartPage.pageTitle).hasText(CART_PAGE_TITLE.getConstant());
    }

    @AfterMethod
    public void browserClose() {
        closePlaywright();
    }
}
