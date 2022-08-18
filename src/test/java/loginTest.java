import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.*;
import pom.pages.loginPage;
import pom.pages.productsPage;
import pom.utils.playwrightBase;
import static pom.data.constants.*;

public class loginTest extends playwrightBase{

    @BeforeMethod(alwaysRun=true)
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
    }

    @Test(testName = "As a standard user, I should be able to log in when I provide valid credentials.", priority = 1, groups = "smoke")
    public void testLoginWithValidCredentials() {
        loginPage loginPage = new loginPage(page);
        productsPage productsPage = new productsPage(page);
        loginPage.submitLoginForm(validUsername, validPassword);
        assertThat(productsPage.pageTitle).hasText(productPageTitle);
    }

    @Test(testName = "As a standard user, I should not be able to log in when I don't provide an username.", priority = 2)
    public void testLoginWithoutUsername() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(null, validPassword);
        //System.out.println(System.getProperty("user.username"));
        assertThat(loginPage.errorMessage).containsText(usernameIsRequiredMessage);
    }

    @Test(testName = "As a standard user, I should not be able to log in when I don't provide a password.", priority = 3)
    public void testLoginWithoutPassword() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(validUsername, null);
        assertThat(loginPage.errorMessage).containsText(passwordIsRequiredMessage);
    }

    @Test(testName = "As a standard user, I should not be able to log in when I don't provide a valid username.", priority = 4, groups = "smoke")
    public void testLoginWithAnInvalidUsername() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(invalidUsername, validPassword);
        assertThat(loginPage.errorMessage).containsText(invalidCredentialMessage);
    }

    @AfterMethod(alwaysRun=true)
    public void browserClose() {
        closePlaywright();
    }
}
