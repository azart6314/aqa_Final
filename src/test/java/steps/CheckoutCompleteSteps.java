package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutCompletePage;
import pages.InventoryPage;

public class CheckoutCompleteSteps extends BaseStep {
    protected CheckoutCompletePage checkoutCompletePage;

    public CheckoutCompleteSteps(WebDriver driver) {
        super(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    public InventoryPage finishByShop () {
        checkoutCompletePage.getBackToProducts().click();
        return new InventoryPage(driver);
    }



}
