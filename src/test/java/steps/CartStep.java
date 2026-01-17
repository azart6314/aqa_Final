package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutOnePage;
import pages.InventoryPage;

public class CartStep extends BaseStep {
    protected CartPage cartPage;

    public CartStep(WebDriver driver) {
        super(driver);
        cartPage = new CartPage(driver);
    }


    public InventoryPage continueShoppingSteps() {
        cartPage.getContinueShoppingButton().click();
        return new InventoryPage(driver);
    }

    public void removeBackpackSteps () {
        cartPage.getBackpackRemoveButton().click();
    }

    public CheckoutOnePage checkoutProductSteps() {
        cartPage.getCheckoutButton().click();
        return new CheckoutOnePage(driver);
    }



}
