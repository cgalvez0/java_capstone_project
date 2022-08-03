package pom.pages;
import pom.pages.productsPage;
import com.microsoft.playwright.*;
public class inventoryItemPage {
    public final Page page;
    public final Locator backToProductsButton;
    public final Locator productName;
    public final Locator productDescription;
    public final Locator productPrice;

    public inventoryItemPage(Page page) {
        this.page = page;
        this.backToProductsButton = page.locator(".inventory_details_back_button");
        this.productName = page.locator(".inventory_details_name");
        this.productDescription = page.locator(".inventory_details_desc");
        this.productPrice = page.locator(".inventory_details_price");
    }

    public boolean checkProductInfo(String[][] productsInfo){
        productsPage productsPage = new productsPage(page);
        productsPage.productImage.click();
//        for (int i=0; i<productsInfo.length; i++){
            if (productsInfo[0][0].equals(productName.textContent()) && productsInfo[0][1].equals(productDescription.textContent()) && productsInfo[0][2].equals(productPrice.textContent())) {
                return true;
            }
            return false;
    }
}
