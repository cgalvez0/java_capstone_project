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

    @Test(testName = "As a standard user, I should be able to log in when I provide valid credentials.", priority = 1, groups = "smoke", description = "As a standard user, I should be able to log in when I provide valid credentials.")
    public void testLoginWithValidCredentials() {
        loginPage loginPage = new loginPage(page);
        productsPage productsPage = new productsPage(page);
        loginPage.submitLoginForm(VALID_USERNAME.getConstant(), VALID_PASSWORD.getConstant());
        assertThat(productsPage.pageTitle).hasText(PRODUCT_PAGE_TITLE.getConstant());
    }

    @Test(testName = "As a standard user, I should not be able to log in when I don't provide an username.", priority = 2, description = "As a standard user, I should not be able to log in when I don't provide an username.")
    public void testLoginWithoutUsername() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(null, VALID_PASSWORD.getConstant());
        assertThat(loginPage.errorMessage).containsText(USERNAME_IS_REQUIRED_MESSAGE.getConstant());
    }

    @Test(testName = "As a standard user, I should not be able to log in when I don't provide a password.", priority = 3, description = "As a standard user, I should not be able to log in when I don't provide a password.")
    public void testLoginWithoutPassword() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(VALID_USERNAME.getConstant(), null);
        assertThat(loginPage.errorMessage).containsText(PASSWORD_IS_REQUIRED_MESSAGE.getConstant());
    }

    @Test(testName = "As a standard user, I should not be able to log in when I don't provide a valid username.", priority = 4, groups = "smoke", description = "As a standard user, I should not be able to log in when I don't provide a valid username.")
    public void testLoginWithAnInvalidUsername() {
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm(INVALID_USERNAME.getConstant(), VALID_PASSWORD.getConstant());
        assertThat(loginPage.errorMessage).containsText(INVALID_CREDENTIAL_MESSAGE.getConstant());
    }

    @AfterMethod(alwaysRun=true)
    public void browserClose() {
        closePlaywright();
    }
}
