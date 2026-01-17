package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.InventoryPage;

public class InventoryStep extends BaseStep {
    protected InventoryPage inventoryPage;

    public InventoryStep(WebDriver driver) {
        super(driver);
       inventoryPage = new InventoryPage(driver);
    }

    public void addBackpackInCart () {
        inventoryPage.getAddToCartButtonBackpack().click();
        inventoryPage.getRemoveInCartButtonBackpack().click();
        inventoryPage.getAddToCartButtonBackpack().click();
    }

    public CartPage goToCart () {
        inventoryPage.getCartButton().click();
        return new CartPage(driver);
    }



}
