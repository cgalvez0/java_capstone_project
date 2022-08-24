package pom.data;
import com.harium.dotenv.Env;
public enum constants {
    VALID_USERNAME(Env.get("VALID_USERNAME")),
    VALID_PASSWORD(Env.get("VALID_PASSWORD")),
    INVALID_USERNAME("standard_us"),

    PRODUCT_PAGE_TITLE("Products"),
    CART_PAGE_TITLE("Your Cart"),

    USERNAME_IS_REQUIRED_MESSAGE("Epic sadface: Username is required"),
    PASSWORD_IS_REQUIRED_MESSAGE("Epic sadface: Password is required"),
    INVALID_CREDENTIAL_MESSAGE("Epic sadface: Username and password do not match any user in this service"),

    MINIMUM_ITEM("1"),

    LOGIN_URL("https://www.saucedemo.com/"),
    PRODUCT_URL("https://www.saucedemo.com/inventory.html"),
    CART_URL("https://www.saucedemo.com/cart.html");

    public final String label;

    constants (String label){
        this.label = label;
    }

    public String getConstant(){
        return label;
    }
}
