package pom.pages;
import java.util.Arrays;
import com.microsoft.playwright.*;

public class productsPage {
    public final Page page;
    public final Locator pageTitle;
    public final Locator productImage;
    public final Locator productName;
    public final Locator productDescription;
    public final Locator productPrice;

    public productsPage(Page page) {
        this.page = page;
        this.pageTitle = page.locator("text='Products'");
        this.productImage = page.locator(".inventory_item_img").first();
        this.productName = page.locator(".inventory_item_name").first();
        this.productDescription = page.locator(".inventory_item_desc").first();
        this.productPrice = page.locator(".inventory_item_price").first();
    }

    public String[][] saveProductInfo(int numberOfItems, int dataStored){
        String [][] productsInfo = new String[numberOfItems][dataStored];
        for (int i=0; i<numberOfItems; i++) {
            productsInfo[i][0] = productName.textContent();
            productsInfo[i][1] = productDescription.textContent();
            productsInfo[i][2] = productPrice.textContent();
        }
        System.out.println(Arrays.deepToString(productsInfo));
        return productsInfo;
    }

}
