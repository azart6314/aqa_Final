package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutOnePage;
import pages.CheckoutTwoPage;
import pages.InventoryPage;

public class CheckoutOneStep extends BaseStep {
    protected CheckoutOnePage checkoutOnePage;

    public CheckoutOneStep(WebDriver driver) {
        super(driver);
        checkoutOnePage = new CheckoutOnePage(driver);
    }

    public CheckoutTwoPage continueShop ( ) {
        checkoutOnePage.getFirstName().click();
        checkoutOnePage.getFirstName().sendKeys("Ruslan");
        checkoutOnePage.getLastName().sendKeys("Khodos");
        checkoutOnePage.getPostalCode().sendKeys("2555");
        checkoutOnePage.getContinueButton().click();
        return new CheckoutTwoPage(driver);
    }

    public InventoryPage cancelCheckout () {
        checkoutOnePage.getCancelButton().click();
        return new InventoryPage(driver);
    }







}
