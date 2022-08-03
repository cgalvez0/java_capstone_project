package pom.pages;

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

    public void saveProductInfo(int files, int numberOfItems){
        String [][] productsInfo = new String [files][numberOfItems];
        for (int i=0; i<files; i++){
            productsInfo[i][numberOfItems] = productName.textContent();
            productsInfo[i][numberOfItems+1] = productDescription.textContent();
            productsInfo[i][numberOfItems+2] = productPrice.textContent();
        }
    }

}
