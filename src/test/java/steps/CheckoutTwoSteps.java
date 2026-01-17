package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutCompletePage;
import pages.CheckoutTwoPage;

public class CheckoutTwoSteps extends BaseStep {
    protected CheckoutTwoPage checkoutTwoPage;

    public CheckoutTwoSteps(WebDriver driver) {
        super(driver);
        checkoutTwoPage = new CheckoutTwoPage(driver);
    }

    public CheckoutCompletePage completeByProduct (){
        checkoutTwoPage.getFinishButton().click();
        return new CheckoutCompletePage(driver);
    }

}
