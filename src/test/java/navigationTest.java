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

    @Test(testName = "As a standard user, I should be able to navigate to the Login page.", priority = 1)
    public void testNavigateToTheLogin() {
        assertThat(page).hasURL(loginURL);
    }

    @Test(testName = "As a standard user, I should be able to navigate to the Product page.", priority = 2)
    public void testNavigateToTheProductPage() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(validUsername, validPassword);
        productsPage productsPage = new productsPage(page);
        assertThat(page).hasURL(productsURL);
        assertThat(productsPage.pageTitle).hasText(productPageTitle);
    }

    @Test(testName = "As a standard user, I should be able to navigate to the Product page.", priority = 3)
    public void testNavigateToTheCartPage() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(validUsername, validPassword);
        productsPage productsPage = new productsPage(page);
        productsPage.cartLink.click();
        cartPage cartPage = new cartPage(page);
        assertThat(page).hasURL(cartURL);
        assertThat(cartPage.pageTitle).hasText(cartPageTitle);
    }

    @AfterMethod
    public void browserClose() {
        closePlaywright();
    }
}
