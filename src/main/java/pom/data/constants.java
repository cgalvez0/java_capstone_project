package pom.data;
import com.harium.dotenv.Env;

public final class constants {

    public static final String validUsername = Env.get("VALID_USERNAME");
    public static final String validPassword = Env.get("VALID_PASSWORD");
    public static final String invalidUsername = "standard_us";

    public static final String productPageTitle = "Products";

    public static final String usernameIsRequiredMessage = "Epic sadface: Username is required";
    public static final String passwordIsRequiredMessage = "Epic sadface: Password is required";
    public static final String invalidCredentialMessage = "Epic sadface: Username and password do not match any user in this service";

    public static final int minimumItem = 1;
    public static final String cartPageTitle = "Your Cart";
    public static final String loginURL = "https://www.saucedemo.com/";
    public static final String productsURL = "https://www.saucedemo.com/inventory.html";
    public static final String cartURL = "https://www.saucedemo.com/cart.html";
}
