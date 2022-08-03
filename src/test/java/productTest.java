import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.*;
import pom.pages.loginPage;
import pom.utils.playwrightBase;

public class productTest extends playwrightBase{
    @BeforeMethod
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
        loginPage loginPage = new loginPage(page);
        loginPage.submitLoginForm("standard_user", "secret_sauce");
    }

    @AfterMethod
    public void browserClose() {
        closePlaywright();
    }
}
