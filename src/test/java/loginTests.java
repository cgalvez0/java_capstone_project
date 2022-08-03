import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.*;
import pom.pages.loginPage;
import pom.pages.productsPage;
import pom.utils.playwrightBase;

public class loginTests extends playwrightBase{

    @BeforeMethod
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
    }

    @Test(priority = 1)
    public void testLogin() {
        loginPage loginPage = new loginPage(page);
        productsPage productsPage = new productsPage(page);
        loginPage.submitLoginForm("standard_user", "secret_sauce");
        assertThat(productsPage.pageTitle).hasText("Products");
    }

    @Test(priority = 2)
    public void testLogin2() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(null, "secret_sauce");
        assertThat(loginPage.errorMessage).containsText("Epic sadface: Username is required");
    }

    @Test(priority = 3)
    public void testLogin3() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm("standard_user", null);
        assertThat(loginPage.errorMessage).containsText("Epic sadface: Password is required");
    }

    @Test(priority = 4)
    public void testLogin4() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm("standard_us", "secret_sauce");
        assertThat(loginPage.errorMessage).containsText("Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void browserClose() {
        closePlaywright();
    }
}
