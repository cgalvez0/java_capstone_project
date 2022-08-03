import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.*;
import pom.pages.loginPage;
import pom.pages.productsPage;
import pom.utils.playwrightBase;

public class loginTest extends playwrightBase{

    @BeforeMethod
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
    }

    @Test(testName = "As a standard user, I should be able to log in when I provide valid credentials.", priority = 1)
    public void testLoginWithValidCredentials() {
        loginPage loginPage = new loginPage(page);
        productsPage productsPage = new productsPage(page);
        loginPage.submitLoginForm("standard_user", "secret_sauce");
        assertThat(productsPage.pageTitle).hasText("Products");
    }

    @Test(testName = "As a standard user, I should not be able to log in when I don't provide an username.", priority = 2)
    public void testLoginWithoutUsername() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(null, "secret_sauce");
        //System.out.println(System.getProperty("user.username"));
        assertThat(loginPage.errorMessage).containsText("Epic sadface: Username is required");
    }

    @Test(testName = "As a standard user, I should not be able to log in when I don't provide a password.", priority = 3)
    public void testLoginWithoutPassword() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm("standard_user", null);
        assertThat(loginPage.errorMessage).containsText("Epic sadface: Password is required");
    }

    @Test(testName = "As a standard user, I should not be able to log in when I don't provide a valid username.", priority = 4)
    public void testLoginWithAnInvalidUsername() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm("standard_us", "secret_sauce");
        assertThat(loginPage.errorMessage).containsText("Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void browserClose() {
        closePlaywright();
    }
}
