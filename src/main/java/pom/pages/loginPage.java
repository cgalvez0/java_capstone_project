package pom.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class loginPage {
    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    public final Locator errorMessage;
    public loginPage(Page page){
        this.page = page;
        this.usernameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
        this.errorMessage = page.locator("[data-test='error']");
    }

    public void submitLoginForm(String username, String password){
        if (username != null){
            usernameInput.fill(username);
        }
        if (password != null){
            passwordInput.fill(password);
        }
        loginButton.click();
    }
}
