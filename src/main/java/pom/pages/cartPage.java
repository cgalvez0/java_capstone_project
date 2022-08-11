package pom.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class cartPage {
    public final Page page;
    public final Locator pageTitle;
    public final Locator productName;
    public final Locator productDescription;
    public final Locator productPrice;

    public cartPage(Page page) {
        this.page = page;
        this.pageTitle = page.locator("text='Your Cart'");
        this.productName = page.locator(".inventory_item_name").first();
        this.productDescription = page.locator(".inventory_item_desc").first();
        this.productPrice = page.locator(".inventory_item_price").first();
    }

    public boolean checkProductsOnCartInfo(String[][] productsInfo){
        productsPage productsPage = new productsPage(page);
        productsPage.addToCart.click();
        productsPage.cartLink.click();
        for (int i=0; i<productsInfo.length; i++) {
            if (productsInfo[i][0].equals(productName.textContent()) && productsInfo[i][1].equals(productDescription.textContent()) && productsInfo[i][2].equals(productPrice.textContent())) {
                return true;
            }
        }
        return false;
    }
}
